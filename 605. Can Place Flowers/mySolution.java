public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] != 1 && canPlant(flowerbed, i)) {
                n--;
                flowerbed[i] = 1;
            }
        }
        return n <= 0;
    }
    
    private boolean canPlant(int[] flowerbed, int idx) {
        if ((idx==0 || flowerbed[idx-1] == 0) && (idx == flowerbed.length-1 || flowerbed[idx+1] == 0)) {
            return true;
        }
        return false;
    }
}