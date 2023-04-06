class Solution {
    
    public int closedIsland(int[][] grid) {

        /*
         * Base Condition :
         * If row or column length is less than 3 all the values will be somehow connected to perimeter.
         * So there can't be a island.
         */
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        int numberOfClosedIsland = 0;

        /*
         * In the perimeter of the grid, irrespective of land(0) or water(0) it will never be a closed island.
         * So, we want to confined our search from (row - 1) to (grid.length - 2) i.e. Skipping first row and last row.
         * Same thing is applicable to columns also for column also we want to confined our search from
         * (col - 1) to (grid[0].length - 2) i.e. Skipping first col and last col.
         */
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                // Try to explore if is a land
                if (grid[i][j] == 0) {
                    if (exploreIsland(i, j, grid)) {
                        numberOfClosedIsland++;
                    }
                }
            }
        }

        return numberOfClosedIsland;
    }

    /*
     * Will try to explore the part with DFS
     * 0 : Land  ,   1 : Water     &   -1 : Visited Position
     */
    public boolean exploreIsland(int row, int col, int[][] grid) {


        /*
         *   *****  NOTE : Keep this condition before base condition of perimeter. Other wise this method will always return false.
         *
         * If we are reaching till to a position which is water or already explored we can return true.
         * As this can lead to a probable closed island
         */
        if (grid[row][col] == 1 || grid[row][col] == -1) {
            return true;
        }

        /*
         * Base Condition :
         * Irrespective of land(0) or water(0) if any of the position is lying on the perimeter we want to return false.
         * Because if it is lying on the perimeter it will never be a closed island.
         *
         * So, we want to confined our search from (row - 1) to (grid.length - 2) i.e. Skipping first row and last row.
         * For column also we want to confined our search from (col - 1) to (grid[0].length - 2) i.e. Skipping first col and last col.
         *
         * So if current row is reaching to position 0 or (grid.length - 1) we can return false.
         * For column also if it is reaching to position 0 or (grid[0].length - 1) we can return false.
         */
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
            return false;
        }


        // To denote that this position is visited, instead of boolean[] visited array.
        grid[row][col] = -1;

        //Explore left side
        boolean left = exploreIsland(row, col - 1, grid);
        //Explore right side
        boolean right = exploreIsland(row, col + 1, grid);
        //Explore Up side
        boolean up = exploreIsland(row - 1, col, grid);
        //Explore down side
        boolean down = exploreIsland(row + 1, col, grid);

        // It will be only closed island if all the side has water in it. So, final result will be ( left && right && up && down )
        return left && right && up && down;
    }
    
}