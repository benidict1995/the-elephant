package com.benidict.core.host

import android.content.Context
import android.content.Intent
import android.util.Log
import com.benidict.core.base.BaseActivity
import com.benidict.core.databinding.ActivityMainHostBinding

class MainHostActivity : BaseActivity<ActivityMainHostBinding>(
    ActivityMainHostBinding::inflate
){

    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context, MainHostActivity::class.java)
        }
    }

}