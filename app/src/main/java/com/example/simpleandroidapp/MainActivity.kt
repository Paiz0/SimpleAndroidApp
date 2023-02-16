package com.example.simpleandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var factLabel: TextView
    private lateinit var prevButton: Button
    private lateinit var nextButton: Button

    private var facts = arrayOf(
        "You can't hum if you're holding your nose.",
        "Walmart has a lower acceptance rate than Harvard."
    )
    private var factIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //connecting our views
        this.connectViews()

        //setting up callbacks
        this.setupCallbacks()
    }

    private fun connectViews() {

        this.factLabel = this.findViewById(R.id.fact_label)
        this.prevButton = this.findViewById(R.id.Prev_button)
        this.nextButton = this.findViewById(R.id.Next_button)
    }

    private fun setupCallbacks() {

        this.prevButton.setOnClickListener{ view: View ->

            this.adjustFactIndex(adjustment = -1)
            this.factLabel.text = this.facts[this.factIndex]
            println("Previous button was clicked")

        }

        this.nextButton.setOnClickListener{ view: View ->
            this.adjustFactIndex(adjustment = 1)
            this.factLabel.text = this.facts[this.factIndex]
            println("Next button was clicked")

        }
    }

    private fun adjustFactIndex(adjustment: Int) {

        this.factIndex += adjustment

        if (this.factIndex < 0 ) {
            this.factIndex = this.facts.size - 1
        }
        else if (this.factIndex >= this.facts.size) {
            this.factIndex = 0
        }

        //this.factLabel.text = "Something"
    }
}