package com.luuren.kanmovie.common

import android.os.Build
import android.os.Bundle
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater

abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //开启元素共享动画，如需耗时操作（如加载网络图片）
        //请在耗时操作前先执行postponeEnterTransition(),完成后执行startPostponedEnterTransition()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            sharedElementEnterTransition = TransitionInflater.from(context)
                .inflateTransition(android.R.transition.move)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().apply {
            onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                if (isFinish()) {
                    finish()
                } else {
                    onBackPressed()
                }
            }
        }
    }

    abstract fun isFinish(): Boolean
}