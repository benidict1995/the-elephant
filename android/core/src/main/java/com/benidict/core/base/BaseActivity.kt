package com.benidict.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding>(
    private val setupBinding: (LayoutInflater) -> VB
) : AppCompatActivity(){

    lateinit var viewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = setupBinding(layoutInflater)
        setContentView(viewBinding.root)
    }

    override fun setContentView(view: View) {
        super.setContentView(view)
        loadContent()
        setUpView()
    }

    open fun loadContent() {}
    open fun setUpView() {}

}