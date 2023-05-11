//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<N-1;i++){
            String s1=dict[i];
            String s2=dict[i+1];
            for(int j=0;j<Math.min(s1.length(),s2.length());j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    adj.get((int)s1.charAt(j)-97).add((int)s2.charAt(j)-97);
                    break;
                }
            }
        }
        return topo(K,adj);
        
    }
    public String topo(int K,ArrayList<ArrayList<Integer>> adj){
        int[] indegree=new int[K];
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<K;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        for(int i=0;i<K;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> arr=new ArrayList<Integer>();
        while(!q.isEmpty()){
            int x=q.poll();
            arr.add(x);
            for(int e:adj.get(x)){
                indegree[e]--;
                if(indegree[e]==0){
                    q.add(e);
                }
            }
        }
        String x="";
        for(int i=0;i<arr.size();i++){
            x+=(char)(arr.get(i)+97);
        }
        return x;
    }
}