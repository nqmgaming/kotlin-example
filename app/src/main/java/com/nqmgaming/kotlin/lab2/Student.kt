package com.nqmgaming.kotlin.lab2

data class Student(
    val id: Int,
    var nameStudent: String,
    val studentId: String,
    var scoreAvg: Double,
    var isGraduated: Boolean? = null,
    var age: Int? = null
) {
    fun printStudentInfo() {
        println("-----------------------------")
        println("Student ID: $studentId")
        println("Name: $nameStudent")
        println("Score Average: $scoreAvg")
        println("Graduated: ${isGraduated ?: "Not graduated"}")
        println("Age: ${age ?: "Unknown"}")
        println("-----------------------------")
    }

}
