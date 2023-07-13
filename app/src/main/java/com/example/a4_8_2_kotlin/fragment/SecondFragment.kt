package com.example.a4_8_1_kotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.a4_8_2_kotlin.R
import com.example.a4_8_2_kotlin.model.User

class SecondFragment : Fragment() {
    var listner: SecondListner? = null

    //    ActivitySecondFragmentBinding SeconBinding;
    var secondText: TextView? = null
    var secondButtom: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.activity_second_fragment, container, false)
        secondText = view.findViewById(R.id.second_text)
        secondButtom = view.findViewById(R.id.second_buttom)
        initViews()
        return view
    }

    interface SecondListner {
        fun onSeconSend(user: User?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listner = if (context is SecondListner) {
            context
        } else {
            throw RuntimeException(context.toString() + "Runtimeda Xatolik!")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listner = null
    }

    fun updateSecondText(user: User?) {
        secondText!!.text = user.toString()
    }

    fun initViews() {
        secondButtom!!.setOnClickListener {

            var user:User=User("Fayzullo","Fozilov")

            listner!!.onSeconSend(user)

        }
    }
}