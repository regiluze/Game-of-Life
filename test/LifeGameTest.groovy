import spock.lang.Specification
import org.egi.game.LifeGame
import org.egi.game.rules.GameRules
import org.egi.game.cell.container.CellContainer

class LifeGameTest extends Specification{


     def "El juego tiene que evolucionar y aplicar las reglas de supervivencia"(){

         setup: CellContainer container = Mock()
                GameRules rules = Mock()

         when: LifeGame game = new LifeGame(["rules":rules,"container":container])
               game.skip()
         then: 1*rules.apply(_)

     }

    def "cuando el juego evoluciona las reglas se aplican sobre un contenedor celulas"(){

        setup: CellContainer container = Mock()
               GameRules rules = Mock()

        when:  LifeGame game = new LifeGame(["rules":rules,"container":container])
               game.skip()
        then:  1*rules.apply(container)

    }

}




