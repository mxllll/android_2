package com.example.android2

interface MainInterface {
    fun showFirstFragment()
    fun showSecondFragment()
    fun showThirdFragment()
    fun showFourthFragment()
    fun hideSecondBtn()
    fun hideThirdBtn()
    fun hideFourthBtn()

    var firstNum: Float?
    var secondNum: Float?
    var result: Float?

    fun saveFirstNum(num: Float)
    fun saveSecondNum(num: Float)
}