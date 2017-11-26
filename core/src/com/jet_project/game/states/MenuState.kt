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
    private lateinit var settingsButton: Texture
    private lateinit var helpButton : Texture
    private lateinit var menuBackground : Texture
    private lateinit var playButtonBounds : Rectangle
    private lateinit var settingsButtonBounds: Rectangle
    private lateinit var helpButtonBounds : Rectangle

    private var buttonWidth = 0f
    private var playButtonY = 0f
    private var settingsButtonY = 0f
    private var helpButtonY = 0f

    override fun create(){
        menuBackground = Texture("backgrounds/menu_background.jpg")
        playButton = Texture("buttons/menu_play_button.jpg")
        settingsButton = Texture("buttons/menu_settings_button.jpg")
        helpButton = Texture("buttons/menu_help_button.jpg")
        buttonWidth = ((Gdx.graphics.width-playButton.width)/2).toFloat()
        playButtonY = (Gdx.graphics.height-playButton.height).toFloat()*3/4
        settingsButtonY = (Gdx.graphics.height-playButton.height).toFloat()*2/4
        helpButtonY = (Gdx.graphics.height-playButton.height).toFloat()/4
        playButtonBounds = Rectangle(buttonWidth, playButtonY,playButton.width.toFloat(),playButton.height.toFloat())
        settingsButtonBounds = Rectangle(buttonWidth, settingsButtonY, settingsButton.width.toFloat(), settingsButton.height.toFloat())
        helpButtonBounds = Rectangle(buttonWidth, helpButtonY,helpButton.width.toFloat(),helpButton.height.toFloat())
    }

    override fun render(batch : SpriteBatch){
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(menuBackground,0f,0f,Gdx.graphics.width.toFloat(),Gdx.graphics.height.toFloat())
        batch.draw(playButton,buttonWidth, playButtonY)
        batch.draw(settingsButton,buttonWidth, settingsButtonY)
        batch.draw(helpButton,buttonWidth,helpButtonY)
        batch.end()
    }

    override fun handleInput() {
        val inputX = Gdx.input.x.toFloat()
        val inputY = Gdx.input.y.toFloat()
        Gdx.app.debug("Input", inputX.toString() + " " + inputY.toString())
        if(playButtonBounds.contains(inputX,inputY)) sm.push(PlayState(sm))
        if(settingsButtonBounds.contains(inputX,inputY)) sm.push(SettingsState(sm))
        if(helpButtonBounds.contains(inputX,inputY)) sm.push(HelpState(sm))
    }

    override fun update(delta : Float){
        if(Gdx.input.isTouched) handleInput()
    }

    override fun dispose(){
        playButton.dispose()
        settingsButton.dispose()
        helpButton.dispose()
    }
}