class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        
        int rowLen = dungeon.length;
        int colLen = dungeon[0].length;
        
        int dp[][] = new int[rowLen][colLen];
        
        if(dungeon[rowLen-1][colLen-1] <0){
            dp[rowLen-1][colLen-1] = 1-dungeon[rowLen-1][colLen-1];
        }else{
             dp[rowLen-1][colLen-1] = 1;
        }
        //Fill Last Row
        for(int i=dp[0].length -2; i>=0; i--){
            dp[rowLen-1][i] = dp[rowLen-1][i+1] - dungeon[rowLen-1][i] <=0 ? 1 
                            : dp[rowLen-1][i+1] - dungeon[rowLen-1][i];
            
        }
        // Fill Last Column
        for(int j=dp.length-2; j>=0; j--){
            
            dp[j][colLen-1] = dp[j+1][colLen-1] - dungeon[j][colLen-1] <=0 ? 1
                                : dp[j+1][colLen-1] - dungeon[j][colLen-1];
        }
        // Fill remaining values with minimum of the array and comparison with dungeon array
        for(int i=rowLen-2; i>=0; i--){
            for(int j=colLen-2; j>=0; j--){
                
                int minNum = Math.min(dp[i][j+1], dp[i+1][j]);
                
                if(dungeon[i][j] <=0 || dungeon[i][j]< minNum) {
                    dp[i][j] = minNum - dungeon[i][j];
                }else{
                       dp[i][j] = 1;
                }
            }
        }
        return dp[0][0];
        
    }
}

// Solution Using Dynammic Programming.