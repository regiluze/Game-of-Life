package org.egi.game.cell.neighbor.builder

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 5/12/11
 * Time: 18:00
 * To change this template use File | Settings | File Templates.
 */
class MatrixNeighborBuilder implements NeighborBuilder{

    def x
    def y
    int id

    def run() {
        def neighbor =[:]
        id = 1
        1.upto(y){ ypos ->
            1.upto(x){ xpos ->
                neighbor.put(id,addneighbor(xpos,ypos))
                id++
            }
        }
        return neighbor
    }

    def addneighbor(xpos,ypos) {
        def n = []
        if (notIsFirstLine(ypos)){
            addLineUpNeigbors(ypos, n)
        }
        addSameLineNeighbors(xpos, n)
        if (notIsLastLine(ypos)){
            addLineDownNeighbors(ypos, n)
        }
        return n
    }

    private def addSameLineNeighbors(xpos, ArrayList n) {
        if (notIsFirstColumn(xpos)) {
            n.add(id - 1)
        }
        if (notIsLastColumn(xpos)) {
            n.add(id + 1)
        }
    }

    private boolean notIsLastColumn(xpos) {
        return xpos < x
    }

    private boolean notIsFirstColumn(xpos) {
        return xpos != 1
    }

    private boolean notIsLastLine(ypos) {
        return ypos < y
    }

    private boolean notIsFirstLine(ypos) {
        return ypos != 1
    }

    private def addLineDownNeighbors(ypos, ArrayList n) {
        int posDownLeft = id + x - 1
        int posDown = id + x
        int posDownRight = id + x + 1
        if (posDownLeft >= ((ypos) * x + 1)) {
            n.add(posDownLeft)
        }
        n.add(posDown)
        if (posDownRight <= (ypos + 1) * x) {
            n.add(posDownRight)
        }
    }

    private def addLineUpNeigbors(ypos, ArrayList n) {
        int posUpLeft = id - x - 1
        int posUp = id - x
        int posUpRight = id - x + 1
        if (posUpLeft >= ((ypos - 2) * x + 1)) {
            n.add(posUpLeft)
        }
        n.add(posUp)
        if (posUpRight <= (ypos - 1) * x) {
            n.add(posUpRight)
        }
    }
}
