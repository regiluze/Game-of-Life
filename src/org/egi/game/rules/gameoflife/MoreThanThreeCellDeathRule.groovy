package org.egi.game.rules.gameoflife

import org.egi.game.cell.container.*
import org.egi.game.rules.CellRule
/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 5:28
 * To change this template use File | Settings | File Templates.
 */
class MoreThanThreeCellDeathRule implements CellRule{

     def run(CellContainer container){
        container.applyRule{ neightborAlive,cell ->
             if (cell.isAlive()){
                if (neightborAlive>3){
                    cell.death()
                }
            }
         }

     }

}
