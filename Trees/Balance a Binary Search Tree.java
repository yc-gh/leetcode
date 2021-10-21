//https://leetcode.com/problems/balance-a-binary-search-tree/

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> treeList = new ArrayList<>();
        inorder(root, treeList);
        return balancedFromInorder(treeList, 0, treeList.size()-1);
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    private TreeNode balancedFromInorder(List<Integer> list, int l, int r) {
        if(l <= r) {
            int mid = (l+r)>>>1;
            TreeNode curr = new TreeNode(list.get(mid));
            curr.left = balancedFromInorder(list, l, mid-1);
            curr.right = balancedFromInorder(list, mid+1, r);
            return curr;
        }
        return null;
    }
}
