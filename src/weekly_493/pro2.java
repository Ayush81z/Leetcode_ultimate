package weekly_493;

public class pro2 {
    public static void main(String[] args) {
        long n = 1004590;
        System.out.println(countCommas(n));
    }
    public static long countCommas(long n) {
        int commas = 1;
        long count = 0;
        long start = 1000; //for 1 comma operations

        while (start <= n){
            long end = start * 1000 - 1; //the max value of 1 comma and so on (based on start)

            long numbers = Math.min(n ,end) - start + 1; //start - end + 1
            if (numbers > 0) {  //to avoid the negative
                count += numbers * commas; //update count for all the range of numbers
            }

            start *= 1000; //update for the next comma cycle with (2,3,4,5...) commas
            commas++; //increases the comma count for next round
        }

        return count;
    }

}
