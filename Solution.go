
package main

import "math"

const NO_TOWER_IS_REACHABLE = -1

func bestTower(towers [][]int, center []int, radius int) []int {
    maxQuality := NO_TOWER_IS_REACHABLE
    coordinates := []int{NO_TOWER_IS_REACHABLE, NO_TOWER_IS_REACHABLE}

    for _, tower := range towers {
        distance := getManhattanDistance(center[0], center[1], tower[0], tower[1])
        if distance > radius || maxQuality > tower[2] {
            continue
        }

        if maxQuality < tower[2] {
            maxQuality = tower[2]
            coordinates[0] = tower[0]
            coordinates[1] = tower[1]
            continue
        }

        if isLexicographicallySmaller(tower[0], tower[1], coordinates[0], coordinates[1]) {
            coordinates[0] = tower[0]
            coordinates[1] = tower[1]
        }
    }

    return coordinates
}

func getManhattanDistance(firstX int, firstY int, secondX int, secondY int) int {
    return int(math.Abs(float64(firstX - secondX)) + math.Abs(float64(firstY - secondY)))
}

func isLexicographicallySmaller(firstX int, firstY int, secondX int, secondY int) bool {
    return (firstX < secondX) || ((firstX == secondX) && firstY < secondY)
}
