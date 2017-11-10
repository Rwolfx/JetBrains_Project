package com.jet_project.game.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle
import com.jet_project.game.creatures.Creature
import com.jet_project.game.gameObjects.GameObject
import java.io.BufferedReader
import java.io.File

/**
 * Created by rwolf on 11/8/2017.
 */
class GameLevel(levelNum : String) {
    private var creaturesData = ArrayList<String>()
    private var gameObjectsData = ArrayList<String>()
    private val levelNumber = levelNum

    //private val bufferedReader : BufferedReader = File("../badlogic.jpg").bufferedReader()
    private val fh : FileHandle = Gdx.files.internal("Levels/Level" + levelNum + ".txt")
    private val lineList = ArrayList<String>()

    internal fun init(){
        loadFile()
        val numberOfCreatures = lineList.get(0).toInt()
        for(i in (1 until numberOfCreatures+1)) creaturesData.add(lineList.get(i))
        val numberOfGameObjects = lineList.get(numberOfCreatures+1).toInt()
        for(i in (numberOfGameObjects until lineList.size)) gameObjectsData.add(lineList.get(i))


    }

    internal fun getCreaturesData() : ArrayList<String> = creaturesData
    internal fun getGameObjectsData() : ArrayList<String> = gameObjectsData


    private fun loadFile(){
        val text = fh.readString()
        text.split(";").forEach { line -> lineList.add(line.trim()) }
        for(line in lineList) {
            if(line == "") lineList.remove(line)
        }
        //bufferedReader.useLines { lines -> lines.forEach { lineList.add(it) } }
    }
}