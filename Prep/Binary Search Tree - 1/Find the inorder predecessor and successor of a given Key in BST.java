//https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       if(root == null) return;
       if(root.data < key) {
           if(p.pre == null) p.pre = root;
           else {
               if(root.data > p.pre.data) p.pre = root;
           }
       }
       else if(root.data > key) {
           if(s.succ == null) s.succ = root;
           else {
               if(root.data < s.succ.data) s.succ = root;
           }
       }
       findPreSuc(root.left, p, s, key);
       findPreSuc(root.right, p, s, key);
    }
}
