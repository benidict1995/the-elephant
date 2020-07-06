package com.benidict.core.ui.extensionmethods

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.benidict.core.R

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(editable: Editable?) {
            try {
                afterTextChanged.invoke(editable.toString())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    })
}

fun EditText.addTextWatcher(watcher: TextWatcher) {
    addTextChangedListener(watcher)
    getWatchers().add(watcher)
}

fun EditText.clearWatchers() {
    val size = getWatchers().size
    if (size == 0){
        return
    }
    for (i in 0 until size){
        removeTextChangedListener(getWatchers()[i])
    }
    getWatchers().clear()
}

@Suppress("UNCHECKED_CAST")
private fun EditText.getWatchers(): MutableList<TextWatcher> {
    return getTag(R.id.text_watchers) as MutableList<TextWatcher>? ?: run {
        val newList = mutableListOf<TextWatcher>()
        setTag(R.id.text_watchers, newList)
        newList
    }    }
