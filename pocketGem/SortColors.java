class PocketColor {
    int data;
    char c;
    PocketColor() {}
    PocketColor(int data, char c) {
        this.data = data;
        this.c = c;
    }
}
class Solution {
    public void sort(PocketColor[] colors) {
        if (colors.length == 0 || colors == null) return;
        int red = 0, blue = colors.length - 1;
        for (int i = 0;  i < colors.length; i++) {
            while (colors[i].c == 'b' && i < blue) {
                swap(colors, i, blue);
                blue--;
            }
            while (colors[i].c == 'r' && i > red) {
                swap(colors, i, red);
                red++;
            }
        }
    }

    private void swap(PocketColor[] colors, int i, int j) {
        char temp = colors[i].c;
        colors[i].c = colors[j].c;
        colors[j].c = temp;
    }
}

public class SortColors {
    public static void main(String[] args) {
        PocketColor p1 = new PocketColor(3, 'r');
        PocketColor p2 = new PocketColor(3, 'g');
        PocketColor p3 = new PocketColor(3, 'b');
        PocketColor p4 = new PocketColor(3, 'r');
        PocketColor p5 = new PocketColor(3, 'g');
        PocketColor p6 = new PocketColor(3, 'b');
        PocketColor[] colors = new PocketColor[]{p1,p2,p3,p4,p5,p6};
        Solution solution = new Solution();
        solution.sort(colors);
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i].c);
        }
    }
}
