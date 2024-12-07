function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}
/**
 * @param {TreeNode} root
 */
var BSTIterator = function (root) {
  this.gen = getGen(root);
  this.nextVal = this.gen.next().value;
};

/**
 * @return {number}
 */
BSTIterator.prototype.next = function () {
  const ans = this.nextVal;
  this.nextVal = this.gen.next().value;
  return ans;
};

/**
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function () {
  return this.nextVal !== null;
};
/**
 *
 * @param {TreeNode} root
 */
function* getGen(root) {
  if (root) {
    if (root.left) {
      yield* getGen(root.left);
    }
    yield root.val;
    if (root.right) {
      yield* getGen(root.right);
    }
  }
  return null;
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */
