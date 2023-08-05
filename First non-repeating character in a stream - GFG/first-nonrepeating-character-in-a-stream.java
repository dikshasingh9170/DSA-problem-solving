//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        StringBuilder s=new StringBuilder("");
        Map<Character,Integer> hm=new LinkedHashMap<>();
        int i=0;
        while(i<A.length()){
            if(!hm.containsKey(A.charAt(i))){
                hm.put(A.charAt(i),1);
            }
            else{
                hm.put(A.charAt(i),hm.get(A.charAt(i))+1);
            }
            int flg=0;
            for(Character t:hm.keySet()){
                if(hm.get(t)==1){
                    s.append(t);
                    flg=1;
                    break;
                }
            }
            if(flg==0){
                s.append('#');
            }
            i++;
        }
        return s.toString();
    }
}