
import kotlin.math.abs

class Solution {

    private companion object {
        const val NO_TOWER_IS_REACHABLE = -1
    }

    fun bestTower(towers: Array<IntArray>, center: IntArray, radius: Int): IntArray {
        var maxQuality = NO_TOWER_IS_REACHABLE
        val coordinates = intArrayOf(NO_TOWER_IS_REACHABLE, NO_TOWER_IS_REACHABLE)

        for (tower in towers) {
            val distance = getManhattanDistance(center[0], center[1], tower[0], tower[1])
            if (distance > radius || maxQuality > tower[2]) {
                continue
            }

            if (maxQuality < tower[2]) {
                maxQuality = tower[2]
                coordinates[0] = tower[0]
                coordinates[1] = tower[1]
                continue
            }

            if (isLexicographicallySmaller(tower[0], tower[1], coordinates[0], coordinates[1])) {
                coordinates[0] = tower[0]
                coordinates[1] = tower[1]
            }
        }

        return coordinates
    }

    private fun getManhattanDistance(firstX: Int, firstY: Int, secondX: Int, secondY: Int): Int {
        return abs(firstX - secondX) + abs(firstY - secondY)
    }

    private fun isLexicographicallySmaller(firstX: Int, firstY: Int, secondX: Int, secondY: Int): Boolean {
        return (firstX < secondX) || ((firstX == secondX) && firstY < secondY)
    }
}
