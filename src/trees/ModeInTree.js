/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var findMode = function (root) {
  map = new Map();
  util1(root);
  let ans = new Set();
  let max = Number.MIN_SAFE_INTEGER;
  for ([key, value] of map) {
    if (value > max) {
      ans = new Set();
      ans.add(key);
      max = value;
    } else if (value == max) {
      ans.add(key);
    }
  }
  return [...ans];
};

let util1 = (root) => {
  if (root == null) {
    return;
  }
  util1(root.left);
  util1(root.right);
  map.set(root.val, (map.get(root.val) || 0) + 1);
};

let map;
