package com.benidict.elephantlist.itemcontroller

import com.airbnb.epoxy.TypedEpoxyController
import com.benidict.domain.model.Elephant
import com.benidict.domain.model.ElephantHeader
import com.benidict.elephantlist.itemmodel.elephantItem
import com.benidict.elephantlist.itemmodel.itemHeader

class ElephantItemController(private val callBack: CallBack): TypedEpoxyController<List<ElephantHeader>>(){

    override fun buildModels(data: List<ElephantHeader>) {
            val size = data.size

            for (i in 0 until size){
                val elephantHeader = data[i]
                val elephantSize = elephantHeader.elephant.size

                itemHeader {
                    id(i)
                    header(elephantHeader.header)
                }

                for (x in 0 until elephantSize){
                    val item = elephantHeader.elephant[x]
                    elephantItem {
                        id("$i - $x")
                        elephant(item)
                        clickListener { model, _, _, _ ->
                            callBack.onItemSelected(model.elephant())
                        }
                    }
                }

            }
    }

    interface CallBack{
        fun onItemSelected(elephant: Elephant)
    }

}