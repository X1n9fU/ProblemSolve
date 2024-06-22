import java.util.*;

class Solution {
    public int solution(String dirs){
        Set<List<Integer>> road = new HashSet<>();
        int [] location = {0,0,0,0}; //1 U 2 D 3 R 4 L
        int length = dirs.length();
        char [] dir = dirs.toCharArray();
        int answer = 0;

        for (int i=0; i<length; i++){
            if (check(location, dir[i])){
                willMove(location, dir[i]);
                road.add(toList(location));
                location = opposite(location);
                road.add(toList(location));
                answer ++;
            }
        }

        return road.size()/2;
    }

    private int [] opposite(int[] location) {
        return new int[]{location[2], location[3], location[0], location[1]};
    }

    private boolean check(int [] present, char move){
        if (present[0] == 5) if (move == 'R') return false;
        if (present[0] == -5) if (move == 'L') return false;
        if (present[1] == 5) if (move == 'U') return false;
        if (present[1] == -5) if (move == 'D') return false;
        return true;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }
    private int [] willMove(int [] present, char move){
        switch (move){
            case 'U':
                present[2] = present[0];
                present[3] = present[1] + 1;
                break;
            case 'D':
                present[2] = present[0];
                present[3] = present[1] - 1;
                break;
            case 'R':
                present[2] = present[0] + 1;
                present[3] = present[1];
                break;
            case 'L':
                present[2] = present[0] - 1;
                present[3] = present[1];
                break;
        }
        return present;
    }
}