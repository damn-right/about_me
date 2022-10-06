package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLayoutBinding
    val Myname: MyName = MyName("alaska");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_layout)
binding.myName=Myname;
        binding.doneButton.setOnClickListener {  addNickname(it)}

    }
    private fun addNickname(view: View)
    {
        binding.apply {
            Myname.nickName= editNickname.text.toString();
            nickNameText.text =editNickname.text
            invalidateAll()
            editNickname.visibility=View.GONE
            nickNameText.visibility= View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0 )
    }

}





