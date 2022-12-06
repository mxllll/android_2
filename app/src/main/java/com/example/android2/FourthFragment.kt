package com.example.android2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android2.databinding.FragmentFourthBinding

class FourthFragment : Fragment() {
    lateinit var binding: FragmentFourthBinding

    var UserMethods: MainInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        UserMethods = context as MainInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvResult.text = UserMethods?.result.toString()

        binding.btnReturn4.setOnClickListener {
            (requireActivity() as? MainInterface)?.hideFourthBtn()
            activity?.onBackPressed()
        }
    }
}