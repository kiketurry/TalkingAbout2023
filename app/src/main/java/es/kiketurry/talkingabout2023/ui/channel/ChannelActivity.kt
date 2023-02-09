package es.kiketurry.talkingabout2023.ui.channel

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import es.kiketurry.talkingabout2023.databinding.ActivityLiveDataBinding
import es.kiketurry.talkingabout2023.extension.showSnack
import es.kiketurry.talkingabout2023.injection.Injection
import es.kiketurry.talkingabout2023.ui.base.BaseActivity
import kotlinx.coroutines.launch

class ChannelActivity : BaseActivity<ActivityLiveDataBinding>() {

    private lateinit var channelViewModel: ChannelViewModel

    override fun inflateBinding() {
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        channelViewModel = ViewModelProvider(this, Injection.provideViewModelFactory(this))[ChannelViewModel::class.java]
        channelViewModel.restoreDataViewModelIfExists(channelViewModel.getKeysNeedSaveStateHandler())
    }

    override fun callViewModelSaveData() {
        channelViewModel.saveDataViewModelCouldBeDestroyed(channelViewModel.getKeysNeedSaveStateHandler())
    }

    override fun observeViewModel() {
        channelViewModel.loadingMutableLiveData.observe(this, this::showLoading)
        channelViewModel.errorMutableLiveData.observe(this, this::showErrorInformativeOnly)
        lifecycleScope.launch {
            channelViewModel.channel.collect() {
                binding.layout.showSnack(message = "Se ha disparado el channel")
            }
        }
    }

    override fun createAfterInflateBindingSetupObserverViewModel(savedInstanceState: Bundle?) {
        binding.btLoad.setOnClickListener {
            channelViewModel.loadInfo()
        }
    }

    override fun configureToolbar() = Unit

    override fun needRefreshTokenInViewModel() = Unit
}