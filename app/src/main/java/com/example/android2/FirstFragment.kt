package com.example.android2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    var UserMethods: MainInterface? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        UserMethods = context as MainInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (UserMethods?.firstNum != null) binding.ed1.setText(UserMethods?.firstNum.toString())

        binding.btnNext1.setOnClickListener {
            if (UserMethods != null) {
                UserMethods?.saveFirstNum(binding.ed1.text.toString().toFloat())
                (requireActivity() as? MainInterface)?.showSecondFragment()
            }
        }

        binding.btnReturn1.setOnClickListener {
            activity?.onBackPressed()
        }
    }
}