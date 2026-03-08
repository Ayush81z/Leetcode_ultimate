package weekly_492;

public class pro1 {
    public static void main(String[] args) {
        int[] arr = {1,5,3,7};
        int itemsize = 3;
        System.out.println(minimumIndex(arr , itemsize));
    }

    public static  int minimumIndex(int[] capacity, int itemSize) {
        int smallest = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < capacity.length ; i++) {
            if (capacity[i] >= itemSize) {
                if (capacity[i] < smallest) {
                    smallest = capacity[i];
                    j = i;
                }
            }
        }
        if (smallest == Integer.MAX_VALUE) {
            return -1;
        }
        return j;
    }
}
