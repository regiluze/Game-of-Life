package org.egi.game.cell.container

import org.egi.game.cell.Cell
import org.egi.game.cell.neighbor.*
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 3:21
 * To change this template use File | Settings | File Templates.
 */
class GameLifeCellContainer implements CellContainer{

    NeighborControler neighbor
    def cells = [:]
    def nextStep = [:]

    def addCell(Cell cell,int id) {
        cells.put(id,cell)
        nextStep.put(id,cell.clone())
    }

    def applyRule(rule) {
        cells.each {id,cell ->
           Cell celu = nextStep.get(id)
           rule.call(neighbor.aliveNeighbor(id,cells),celu)
       }


    }

    def updateState() {
        cells.each {id,cell ->
            if (nextStep.get(id).isAlive()) {
               cell.alive()
            }else{
                cell.death()
            }
        }
    }

    def print() {
        int i = 1
        cells.each {id,cell ->

            if (cell.isAlive()){
                print "*"
            }else {
                print "-"
            }
            if (i % 5 == 0){
                println()
            }
            i++
        }
    }

     def printnext() {
        int i = 1
        nextStep.each {id,cell ->

            if (cell.isAlive()){
                print "*"
            }else {
                print "-"
            }
            if (i % 5 == 0){
                println()
            }
            i++
        }
    }
}
