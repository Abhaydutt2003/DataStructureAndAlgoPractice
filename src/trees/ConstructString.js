function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

/**
 * @param {TreeNode} root
 * @return {string}
 */
var tree2str = function (root) {
  ans = new String();
  util(root);
  return ans;
};

let ans;
/**
 *
 * @param {TreeNode} root
 *
 */
let util = (root) => {
  if (root == null) {
    return;
  }
  ans += "" + root.val;
  //no children
  if (root.left == null && root.right == null) {
    return;
  }
  ans += "(";
  util(root.left);
  ans += ")";
  //there is a right child?
  if (root.right != null) {
    ans += "(";
    util(root.right);
    ans += ")";
  }
};
