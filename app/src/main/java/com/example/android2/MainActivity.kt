package com.example.android2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainInterface {
    lateinit var binding: ActivityMainBinding

    override var firstNum: Float? = null
    override var secondNum: Float? = null
    override var result: Float? = null

    override fun saveFirstNum(num: Float) {
        firstNum = num
    }

    override fun saveSecondNum(num: Float) {
        secondNum = num
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FirstFragment::class.java, null).commit()

        binding.btn2.visibility = View.INVISIBLE
        binding.btn3.visibility = View.INVISIBLE
        binding.btn4.visibility = View.INVISIBLE

        binding.btn1.setOnClickListener {
            showFirstFragment()
            binding.btn2.visibility = View.INVISIBLE
            binding.btn3.visibility = View.INVISIBLE
            binding.btn4.visibility = View.INVISIBLE
        }

        binding.btn2.setOnClickListener {
            showSecondFragment()
            binding.btn3.visibility = View.INVISIBLE
            binding.btn4.visibility = View.INVISIBLE
        }

        binding.btn3.setOnClickListener {
            showThirdFragment()
            binding.btn4.visibility = View.INVISIBLE
        }
    }

    override fun showFirstFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FirstFragment::class.java, null)
            .addToBackStack("first").commit()
    }

    override fun showSecondFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SecondFragment::class.java, null)
            .addToBackStack("second").commit()
        binding.btn2.visibility = View.VISIBLE
    }

    override fun showThirdFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ThirdFragment::class.java, null)
            .addToBackStack("third").commit()
        binding.btn3.visibility = View.VISIBLE
    }

    override fun showFourthFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FourthFragment::class.java, null)
            .addToBackStack("fourth").commit()
        binding.btn4.visibility = View.VISIBLE
    }

    override fun hideSecondBtn() {
        binding.btn2.visibility = View.INVISIBLE
    }

    override fun hideThirdBtn() {
        binding.btn3.visibility = View.INVISIBLE
    }

    override fun hideFourthBtn() {
        binding.btn4.visibility = View.INVISIBLE
    }
}