//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here 
        StringBuilder sb=new StringBuilder();
        String k[]=s.split("\\.");
        Stack<String> st=new Stack<>();
        for(int i=0;i<k.length;i++){
            if(k[i]=="."){
                
            }else{
                st.push(k[i]);
            }
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
            sb.append(".");
        }
        sb.deleteCharAt(sb.length()-1);
        return String.valueOf(sb);
    }
}