
import spock.lang.Specification
import org.egi.game.cell.neighbor.builder.NeighborBuilder
import org.egi.game.cell.neighbor.builder.MatrixNeighborBuilder

class MatrixCellBuilderTest extends Specification{

    NeighborBuilder builder

    def "una matriz de 1 por 1 devuelve lista vacia"(){

        when:builder = new MatrixNeighborBuilder(["x":1,"y":1])

        then: builder.run() == [1:[]]

    }

    def "una matriz de 2 por 2 huecos devuelve lista con cuatro huecos con las posiciones vecinas"(){

        when:builder = new MatrixNeighborBuilder(["x":2,"y":2])

        then: assert builder.run() == [1:[2, 3, 4],2:[1, 3, 4],3:[1, 2, 4],4:[1, 2, 3]]

    }

    def "una matriz de 3 por 3 huecos devuelve lista con nueve huecos con las posiciones veninas"(){

        when:builder = new MatrixNeighborBuilder(["x":3,"y":3])

        then: assert builder.run() == [1:[2, 4, 5],2:[1, 3, 4, 5, 6],3:[2, 5, 6],4:[1, 2, 5, 7, 8],
                                5:[1, 2, 3, 4, 6, 7, 8, 9],6:[2, 3, 5, 8, 9],7:[4, 5, 8],
                                8:[4, 5, 6, 7, 9],9:[5, 6, 8]]

    }

    def "una matriz de 4 por 4 huecos devuelve lista con 16 huecos con las posiciones veninas"(){

        when:builder = new MatrixNeighborBuilder(["x":4,"y":4])

        then: assert builder.run().size() == 16
              assert builder.run().get(1) == [2, 5, 6]
              assert builder.run().get(10) == [5, 6, 7, 9, 11, 13, 14, 15]
              assert builder.run().get(16) == [11, 12, 15]


    }

    def "una matriz de 4 por 2 huecos devuelve lista con 8 huecos con las posiciones veninas"(){

        when:builder = new MatrixNeighborBuilder(["x":4,"y":2])

        then: assert builder.run().size() == 8
              assert builder.run().get(1) == [2, 5, 6]
              //assert builder.run().get(6) == [1, 2, 3, 5, 7]
              assert builder.run().get(8) == [3, 4, 7]


    }


}
