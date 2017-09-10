class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuesPair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                valuesPair.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            valuesPair.get(equation[0]).add(values[i]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
            
        }
        return result;
    }
    
    private double dfs(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> valuesPair, Set<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);
        
        List<String> strList =  pairs.get(start);
        List<Double> valueList = valuesPair.get(start);
        double temp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            temp = dfs(strList.get(i), end, pairs, valuesPair, set, value*valueList.get(i));
            if (temp != 0.0) {
                break;
            }
        }
        return temp;
    }
}