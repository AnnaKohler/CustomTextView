package ru.customtextview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
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

    override fun setFrame(left: Int, top: Int, right: Int, bottom: Int): Boolean {
        if(orientation==Orientation.VERTICAL) {
            super.setFrame(left, top, left + (bottom - top), top + (right - left))
        }
        else super.setFrame(left, top, right, bottom)
        return true
    }

    override fun draw(canvas: Canvas) {
        if(orientation==Orientation.VERTICAL) {
            canvas.translate(0f, width.toFloat())
            canvas.rotate(-90f)
        }

        super.draw(canvas)
    }
}