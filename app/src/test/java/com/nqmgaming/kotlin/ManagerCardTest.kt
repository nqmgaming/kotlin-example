package com.nqmgaming.kotlin

import com.nqmgaming.kotlin.lab2.b8.Card
import com.nqmgaming.kotlin.lab2.b8.ManagerCard
import com.nqmgaming.kotlin.lab2.b8.Student
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
class ManagerCardTest {

    @Test
    fun `addCard adds a card to the list`() {
        val managerCard = ManagerCard()
        val student = Student(1, "John", 20, "ABC School")
        val card = Card(1, student, "01/01/2021", "01/02/2021", 1)

        managerCard.addCard(card)

        assertTrue(managerCard.listCard.contains(card))
    }

    @Test
    fun `deleteCardById removes a card from the list`() {
        val managerCard = ManagerCard()
        val student = Student(1, "John", 20, "ABC School")
        val card = Card(1, student, "01/01/2021", "01/02/2021", 1)
        managerCard.addCard(card)

        managerCard.deleteCardById(1)

        assertFalse(managerCard.listCard.contains(card))
    }

    @Test
    fun `deleteCardById does nothing when card is not found`() {
        val managerCard = ManagerCard()
        val student = Student(1, "John", 20, "ABC School")
        val card = Card(1, student, "01/01/2021", "01/02/2021", 1)
        managerCard.addCard(card)

        managerCard.deleteCardById(2)

        assertTrue(managerCard.listCard.contains(card))
    }
}