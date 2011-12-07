import spock.lang.Specification

import org.egi.game.rules.GameRules
import org.egi.game.rules.GameOfLifeRules
import org.egi.game.rules.CellRule
import org.egi.game.cell.container.CellContainer
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 1:39
 * To change this template use File | Settings | File Templates.
 */
class GameRulesTest extends Specification{

    CellContainer container

    def setup(){
         container = Mock()
    }

    def "cuando se ejecutan las reglas se itera por cada una de ellas sobre el contenedor"(){

        setup: CellRule ruleOne = Mock()
              CellRule ruleTwo = Mock()

        when: GameRules rules = new GameOfLifeRules()
              rules.addRule(ruleOne)
              rules.addRule(ruleTwo)
              rules.apply(container)
        then: 1*ruleOne.run(container)
              1*ruleTwo.run(container)
    }

    def "Cuando se ejecutan todas las reglas se actualiza el estado del contenedor"(){

        when: GameRules rules = new GameOfLifeRules()
              rules.apply(container)
        then: 1*container.updateState()

    }



}
