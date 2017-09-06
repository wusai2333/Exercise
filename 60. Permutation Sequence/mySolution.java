class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        // create a list of number to get indices
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;

        for (int i = 1; i <= n; i++) {
            int index = k/factorial[n-i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index*factorial[n-i];
        }

        return sb.toString();
    }
}