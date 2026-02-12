class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // Case 1: dono null hain
        if (p == null && q == null) {
            return true;
        }
        
        // Case 2: ek null hai aur dusra nahi
        if (p == null || q == null) {
            return false;
        }
        
        // Case 3: value match nahi kar rahi
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively left aur right subtree check karo
        return isSameTree(p.left, q.left) 
            && isSameTree(p.right, q.right);
    }
}
