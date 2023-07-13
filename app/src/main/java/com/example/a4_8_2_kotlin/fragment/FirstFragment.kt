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
import java.lang.reflect.Member

class FirstFragment : Fragment() {
    private var listner: FirstListner? = null

    // ActivityFirstFragmentBinding firstBinding;
    var firstText: TextView? = null
    var firstButtom: Button? = null
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_first_fragment, container, false)
        firstText = view.findViewById(R.id.first_text)
        firstButtom = view.findViewById(R.id.first_button)
        initViews()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listner = if (context is FirstListner) {
            context
        } else {
            throw RuntimeException(context.toString() + "Runtime ishlamayapdi!")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listner = null
    }

    interface FirstListner {
        fun onFirstSend(user: User?)
    }

    fun updateFirstText(user: User?) {
        firstText!!.text = user.toString()
    }

    fun initViews() {
        firstButtom!!.setOnClickListener {

            var user:User= User("Shaxzod", "Aliyev")

            listner!!.onFirstSend(user)

        }
    }
}
