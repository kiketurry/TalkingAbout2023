package es.kiketurry.talkingabout2023.ui.livedata

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import es.kiketurry.talkingabout2023.databinding.ActivityLiveDataBinding
import es.kiketurry.talkingabout2023.injection.Injection
import es.kiketurry.talkingabout2023.ui.base.BaseActivity

class LiveDataActivity : BaseActivity<ActivityLiveDataBinding>() {

    private lateinit var liveDataViewModel: LiveDataViewModel

    override fun inflateBinding() {
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        liveDataViewModel = ViewModelProvider(this, Injection.provideViewModelFactory(this))[LiveDataViewModel::class.java]
        liveDataViewModel.restoreDataViewModelIfExists(liveDataViewModel.getKeysNeedSaveStateHandler())
    }

    override fun callViewModelSaveData() {
        liveDataViewModel.saveDataViewModelCouldBeDestroyed(liveDataViewModel.getKeysNeedSaveStateHandler())
    }

    override fun observeViewModel() {
        liveDataViewModel.loadingMutableLiveData.observe(this, this::showLoading)
        liveDataViewModel.errorMutableLiveData.observe(this, this::showErrorInformativeOnly)
    }

    override fun createAfterInflateBindingSetupObserverViewModel(savedInstanceState: Bundle?) {
        binding.btLoad.setOnClickListener {
            liveDataViewModel.loadInfo()
        }
    }

    override fun configureToolbar() = Unit

    override fun needRefreshTokenInViewModel() = Unit
}