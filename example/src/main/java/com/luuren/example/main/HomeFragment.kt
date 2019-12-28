package com.luuren.example.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.luuren.example.R
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private  val viewModel by inject<HomeViewModel>()
    private  val container by inject<NavController>{
        parametersOf(toMotion)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toMotion.onClick {
            container.navigate(R.id.action_homeFragment_to_motionFragment)
        }

    }

}
