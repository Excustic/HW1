public class Assignment01Q05 {

    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }

        int n = m.length;
        boolean[] visited = new boolean[n];
        visited[i] = true;
        int[] nextVisit = new int[n]; // we save here nodes to visit, mimicing a list and setting the cell next to
                                      // last as -1
        nextVisit[0] = i;
        if (n > 1)
            nextVisit[1] = -1;

        int visitCount = 0; // we count how many levels we have searched

        // Search all nodes level by level - first to reach j wins.
        while (visitCount <= n) {
            // Assign next visits
            int idx = 0, p = 0;
            int[] tmp = new int[n]; // helper array to save next state
            while (p < n && nextVisit[p] != -1) {
                // nextVisit[p] is the index we wish to visit
                for (int k = 0; k < n; k++) {
                    // Visit if connected, and not visited before
                    if (m[nextVisit[p]][k] == 1 && visited[k] == false) {
                        tmp[idx++] = k;
                        visited[k] = true;
                        if (k == j)
                            return visitCount + 1;

                    }
                }
                p++;
            }
            if (idx == 0) // no routes to discover, we're finished.
                return -1;
            else if (idx < n)
                tmp[idx] = -1;
            nextVisit = tmp;
            visitCount++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 0, 1)); // -1
        System.out.println(
                findShortestPath(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, 1, 1)); // 0
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 } }, 0, 2)); // 2
        System.out.println(
                findShortestPath(new int[][] { { 0, 1, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } }, 0, 2)); // 2
    }
}