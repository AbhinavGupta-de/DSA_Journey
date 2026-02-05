#define int long
class Node {
public:
 TreeNode* root;
 int sum;
 int numberOfNodes;

  Node(TreeNode* root, int sum, int numberOfNodes){
  this->root = root;
  this->sum = sum;
  this->numberOfNodes = numberOfNodes;
 }
};

Node* findLCA(TreeNode* root){
  if(root == NULL) return new Node(root, 0, 0);

  Node* left = findLCA(root->left);
  Node* right = findLCA(root->right);

  int contribution = ((left->numberOfNodes * right->numberOfNodes) + left->numberOfNodes + right->numberOfNodes) * root->val + left->sum + right->sum;

  return new Node(root, contribution, left->numberOfNodes + right->numberOfNodes + 1); 
}

#undef int
long Solution::lcaPairs(TreeNode* A) {
    return findLCA(A)->sum;
}
