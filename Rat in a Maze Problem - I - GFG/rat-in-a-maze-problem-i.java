//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> arr=new ArrayList<>();
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        arr.clear();
        boolean[][] vis=new boolean[n][n];
        if(m[0][0]==0) return arr;
        if(m[n-1][n-1]==0)return arr;
        
        String s="";
        
        dfs(0,0,s,m,n,vis);
        Collections.sort(arr);
        return arr;
        
    }
    
    public static void dfs(int i,int j,String s,int[][] m, int n,boolean[][]vis){
        if(i<0 ||j<0 ||i>=n || j>=n) return;
        
        if(m[i][j]==0 || vis[i][j]==true) return;
        
        if(i==n-1 && j==n-1){
            arr.add(s);
            return;
        }
        //agar upar me se kuch bhi nahi hua to aage traverse krna hai
        vis[i][j]=true;
        dfs(i-1,j,s+"U",m,n,vis);
        dfs(i+1,j,s+"D",m,n,vis);
        dfs(i,j-1,s+"L",m,n,vis);
        dfs(i,j+1,s+"R",m,n,vis);
        
        //if the route that we took doesnot work then come back,backtrack
        vis[i][j]=false;
        
    }
}