package org.egi.game.cell.container

import org.egi.game.cell.Cell
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 1:35
 * To change this template use File | Settings | File Templates.
 */
interface CellContainer {

    def addCell(Cell cell,int id)

    def applyRule(rule)

    def updateState()

    def print()

}
