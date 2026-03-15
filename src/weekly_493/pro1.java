package weekly_493;

public class pro1 {
    public int countCommas(int n) {
        int count = 0;
        if (n > 999) {
            int times = n - 999;
            for(int i = 0; i < times ; i++) {
                count++;
            }
        }
        return count;
    }
}
