class NumArray {
    SegmentTreeNode root;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public int sumRange(int i, int j) {
        return query(root, i, j);
    }
    
    private int query(SegmentTreeNode root, int start, int end) {
        int mid = root.start + (root.end - root.start) / 2;
        if (start <= root.start && end >= root.end) {
            return root.sum;
        } else if (start > mid) {
            return query(root.right, start, end);
        } else if (end <= mid) {
            return query(root.left, start, end);
        } else if (start<= mid && end > mid) {
            return query(root.left, start, mid) + query(root.right, mid+1, end);
        }
        return 0;
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start == end) return new SegmentTreeNode(start, end, nums[start]);
        int mid = start + (end - start) / 2;
        SegmentTreeNode leftNode = buildTree(nums, start, mid);
        SegmentTreeNode rightNode = buildTree(nums, mid + 1, end);
        SegmentTreeNode node = new SegmentTreeNode(start, end, leftNode.sum + rightNode.sum);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }
    
    
    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int s, int e, int val) {
            start = s;
            end = e;
            sum = val;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */