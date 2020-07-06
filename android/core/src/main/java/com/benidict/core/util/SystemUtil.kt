package com.benidict.core.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object SystemUtil {
    fun hideKeyboard(context: Context, view: View) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
            .hideSoftInputFromWindow(
                view.windowToken,
                InputMethodManager.RESULT_UNCHANGED_SHOWN
            )
    }
}