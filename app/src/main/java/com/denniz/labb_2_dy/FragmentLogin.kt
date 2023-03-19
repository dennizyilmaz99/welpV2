package com.denniz.labb_2_dy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.*

class FragmentLogin : Fragment() {


    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val displayUsername = view.findViewById<TextView>(R.id.displayUsername)

        view.findViewById<FragmentContainerView>(R.id.frag_container_sub)
        val fragmentSpawner = view.findViewById<FragmentContainerView>(R.id.frag_container_sub)


        view.findViewById<Button>(R.id.btn_SpawnSub).setOnClickListener() {
            createFragment(fragmentSpawner)
        }

        sharedViewModel.greetingText().let{
            displayUsername.text = it
        }



        return view
    }

    private fun createFragment(fragmentContainer: FragmentContainerView) {

        if (childFragmentManager.findFragmentByTag("MyTag") == null) {
            println("TRUE")
            childFragmentManager.commit {
                setReorderingAllowed(true)
                add(fragmentContainer.id, FragmentNewsletter(), "MyTag")
            }
        }
        }

        }
