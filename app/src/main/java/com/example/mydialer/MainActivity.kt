package com.example.mydialer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view,
                    ContentFragment::class.java, null)
                .commit()
        }

        val searchString = findViewById<EditText>(R.id.et_search)
        searchString.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(request: Editable) {}

            override fun beforeTextChanged(request: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(request: CharSequence, start: Int,
                                       before: Int, count: Int) {
                ContentFragment().search(request)
            }
        })

    }

}