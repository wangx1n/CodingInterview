package RealInterView.Tencent;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/24 20:03
 **/
public class TX2 {

    public static void main(String[] args) {
        int[] a = {2,900,500,300};

        TX2 tx2 = new TX2();
        int[] result = tx2.sort(a);

        for(int i : result){
            System.out.println(i);
        }
    }
    int[] sort(int a[]){

        int[] result = new int[2];

        int j = 0;
        for(int i = 0;i < a.length - 1;i++){
            if(a[i] > a[i+1]){
                result[j] = i;
                if(j == 1){
                    result[j] = i+1;
                }
                j++;
            }
            if(j == 2){
                break;
            }
        }

        int temp = a[result[0]];
        a[result[0]] = a[result[1]];
        a[result[1]] = temp;

        return a;
    }
}
