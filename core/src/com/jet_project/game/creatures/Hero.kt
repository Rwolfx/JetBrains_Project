package com.jet_project.game.creatures

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.jet_project.game.game.GameWorld

/**
 * Created by rwolf on 11/9/2017.
 */
class Hero( name: String, currentWorld: GameWorld, x: Float, y: Float) : Creature(name, currentWorld, x, y) {
    override fun init() {
        img = Texture("badlogic.jpg")
        sprite = Sprite(img)
        super.init()
    }
}