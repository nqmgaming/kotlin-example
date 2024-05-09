package com.nqmgaming.kotlin

import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.system.exitProcess

@RequiresApi(Build.VERSION_CODES.O)
private fun main() {
    while (true) {
        printMenu()
        when (readln().toIntOrNull() ?: -1) {
            1 -> demonstrateInfixFunctions()
            2 -> demonstrateStringOperators()
            3 -> demonstratePersonClass()
            4 -> calculate()
            5 -> clearConsole()
            else -> println("Invalid choice. Please try again.")
        }
    }
}

private fun printMenu() {
    println(
        """
        Menu:
        1. Demonstrate Infix Functions
        2. Demonstrate String Operators
        3. Demonstrate Person Class
        4. Calculate with arithmetic operators
        5. Clear console
        6. Exit
        Enter your choice:
    """.trimIndent()
    )
}

private fun demonstrateInfixFunctions() {
    println("\nDemonstrating Infix Functions...")
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)
}

private fun demonstrateStringOperators() {
    println("\nDemonstrating String Operators...")
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..5])
}

private fun demonstratePersonClass() {
    println("\nDemonstrating Person Class...")
    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

private fun calculate() {
    println("\nCalculator...")
    println("Enter first number: ")
    val num1 = readln().toIntOrNull() ?: return
    println("Enter second number: ")
    var num2 = readln().toIntOrNull() ?: return
    while (num2 == 0) {
        println("Second number cannot be zero. Please enter a valid number: ")
        num2 = readln().toIntOrNull() ?: return
    }

    println("---------------------------\n")
    println("Sum: ${num1.plus(num2)}")
    println("Minus: ${num1.minus(num2)}")
    println("Multiply: ${num1.times(num2)}")
    println("Divide: ${num1.toFloat().div(num2.toFloat())}")
}

private fun exit() {
    println("Exiting...")
    exitProcess(0)
}

@RequiresApi(Build.VERSION_CODES.O)
private fun clearConsole() {
    try {
        val process = ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
        process.waitFor()
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

private class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
        println("$name likes $other")
    }
}

operator fun Int.times(str: String) = str.repeat(this)
operator fun String.get(range: IntRange) = substring(range = range)