class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        int sum = list1.length + list2.length;
        List<String> res = new LinkedList<>();
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                if (map1.get(s) + map2.get(s) <= sum) {
                    int temp = map1.get(s) + map2.get(s);;
                    if (temp < sum) {
                        res.clear();
                    }
                    res.add(s);
                    sum = temp;
                }
            }
        }
        String[] result = res.toArray(new String[res.size()]);
        return result;
    }
}