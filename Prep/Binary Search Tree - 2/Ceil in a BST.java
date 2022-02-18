//https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464

public class Solution {
    public  static int findCeil(TreeNode<Integer> root, int x) {
		if(root == null) return -1;
        
        if(root.data < x) return findCeil(root.right, x);
        
        int leftCiel = findCeil(root.left, x);
        return (leftCiel >= x) ? leftCiel : root.data;
    }
}
