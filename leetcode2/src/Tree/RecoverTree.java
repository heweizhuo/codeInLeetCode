package Tree;

public class RecoverTree {
    public void recoverTree(TreeNode root) {
        TreeNode cur=root;
        while (cur!=null){
            if(cur.left==null){
                cur=cur.right;
            }
            else {
                TreeNode prev=cur.left;
                while (prev.val<cur.val && (prev.right!=null || prev.right!=cur)){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur=cur.left;
                }
                else {
                    prev.right=null;
                    cur=cur.right;
                }
            }
        }
    }
}
