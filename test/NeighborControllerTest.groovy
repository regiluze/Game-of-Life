import spock.lang.Specification

import org.egi.game.cell.GameLifeCell
import org.egi.game.cell.Cell
import org.egi.game.cell.neighbor.NeighborControler
import org.egi.game.cell.neighbor.CellNeighborController
import org.egi.game.cell.neighbor.builder.NeighborBuilder
import org.egi.util.FiveMatrixLiveCellsBuilder
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 5:32
 * To change this template use File | Settings | File Templates.
 */
class NeighborControllerTest extends Specification{

    def cells = [:]
    NeighborControler neighbor
    NeighborBuilder builder

    def setup(){
      builder = Mock()

      cells = FiveMatrixLiveCellsBuilder.run()

    }


    def "la celula posicionada en 1 tiene una vecina viva"(){

        when:   builder.run() >> [1:[2,6,7]]
                neighbor = new CellNeighborController(builder)


        then:
                assert neighbor.aliveNeighbor(1,cells) == 1

    }

    def "la celula posicionada en 2 tiene 3 vecinas viva"(){

        when:   builder.run() >> [2:[1,3,6,7,8]]
                neighbor = new CellNeighborController(builder)


        then:
                assert neighbor.aliveNeighbor(2,cells) == 3

    }


}
