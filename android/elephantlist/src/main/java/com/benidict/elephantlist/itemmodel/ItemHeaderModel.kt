package com.benidict.elephantlist.itemmodel

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.benidict.core.ui.epoxy.KotlinEpoxyHolder
import com.benidict.elephantlist.R

@EpoxyModelClass
abstract class ItemHeaderModel: EpoxyModelWithHolder<ItemHeaderModel.Holder>(){

    @EpoxyAttribute
    lateinit var header : String

    @EpoxyAttribute
    lateinit var clickListener: View.OnClickListener

    override fun getDefaultLayout(): Int = R.layout.item_header

    override fun bind(holder: Holder) {
        super.bind(holder)
        holder.tvHeader.text = header
    }

    class Holder: KotlinEpoxyHolder(){
        val tvHeader by bind<AppCompatTextView>(R.id.tvHeader)
    }
}