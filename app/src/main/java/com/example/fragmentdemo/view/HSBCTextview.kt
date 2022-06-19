package com.example.fragmentdemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.TextView

@SuppressLint("AppCompatCustomView")
class HSBCTextview : TextView {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style)

    override fun onDraw(canvas: Canvas?) {
        val drawables = compoundDrawables
        if (drawables != null) {
            val drawableLeft = drawables[0]
            if (drawableLeft != null) {
                val textWidth = paint.measureText(text.toString())
                val drawablePadding = compoundDrawablePadding
                var drawableWidth =  drawableLeft.intrinsicWidth
                val bodyWidth = textWidth + drawableWidth + drawablePadding
                canvas?.translate((width - bodyWidth) / 2, 0F)
            }
        }
        super.onDraw(canvas)
    }
}