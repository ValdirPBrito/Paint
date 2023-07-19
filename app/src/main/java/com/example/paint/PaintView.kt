package com.example.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paint.MainActivity.Companion.caminho
import com.example.paint.MainActivity.Companion.paintPincel

class PaintView : View {

    var params: ViewGroup.LayoutParams? = null

    companion object {
        var caminhoLista = ArrayList<Path>()
        var corLista = ArrayList<Int>()
        var pincelAtual = Color.BLACK
    }

    constructor (context: Context) : this(context, null) {
        init()
    }

    constructor (context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()
    }

    constructor (context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        paintPincel.isAntiAlias = true
        paintPincel.color = pincelAtual
        paintPincel.style = Paint.Style.STROKE
        paintPincel.strokeJoin = Paint.Join.ROUND
        paintPincel.strokeWidth = 8f
        params = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                caminho.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                caminho.lineTo(x, y)
                caminhoLista.add(caminho)
                corLista.add(pincelAtual)
            }
            else -> return false
        }
        postInvalidate()
        return false
    }

    override fun onDraw(canvas: Canvas) {

        for (i in caminhoLista.indices) {
            paintPincel.setColor(corLista[i])
            canvas.drawPath(caminhoLista[i], paintPincel)
        }

    }

}