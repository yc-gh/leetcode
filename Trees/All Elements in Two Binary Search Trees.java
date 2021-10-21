//https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

//Using sorting OR merging sorted lists

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list1);
        Collections.sort(list1);
        return list1;
        // List<Integer> list3 = mergeLists(list1, list2);
        // return list3;
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    
    private List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        int i=0, j=0, k=0;
        List<Integer> resList = new ArrayList<>();
        int size1 = list1.size();
        int size2 = list2.size();
        
        while(i < size1 && j < size2) {
            int num1 = list1.get(i), num2 = list2.get(j);
            if(num1 < num2) {
                resList.add(num1);
                i++;
            }
            else {
                resList.add(num2);
                j++;
            }
        }
        
        while(i < size1) {
            resList.add(list1.get(i));
            i++;
        }
        while(j < size2) {
            resList.add(list2.get(j));
            j++;
        }
        
        return resList;
    }
}
