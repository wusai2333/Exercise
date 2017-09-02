class Solution {
    private List<HashMap<String, String>> list = new LinkedList<>();
    private HashMap<String, String> table = new HashMap<>();
    public List<HashMap<String, String>> parseJSon(JSON data, String[] columns) {
        helper(data, columns, 0);
        return list;
    }

    private void helper(JSON data, String[] columns, int depth) {
        if (data.type().equals("JSONMapping")) {
            JSONMapping dataMap = (JSONMapping) data;

            for (String key: dataMap.keys()) {
                JSON childJSON = dataMap.get(key);

                table.put(columns[depth], key);
                helper(childJSON, columns, depth + 1);
                table.remove(columns[depth]);
            }
        } else if (data.type().equals("JSONString")) {
            JSONString dataString = (JSONString) data;
            String val = dataString.value();

            table.put(columns[depth], val);
            list.add(table.clone());
            table.remove(columns[depth]);
        }
    }
}