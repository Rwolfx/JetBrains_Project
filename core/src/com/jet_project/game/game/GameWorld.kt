package com.jet_project.game.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.scenes.scene2d.Stage
import com.jet_project.game.controls.GameTouchpad
import com.jet_project.game.creatures.Creature
import com.jet_project.game.creatures.Hero
import com.jet_project.game.gameObjects.GameObject
import com.jet_project.game.gameObjects.Wall
import java.util.*

/**
 * Created by rwolf on 11/8/2017.
 */
class GameWorld(lvl : GameLevel) {
    private lateinit var world : World
    private val stage = Stage()
    private val gameTouchpad = GameTouchpad()
    private var creatures = ArrayList<Creature>()
    private var gameObjects = ArrayList<GameObject>()
    private val level = lvl


    internal fun init(){
        world = World(Vector2(0f,Settings.GRAVITY), true)
        gameTouchpad.init()
        stage.addActor(gameTouchpad.touchpad)
        Gdx.input.inputProcessor = stage
        generateWorld()
        if(creatures.isNotEmpty()) creatures.forEach { creature -> creature.init() }
        if(gameObjects.isNotEmpty()) gameObjects.forEach { gameObject -> gameObject.init() }
    }

    private fun generateCreatures(){
        for(line in level.getCreaturesData()) {
            val name = line.substring(0, line.indexOf("{"))
            val posX = line.substring(line.indexOf("{") + 1, line.indexOf(",")).toFloat()
            val posY = line.substring(line.indexOf(",") + 1, line.indexOf("}")).toFloat()
            creatures.add(Hero(name,this , posX,posY))
        }
    }

    private fun generateWorld(){
        generateCreatures()
        generateObjects()

    }
    private fun generateObjects(){
        for(line in level.getGameObjectsData()) {
            val name = line.substring(0, line.indexOf("{"))
            val posX = line.substring(line.indexOf("{") + 1, line.indexOf(",")).toFloat()
            val posY = line.substring(line.indexOf(",") + 1, line.indexOf("}")).toFloat()
            gameObjects.add(Wall(name,this , posX,posY))
        }
    }

    internal fun render(batch : SpriteBatch){
        if(creatures.isNotEmpty()) creatures.forEach { creature -> creature.render(batch) }
        if(gameObjects.isNotEmpty()) gameObjects.forEach { gameObject -> gameObject.render(batch) }
        stage.draw()
    }
    internal fun update(delta : Float){
        if(creatures.isNotEmpty()) creatures.forEach {  creature -> creature.update(delta) }
        if(gameObjects.isNotEmpty()) gameObjects.forEach { gameObject -> gameObject.update(delta) }
    }

    internal fun step(timeStep : Float){
        world.step(timeStep,Settings.velocityIterations,Settings.positionIterations)
    }

    fun getWorld() : World =  world
    fun getCreatures() : ArrayList<Creature> = creatures
    fun getGameObjects() : ArrayList<GameObject> = gameObjects






}