<<<<<<< HEAD
vlass Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode*p, TreeNode* q) {
        if (root == NULL || root == p || root == q) return root;
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p ,q);
        return !left? right : !right? left : root;
    }
}
=======
vlass Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode*p, TreeNode* q) {
        if (root == NULL || root == p || root == q) return root;
        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p ,q);
        return !left? right : !right? left : root;
    }
}
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
