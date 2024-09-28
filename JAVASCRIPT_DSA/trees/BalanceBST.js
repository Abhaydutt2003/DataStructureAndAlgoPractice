function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var balanceBST = function (root) {
  inroder = [];
  //get the sorted array in the inorder array
  inorderTraversal(root);
  //now use it to make a balanced bst
  return getAns(0, inroder.length - 1);
};

let inroder;

/**
 *
 * @param {TreeNode} root
 */
let inorderTraversal = (root) => {
  if (root == null) return;
  inorderTraversal(root.left);
  inroder.push(root.val);
  inorderTraversal(root.right);
};

/**
 *
 * @param {number} start
 * @param {number} end
 */
let getAns = (start, end) => {
  if (start > end) return null;
  let mid = start + (((end - start) / 2) | 0);
  let root = new TreeNode(inroder[mid]);
  root.left = getAns(start, mid - 1);
  root.right = getAns(mid + 1, end);
  return root;
};

//thought of a very bad way , the inorder of a bst is always a sorted array
//can use that to make a balanced bst

// 1 2 3 4 5    (0 + (4-0))/2
