package org.egi.util

import org.egi.game.cell.Cell
import org.egi.game.cell.GameLifeCell
import org.egi.game.cell.container.CellContainer

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 5/12/11
 * Time: 17:49
 * To change this template use File | Settings | File Templates.
 */
class FiveMatrixLiveCellsBuilder {

    static def run(){

        def cells = [:]

        1.upto(25){

            Cell cell = new GameLifeCell()
            cells.put(it,cell)

        }

        [3,6,8,9,17].each {

            Cell cellAlive = new GameLifeCell()
            cellAlive.alive()
            cells.put(it,cellAlive)
        }
        return  cells

    }

    static def run(CellContainer container){

        1.upto(25){

            Cell cell = new GameLifeCell()
            container.addCell(cell,it)

        }

        [3,6,8,9,17].each {

            Cell cellAlive = new GameLifeCell()
            cellAlive.alive()
            container.addCell(cellAlive,it)
        }

    }

}
