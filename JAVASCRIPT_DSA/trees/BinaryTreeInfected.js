function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

/**
 *
 * @param {TreeNode} root
 * @param {number} start
 * @returns {number}
 */
let amountOfTime = (root, start) => {
  let maxTime = 1 << 31;
  /**
   *
   * @param {TreeNode} root
   */
  let getMaxTime = (root) => {
    if (root == null) {
      return 0;
    }
    let leftDepth = getMaxTime(root.left);
    let rightDepth = getMaxTime(root.right);
    if (root.val == start) {
      maxTime = Math.max(leftDepth, rightDepth, maxTime);
      return -1;
    } else if (leftDepth >= 0 && rightDepth >= 0) {
      return Math.max(leftDepth, rightDepth) + 1;
    } else {
      let currentTime = Math.abs(rightDepth) + Math.abs(leftDepth);
      maxTime = Math.max(maxTime, currentTime);
      return Math.min(leftDepth, rightDepth) - 1;
    }
  };
  getMaxTime(root);
  return maxTime;
};

//can convert to graph and then simply to bfs(big time waste)
//convert to one pass algo using dfs

//while coming up , if getting a negative value, we encountered the target node
