class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        char [] c = s.toCharArray();
        int [] n = new int[c.length];
        for(int i=0;i<n.length;i++)n[i]=m.get(c[i]);
        int sum=0;
        for(int i=0;i<n.length;i++)sum = i==c.length-1||n[i]>=n[i+1]?sum+n[i]:sum-n[i];
        return sum;
        
    }
}
