//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
class Solution
{
    public String FirstNonRepeating(String A)
    {
          StringBuilder sb=new StringBuilder("");
          
          Map<Character,Integer> map=new LinkedHashMap<>();
          int i=0;
          
          while(i<A.length())
          {
              char c=A.charAt(i);
              if(!map.containsKey(c))
              {
                  map.put(c,1);
              }
              else
              {
                  map.put(c,map.get(c)+1);
              }
              int flg=0;
              
              for(Character t : map.keySet())
              {
                  if(map.get(t)==1)
                  {
                      sb.append(t);
                      flg=1;
                      break;
                  }
              }
              
              if(flg==0)
              {
                  sb.append("#");
              }
              i++;
          }
          
          return sb.toString();
    }
}