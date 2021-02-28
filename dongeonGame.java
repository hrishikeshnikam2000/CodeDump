class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        return calculate(dungeon, 0, 0);
    }

    private int calculate(int[][] a, int i, int j) {
        // base case
        if (i == a.length - 1 && j == a[0].length - 1)
            return a[i][j] > 0 ? 1 : -a[i][j] + 1;
        // last row
        if (i == a.length - 1)
            return Math.max(1, calculate(a, i, j + 1) - a[i][j]);
        // last column
        if (j == a[0].length - 1)
            return Math.max(1, calculate(a, i + 1, j) - a[i][j]);
        return Math.max(1, Math.min(calculate(a, i + 1, j) - a[i][j],
                calculate(a, i, j + 1) - a[i][j]));
    }
}

// As you can see the subproblem in recursive true solved multiple times so we will cache in dp array the solution and re-use later.