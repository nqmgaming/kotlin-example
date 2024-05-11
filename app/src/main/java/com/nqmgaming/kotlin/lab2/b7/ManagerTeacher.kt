package com.nqmgaming.kotlin.lab2.b7

class ManagerTeacher {
    private val _listTeacher = mutableListOf<Teacher>()
    val listTeacher: List<Teacher>
        get() = _listTeacher

    fun addTeacher(teacher: Teacher) {
        if (_listTeacher.any { it.id == teacher.id }) {
            println("Teacher with id ${teacher.id} already exists. Please enter a different id.")
            return
        }
        _listTeacher.add(teacher)
    }

    fun deleteTeacherById(id: Int) {
        val teacher = _listTeacher.find { it.id == id }
        if (teacher == null) {
            println("Cannot find teacher with id $id")
            return
        }
        _listTeacher.remove(teacher)
        println("Teacher with id $id deleted successfully.")
    }

    fun getSalaryById(id: Int): Double {
        val teacher = _listTeacher.find { it.id == id }
        if (teacher == null) {
            println("Cannot find teacher with id $id")
            return 0.0
        }
        val salary = teacher.realSalary.plus(teacher.bonus).minus(teacher.penalty)
        return salary ?: 0.0
    }


}