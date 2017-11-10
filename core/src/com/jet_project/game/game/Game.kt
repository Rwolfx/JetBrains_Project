package com.jet_project.game.game

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import sun.rmi.runtime.Log
import java.io.File

class Game : ApplicationAdapter() {
    internal lateinit var batch: SpriteBatch ;
    private lateinit var world : GameWorld;
    private lateinit var test : Texture
    private lateinit var fh : FileHandle
    private lateinit var level : GameLevel

    override fun create() {
        batch = SpriteBatch()
        test = Texture("badlogic.jpg")
        fh = Gdx.files.local("Levels/Level1.txt")
        level = GameLevel("1")
        level.init()
        world = GameWorld(level)
        world.init()
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        world.update()
        world.render(batch)
        batch.end()
    }

    override fun dispose() {
        batch.dispose()
    }
}
