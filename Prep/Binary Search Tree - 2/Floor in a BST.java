//https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457

public class Solution {
    public static int floorInBST(TreeNode<Integer> root, int X) {
        if(root == null) return Integer.MAX_VALUE;
        
        if(root.data > X) return floorInBST(root.left, X);
        
        int rightFloor = floorInBST(root.right, X);
        return (rightFloor <= X) ? rightFloor : root.data;
    }
}
