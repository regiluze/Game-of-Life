import spock.lang.Specification
import org.egi.game.LifeGame
import org.egi.game.rules.GameRules
import org.egi.game.cell.container.CellContainer
import org.egi.game.rules.GameOfLifeRules

import org.egi.game.rules.gameoflife.ThreeNeighborCellAliveRule
import org.egi.game.cell.container.GameLifeCellContainer
import org.egi.game.cell.neighbor.NeighborControler
import org.egi.game.cell.neighbor.CellNeighborController
import org.egi.game.cell.neighbor.builder.NeighborBuilder
import org.egi.util.FiveMatrixLiveCellsBuilder
import org.egi.game.cell.neighbor.builder.MatrixNeighborBuilder
import org.egi.game.rules.gameoflife.LessThanTwoCellDeathRule
import org.egi.game.rules.gameoflife.MoreThanThreeCellDeathRule
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 6/12/11
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
class GameLifeIntegrationTest extends Specification{

    GameRules rules
    CellContainer container
    LifeGame game

    def setup(){
          def gameRules = [new LessThanTwoCellDeathRule(),
                           new MoreThanThreeCellDeathRule(),
                           new ThreeNeighborCellAliveRule()]
          rules = new GameOfLifeRules(["rules":gameRules])

          NeighborBuilder builder = new MatrixNeighborBuilder(["x":5,"y":5])
          NeighborControler neighbor = new CellNeighborController(builder)
          FiveMatrixLiveCellsBuilder.run()
          container = new GameLifeCellContainer(["neighbor":neighbor])
          FiveMatrixLiveCellsBuilder.run(container)

          game = new LifeGame()
          game.setContainer(container)
          game.setRules(rules)
          game.skip()
    }

    def "esto no revienta"(){

        expect:
        game.container.cells.get(id).isAlive() == alive

        where:
        id    | alive
           1  | false
           2  | false
           3  | true
           4  | false
           5  | false

    }

}
