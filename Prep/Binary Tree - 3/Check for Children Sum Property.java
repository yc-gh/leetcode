//https://practice.geeksforgeeks.org/problems/children-sum-parent/1/

public static int isSumProperty(Node root)
{
    if(root == null) return 1;
    if(root.left == null && root.right == null) return 1;

    int left = isSumProperty(root.left);
    if(left != 1) return 0;

    int right = isSumProperty(root.right);
    if(right != 1) return 0;

    return (root.data == (root.left != null ? root.left.data : 0) + (root.right != null ? root.right.data : 0)) ? 1 : 0;
}
