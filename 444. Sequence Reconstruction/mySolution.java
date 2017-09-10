/**
 * For org to be uniquely reconstructible from  seqs we need to satisfy 2 conditions: 
 *  1. Every sequences in seqs should be a subsequence in org. This 
 *      part is obvious
 *  2. Every 2 consecutive elements in org should be consecutive
 *      elements  in some sequence from seqs.
 *  https://leetcode.com/problems/sequence-reconstruction/discuss/
 */
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Set<String> pairs = new HashSet<>();
        Map<Integer, Integer> idxs = new HashMap<>();
        for (int i = 0; i < org.length; i++) {
            idxs.put(org[i], i);
        }

        for (int j = 0; j <seqs.size(); j++) {
            List<Integer> s = seqs.get(j);
            for (int i = 0; i < s.size(); i++) {
                if (!idxs.containsKey(s.get(i)))
                    return false;
                if (i > 0 && idxs.get(s.get(i-1)) >= idxs.get(s.get(i))) 
                    return false;
                if (i > 0) 
                    pairs.add(s.get(i-1)+"_"+s.get(i));
                else if (i == 0)
                    pairs.add("NULL_" +s.get(i));
            }
        }

        for (int i = 0; i < org.length; i++) {
            String s = (i == 0) ? "NULL_" : org[i-1]+ "_";
            if (!pairs.contains(s+org[i])) {
                return false;
            }
        }
        return true;
    }
}