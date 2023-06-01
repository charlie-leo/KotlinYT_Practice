package com.kotlin.lib


fun main(){
    val one = MyClass()
    one.main()
}

class MyClass {

    fun main(){
        println("Working Fine")
        demoSuspend()

    }

     fun demoSuspend(){
        var work = "doing this is good";
        var plesent =  "following the main"

        val arrayItem = arrayListOf<String>()
        arrayItem.add("Monday")
        arrayItem.add("Tuesday")
        arrayItem.add("Wednesday")
        arrayItem.add("Thursday")
        arrayItem.add("Friday")

        for (item in arrayItem) {
            if ("Monday" == item) {
                println("Today is Monday")
                continue
            }
            if ("Tuesday" == item) {
                println("Today is Tuesday")
                continue
            }
            if ("Wednesday" == item) {
                println("Today is Wednesday")
                continue
            }
        }
    }
}