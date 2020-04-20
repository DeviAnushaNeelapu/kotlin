package com.example.roomdatabase.Database

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.roomdatabase.com.example.roomdatabase.database.StudentDetails

class StudentRepository(application: Application){

    private val studentDao : StudentDao
    private val studentlist : LiveData<List<StudentDetails>>

    init {
        val studentDatabase:StudentDatabase = StudentDatabase.getInstance(application)
        studentDao = studentDatabase.studentDao
        studentlist = studentDao.getAll()
    }


    fun getAll():LiveData<List<StudentDetails>>{
        return studentlist
    }

    fun insert(studentDetails: StudentDetails){
        studentDao.insert(studentDetails)
    }

}