package com.nqmgaming.kotlin.lab2.b7

import kotlin.system.exitProcess

fun main() {
    val managerTeacher = ManagerTeacher()
    val teacher1 = Teacher(1, "Nguyen Van A", 30, "Ha Noi", 1000.0, 100.0, 200.0, 1100.0)
    val teacher2 = Teacher(2, "Nguyen Van B", 35, "Ha Noi", 1200.0, 150.0, 250.0, 1300.0)
    val teacher3 = Teacher(3, "Nguyen Van C", 40, "Ha Noi", 1500.0, 200.0, 300.0, 1600.0)
    managerTeacher.addTeacher(teacher1)
    managerTeacher.addTeacher(teacher2)
    managerTeacher.addTeacher(teacher3)

    while (true) {
        printMenu()
        when (readInt()) {
            1 -> addTeacher(managerTeacher)
            2 -> deleteTeacher(managerTeacher)
            3 -> getSalary(managerTeacher)
            4 -> managerTeacher.listTeacher.forEach { it.printTeacherInfo() }
            0 -> exit()
            else -> println("Invalid choice")
        }
    }
}

fun printMenu() {
    println(
        """
        Menu:
        1. Add teacher
        2. Delete teacher
        3. Get salary
        4. Print all teachers
        0. Exit
        Enter your choice:
    """.trimIndent()
    )
}

fun addTeacher(managerTeacher: ManagerTeacher) {
    println("Enter teacher id:")
    var id = readInt()
    if (managerTeacher.listTeacher.any { it.id == id }) {
        println("Teacher with id $id already exists. Please enter a different id.")
        id = readInt()
    }
    println("Enter teacher name:")
    val name = readString()
    println("Enter teacher age:")
    var age = readInt()
    while (age < 0) {
        println("Invalid input. Please enter a non-negative integer.")
        age = readInt()
    }
    println("Enter teacher hometown:")
    val hometown = readString()
    println("Enter teacher real salary:")
    val realSalary = readDouble()
    println("Enter teacher penalty:")
    val penalty = readDouble()
    println("Enter teacher bonus:")
    val bonus = readDouble()
    println("Enter teacher salary:")
    val salary = readDouble()
    val teacher = Teacher(id, name, age, hometown, realSalary, penalty, bonus, salary)
    managerTeacher.addTeacher(teacher)
    println("Teacher added successfully.")
}

fun deleteTeacher(managerTeacher: ManagerTeacher) {
    println("Enter teacher id:")
    val id = readInt()
    managerTeacher.deleteTeacherById(id)
}

fun getSalary(managerTeacher: ManagerTeacher) {
    println("Enter teacher id:")
    val id = readInt()
    val salary = managerTeacher.getSalaryById(id)
    println("Salary of teacher with id $id is: $salary")
}

fun exit() {
    println("Goodbye!")
    exitProcess(0)
}

fun readInt(): Int {
    while (true) {
        val input = readlnOrNull()
        if (input != null && input.toIntOrNull() != null) {
            return input.toInt()
        }
        println("Invalid input. Please enter a valid integer.")
    }
}

fun readDouble(): Double {
    while (true) {
        val input = readlnOrNull()
        if (input != null && input.toDoubleOrNull() != null) {
            return input.toDouble()
        }
        println("Invalid input. Please enter a valid double.")
    }
}

fun readString(): String {
    while (true) {
        val input = readlnOrNull()
        if (!input.isNullOrBlank()) {
            return input
        }
        println("Invalid input. Please enter a non-empty string.")
    }
}