/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} target
 * @return {TreeNode}
 */
var removeLeafNodes = function (root, target) {
  return deleteLeaves(root, target);
};

let deleteLeaves = (root, target) => {
  if (root == null) {
    return null;
  }
  root.left = deleteLeaves(root.left, target);
  root.right = deleteLeaves(root.right, target);
  if (root.val == target && root.left == null && root.right == null) {
    //a leaf node and a target node
    return null;
  } else {
    return root;
  }
};
