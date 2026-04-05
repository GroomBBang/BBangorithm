import java.util.*;

class Solution {
    
    static int n;
    
    public static int calc(int start, int target, int[] money){
        
        int[] dp = new int[n];
        dp[start] = money[start];
        dp[start+1] = Math.max(money[start], money[start+1]);
        
        for(int i=start+2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
        }
        
        return dp[target];
    }
    
    public int solution(int[] money) {
        n = money.length;
        
        int ans1 = calc(0, n-2, money);
        int ans2 = calc(1, n-1, money);
        
        return Math.max(ans1, ans2);
    }
}
