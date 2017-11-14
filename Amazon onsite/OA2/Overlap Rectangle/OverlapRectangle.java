public class OverlapRectangle {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int innerL = Math.max(A, E);
        int innerR = Math.max(innerL, Math.min(C, G));
        int innerT = Math.min(B, F);
        int innerB = Math.min(innerT, Math.max(D, H));
        return (C - A)*(B - D) - (innerR - innerL) * (innerT - innerB) + (G - E) * (F - H);
    }
    
}