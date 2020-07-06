package com.benidict.mvvm_ktdsl

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import com.benidict.core.base.BaseActivity
import com.benidict.core.host.MainHostActivity
import com.benidict.core.ui.state.UIState
import com.benidict.core.util.Constant.KEY_FIRST_INSTALL
import com.benidict.mvvm_ktdsl.databinding.ActivitySplashBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<ActivitySplashBinding>(
        ActivitySplashBinding::inflate
) {

    private val splashViewModel: SplashViewModel by viewModel()


    override fun loadContent() {
        splashViewModel.doCheckIfFirstInstall.value = KEY_FIRST_INSTALL
    }

    override fun setUpView() {
        initFirstInstallObservable()
        initSaveFirstInstallObservable()
    }

    private fun initFirstInstallObservable(){
        splashViewModel.checkIfFirstInstall.observe(this, Observer { result ->
            when(result){
                UIState.Loading -> {
                    viewBinding.pbSplash.visibility = VISIBLE
                }
                is UIState.Success -> {
                    if (result.data) splashViewModel.doSaveFirstInstall.value = KEY_FIRST_INSTALL else navigateToDashBoard()
                }
                is UIState.Error -> {
                    viewBinding.pbSplash.visibility = GONE
                }
            }
        })
    }

    private fun initSaveFirstInstallObservable(){
        splashViewModel.saveFirstInstall.observe(this, Observer { result ->
            when(result){
                is UIState.Success -> {
                    viewBinding.pbSplash.visibility = GONE
                    navigateToDashBoard()
                }
                is UIState.Error -> {
                    viewBinding.pbSplash.visibility = GONE
                }
            }
        })
    }

    private fun navigateToDashBoard(){
        startActivity(MainHostActivity.getIntent(this))
        finish()
    }

}

