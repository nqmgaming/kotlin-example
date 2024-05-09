package com.nqmgaming.kotlin.lab2

import kotlin.system.exitProcess


private fun main() {
    while (true) {
        printMenu()
        when (readln().toIntOrNull() ?: -1) {
            1 -> quadraticEquation()
            2 -> printQuarterOfYear()
            3 -> leapYearChecker()
            4 -> student()
            0 -> exit()
            else -> println(Messages.INVALID_CHOICE)
        }
    }
}

private fun printMenu() {
    println(
        """
        Menu:
        1. Giải phương trình bậc 2
        2. Hiển thị quý của năm
        3. Kiểm tra năm nhuận
        4. Quản lý sinh viên
        0. Thoát
        Enter your choice:
    """.trimIndent()
    )
}

private fun quadraticEquation() {
    var a = 0.0
    var b = 0.0
    println("Nhập a:")
    var s = readlnOrNull()
    if (s != null) a = s.toDouble()
    println("Nhập b:")
    s = readlnOrNull()
    if (s != null) b = s.toDouble()
    if (a == 0.0 && b == 0.0) {
        println("Phương trình vô số nghiệm")
    } else if (a == 0.0 && b != 0.0) {
        println("Phương trình vô nghiệm")
    } else {
        val x = -b / a
        println("No x = $x")
    }
}

private fun printQuarterOfYear() {
    var month = 0
    println("Enter month:")
    val s: String? = readlnOrNull()
    if (s != null) month = s.toInt()
    when (month) {
        1, 2, 3 -> println("Month $month is in quarter 1")
        4, 5, 6 -> println("Month $month is in quarter 2")
        7, 8, 9 -> println("Month $month is in quarter 3")
        10, 11, 12 -> println("Month $month is in quarter 4")
        else -> println("Month $month is not valid")
    }
}

private fun leapYearChecker() {
    var year = 0
    var s: String?
    println("Leap Year Checker Program:")
    do {
        println("Enter a year:")
        s = readlnOrNull()
        while (s == null || s.toInt() < 0) {
            println("Invalid year input, please try again:")
            s = readlnOrNull()
        }
        year = s.toInt()
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            println("Year $year is a leap year")
        } else {
            println("Year $year is not a leap year")
        }
        print("Continue?(y/n):")
        s = readlnOrNull()
        if (s == "n")
            break;
    } while (true)
    println("End of program")
}

private fun student() {
    val students = mutableListOf<Student>()
    students.add(Student(1, "Nguyễn Văn A", "PH31902", 8.0, true, 20))
    students.add(Student(2, "Nguyễn Văn B", "PH31903", 7.0, false, 21))
    students.add(Student(3, "Nguyễn Văn C", "PH31904", 6.0, true, 22))
    while (true) {
        menuStudent()
        when (readln().toIntOrNull() ?: -1) {
            1 -> printListStudents(students)
            2 -> addStudent(students)
            3 -> editStudent(students)
            4 -> deleteStudent(students)
            else -> printErr(Messages.INVALID_CHOICE)
        }
    }
}

private fun menuStudent() {
    println(
        """
        Menu:
        1. Hiển thị thông tin sinh viên
        2. Thêm sinh viên
        3. Sửa thông tin sinh viên
        4. Xóa sinh viên
        5. Thoát
        Enter your choice:
    """.trimIndent()
    )
}

private fun printListStudents(students: List<Student>) {
    println("Danh sách sinh viên:")
    for (student in students) {
        student.printStudentInfo()
    }
}

private fun addStudent(students: MutableList<Student>) {
    val studentId = validateStudentId()
    if (validateStudentId(students, studentId)) {
        printErr("Mã sinh viên đã tồn tại")
        return
    }
    val nameStudent = validateStudentName()
    val scoreAvg = validateScoreAvg()
    println("Sinh viên đã tốt nghiệp?(y/n):")
    val isGraduated = readln() == "y"
    val age = validateAge()
    val student = Student(
        students.size + 1,
        nameStudent,
        studentId,
        scoreAvg,
        isGraduated,
        age
    )
    students.add(student)
    printSuccess(Messages.ADD_STUDENT_SUCCESS)
}

private fun editStudent(students: MutableList<Student>) {
    println("Nhập mã sinh viên cần sửa:")
    val studentId = validateStudentId()
    val student = students.find { it.studentId == studentId }
    if (student != null) {
        println("Tên cũ ${student.nameStudent}:")
        student.nameStudent = validateStudentName()
        println("Điểm trung bình cũ ${student.scoreAvg}:")
        student.scoreAvg = validateScoreAvg()
        println("Trạng thái tốt nghiệp cũ ${student.isGraduated}:")
        println("Sinh viên đã tốt nghiệp?(y/n):")
        student.isGraduated = readln() == "y"
        println("Tuổi cũ ${student.age}:")
        student.age = validateAge()
        printSuccess(Messages.EDIT_STUDENT_SUCCESS)
    } else {
        printErr(Messages.STUDENT_NOT_FOUND)
    }
}

private fun deleteStudent(students: MutableList<Student>) {
    println("Nhập mã sinh viên cần xóa:")
    val studentId = readln()
    val student = students.find { it.studentId == studentId }
    if (student != null) {
        students.remove(student)
        printSuccess(Messages.DELETE_STUDENT_SUCCESS)
    } else {
        printErr(Messages.STUDENT_NOT_FOUND)
    }
}

private fun validateStudentId(students: MutableList<Student>, studentId: String): Boolean {
    return students.any { it.studentId == studentId }
}

private fun validateStudentId(): String {
    var studentId: String? = null
    while (studentId.isNullOrEmpty()) {
        println("Nhập mã sinh viên:")
        studentId = readln()
        if (studentId.isEmpty()) {
            printErr(Messages.INVALID_STUDENT_ID)
        }
    }
    return studentId
}

private fun validateStudentName(): String {
    var nameStudent: String? = null
    while (nameStudent.isNullOrEmpty()) {
        println("Nhập tên sinh viên:")
        nameStudent = readln()
        if (nameStudent.isEmpty()) {
            printErr(Messages.INVALID_NAME)
        }
    }
    return nameStudent
}

private fun validateScoreAvg(): Double {
    var scoreAvg: Double? = null
    while (scoreAvg == null || scoreAvg < 0 || scoreAvg > 10) {
        println("Nhập điểm trung bình:")
        scoreAvg = readln().toDoubleOrNull()
        if (scoreAvg == null || scoreAvg < 0 || scoreAvg > 10) {
            printErr(Messages.INVALID_SCORE_AVG)
        }
    }
    return scoreAvg
}

private fun validateAge(): Int {
    var age: Int? = null
    while (age == null || age < 18) {
        println("Nhập tuổi:")
        age = readln().toIntOrNull()
        if (age == null || age < 18) {
            printErr(Messages.INVALID_AGE)
        }
    }
    return age
}

private fun exit() {
    println("Exiting program...")
    exitProcess(0)
}

fun printErr(errorMsg: String) {
    System.err.println(errorMsg)
}
fun printSuccess(successMsg: String) {
    val greenColor = "\u001b[32m"
    val resetColor = "\u001b[0m"
    println("$greenColor$successMsg$resetColor")
}