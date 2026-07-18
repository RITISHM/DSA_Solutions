class Solution {
    private int maxDepth = -1;
    private int answer = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return answer;
    }
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            answer = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}