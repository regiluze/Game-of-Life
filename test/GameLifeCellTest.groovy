import spock.lang.Specification
import org.egi.game.cell.GameLifeCell
import org.egi.game.cell.Cell
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 */
class GameLifeCellTest extends Specification{

    def "una celula si se mata esta muerta"(){

        when: Cell cell = new GameLifeCell()
              cell.death()

        then: assert cell.isAlive() == false
    }

    def "una celula si se revive esta viva"(){

        when: Cell cell = new GameLifeCell()
              cell.alive()
        then: assert cell.isAlive() == true


    }

}
