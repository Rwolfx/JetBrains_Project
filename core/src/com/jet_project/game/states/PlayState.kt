package com.jet_project.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.physics.box2d.Box2D
import com.jet_project.game.game.GameLevel
import com.jet_project.game.game.GameWorld

/**
 * Created by rwolf on 11/25/2017.
 */
class PlayState(sm : StateManager) : State(sm) {

    private lateinit var world : GameWorld
    private lateinit var fh : FileHandle
    private lateinit var level : GameLevel


    override fun create(){
        Box2D.init()
        fh = Gdx.files.local("Levels/Level1.txt")
        level = GameLevel("1")
        level.init()
        world = GameWorld(level)
        world.init()
    }

    override fun render(batch : SpriteBatch){
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        world.render(batch)
        batch.end()
    }

    override fun update(delta : Float){
        world.step(Gdx.graphics.deltaTime)
        world.update(delta)
    }

    override fun dispose(){

    }
}