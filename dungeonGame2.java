class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] dp = new Integer[dungeon.length][dungeon[0].length];
        return calculate(dungeon, 0, 0, dp);
    }

    private int calculate(int[][] a, int i, int j, Integer[][] dp) {
        // base case
        if (i == a.length - 1 && j == a[0].length - 1)
            return a[i][j] > 0 ? 1 : -a[i][j] + 1;
        if (dp[i][j] != null)
            return dp[i][j];
        // last row
        if (i == a.length - 1)
            return dp[i][j] = Math.max(1, calculate(a, i, j + 1, dp) - a[i][j]);
        // last column
        if (j == a[0].length - 1)
            return dp[i][j] = Math.max(1, calculate(a, i + 1, j, dp) - a[i][j]);

        return dp[i][j] = Math.max(1, Math.min(calculate(a, i + 1, j, dp) - a[i][j],
                calculate(a, i, j + 1, dp) - a[i][j]));
    }
}


// TC - O(mn), where m = number of rows and n number of cols
// SC - O(mn), where m = number of rows and n number of cols