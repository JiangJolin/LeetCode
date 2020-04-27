/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         TreeNode cur = root;
//         Stack<TreeNode> path = new Stack<>();
//         while(k > 0){
//             while(cur.left != null){
//                 path.push(cur);
//                 cur = cur.left;
//             }
//             k --;
//             if(k == 0) return cur.val;
//             if(cur.right != null){
//                 cur = cur.right;
//             }else{
//                 cur = path.pop();
//                 cur.left = null;
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    private static int k_small;
    private TreeNode ans;
    private void preorder(TreeNode node){
        if(node.left != null) preorder(node.left);
        if(k_small == 0) return;
        k_small -= 1;
        if(k_small > 0 && node.right != null){
            preorder(node.right);
        }else{
            ans = node;
            return;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        k_small = k;
        preorder(root);
        return ans.val;
    }
}