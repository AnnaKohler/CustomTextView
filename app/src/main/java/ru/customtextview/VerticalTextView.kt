package ru.customtextview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.TextView


class VerticalTextView(context: Context, attrs: AttributeSet) : TextView(context, attrs) {

    enum class Orientation{
        HORIZONTAL(),
        VERTICAL()
    }

    var orientation = Orientation.HORIZONTAL

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        if(orientation==Orientation.VERTICAL) {
            super.onMeasure(heightMeasureSpec, widthMeasureSpec)
            setMeasuredDimension(measuredHeight, measuredWidth)
        } else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            setMeasuredDimension(measuredWidth, measuredHeight)
        }
    }

    override fun onDraw(canvas: Canvas) {
        canvas.save()
        if(orientation==Orientation.VERTICAL) {
            canvas.translate(0F, height.toFloat())
            canvas.rotate(-90F)
        }
        layout.draw(canvas)

        canvas.restore()
    }
}