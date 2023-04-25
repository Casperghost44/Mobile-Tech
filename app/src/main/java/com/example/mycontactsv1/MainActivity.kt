package com.example.mycontactsv1

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontactsv1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.floatingActionButton.setOnClickListener{
            val intent = Intent(this , CreateContact::class.java)
            startActivity(intent)
        }


        viewModel.getAllContacts().observe(this , Observer { list->

            binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
            binding.recyclerView.adapter = ContactsAdapter(this,list)
        })
    }
}




