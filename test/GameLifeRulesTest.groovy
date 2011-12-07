import spock.lang.Specification

import org.egi.game.rules.gameoflife.ThreeNeighborCellAliveRule
import org.egi.game.cell.Cell
import org.egi.game.cell.container.GameLifeCellContainer
import org.egi.game.cell.container.CellContainer
import org.egi.game.cell.neighbor.NeighborControler
import org.egi.game.cell.GameLifeCell
import org.egi.game.rules.gameoflife.LessThanTwoCellDeathRule
import org.egi.game.rules.gameoflife.MoreThanThreeCellDeathRule
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 4:50
 * To change this template use File | Settings | File Templates.
 */
class GameLifeRulesTest extends Specification{

    NeighborControler neighbor
    Cell cell

    def setup(){
        cell = new GameLifeCell()
        neighbor = Mock()
    }

    def "si el numero de vecinas vivas es igual a tres la celula pasa viva"(){

        setup: def rule = new ThreeNeighborCellAliveRule()

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
              cell.death()
              container.addCell(cell,1)
              neighbor.aliveNeighbor(1,_) >> 4

              rule.run(container)
        then: assert container.nextStep.get(1).isAlive() == true
    }

    def "si el numero de vecinas vivas es menor que dos la celula pasa muerta"(){

        setup: def rule = new LessThanTwoCellDeathRule()

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
              cell.alive()
               container.addCell(cell,1)
              neighbor.aliveNeighbor(1,_) >> 1
              rule.run(container)
        then: assert container.nextStep.get(1).isAlive() == false
    }

    def "si el numero de vecinas vivas es mayor que 3 la celula pasa muerta"(){

        setup: def rule = new MoreThanThreeCellDeathRule()

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
              cell.alive()
              container.addCell(cell,1)
              neighbor.aliveNeighbor(1,_) >> 5
              rule.run(container)
        then: assert container.nextStep.get(1).isAlive() == false
    }
}
