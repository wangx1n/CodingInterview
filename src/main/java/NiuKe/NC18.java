package NiuKe;

public class NC18 {
    public static void main(String[] args) {
        int[] req = new int[]{1,2, -99, 5,-5};
        maxsumofSubarray(req);
    }
    public static int maxsumofSubarray (int[] arr) {
// write code here
        if(arr.length == 0)return 0;
        int sum = arr[0];
        int max = sum;
        for(int i = 1;i < arr.length;i++){
            sum = sum > 0 ? sum + arr[i] : arr[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
