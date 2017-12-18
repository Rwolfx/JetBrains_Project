package com.jet_project.game.gameObjects

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.jet_project.game.game.GameWorld
import com.jet_project.game.game.Settings

/**
 * Created by rwolf on 11/13/2017.
 */
class Wall(name: String, currentWorld: GameWorld, x: Float, y: Float) : GameObject(name, currentWorld, x, y) {

    override fun init() {
        img = Texture("gameObjects/wall.png")
        sprite = Sprite(img)
        sprite.setPosition(positionX,positionY)
        bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.StaticBody
        bodyDef.position.set(sprite.x, sprite.y)
        body = world.getWorld().createBody(bodyDef)
        shape = PolygonShape()
        shape.setAsBox(sprite.width/2,sprite.height/2)
        fixtureDef = FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = Settings.DEFAULT_DENSITY
        fixture = body.createFixture(fixtureDef)
        shape.dispose()
    }


}