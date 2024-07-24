import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> list = new ArrayList<>();
        for (int i=0; i<banned_id.length; i++){
            list.add(new ArrayList<>());
        }
        int index = 0;
        for (String ban : banned_id){
            for (String user : user_id){
                boolean isBan = false;
                if (ban.length() == user.length()){
                    for (int i=0; i<ban.length(); i++){
                        if (ban.charAt(i) != user.charAt(i)){
                            if (ban.charAt(i) == '*'){
                                isBan = true;
                            } else {
                                isBan = false;
                                break;
                            }
                        }
                    }
                    if (isBan) {
                        list.get(index).add(user);
                    }
                }
            }
            index++;
        }

        Set<Set<String>> combinations = new HashSet<>();
        getAllCombinations(list, 0, new HashSet<>(), combinations);

        return combinations.size();
    }

    private static void getAllCombinations(List<List<String>> matchedList, int index, Set<String> current, Set<Set<String>> uniqueCombinations) {
        if (index == matchedList.size()) {
            uniqueCombinations.add(new HashSet<>(current));
            return;
        }

        for (String user : matchedList.get(index)) {
            if (!current.contains(user)) {
                current.add(user);
                getAllCombinations(matchedList, index + 1, current, uniqueCombinations);
                current.remove(user);
            }
        }
    }
}