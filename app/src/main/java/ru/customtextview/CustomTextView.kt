package ru.customtextview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.util.AttributeSet


class CustomTextView(c: Context, attributeSet: AttributeSet): android.support.v7.widget.AppCompatTextView(c, attributeSet){

    enum class Orientation{
        HORIZONTAL(),
        VERTICAL()
    }

    var orientation = Orientation.HORIZONTAL
    var customHeight =0
    var customWidth=0 //

    //Измерение размеров самого текста в TextView
    private fun getTextMeasurements():Pair<Float,Float>{

        val bounds = Rect()
        this.paint.getTextBounds(this.text.toString(), 0, this.text.length, bounds)
        return Pair(bounds.width().toFloat(), bounds.height().toFloat())
    }

    override fun draw(canvas: Canvas) {
        pivotX = 0F
        pivotY = 0F

        if(this.orientation == Orientation.VERTICAL){
            this.rotation=-90F
        }

        //Определение доступного места для текста в TextView
        val availableWidth = customWidth - paddingRight - paddingLeft
        val availableHeight = customHeight - paddingTop - paddingBottom


        val (textWidth, textHeight) = this.getTextMeasurements()


        if(customWidth!=0) scaleX = availableWidth / textWidth
        if(customHeight!=0) scaleY = availableHeight / textHeight

        super.draw(canvas)
    }

}