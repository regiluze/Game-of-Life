package org.egi.game.cell.neighbor

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 15:17
 * To change this template use File | Settings | File Templates.
 */
class CellNeighborController implements NeighborControler{

    def neighbor

    CellNeighborController(matrixbuilder){
        neighbor = matrixbuilder.run()
    }

    def aliveNeighbor(id,cells) {
        int alive = 0
        neighbor.get(id).each {
             if (cells.get(it).isAlive()){
                 alive++
             }
         }
        return alive
    }
}
