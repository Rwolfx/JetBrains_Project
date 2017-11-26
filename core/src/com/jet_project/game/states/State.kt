package com.jet_project.game.states

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.jet_project.game.game.GameLevel
import com.jet_project.game.game.GameWorld

/**
 * Created by rwolf on 11/25/2017.
 */
abstract class State(sm : StateManager) {
    protected var sm = sm

    open fun create(){

    }

    open fun render(batch : SpriteBatch){

    }

    open fun dispose(){

    }

    open fun update(delta : Float){

    }

    open fun handleInput(){

    }


}