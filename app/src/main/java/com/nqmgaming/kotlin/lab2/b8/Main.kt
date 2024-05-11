package com.nqmgaming.kotlin.lab2.b8

import android.os.Build
import androidx.annotation.RequiresApi
import com.nqmgaming.kotlin.lab2.b7.readInt
import com.nqmgaming.kotlin.lab2.b7.readString
import java.time.LocalDate
import kotlin.system.exitProcess

fun main() {
    val student1 = Student(1, "John", 20, "ABC School")
    val student2 = Student(2, "Alice", 21, "XYZ School")
    val student3 = Student(3, "Bob", 22, "DEF School")
    val student4 = Student(4, "Cindy", 23, "GHI School")
    val student5 = Student(5, "David", 24, "JKL School")

    val card1 = Card(1, student1, "01/01/2021", "01/02/2021", 1)
    val card2 = Card(2, student2, "02/01/2021", "02/02/2021", 2)
    val card3 = Card(3, student3, "03/01/2021", "03/02/2021", 3)
    val card4 = Card(4, student4, "04/01/2021", "04/02/2021", 4)
    val card5 = Card(5, student5, "05/01/2021", "05/02/2021", 5)

    val managerCard = ManagerCard()
    managerCard.addCard(card1)
    managerCard.addCard(card2)
    managerCard.addCard(card3)
    managerCard.addCard(card4)
    managerCard.addCard(card5)

    while (true) {
        printMenu()
        when (readInt()) {
            1 -> addCard(managerCard)
            2 -> deleteCard(managerCard)
            3 -> printAllCard(managerCard)
            4 -> exit()
            else -> println("Invalid choice")
        }

    }

}

fun printMenu() {
    println("1. Add new card")
    println("2. Delete card by ID")
    println("3. Print all card")
    println("4. Exit")
}

fun addCard(managerCard: ManagerCard) {
    println("Enter card ID:")
    var id = readInt()
    if (managerCard.listCard.any { it.id == id }) {
        println("Card with ID $id already exists. Please enter a different ID.")
        id = readInt()
    }
    println("Enter student ID:")
    val studentId = readInt()
    println("Enter borrow date:")
    val borrowDate = readString()
    println("Enter payment date:")
    val paymentDate = readString()
    println("Enter book ID:")
    val bookId = readInt()

    val student = managerCard.listCard.find { it.student.id == studentId }?.student
    if (student == null) {
        println("Student with ID $studentId does not exist.")
        return
    }

    val card = Card(id, student, borrowDate, paymentDate, bookId)
    managerCard.addCard(card)
}

fun deleteCard(managerCard: ManagerCard) {
    println("Enter card ID:")
    val id = readInt()
    managerCard.deleteCardById(id)
}

fun printAllCard(managerCard: ManagerCard) {
    managerCard.listCard.forEach { it.printCardInfo() }
}

fun exit() {
    println("Goodbye!")
    exitProcess(0)
}