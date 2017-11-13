package com.jet_project.game.game

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.files.FileHandle


/**
 * Created by rwolf on 11/8/2017.
 */
class GameLevel(levelNum : String) {
    private var creaturesData = ArrayList<String>()
    private var gameObjectsData = ArrayList<String>()
    private val fh : FileHandle = Gdx.files.internal("Levels/Level" + levelNum + ".txt")
    private val lineList = ArrayList<String>()

    //initializing
    internal fun init(){
        loadFile()
        val numberOfCreatures = lineList.get(0).toInt()
        for(i in (1 until numberOfCreatures+1)) creaturesData.add(lineList[i])
        val numberOfGameObjects = lineList.get(numberOfCreatures+1).toInt()
        for(i in (numberOfGameObjects until lineList.size)) gameObjectsData.add(lineList[i])


    }

    internal fun getCreaturesData() : ArrayList<String> = creaturesData
    internal fun getGameObjectsData() : ArrayList<String> = gameObjectsData

    //loading our level file and getting it's data
    private fun loadFile(){
        val text = fh.readString()
        text.split(";").forEach { line -> lineList.add(line.trim()) }
        lineList.forEach { s -> if(s.isEmpty()) lineList.remove(s)}

    }
}