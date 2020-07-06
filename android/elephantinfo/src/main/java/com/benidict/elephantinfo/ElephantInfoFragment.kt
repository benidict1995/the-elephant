package com.benidict.elephantinfo

import androidx.lifecycle.Observer
import com.benidict.core.base.BaseFragment
import com.benidict.core.ui.state.UIState
import com.benidict.core.util.ImageUtil
import com.benidict.elephantinfo.databinding.ElephantInfoFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ElephantInfoFragment : BaseFragment<ElephantInfoFragmentBinding>(
    ElephantInfoFragmentBinding::inflate
){

    private val elephantInfoViewModel: ElephantInfoViewModel by viewModel()

    override fun loadContent() {
        super.loadContent()
        elephantInfoViewModel.doLoadElephantInfo.value = true
    }

    override fun setUpView() {
        super.setUpView()
        initLoadElephantInfoObserver()
        initToolbar()
    }

    private fun initLoadElephantInfoObserver(){
        elephantInfoViewModel.loadElephantInfo.observe(this, Observer { info ->
            when(info){
                is UIState.Success ->{
                    ImageUtil.loadImage(info.data.image, viewBinding.ivProfilePicture)
                    viewBinding.tvElephantName.text = info.data.name
                    viewBinding.tvAffiliation.text = info.data.affiliation
                    viewBinding.tvElephantInfoSex.text = info.data.sex
                    viewBinding.tvElephantInfoSpecies.text = info.data.species
                    viewBinding.tvElephantAdditionalInfo.text = info.data.note
                    viewBinding.tvElephantInfoDob.text = info.data.dob
                    viewBinding.tvElephantInfoDod.text = info.data.dod
                    viewBinding.tvFollowersCount.text = info.data.followers.toString()
                    viewBinding.tvFollowingCount.text = info.data.following.toString()
                    viewBinding.tvMemoriesCount.text = info.data.memories.toString()
                }
            }
        })
    }


    private fun initToolbar(){

        getBaseActivity().setSupportActionBar(viewBinding.toolBar)
        viewBinding.toolBar.setNavigationOnClickListener {
            getBaseActivity().onBackPressed()
        }
    }




}