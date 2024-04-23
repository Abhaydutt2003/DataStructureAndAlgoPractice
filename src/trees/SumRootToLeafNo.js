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
 * @return {number}
 */
var sumNumbers = function (root) {
  ans = 0;
  tillNow = 0;
  updateAns(root);
  return ans;
};

let ans;
let tillNow;

/**
 * updates the answer
 * @param {TreeNode} root
 */
let updateAns = (root) => {
  if (root == null) {
    return;
  } else if (root.left == null && root.right == null) {
    tillNow *= 10;
    tillNow += root.val;
    ans += tillNow;
    tillNow = (tillNow / 10) | 0;
    return;
  }
  tillNow *= 10;
  tillNow += root.val;
  updateAns(root.left);
  updateAns(root.right);
  tillNow = (tillNow / 10) | 0;
};
