package com.jet_project.game.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.jet_project.game.states.MainMenuState
import com.jet_project.game.states.StateManager

class Game : ApplicationAdapter() {
    private var sm : StateManager = StateManager()
    private lateinit var batch: SpriteBatch
    private lateinit var world : GameWorld
    private lateinit var test : Texture
    private lateinit var fh : FileHandle
    private lateinit var level : GameLevel

    override fun create() {
        sm.push(MainMenuState(sm))
        batch = SpriteBatch()
    }

    override fun render() {
        sm.render(batch)
        sm.update(Gdx.graphics.deltaTime)
    }

    override fun dispose() {
        batch.dispose()
    }
}
