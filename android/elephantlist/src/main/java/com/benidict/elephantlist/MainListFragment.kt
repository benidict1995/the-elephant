package com.benidict.elephantlist

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.benidict.core.base.BaseFragment
import com.benidict.core.ui.state.UIState
import com.benidict.domain.model.Elephant
import com.benidict.elephantlist.databinding.FragmentMainListBinding
import com.benidict.elephantlist.itemcontroller.ElephantItemController
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.benidict.core.util.Constant.EMPTY_STRING
import com.benidict.core.util.EventObserver
import com.benidict.core.util.SystemUtil

class MainListFragment : BaseFragment<FragmentMainListBinding>(
    FragmentMainListBinding::inflate
), ElephantItemController.CallBack, SearchView.OnQueryTextListener{

    private val mainListViewModel: MainListViewModel by viewModel()

    private lateinit var controller: ElephantItemController

    private lateinit var mLayoutManager: LinearLayoutManager

    override fun loadContent() {
        super.loadContent()
        mainListViewModel.doLoadElephantList.value = Pair(true, EMPTY_STRING)
    }

    override fun setUpView() {
        super.setUpView()

        initRecyclerView()
        initRefreshFeedClicked()
        initSearchView()
        initLoadElephantListObservable()
        initSaveElephantInfoObservable()
    }

    private fun initRecyclerView(){
        controller = ElephantItemController(this)
        mLayoutManager = LinearLayoutManager(activity)

        viewBinding.elephantRecyclerview.apply {
            layoutManager = mLayoutManager
        }.setController(controller)
    }

    private fun initSearchView(){
        viewBinding.svElephant.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        mainListViewModel.doLoadElephantList.value = Pair(true, if(newText.isNullOrEmpty()) EMPTY_STRING else newText)
        return true
    }

    override fun onItemSelected(elephant: Elephant) {
        mainListViewModel.doSaveElephantInfo.value = elephant
    }

    private fun initLoadElephantListObservable(){
        mainListViewModel.loadElephantList.observe(this, Observer { result ->
            when(result){
                UIState.Loading -> {
                    viewBinding.pdMainList.visibility = VISIBLE
                    viewBinding.groupError.visibility = GONE
                }
                is UIState.Success -> {
                    viewBinding.pdMainList.visibility = GONE
                    controller.setData(result.data)
                }
                is UIState.Error -> {
                    viewBinding.pdMainList.visibility = GONE
                    viewBinding.groupError.visibility = VISIBLE
                }
            }
        })
    }

    private fun initSaveElephantInfoObservable(){
        mainListViewModel.saveElephantInfo.observe(this, EventObserver { result ->
                when(result){
                    is UIState.Success ->{
                        hideKeyBoard()
                        findNavController().navigate(R.id.navigateToElephantInfoFragment)
                    }
                }
        })
    }


    private fun initRefreshFeedClicked() = viewBinding.viewRefresh.setOnClickListener {
        mainListViewModel.doLoadElephantList.value = Pair(true, EMPTY_STRING)
    }

    private fun hideKeyBoard(){
        SystemUtil.hideKeyboard(getBaseActivity(), viewBinding.svElephant)
    }


}