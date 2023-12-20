package edit_distance;

public class Solution {

    public static int editDistance1(String s1, String s2) {
        if (s1.length() == 0)
            return s2.length();

        if (s2.length() == 0)
            return s1.length();

        if (s1.charAt(0) == s2.charAt(0)) {
            return editDistance1(s1.substring(1), s2.substring(1));
        } else {
            // insert
            int ed1 = editDistance1(s1, s2.substring(1));
            // delete
            int ed2 = editDistance1(s1.substring(1), s2);
            // substitute/replace
            int ed3 = editDistance1(s1.substring(1), s2.substring(1));

            return 1 + Math.min(Math.min(ed1, ed2), ed3);

        }
    }

    public static int editDistance2(String s, String t, int[][] dist) {
        int m = s.length();
        int n = t.length();

        for (int i = 0; i <= m; ++i) {
            dist[i][0] = i;
        }

        for (int i = 0; i <= n; ++i) {
            dist[0][i] = i;
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(m - i) == t.charAt(n - j)) {
                    dist[i][j] = dist[i - 1][j - 1];
                } else {
                    // insert
                    int ed1 = dist[i][j-1];
                    // delete
                    int ed2 = dist[i-1][j];
                    // substitute/replace
                    int ed3 = dist[i-1][j-1];

                    dist[i][j] =  1 + Math.min(Math.min(ed1, ed2), ed3);

                }
            }
        }
        return dist[m][n];

    }

    public static int editDistance(String s1, String s2) {
        int[][] dist = new int[s1.length() + 1][s2.length() + 1];

        return editDistance2(s1, s2, dist);

    }

}