package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding
import com.example.viewmodeldemo.models.StudentModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val myModel = StudentModel()
        val myModel = ViewModelProvider(this).get(StudentModel::class.java)

        binding.myData = myModel

        //using live data, add in observer
        /*
        myModel.studentID.observe(this, Observer {
                newValue -> binding.showID.text = newValue
        })

        myModel.name.observe(this, Observer {
                newValue -> binding.showName.text = newValue
        })
         */

        //var studentID :String = ""
        //var name :String = ""

        binding.btnSet.setOnClickListener(){
            myModel.studentID.value = "W1234"
            myModel.name.value = "John"

            binding.invalidateAll()
        }

        //Used the mutableLiveData to replace the get btn function
        /*
        binding.btnGet.setOnClickListener(){
            binding.showID.text = myModel.studentID.value
            binding.showName.text = myModel.name.value
        }
        */

    }
}