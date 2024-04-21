import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        s.nextLine();
        int count=0;
        int []alp = new int[26];


        for(int i=0; i<num; i++){
            boolean check = true; //
            String str = s.nextLine();
            char [] c = str.toCharArray();
            for (int j=0; j<26; j++) {
                alp[j] = 0;
            }
            for (int j=0; j<c.length; j++) {
                char cp = c[j];
                int index = c[j]-'a';
                if (alp[index]==0) {
                    for (int k = j + 1; k < c.length; k++) {
                        if (cp != c[k]) {
                            alp[index] = 1;
                            j=k-1;
                            break;
                        }
                    }
                }
                else {
                    check =false;
                    break;
                }
            }
            if (check) count++;
        }

        System.out.print(count);

    }
}
