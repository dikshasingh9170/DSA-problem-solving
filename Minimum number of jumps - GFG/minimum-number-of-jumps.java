//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends
class Solution{
    static int minJumps(int[] arr){
        int[] jumps=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            jumps[i]=Integer.MAX_VALUE;
        }
        jumps[0]=0;
        int i=0,j=1;
        while(i<arr.length && j<arr.length){
            if(j<=arr[i]+i){
                jumps[j]=jumps[i]+1;
                j++;
            }else{
                i++;
            }
        }
        return jumps[arr.length-1]>=0 ? jumps[arr.length-1] : -1;
    }
}