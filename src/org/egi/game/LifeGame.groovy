package org.egi.game

import org.egi.game.rules.GameRules
import org.egi.game.cell.container.*

class LifeGame{

      GameRules rules
      CellContainer container

       def skip(){
           println()
           rules.apply(container)
           container.print()
       }

       def setContainer(CellContainer container ){
            this.container = container
            this.container.print()
       }

}