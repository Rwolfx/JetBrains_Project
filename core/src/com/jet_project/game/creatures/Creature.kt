package com.jet_project.game.creatures

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.physics.box2d.*
import com.jet_project.game.game.GameWorld
import com.jet_project.game.game.Settings

/**
 * Created by rwolf on 11/8/2017.
 */
open abstract class Creature(name : String, currentWorld : GameWorld, x : Float, y : Float) {
    private lateinit var bodyDef : BodyDef
    private lateinit var body : Body
    private lateinit var shape : PolygonShape
    private lateinit var fixtureDef : FixtureDef
    private lateinit var fixture : Fixture
    protected lateinit var img : Texture
    protected lateinit var sprite : Sprite
    private var positionX = x
    private var positionY = y
    private var world = currentWorld

    open fun init() {
        bodyDef = BodyDef()
        bodyDef.type = BodyDef.BodyType.DynamicBody
        bodyDef.position.set(positionX, positionY)
        body = world.getWorld().createBody(bodyDef)
        shape = PolygonShape()
        shape.setAsBox(img.width.toFloat(),img.height.toFloat())
        fixtureDef = FixtureDef()
        fixtureDef.shape = shape
        fixtureDef.density = Settings.DEFAULT_DENSITY
        fixture = body.createFixture(fixtureDef)
        shape.dispose()
    }

    fun render(batch : SpriteBatch){
        batch.draw(sprite,positionX,positionY)
    }

    fun update(){
        positionX = body.position.x
        positionY = body.position.y
    }

}