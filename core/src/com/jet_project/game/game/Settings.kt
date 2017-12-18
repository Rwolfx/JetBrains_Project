package com.jet_project.game.game

/**
 * Created by rwolf on 11/8/2017.
 */
abstract class Settings {
    companion object{
        val GRAVITY = 0f
        val DEFAULT_DENSITY = 1f
        val velocityIterations = 6
        val positionIterations = 2
        val cameraViewPort = 30f
        val maximumVelocityX = 200f;
        val maximumVelocityY = 200f;
    }
}