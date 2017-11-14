class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int innerL = Math.max(A, E);
        int innerR = Math.max(innerL, Math.min(C, G));
        int innerT = Math.min(D, H);
        int innerB = Math.min(innerT, Math.max(B, F));
        return (C - A) * (D - B) - (innerR - innerL) * (innerT - innerB) + (G - E) * (H - F);
    }
}