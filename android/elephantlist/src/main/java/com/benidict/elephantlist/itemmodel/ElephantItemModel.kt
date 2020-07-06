package com.benidict.elephantlist.itemmodel

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.benidict.core.ui.epoxy.KotlinEpoxyHolder
import com.benidict.core.util.ImageUtil
import com.benidict.domain.model.Elephant
import com.benidict.elephantlist.R

@EpoxyModelClass
abstract class ElephantItemModel: EpoxyModelWithHolder<ElephantItemModel.Holder>(){

    @EpoxyAttribute
    lateinit var elephant: Elephant

    @EpoxyAttribute
    lateinit var clickListener: View.OnClickListener

    override fun getDefaultLayout(): Int = R.layout.item_elephant

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tvElephantName.text = elephant.name
        holder.tvElephantSpecies.text = elephant.species
        holder.clContainer.setOnClickListener(clickListener)

        ImageUtil.loadImage(elephant.image, holder.ivElephantPicture)
    }

    class Holder: KotlinEpoxyHolder(){
        val tvElephantName by bind<AppCompatTextView>(R.id.tv_elephant_name)
        val tvElephantSpecies by bind<AppCompatTextView>(R.id.tv_elephant_species)
        val ivElephantPicture by bind<AppCompatImageView>(R.id.iv_elephant_picture)
        val clContainer by bind<ConstraintLayout>(R.id.cl_container)
    }
}