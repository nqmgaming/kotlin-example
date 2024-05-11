package com.nqmgaming.kotlin.lab2.b7

data class Teacher(
    val id: Int,
    val name: String,
    val age: Int,
    val hometown: String,
    val realSalary: Double,
    val penalty: Double,
    val bonus: Double,
    val salary: Double
){
    fun printTeacherInfo(){
        println("-----------------------------")
        println("Teacher ID: $id")
        println("Name: $name")
        println("Age: $age")
        println("Hometown: $hometown")
        println("Real Salary: $realSalary")
        println("Penalty: $penalty")
        println("Bonus: $bonus")
        println("Salary: $salary")
        println("-----------------------------")
    }
}
