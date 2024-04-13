import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int check = s.nextInt();
        int count =1;
        int num = check;
        while (count > 0){
            int a = (num/10) + (num%10);
            int new_ = (num%10)*10 + (a%10);
            if (check == new_){
                break;
            }
            count++;
            num = new_;
        }
        System.out.print(count);
        s.close();
    }
}
