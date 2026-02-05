class TreeNode {

 int val;
 TreeNode* left;
 TreeNode* right;
 TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


bool isValidBST(TreeNode* root) {
 return isValid(root, LONG_MIN, LONG_MAX);
}

bool isValid(TreeNode* root, long min, long max) {
 if (root == NULL) return true;
 if ((long) root->val <= min || (long) root->val >= max) return false;
 return isValid(root->left, min, root->val) && isValid(root->right, root->val, max);
}

int main() {
 
 return 0;
}