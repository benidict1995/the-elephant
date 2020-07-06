package com.benidict.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

@Suppress("UNCHECKED_CAST")
abstract class BaseFragment<VB: ViewBinding>(
    private val setupBinding: (LayoutInflater) -> VB
) : Fragment(){

    lateinit var viewBinding: VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = setupBinding(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadContent()
        setUpView()
    }

    fun getBaseActivity() : BaseActivity<Nothing> {
        return activity as BaseActivity<Nothing>
    }


    open fun setUpView() {}

    open fun loadContent(){}
}