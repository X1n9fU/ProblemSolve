class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        if (s.length() == 1) return 1;
        for (int i=0; i<s.length(); i++) {
            int even = checkEvenPalin(s,i);
            int odd = checkOddPalin(s,i);            
            answer = Math.max(answer, Math.max(even, odd));
        }
        
        return answer;
    }
    
    int checkOddPalin(String s, int index){
        int len = 0;
        int left = index;
        int right = index;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len++;
            left --;
            right ++;
        }
        
        return len * 2 - 1;
    }
    
    int checkEvenPalin(String s, int index){
        int len = 0;
        int left = index;
        int right = index+1;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            len++;
            left --;
            right ++;
        }
        
        return len * 2;
    }
}