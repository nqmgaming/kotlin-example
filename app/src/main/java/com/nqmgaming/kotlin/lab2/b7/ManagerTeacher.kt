package com.nqmgaming.kotlin.lab2.b7

class ManagerTeacher {
    private val _listTeacher = mutableListOf<Teacher>()
    val listTeacher: List<Teacher>
        get() = _listTeacher

    fun addTeacher(teacher: Teacher) {
        _listTeacher.add(teacher)
    }

    fun deleteTeacherById(id: Int) {
        _listTeacher.removeIf { it.id == id }
    }

    fun getSalaryById(id: Int): Double {
        // return salary = realSalary + bonus - penalty
        val teacher = _listTeacher.find { it.id == id }
        if (teacher == null) {
            println("Cannot find teacher with id $id")
            return 0.0
        }
        val salary = teacher.realSalary.plus(teacher.bonus).minus(teacher.penalty)
        return salary ?: 0.0
    }


}