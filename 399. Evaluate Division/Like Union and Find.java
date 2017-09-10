class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> sets = new HashMap<>();
        Map<String, Double> vals = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        int nextSetNum = 0;
        for (int i = 0; i < equations.length; i++) {
            String a = equations[i][0], b = equations[i][1];
            Integer setA = sets.get(a), setB = sets.get(b);
            if (setA == null && setB == null) {
                sets.put(a, nextSetNum);
                sets.put(b, nextSetNum++);
                vals.put(a, values[i]);
                vals.put(b, 1.0);
                list.add(new LinkedList<>(Arrays.asList(a,b)));
            } else if (setB == null) {
                sets.put(b, setA);
                vals.put(b, vals.get(a) / values[i]); // node consider 0,0;
                list.get(setA).add(b);
            } else if (setA == null) {
                sets.put(a, setB);
                vals.put(a, vals.get(b) * values[i]);
                list.get(setB).add(a);
            } else if (!setA.equals(setB)) {
                double factor = vals.get(a) / values[i] / vals.get(b);
                for (String str: list.get(setB)) {
                    sets.put(str, setA);
                    vals.put(str, vals.get(str) * factor);
                }
            }
        }
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            Integer setA = sets.get(queries[i][0]), setB = sets.get(queries[i][1]);
            if (setA != null && setA.equals(setB)) ans[i] = vals.get(queries[i][0]) / vals.get(queries[i][1]);
            else ans[i] = -1.0;
        }
        return ans;
    }
}