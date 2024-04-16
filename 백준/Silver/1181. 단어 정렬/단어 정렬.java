import java.util.Arrays;
import java.util.Scanner;
//[문자열] 단어 정렬
class Words{
    String word;
    Words(String word){
        this.word=word;
    }
}
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        s.nextLine();
        Words [] words = new Words[num];
        for (int i=0; i<num; i++){
            String word = s.nextLine();
            words[i] = new Words(word);
        }
        Arrays.sort(words, (w1, w2) -> w1.word.length() == w2.word.length()? w1.word.compareTo(w2.word) : w1.word.length() - w2.word.length());
        System.out.println(words[0].word);
        for (int i=0; i<words.length-1; i++){
            if (!words[i].word.equals(words[i+1].word)){
                System.out.println(words[i+1].word);
            }

        }

    }
}
