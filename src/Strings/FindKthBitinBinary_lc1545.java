package Strings;

public class FindKthBitinBinary_lc1545 {

    public static void main(String[] args) {

        FindKthBitinBinary_lc1545 sol = new FindKthBitinBinary_lc1545();

        int n = 3;
        int k = 2;

        char result = sol.findKthBit(n, k);

        System.out.println(result);
    }


    //optimal
    public char findKthBit(int n , int k) {
        //we need to make sure that we dont ignore patterns like we did in this , we should always check for patterns

        //we need the kth value to track where it is gonna land , is it the first part of the (si) or the mid or the end
        if (n==1) return '0';
        //we need length for that this is the pattern 2^n -1
        int len = (int) Math.pow(2,n)-1;

        if (k == len/2+1) {
            return 1;
        }
        else if (k<= len/2) {
            return findKthBit(n-1, k);
        }

        char c = findKthBit(n-1 , len-k+1);
        return c == '0' ? '1' : '0';
    }





//    //Brute Force
//    public char findKthBit(int n, int k) {
//        String str = "0";
//        int i = 0;
//        while (i < n-1) { //lots of memory consumed for each loop
//            String inverted = invert(str);
//
//            //no need to create these , just use recursive approach and get the pattern of n that where it would fall and based on that just keep the conditions such thaat it will fall somehwhere and get a 0(n)
//            String SB = new StringBuilder(inverted).reverse().toString();
//            str = str + "1" + SB;
//            i++;
//        }
//        return str.charAt(k-1);
//    }
//
//    public String invert(String str) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < str.length(); i++) {
//            char compare = str.charAt(i);
//            sb.append(compare=='0' ? '1' : '0');
//        }
//        return sb.toString();
//
//    }




}
