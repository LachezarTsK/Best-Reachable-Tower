
using System;

public class Solution
{
    private static readonly int NO_TOWER_IS_REACHABLE = -1;

    public int[] BestTower(int[][] towers, int[] center, int radius)
    {
        int maxQuality = NO_TOWER_IS_REACHABLE;
        int[] coordinates = { NO_TOWER_IS_REACHABLE, NO_TOWER_IS_REACHABLE };

        foreach (int[] tower in towers)
        {
            double distance = GetManhattanDistance(center[0], center[1], tower[0], tower[1]);
            if (distance > radius || maxQuality > tower[2])
            {
                continue;
            }

            if (maxQuality < tower[2])
            {
                maxQuality = tower[2];
                coordinates[0] = tower[0];
                coordinates[1] = tower[1];
                continue;
            }

            if (IsLexicographicallySmaller(tower[0], tower[1], coordinates[0], coordinates[1]))
            {
                coordinates[0] = tower[0];
                coordinates[1] = tower[1];
            }
        }

        return coordinates;
    }

    private double GetManhattanDistance(int firstX, int firstY, int secondX, int secondY)
    {
        return Math.Abs(firstX - secondX) + Math.Abs(firstY - secondY);
    }

    private bool IsLexicographicallySmaller(int firstX, int firstY, int secondX, int secondY)
    {
        return (firstX < secondX) || ((firstX == secondX) && firstY < secondY);
    }
}
