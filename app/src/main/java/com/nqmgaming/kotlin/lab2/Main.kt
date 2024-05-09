package com.nqmgaming.kotlin.lab2

import kotlin.system.exitProcess


private fun main() {
    while (true) {
        printMenu()
        when (readln().toIntOrNull() ?: -1) {
            1 -> quadraticEquation()
            2 -> printQuarterOfYear()
            3 -> leapYearChecker()
            0 -> exit()
            else -> println("Invalid choice. Please try again.")
        }
    }

}

private fun printMenu() {
    println(
        """
        Menu:
        1. Giải phương trình bậc 2
        2. Hiển thị quý của năm
        3. Kiểm tra năm nhuận
        0. Thoát
        Enter your choice:
    """.trimIndent()
    )
}

private fun quadraticEquation() {
    var a = 0.0
    var b = 0.0
    println("Nhập a:")
    var s = readlnOrNull()
    if (s != null) a = s.toDouble()
    println("Nhập b:")
    s = readlnOrNull()
    if (s != null) b = s.toDouble()
    if (a == 0.0 && b == 0.0) {
        println("Phương trình vô số nghiệm")
    } else if (a == 0.0 && b != 0.0) {
        println("Phương trình vô nghiệm")
    } else {
        val x = -b / a
        println("No x = $x")
    }
}

private fun printQuarterOfYear() {
    var month = 0
    println("Enter month:")
    val s: String? = readlnOrNull()
    if (s != null) month = s.toInt()
    when (month) {
        1, 2, 3 -> println("Month $month is in quarter 1")
        4, 5, 6 -> println("Month $month is in quarter 2")
        7, 8, 9 -> println("Month $month is in quarter 3")
        10, 11, 12 -> println("Month $month is in quarter 4")
        else -> println("Month $month is not valid")
    }
}

private fun leapYearChecker() {
    var year = 0
    var s: String?
    println("Leap Year Checker Program:")
    do {
        println("Enter a year:")
        s = readlnOrNull()
        while (s == null || s.toInt() < 0) {
            println("Invalid year input, please try again:")
            s = readlnOrNull()
        }
        year = s.toInt()
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            println("Year $year is a leap year")
        } else {
            println("Year $year is not a leap year")
        }
        print("Continue?(y/n):")
        s = readlnOrNull()
        if (s == "n")
            break;
    } while (true)
    println("End of program")
}

private fun exit() {
    println("Exiting program...")
    exitProcess(0)
}