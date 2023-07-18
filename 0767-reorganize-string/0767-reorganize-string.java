/*class Solution {
    public String reorganizeString(String S){
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}*/
class Solution {
    public String reorganizeString(String s) {
        int m[]=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++)
            m[s.charAt(i)-'a']++;
        
        StringBuilder ans=new StringBuilder();
        int i=0;
        char prev='*';
        while(i<n){
            int maxi=0,ind=0;
            for(int j=0;j<26;j++){                
                if(m[j]>maxi&&prev!=(j+'a')&&m[j]>0){
                    maxi=m[j];
                    ind=j;
                }
            }
            if(maxi==0) return "";
            prev=(char)(ind+'a');
            ans.append(prev);
            m[ind]--;  
            i++;
        }        
        return ans.toString();
    }
}
