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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int initialColor = image[sr][sc]; // Store the initial color of the starting pixel
        int[][] result = image; // Create a copy of the image to store the result
        
        int[] delRow = {-1, 0, 1, 0}; // Changes in row index to traverse neighbors (up, right, down, left)
        int[] delCol = {0, 1, 0, -1}; // Changes in column index to traverse neighbors (up, right, down, left)
        
        // Perform the DFS traversal to fill the connected region with the new color
        dfs(sr, sc, result, image, newColor, delRow, delCol, initialColor);
        
        return result; // Return the updated image after flood fill
    }
    

    private void dfs(int row, int col, int[][] result, int[][] image, int newColor, int[] delRow, int[] delCol, int initialColor) {
        
        // Fill the current pixel with the new color
        result[row][col] = newColor; 
        
        int numRows = image.length; // Number of rows in the image
        int numCols = image[0].length; // Number of columns in the image
        
        // Traverse the neighbors of the current pixel
        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i]; // Calculate the new row index for the neighbor
            int newCol = col + delCol[i]; // Calculate the new column index for the neighbor
            
            // Check if the neighbor pixel is within the image boundaries,
            //has the initial color,
            // and has not been filled with the new color
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                    && image[newRow][newCol] == initialColor && result[newRow][newCol] != newColor)
            {
                // Recursively perform the flood fill operation on the neighbor pixel
                dfs(newRow, newCol, result, image, newColor, delRow, delCol, initialColor);
            }
        }
    }
}