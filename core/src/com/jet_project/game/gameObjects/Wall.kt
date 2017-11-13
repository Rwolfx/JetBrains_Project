package com.jet_project.game.gameObjects

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.jet_project.game.game.GameWorld

/**
 * Created by rwolf on 11/13/2017.
 */
class Wall(name: String, currentWorld: GameWorld, x: Float, y: Float) : GameObject(name, currentWorld, x, y) {

    override fun init() {
        img = Texture("badlogic.jpg")
        sprite = Sprite(img)
        super.init()
    }


}