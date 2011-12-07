package org.egi.game.rules

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 1:26
 * To change this template use File | Settings | File Templates.
 */
public interface GameRules {

    def apply(container)

    def addRule(CellRule)

}

