import spock.lang.Specification
import org.egi.game.cell.Cell
import org.egi.game.cell.container.GameLifeCellContainer
import org.egi.game.cell.container.CellContainer
import org.egi.game.cell.neighbor.NeighborControler
import org.egi.game.cell.GameLifeCell
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 2:43
 * To change this template use File | Settings | File Templates.
 */
class CellContainerTest extends Specification{

    NeighborControler neighbor
    Cell cell

    def setup(){
        cell = Mock()
        neighbor = Mock()
    }

    def "las reglas son aplicadas a cada una de la celulas y pregunta por las vecinas vivas"(){

        setup: def rule = { neighborAlive ,cell->}

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
               container.addCell(cell,1)
               container.applyRule(rule)

        then: 1*neighbor.aliveNeighbor(1,_)
    }

    def "una regla que termina con sobrevivir si esta muerta actualiza la celula a viva papa la proxima evol"(){
        setup: def rule = { neighborAlive ,cell-> if (!cell.isAlive()){cell.alive()}}
               cell = new GameLifeCell()
               cell.death()

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
               container.addCell(cell,1)
               container.applyRule(rule)
               cell.isAlive() >> false
        then: Cell nextStataCell = container.nextStep.get(1)
              assert nextStataCell.isAlive() == true
    }

    def "una regla que termina con no sobrevivir actualiza la celula a muerta"(){
        setup: def rule = { neighborAlive ,cell-> if (cell.isAlive()){cell.death()} }
               cell = new GameLifeCell()
               cell.alive()

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
               container.addCell(cell,1)
               container.applyRule(rule)
        then: Cell nextStataCell = container.nextStep.get(1)
              assert nextStataCell.isAlive() == false
    }

    def "una celula que evoluciona sigue teniendo su propio estado anterior si se aplica otra regla sin evolucionar"(){

        setup: def rule = { neighborAlive,cell -> cell.alive()}
               def ruleTwo = { neighborAlive,cell -> cell.death()}
               cell = new GameLifeCell(["alive":false])

        when: CellContainer container = new GameLifeCellContainer(["neighbor":neighbor])
               container.addCell(cell,1)
               container.applyRule(rule)
               container.updateState()
               container.applyRule(ruleTwo)
        then:  Cell evolutedCell = container.cells.get(1)
               Cell nextStepCell = container.nextStep.get(1)
               assert evolutedCell.isAlive() == true
               assert nextStepCell.isAlive() == false
    }



}
