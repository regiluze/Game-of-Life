package org.egi.game.cell

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 3:22
 * To change this template use File | Settings | File Templates.
 */
interface Cell extends Cloneable{

    def alive()

    def death()

    def isAlive()

}
