//https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1

class Solution
{
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int K)
    {
        return util(root, new int[]{K});
    }
    
    private int util(Node root, int[] k) {
        if(root == null) return -1;
        
        int right = util(root.right, k);
        if(right != -1) return right;
        if(--k[0] == 0) return root.data;
        return util(root.left, k);
    }
}
