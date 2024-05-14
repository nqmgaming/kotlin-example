package com.nqmgaming.kotlin.lab2.b7

data class Teacher(
    val id: Int,
    override var name: String,
    override var age: Int,
    override var hometown: String,
    val realSalary: Double,
    val penalty: Double,
    val bonus: Double,
    val salary: Double,
) : Human(name, age, hometown) {
    fun printTeacherInfo() {
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