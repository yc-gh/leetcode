//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class Codec {
    
    private static final String splitter = ",";
    private static final String NN = "X";

    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null) sb.append(NN).append(splitter);
        else {
            sb.append(root.val).append(splitter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private TreeNode buildTree(String[] arr, int[] index) {
        index[0]++;
        String curr = arr[index[0]];
        if(curr.equals(NN)) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.valueOf(arr[index[0]]));
            node.left = buildTree(arr, index);
            node.right = buildTree(arr, index);
            return node;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(splitter);
        return buildTree(arr, new int[]{-1});
    }
}
