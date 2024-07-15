import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (isCorrect(p)) return p;

        return checkString(p);
    }

    private String checkString(String p){
        if (p.isEmpty()) return p;
        String u="";
        String v="";
        for (int i=2; i<=p.length(); i+=2) {
            u = p.substring(0, i);
            v = p.substring(i);

            if (isEven(u)) break;
        }

        if (isCorrect(u)) {
            u = u.concat(checkString(v));
            return u;
        } else {
                String tmp = "";

                u = u.substring(1, u.length() - 1);
                for (int j = 0; j < u.length(); j++) {
                    if (u.charAt(j) == '(') tmp = tmp.concat(")");
                    else tmp = tmp.concat("(");
                }
                u = "(".concat(checkString(v)).concat(")").concat(tmp);
                //여기서 잘못 이해한 것 같다.

                return u;

        }
    }

    private boolean isEven(String p){
        int left = 0;
        int right = 0;
        for (int i=0; i<p.length(); i++){
            if (p.charAt(i) == '(') left += 1;
            else right += 1;
        }
        return right == left;
    }

    /*
    균형잡힌 문자열인지 먼저 확인 -> 균형 잡힌 문자열 false
    올바른 문자열인지 확인 -> 올바른 문자열 true
     */
    private boolean isCorrect(String u){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<u.length(); i++){
            if (u.charAt(i) == '(') stack.push('('); // '('가 나오면 넣기
            else {
                if (stack.isEmpty()){ //만약 비어 있다면 ')'가 먼저 나온 것이므로 올바른 문자열이 아님
                    return false;
                } else stack.pop(); //')'를 만났을 때 '('이 있으면 pop!
            }
        }
        return true;
    }
}