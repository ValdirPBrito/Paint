package com.example.paint

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.paint.PaintView.Companion.caminhoLista
import com.example.paint.PaintView.Companion.corLista
import com.example.paint.PaintView.Companion.pincelAtual

class MainActivity : AppCompatActivity() {

    companion object {
        var caminho = Path()
        var paintPincel = Paint()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val botaoPreto = findViewById<ImageButton>(R.id.preto)
        val botaoVermelho = findViewById<ImageButton>(R.id.vermelho)
        val botaoAzul = findViewById<ImageButton>(R.id.azul)
        val botaoLimpar = findViewById<ImageButton>(R.id.limpar)

        botaoPreto.setOnClickListener {
            Toast.makeText(this, "Preto", Toast.LENGTH_SHORT).show()
            paintPincel.color = Color.BLACK
            corAtual(paintPincel.color)
        }

        botaoVermelho.setOnClickListener {
            Toast.makeText(this, "Vermelho", Toast.LENGTH_SHORT).show()
            paintPincel.color = Color.RED
            corAtual(paintPincel.color)
        }

        botaoAzul.setOnClickListener {
            Toast.makeText(this, "Azul", Toast.LENGTH_SHORT).show()
            paintPincel.color = Color.BLUE
            corAtual(paintPincel.color)
        }

        botaoLimpar.setOnClickListener {
            Toast.makeText(this, "Limpar", Toast.LENGTH_SHORT).show()
            caminhoLista.clear()
            corLista.clear()
            caminho.reset()
        }
    }

    private fun corAtual(color: Int) {
        pincelAtual = color
        caminho = Path()
    }
}