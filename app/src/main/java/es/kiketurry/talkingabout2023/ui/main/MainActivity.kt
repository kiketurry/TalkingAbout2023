package es.kiketurry.talkingabout2023.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import es.kiketurry.talkingabout2023.databinding.ActivityMainBinding
import es.kiketurry.talkingabout2023.injection.Injection
import es.kiketurry.talkingabout2023.ui.base.BaseActivity
import es.kiketurry.talkingabout2023.ui.channel.ChannelActivity
import es.kiketurry.talkingabout2023.ui.livedata.LiveDataActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var mainViewModel: MainViewModel

    override fun inflateBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupViewModel() {
        mainViewModel = ViewModelProvider(this, Injection.provideViewModelFactory(this))[MainViewModel::class.java]
        mainViewModel.restoreDataViewModelIfExists(mainViewModel.getKeysNeedSaveStateHandler())
    }

    override fun callViewModelSaveData() = Unit

    override fun observeViewModel() = Unit

    override fun createAfterInflateBindingSetupObserverViewModel(savedInstanceState: Bundle?) {
        binding.btLiveDataExample.setOnClickListener { goToLiveDataActivity() }
        binding.btChannelExample.setOnClickListener { goToChannelActivity() }
    }

    override fun configureToolbar() = Unit

    override fun needRefreshTokenInViewModel() = Unit

    private fun goToLiveDataActivity() {
        val intent = Intent(this, LiveDataActivity::class.java)
        startActivity(intent)
    }

    private fun goToChannelActivity() {
        val intent = Intent(this, ChannelActivity::class.java)
        startActivity(intent)
    }
}