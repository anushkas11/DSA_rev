class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int value=image[sr][sc];
        if(value==color) return image;
        dfs(image,sr,sc,value,color);
        return image;
    }
    private void dfs(int[][] image, int i,int j,int value,int color){
        if(i<0||j<0|| i>=image.length ||j>=image[0].length|| image[i][j]!=value) return ;
        image[i][j]=color;
        dfs(image,i+1,j,value,color);
        dfs(image,i-1,j,value,color);
        dfs(image,i,j+1,value,color);
        dfs(image,i,j-1,value,color);
    }
}