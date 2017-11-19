package com.jet_project.game.creatures

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.jet_project.game.game.GameWorld

/**
 * Created by rwolf on 11/9/2017.
 */
class Hero( name: String, currentWorld: GameWorld, x: Float, y: Float) : Creature(name, currentWorld, x, y) {
    override fun init() {
        img = Texture("creatures/character.png")
        sprite = Sprite(img)
        sprite.setPosition(positionX,positionY)
        super.init()
    }
}