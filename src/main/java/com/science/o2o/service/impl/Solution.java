class Solution {
    public int uPaths(int[][] obstacleGrid, int x, int y, int[][] memo){
        if(x >= obstacleGrid[0].length || y >= obstacleGrid.length)
            return 0;
        if(obstacleGrid[x][y] == 1)
            return 0;
        if(x == obstacleGrid[0].length -1 && y==obstacleGrid.length-1)
            return 1;

        if(memo[x][y] == -1){
            memo[x][y] = uPaths(obstacleGrid, x+1, y, memo)+uPaths(obstacleGrid, x, y+1, memo);
        }
        return memo[x][y];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int[][] memo=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0; i< obstacleGrid.length; i++){
            for(int j=0; j<obstacleGrid[0].length;j++){
                memo[i][j]=-1;
            }
        }
        return uPaths(obstacleGrid, 0, 0, memo);
    }

    public static void main(String[] args) {
        int[][] u=new int[1][2];
        u[0][0]=0;
        u[0][1]=0;
        new Solution().uniquePathsWithObstacles(u);
    }
}