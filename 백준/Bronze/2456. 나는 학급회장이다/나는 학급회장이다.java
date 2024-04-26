import java.util.Arrays;
import java.util.Scanner;

class Count{
    int one;
    int two;
    int three;

    Count(int i, int j, int k){
        one=i;
        two=j;
        three=k;
    }
}
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        Count [] count = new Count[3];
        int []score = new int[]{0,0,0};
        int N = s.nextInt();

        for (int i=0; i<3; i++) count[i] = new Count(0,0,0);

        for (int i=0; i<N; i++){
            for (int j=0; j<3; j++) {
                int num = s.nextInt();
                score[j] += num;
                if (num == 1) count[j].one++;
                else if(num==2) count[j].two++;
                else count[j].three++;
            }
        }
        int max = 0;
        int index=-1;
        for (int i=0; i<3; i++) {
            if (max < score[i]) {
                max=score[i];
                index=i;
            }
        }
        boolean indecisive = false;
        index = index+1;
        for (int i=1; i<4; i++){
            if (max == score[i-1] && index != i) {
                if (count[index-1].three < count[i-1].three) {
                    indecisive = false;
                    index=i;
                }
                else if(count[index-1].three == count[i-1].three){
                    if (count[index-1].two < count[i-1].two) index=i;
                    else if(count[index-1].two == count[i-1].two) {
                        indecisive = true;
                    }
                }
            }
        }
        if (indecisive) System.out.println(0+" "+max);
        else  System.out.println(index +" "+max);
    }
}
