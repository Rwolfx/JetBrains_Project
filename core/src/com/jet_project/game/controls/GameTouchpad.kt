package com.jet_project.game.controls

import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad
import com.badlogic.gdx.scenes.scene2d.utils.Drawable
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle
import com.badlogic.gdx.graphics.Texture



/**
 * Created by rwolf on 12/3/2017.
 */
class GameTouchpad() {
    private lateinit var touchpadSkin : Skin
    lateinit var touchpad : Touchpad
    private lateinit var touchpadStyle : Touchpad.TouchpadStyle
    private lateinit var touchBackground : Drawable
    private lateinit var touchKnob : Drawable

    fun init(){
        touchpadSkin = Skin()
        touchpadSkin.add("touchBackground", Texture("touchpad/touchBackground.png"))
        touchpadSkin.add("touchKnob", Texture("touchpad/touchKnob.png"))
        touchpadStyle = TouchpadStyle()
        touchBackground = touchpadSkin.getDrawable("touchBackground")
        touchKnob = touchpadSkin.getDrawable("touchKnob")
        touchpadStyle.background = touchBackground
        touchpadStyle.knob = touchKnob
        touchpad = Touchpad(10f, touchpadStyle)
        touchpad.setBounds(15f, 15f, 200f, 200f)
    }


}