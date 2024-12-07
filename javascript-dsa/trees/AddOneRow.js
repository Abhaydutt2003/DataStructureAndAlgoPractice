function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}
/**
 * @param {TreeNode} root
 * @param {number} val
 * @param {number} depth
 * @return {TreeNode}
 */
var addOneRow = (root, val, depth) => {
  return updateTree(root, val, depth, 0, "LEFT");
};

let updateTree = (root, val, depth, currentDepth, direction) => {
  if (currentDepth + 1 == depth) {
    if (direction == "LEFT") {
      let newNode = new TreeNode(val, root);
      return newNode;
    } else {
      let newNode = new TreeNode(val, undefined, root);
      return newNode;
    }
  } else if (root == null) {
    return root;
  }
  root.left = updateTree(root.left, val, depth, currentDepth + 1, "LEFT");
  root.left = updateTree(root.right, val, depth, currentDepth + 1, "RIGHT");
  return root;
};
