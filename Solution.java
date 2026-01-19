
public class Solution {

    private static final int NO_TOWER_IS_REACHABLE = -1;

    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int maxQuality = NO_TOWER_IS_REACHABLE;
        int[] coordinates = {NO_TOWER_IS_REACHABLE, NO_TOWER_IS_REACHABLE};

        for (int[] tower : towers) {
            double distance = getManhattanDistance(center[0], center[1], tower[0], tower[1]);
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
    }

    private double getManhattanDistance(int firstX, int firstY, int secondX, int secondY) {
        return Math.abs(firstX - secondX) + Math.abs(firstY - secondY);
    }

    private boolean isLexicographicallySmaller(int firstX, int firstY, int secondX, int secondY) {
        return (firstX < secondX) || ((firstX == secondX) && firstY < secondY);
    }
}
