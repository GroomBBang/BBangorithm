import java.util.*;

class Solution {
    public int solution(int N, int number) {
        
        if(N == number) return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0; i<9; i++){
            list.add(new HashSet<>());
        }
        
        list.get(1).add(N);
        
        for(int i=2; i<9; i++){
            String str = "";
            for(int j=0; j<i; j++){
                str += Integer.toString(N);
            }
            list.get(i).add(Integer.parseInt(str));
            
            for(int j=1; j<i; j++){
                for(int x : list.get(j)){
                    for(int y : list.get(i-j)){
                        int n1 = x + y;
                        int n2 = x - y;
                        int n3 = x * y;
                        int n4 = x / y;
                        if(n1 > 0 && n1 <= 32000) list.get(i).add(n1);
                        if(n2 > 0 && n2 <= 32000) list.get(i).add(n2);
                        if(n3 > 0 && n3 <= 32000) list.get(i).add(n3);
                        if(n4 > 0 && n4 <= 32000) list.get(i).add(n4);
                    }
                }
            }
            if(list.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}
