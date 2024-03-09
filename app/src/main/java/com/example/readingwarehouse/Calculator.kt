package com.example.readingwarehouse

import android.widget.EditText
import android.widget.TextView
object Calculator {
    fun calculateDiscount(editTextPrice: EditText, editTextDiscount: EditText, resultTextView: TextView) {
        try {
            val price = editTextPrice.text.toString().toDouble()
            val discountPercentage = editTextDiscount.text.toString().toDouble()

            // Calculate discounted price
            val discountedPrice = price - (price * (discountPercentage / 100))

            // Display result
            resultTextView.text = "Result: \$${String.format("%.2f", discountedPrice)}"
        } catch (e: NumberFormatException) {
            resultTextView.text = "Result: Invalid input"
        }
    }
}