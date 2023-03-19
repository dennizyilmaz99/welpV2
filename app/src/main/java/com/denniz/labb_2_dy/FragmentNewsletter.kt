package com.denniz.labb_2_dy

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class FragmentNewsletter : Fragment() {

    private val userArray = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newsletter, container, false)
        val emailInput = view.findViewById<EditText>(R.id.email_textArea)

        view.findViewById<ImageButton>(R.id.close_Spawner).setOnClickListener(){
            parentFragmentManager.beginTransaction().remove(this).commit()
        }

        view.findViewById<Button>(R.id.button_Submit).setOnClickListener(){
            val email = emailInput.text.toString()
            if (email.isNotEmpty()) {
                userArray.add(email)
                Log.d("Emails:", userArray.toString())
                Snackbar.make(view, "Email submitted! Delete? Click UNDO", Snackbar.LENGTH_LONG)
                    .setAction("UNDO") {
                        userArray.remove(email)
                        Log.d("Emails:", userArray.toString())
                    }
                    .show()
                emailInput.text.clear()
            } else {
                val text = "You need to enter an email. Try again."
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}