package org.egi.game.rules

/**
 * Created by IntelliJ IDEA.
 * User: ruben
 * Date: 4/12/11
 * Time: 1:50
 * To change this template use File | Settings | File Templates.
 */
class GameOfLifeRules implements GameRules{

    def rules = []

    def apply(container) {
        rules.each { rule ->
            rule.run(container)
        }
        container.updateState()
    }

    def addRule(rule) {
       rules.add(rule)
    }
}
