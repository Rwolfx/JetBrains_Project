package com.jet_project.game.states

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import java.util.*

class StateManager(){
    var states : Stack<State> = Stack<State>()

    fun push(state : State) {
        states.push(state)
        state.create()
    }

    fun pop(){
        states.pop()
    }

    fun setState(state : State){
        states.pop();
        states.push(state)
    }

    fun update(delta : Float){
        states.peek().update(delta);
    }

    fun render(sb : SpriteBatch){
        states.peek().render(sb)
    }
}
