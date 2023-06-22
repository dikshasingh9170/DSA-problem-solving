class Solution {
    public int punishmentNumber(int n) {
        long ans = 0;
        for (long i = 1; i <= n; ++i) {
            long x = i*i;
            String s = Long.toString(x);
            if(valid(0,s,(int)i)){
                ans+=i*i;
            }
        }
        return (int)ans;
    }
    public static boolean valid(int idx, String s, int target) {
        if (idx == s.length()) {
            return target == 0;
        }
        if (target < 0) {
            return false;
        }
        for (int i = idx;i<s.length();i++) {
            String x = s.substring(idx, i + 1);
            int y = Integer.parseInt(x);
            if (valid(i + 1,s,target-y)) {
                return true;
            }
        }
        return false;
    }
}