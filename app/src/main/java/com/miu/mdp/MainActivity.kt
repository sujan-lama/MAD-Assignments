package com.miu.mdp

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn.setOnClickListener {
            if (versionEditText.text.isEmpty()) {
                versionEditText.error = "Please enter a Android Version"
                return@setOnClickListener
            }

            if (codeEditText.text.isEmpty()) {
                codeEditText.error = "Please enter a Android code name"
                return@setOnClickListener
            }

            val tableRow = TableRow(applicationContext)
            tableRow.setPadding(18)
            tableRow.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.pink))

            val layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 24, 0, 0)
            tableRow.layoutParams = layoutParams

            val versionTextView = TextView(applicationContext)
            versionTextView.text = versionEditText.text.toString()
            versionTextView.typeface = Typeface.SERIF
            versionTextView.textSize = 16f
            versionTextView.gravity = Gravity.CENTER_HORIZONTAL
            tableRow.addView(versionTextView)

            val codeTextView = TextView(applicationContext)
            codeTextView.text = codeEditText.text.toString()
            codeTextView.textSize = 16f
            codeTextView.gravity = Gravity.CENTER_HORIZONTAL
            codeTextView.typeface = Typeface.SERIF
            tableRow.addView(codeTextView)

            tableLayout.addView(tableRow, layoutParams)

            versionEditText.text.clear()
            codeEditText.text.clear()
            codeEditText.clearFocus()
        }
    }
}