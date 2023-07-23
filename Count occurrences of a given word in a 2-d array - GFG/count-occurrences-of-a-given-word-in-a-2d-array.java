//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 
        
        Integer nextInt(){
            return Integer.parseInt(next());
        }
    } 
    
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t>0)
        {
            int R = sc.nextInt();
            int C = sc.nextInt();
            
            char mat[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
            String target  = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findOccurrence(mat,target));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findOccurrence(char mat[][], String target) {
        int res = 0; 
        for (int i = 0; i < mat.length; i++) { 
            for (int j = 0; j < mat[i].length; j++) { 
                res += helper(mat, target, i, j, 0);
            }
        }
        return res;
    }

    int helper(char mat[][], String target, int i, int j, int ind) {
        int found = 0;

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || target.charAt(ind) != mat[i][j]) {
            return 0;
        }
        if (ind == target.length() - 1) {
            return 1;
        }
        char temp = mat[i][j];
        mat[i][j] = '*';
        found += helper(mat, target, i - 1, j, ind + 1);
        found += helper(mat, target, i + 1, j, ind + 1);
        found += helper(mat, target, i, j - 1, ind + 1);
        found += helper(mat, target, i, j + 1, ind + 1);
        mat[i][j] = temp;

        return found;
    }
}