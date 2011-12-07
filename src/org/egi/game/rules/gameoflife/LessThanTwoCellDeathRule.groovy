package org.egi.game.rules.gameoflife

import org.egi.game.rules.*
import org.egi.game.cell.container.*
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 5:23
 * To change this template use File | Settings | File Templates.
 */
class LessThanTwoCellDeathRule implements CellRule{
    def run(CellContainer container) {
         container.applyRule{ neightborAlive,cell ->
             if (cell.isAlive()){
                if (neightborAlive<2){
                    cell.death()
                }
            }
         }
    }
}
