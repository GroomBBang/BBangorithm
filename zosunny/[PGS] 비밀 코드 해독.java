import java.util.*;

class Solution {
    
    static int len;
    static int answer;
    
    // 2) q 돌면서 응답(ans) 맞는지 확인하고, answer++
    public static void check(Set<Integer> set, int[][] q, int[] ans){
        for(int i=0; i<len; i++){
            int cnt = 0;
            for(int j=0; j<5; j++){
                if(set.contains(q[i][j])) cnt++;
            }
            if(cnt != ans[i]) return;
        }
        answer++;
    }
    
    // 1) n 범위까지 5자리 조합 생성
    public static void combi(int cnt, int start, int n, boolean[] select, int[][] q, int[] ans){
        if(cnt == 5){
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<=n; i++){
                if(select[i]) set.add(i);
            }
            check(set, q, ans);
            return;
        }
        for(int i=start; i<=n; i++){
            if(select[i]) continue;
            select[i] = true;
            combi(cnt+1, i+1, n, select, q, ans);
            select[i] = false;
        }
    }
    
    public int solution(int n, int[][] q, int[] ans) {
        len = q.length;
        
        boolean[] select = new boolean[n+1];
        combi(0, 1, n, select, q, ans);
        
        return answer;
    }
}
