//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> search(String pat, String S)
    {
        // your code here
        //1.check whether that substring is even there or not
        ArrayList<Integer> l=new ArrayList<>();
        
        if(S.contains(pat)==false){
            l.add(-1);
            return l;
        } 
        
        indexOfAll(S,pat,l);
        
        return l;
    }
    
    public void indexOfAll(String s,String pattern,ArrayList<Integer> l){
        int index=s.indexOf(pattern);
        
        while(index!=-1){
            l.add(index+1);
            index=s.indexOf(pattern,index+1);
            //System.out.println(index);
        }
    }
}