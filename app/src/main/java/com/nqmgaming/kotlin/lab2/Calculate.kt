package com.nqmgaming.kotlin.lab2

fun main() {
    val numberA: Int? = 5
    val numberB: Int? = 10
    val sum = sum(numberA!!, numberB!!)
    val subtract = subtract(numberA, numberB)
    val squareNumberA = square(numberA)
    val divideNumberAByNumberB = divide(numberA.toFloat(), numberB.toFloat())
    println("Summary of two number $numberA and $numberB is: $sum")
    println("Subtract of two number $numberA and $numberB is: $subtract")
    println("Square of number $numberA is: $squareNumberA")
    println("Divide of number $numberA by number $numberB is: ${divideNumberAByNumberB()}")

}

val sum: (Int, Int) -> Int =
    { numberA: Int, numberB: Int -> (numberA + numberB) }

val subtract =
    { numberA: Int, numberB: Int -> (numberA - numberB) }

val square: (Int) -> Int = { number: Int -> number * number }

val divide: (Float, Float) -> () -> Float = { numberA: Float, numberB: Float ->
    {
        if (numberB == 0f) {
            println("Cannot divide by zero")
            0f
        } else {
            numberA / numberB
        }
    }
}