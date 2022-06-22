import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UniquePaths {

    // Recursive solution times out on submit.
    public int uniquePathsRecursive(int m, int n) {

        if(n == 1 && m == 1) return 1;
        if(n == 0 || m == 0) return 0;

        return uniquePathsRecursive(m - 1, n) + uniquePathsRecursive(m, n - 1);
    }

    // Next idea was to use a HashMap along with DP. Accepted, but still slow
    public int uniquePathsMap(int m, int n) {

        Map<String, Integer> map = new HashMap<>();

        return uniqueHelper(m, n, map);
    }

    public int uniqueHelper(int m, int n, Map<String, Integer> map) {

        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;

        String key = m + "," + n;

        if(map.containsKey(key)) return map.get(key);

        int path = uniqueHelper(m - 1, n, map) + uniqueHelper(m, n - 1, map);

        map.put(key, path);

        return path;
    }

    // Same idea, but much faster than using HashMap. Hashmap was 16ms using Array was 1ms
    public int uniquePathArray(int m, int n) {

        int[][] memo = new int[m + 1][n + 1];

        return uniqueArrayHelper(m, n, memo);
    }

    private int uniqueArrayHelper(int m, int n, int[][] memo) {

        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;

        if(memo[m][n] > 0) return memo[m][n];

        int path = uniqueArrayHelper(m - 1, n, memo) + uniqueArrayHelper(m, n - 1, memo);

        memo[m][n] = path;

        return path;
    }

    // 0ms faster than 100% for java
    public int uniquePathsIterative(int m, int n) {

        int[][] paths = new int[m][n];

        // Set left column to 1's
        for(int i = 0; i < m; i++) paths[i][0] = 1;

        // Set first row to 1's
        for(int i = 0; i < n; i++) paths[0][i] = 1;

        for(int i = 1; i < m; i++) {

            for(int j = 1; j < n; j++) {

                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];

            }

        }

        return paths[m - 1][n - 1];
    }
}
