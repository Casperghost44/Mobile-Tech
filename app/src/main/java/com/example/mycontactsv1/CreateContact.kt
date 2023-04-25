package com.example.mycontactsv1


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mycontactsv1.databinding.ActivityCreateContactBinding

class CreateContact : AppCompatActivity() {
    private lateinit var binding : ActivityCreateContactBinding


    val viewModel : ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateContactBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.save.setOnClickListener{
            createContact(it)
        }
    }


    private fun createContact(it: View?) {

        val name = binding.etName.text.toString()
        val number = binding.etNumber.text.toString()


        val data = Contacts(null,name = name , number = number)


        viewModel.addContacts(data)


        Toast.makeText(this@CreateContact, "Saved", Toast.LENGTH_SHORT).show()


        startActivity(Intent(this@CreateContact, MainActivity::class.java))
    }


}