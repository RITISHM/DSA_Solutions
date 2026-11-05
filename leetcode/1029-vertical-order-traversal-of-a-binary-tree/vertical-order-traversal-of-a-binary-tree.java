import java.util.*;

class Solution {
    class Point implements Comparable<Point> {
        int row, col, val;
        
        Point(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Point b) {
            // Sort by col, then row, then value
            if (this.col != b.col) return Integer.compare(this.col, b.col);
            if (this.row != b.row) return Integer.compare(this.row, b.row);
            return Integer.compare(this.val, b.val);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> list = new ArrayList<>();
        dfs(root, 0, 0, list);
        Collections.sort(list); // Apply custom sort order
        
        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> currList = null;

        // Group sorted points by column
        for (Point point : list) {
            if (point.col != prevCol) {
                prevCol = point.col;
                currList = new ArrayList<>();
                res.add(currList);
            }
            currList.add(point.val);
        }

        return res;
    }

    private void dfs(TreeNode root, int row, int col, List<Point> list) {
        if (root == null) return;
        list.add(new Point(root.val, row, col));
        dfs(root.left, row + 1, col - 1, list);
        dfs(root.right, row + 1, col + 1, list);
    }
}