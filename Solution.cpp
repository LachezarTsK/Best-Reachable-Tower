
#include <cmath>
#include <vector>
using namespace std;

class Solution {

    static const int NO_TOWER_IS_REACHABLE = -1;

public:
    vector<int> bestTower(vector<vector<int>>& towers, vector<int>& center, int radius) const {
        int maxQuality = NO_TOWER_IS_REACHABLE;
        vector<int> coordinates{ NO_TOWER_IS_REACHABLE, NO_TOWER_IS_REACHABLE };

        for (const auto& tower : towers) {
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

private:
    double getManhattanDistance(int firstX, int firstY, int secondX, int secondY) const {
        return abs(firstX - secondX) + abs(firstY - secondY);
    }

    bool isLexicographicallySmaller(int firstX, int firstY, int secondX, int secondY) const {
        return (firstX < secondX) || ((firstX == secondX) && firstY < secondY);
    }
};
