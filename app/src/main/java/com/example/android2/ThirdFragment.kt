package com.example.android2

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.android2.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding
    private var UserMethods: MainInterface? = null

    var firstNum: Float = 0.0F
    var secondNum: Float = 0.0F

    override fun onAttach(context: Context) {
        super.onAttach(context)
        UserMethods = context as MainInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstNum = UserMethods?.firstNum!!
        secondNum = UserMethods?.secondNum!!

        binding.plus.setOnClickListener {
            UserMethods?.result = firstNum + secondNum
            Toast.makeText(context, "Сложение выполнено", Toast.LENGTH_SHORT).show()
        }

        binding.minus.setOnClickListener {
            UserMethods?.result = firstNum - secondNum
            Toast.makeText(context, "Вычитание выполнено", Toast.LENGTH_SHORT).show()
        }

        binding.multiply.setOnClickListener {
            UserMethods?.result = firstNum * secondNum
            Toast.makeText(context, "Умножение выполнено", Toast.LENGTH_SHORT).show()
        }

        binding.divide.setOnClickListener {
            UserMethods?.result = firstNum / secondNum
            Toast.makeText(context, "Деление выполнено", Toast.LENGTH_SHORT).show()
        }

        binding.btnNext3.setOnClickListener {
            (requireActivity() as? MainInterface)?.showFourthFragment()
        }

        binding.btnReturn3.setOnClickListener {
            (requireActivity() as? MainInterface)?.hideThirdBtn()
            activity?.onBackPressed()
        }
    }
}