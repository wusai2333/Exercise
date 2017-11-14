class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        // when the length of two solutions are equal, the longer one must be the lexicographically smaller one;
       int n = A.length;
       int[] c = new int[n]; // cost;
       int[] p = new int[n]; // previous index, record the path;
       int[] l = new int[n]; // length;
       Arrays.fill(c, Integer.MAX_VALUE);
       Arrays.fill(p, -1);
       c[0] = 0; // c[0] = A[0];
       for (int i = 0; i < n; i++) {
           if (A[i] == -1) continue;
           for (int j = Math.max(0, i - B); j < i; j++) {
               if (A[j] == -1) continue;
               int newCost = c[j] + A[i];
               if (newCost < c[i] || newCost == c[i] && l[j] + 1 > l[i]) {
                   c[i] = newCost;
                   p[i] = j;
                   l[i] = l[j] + 1;
               }
           }
       }
       List<Integer> path = new ArrayList<Integer>();
       for (int cur = n - 1; cur >=0; cur = p[cur]) path.add(0, cur + 1);
       return path.get(0) != 1 ? new ArrayList<>(): path;
    }
}
