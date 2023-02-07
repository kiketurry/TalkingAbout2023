package es.kiketurry.talkingabout2023.ui.base

import androidx.fragment.app.FragmentManager

class BaseActivityControlShowLoading private constructor() {

    private var loadingIsShowing: Boolean = false

    companion object {
        private var INSTANCE: BaseActivityControlShowLoading? = null

        @Synchronized
        fun getInstance(): BaseActivityControlShowLoading {
            if (INSTANCE == null) {
                INSTANCE = BaseActivityControlShowLoading()
            }
            return INSTANCE!!
        }
    }

    @Synchronized
    fun canShowLoading(fragmentManager: FragmentManager, tag: String): Boolean {
        val canShow = if (loadingIsShowing) {
            false
        } else {
            fragmentManager.findFragmentByTag(tag) == null
        }
        if (canShow) {
            loadingIsShowing = true
        }
        return canShow
    }

    @Synchronized
    fun canHideLoading(fragmentManager: FragmentManager, tag: String): Boolean {
        val canHide = fragmentManager.findFragmentByTag(tag) != null
        if (canHide) {
            loadingIsShowing = false
        }
        return canHide
    }

}