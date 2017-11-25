package com.jet_project.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

/**
 * Created by rwolf on 11/25/2017.
 */
class MenuState(sm : StateManager) : State(sm){

    private lateinit var playButton : Texture
    private lateinit var optionsButton : Texture
    private lateinit var helpButton : Texture

    override fun create(){
        playButton = Texture("badlogic.jpg")
        optionsButton = Texture("badlogic.jpg")
        helpButton = Texture("badlogic.jpg")

    }

    override fun render(batch : SpriteBatch){
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(playButton,100f,400f)
        batch.draw(optionsButton,400f,400f)
        batch.draw(helpButton,700f,400f)

        batch.end()
    }

    override fun update(delta : Float){

    }

    override fun dispose(){

    }
}