package com.nqmgaming.kotlin.lab2.b8

data class Card(
    val id: Int,
    val student: Student,
    val borrowDate: String,
    val paymentDate: String,
    val bookId: Int,
){
    fun printCardInfo(){
        println("-----------------------------")
        println("Card ID: $id")
        println("Student ID: ${student.id}")
        println("Student Name: ${student.name}")
        println("Student Age: ${student.age}")
        println("Student School: ${student.school}")
        println("Borrow Date: $borrowDate")
        println("Payment Date: $paymentDate")
        println("Book ID: $bookId")
        println("-----------------------------")
    }
}
