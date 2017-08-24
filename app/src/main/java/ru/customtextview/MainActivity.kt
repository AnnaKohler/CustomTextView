package ru.customtextview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt:VerticalTextView = findViewById(R.id.textView) as VerticalTextView
        txt.orientation = VerticalTextView.Orientation.VERTICAL
    }
}
