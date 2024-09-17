package org.example

class Calculator{
    companion object{
        fun <T: Number> sum(firstVal: T, secondVal: T): Int{
            return firstVal.toInt() + secondVal.toInt()
        }
    }
}