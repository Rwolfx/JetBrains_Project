package com.jet_project.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle

/**
 * Created by rwolf on 11/25/2017.
 */
class MenuState(sm : StateManager) : State(sm){

    private lateinit var playButton : Texture
    private lateinit var optionsButton : Texture
    private lateinit var helpButton : Texture
    private lateinit var playButtonBounds : Rectangle
    private lateinit var optionsButtonBounds : Rectangle
    private lateinit var helpButtonBounds : Rectangle

    private var buttonWidth = 0f
    private val playButtonY = 700f
    private val optionsButtonY = 400f
    private val helpButtonY = 100f

    override fun create(){
        playButton = Texture("badlogic.jpg")
        optionsButton = Texture("badlogic.jpg")
        helpButton = Texture("badlogic.jpg")
        buttonWidth = ((Gdx.graphics.width-playButton.width)/2).toFloat()
        playButtonBounds = Rectangle(buttonWidth, playButtonY,playButton.width.toFloat(),playButton.height.toFloat())
        optionsButtonBounds = Rectangle(buttonWidth, optionsButtonY, optionsButton.width.toFloat(), optionsButton.height.toFloat())
        helpButtonBounds = Rectangle(buttonWidth, helpButtonY,helpButton.width.toFloat(),helpButton.height.toFloat())
    }

    override fun render(batch : SpriteBatch){
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(playButton,buttonWidth, playButtonY)
        batch.draw(optionsButton,buttonWidth, optionsButtonY)
        batch.draw(helpButton,buttonWidth,helpButtonY)
        batch.end()
    }

    override fun handleInput() {
        val inputX = Gdx.input.x.toFloat()
        val inputY = Gdx.input.y.toFloat()
        Gdx.app.debug("Input", inputX.toString() + " " + inputY.toString())
        if(playButtonBounds.contains(inputX,inputY)) sm.push(PlayState(sm))
        if(optionsButtonBounds.contains(inputX,inputY)) sm.push(OptionsState(sm))
        if(helpButtonBounds.contains(inputX,inputY)) sm.push(HelpState(sm))
    }

    override fun update(delta : Float){
        if(Gdx.input.isTouched) handleInput()
    }

    override fun dispose(){
        playButton.dispose()
        optionsButton.dispose()
        helpButton.dispose()
    }
}