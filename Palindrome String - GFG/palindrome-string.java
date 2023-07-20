//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        boolean res=recur(S);
        
        if(res==false) return 0;
        
        else return 1;
    }
    public boolean recur(String s){
        if(s.length()==1 || s.length()==0) return true;
        
        if(s.charAt(0)==s.charAt(s.length()-1)){
            return recur(s.substring(1,s.length()-1));
        }
        return false;
    }
};