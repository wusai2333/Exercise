// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class GreyCheck {
    // METHOD SIGNATURES BEGINS, THIS CLASS IS REQUIRED.
    public static int greycheck(byte term1, byte term2) {
        byte x = (byte)(term1^term2);
        int count = 0;
         while (x != 0) {
             x = (byte) (x & (x - 1));
             count++;
         }
         return count == 1 ? 1 : 0;
    }

    public static void main(String[] args) {
        byte term1 = (byte)0x0a, term2 = (byte)0x80;
        int out;
        out = greycheck(term1, term2);
        System.out.print(out);
    }
}