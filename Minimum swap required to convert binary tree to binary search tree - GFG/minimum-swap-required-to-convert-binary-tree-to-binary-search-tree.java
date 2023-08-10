//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minSwaps(n, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minSwaps(int n, int[] A) {
        ArrayList<Integer> in=new ArrayList<Integer>();
        inorder(0,n,A,in);
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            arr.add(in.get(i));
            hm.put(in.get(i),i);
        }
        Collections.sort(arr);
        int cnt=0;
        for(int i=0;i<in.size();i++){
            int x=in.get(i);
            if(in.get(i)!=arr.get(i)){
                cnt++;
                Collections.swap(in,i,hm.get(arr.get(i)));
                hm.put(x,hm.get(arr.get(i)));
                hm.put(arr.get(i),i);
            }
        }
        return cnt;
    }
    public static void inorder(int i,int n,int[] A,ArrayList<Integer> in){
        if(i>=n){
            return;
        }
        inorder(2*i+1,n,A,in);
        in.add(A[i]);
        inorder(2*i+2,n,A,in);
    }
}
        
