
function bestTower(towers: number[][], center: number[], radius: number): number[] {
    const NO_TOWER_IS_REACHABLE = -1;
    let maxQuality = NO_TOWER_IS_REACHABLE;
    const coordinates = [NO_TOWER_IS_REACHABLE, NO_TOWER_IS_REACHABLE];

    for (let tower of towers) {
        const distance = getManhattanDistance(center[0], center[1], tower[0], tower[1]);
        if (distance > radius || maxQuality > tower[2]) {
            continue;
        }

        if (maxQuality < tower[2]) {
            maxQuality = tower[2];
            coordinates[0] = tower[0];
            coordinates[1] = tower[1];
            continue;
        }

        if (isLexicographicallySmaller(tower[0], tower[1], coordinates[0], coordinates[1])) {
            coordinates[0] = tower[0];
            coordinates[1] = tower[1];
        }
    }

    return coordinates;
};

function getManhattanDistance(firstX: number, firstY: number, secondX: number, secondY: number): number {
    return Math.abs(firstX - secondX) + Math.abs(firstY - secondY);
}

function isLexicographicallySmaller(firstX: number, firstY: number, secondX: number, secondY: number): boolean {
    return (firstX < secondX) || ((firstX === secondX) && firstY < secondY);
}
