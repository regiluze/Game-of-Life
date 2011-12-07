package org.egi.game.cell

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 12:26
 * To change this template use File | Settings | File Templates.
 */
class GameLifeCell implements Cell{
    def alive = false
    def alive() {
        alive = true
    }

    def death() {
        alive = false
    }

    def isAlive() {
        alive
    }
}
