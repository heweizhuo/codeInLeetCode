import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args){
        MaximalRectangle Solution=new MaximalRectangle();
        System.out.println(Solution.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int maxArea=0,row=matrix.length,col=matrix[0].length;
        int [] heights=new int[matrix[0].length];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                heights[j]=matrix[i][j]=='1'?heights[j]+1:0;
            }
            maxArea=Math.max(maxArea,LargestRectangle(heights));
        }
        return maxArea;
    }
    public int LargestRectangle(int[] height){
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int maxArea=0;
        for (int j=0;j<=height.length;j++){
            if(j==height.length || (!stack.isEmpty() && stack.peek()>height[j])){
                int min=Integer.MAX_VALUE;
                for (int m=j-1;m>=0;m--){
                    min=Math.min(min,height[m]);
                    int area=min*(j-m);
                    maxArea=Math.max(maxArea,area);
                }
            }
            if(j<height.length)
                stack.push(height[j]);
        }
        return maxArea;
    }
}
