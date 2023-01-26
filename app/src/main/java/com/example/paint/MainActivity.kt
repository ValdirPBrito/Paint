package com.example.paint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.paint.PaintView.Companion.colorList
import com.example.paint.PaintView.Companion.currentBrush
import com.example.paint.PaintView.Companion.pathList

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var paintBrush = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blackButton = findViewById<ImageButton>(R.id.black)
        val redButton = findViewById<ImageButton>(R.id.red)
        val blueButton = findViewById<ImageButton>(R.id.blue)
        val whiteButton = findViewById<ImageButton>(R.id.white)

        blackButton.setOnClickListener {
            Toast.makeText(this,"Preto",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLACK
            currentColor (paintBrush.color)
        }

        redButton.setOnClickListener {
            Toast.makeText(this,"Vermelho",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.RED
            currentColor (paintBrush.color)        }

        blueButton.setOnClickListener {
            Toast.makeText(this,"Azul",Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLUE
            currentColor (paintBrush.color)
        }

        whiteButton.setOnClickListener {
            Toast.makeText(this,"Limpar",Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear ()
            path.reset ()
        }
    }
    private fun currentColor (color: Int){
        currentBrush = color
        path = Path ()

    }
}