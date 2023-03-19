package com.denniz.labb_2_dy

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class FragmentHome : Fragment() {


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
// Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.findViewById<Button>(R.id.aboutBtn).setOnClickListener() {
            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentAbout)
        }
        view.findViewById<Button>(R.id.signInBtn).setOnClickListener(){
            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentSignin)
        }

        var isBlue = true
        view.findViewById<Button>(R.id.changeColor_btn).setOnClickListener() {
            isBlue = !isBlue
            val color = if (isBlue) Color.parseColor("#FF018786") else Color.parseColor("#FF000000")
            it.setBackgroundColor(color)
        }
        return view }
}