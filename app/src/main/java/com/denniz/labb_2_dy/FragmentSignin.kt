package com.denniz.labb_2_dy

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation


class FragmentSignin : Fragment() {

    private var userList = ArrayList<UserSignin>(
        listOf(
            UserSignin(
                "Denniz", "denniz"
            )
        )
    )

    private val sharedViewModel: SharedViewModel by activityViewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_signin, container, false)
        val txtUsername = view.findViewById<EditText>(R.id.textUsername)
        val txtPass = view.findViewById<EditText>(R.id.textPass)

        view.findViewById<Button>(R.id.button_signIn).setOnClickListener(){
            if (txtUsername.text.toString().isEmpty() || txtPass.text.toString().isEmpty()) {
                val text = "No credentials, Try again."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            } else if (txtUsername.text.toString() != userList[0].username && txtPass.text.toString() != userList[0].password) {
                val text = "Wrong username and password. Try again."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            } else if (txtUsername.text.toString() != userList[0].username){
                val text = "Wrong username. Try again."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            } else if (txtPass.text.toString() != userList[0].password){
                val text = "Wrong password. Try again."
                val duration = Toast.LENGTH_SHORT
                val toast = Toast.makeText(context, text, duration)
                toast.show()
            }
            else {
                sharedViewModel.sharedData = txtUsername.text.toString()
                Navigation.findNavController(view).navigate(R.id.action_fragmentSignin5_to_fragmentLogin)

            }
        }


        return view }
}
