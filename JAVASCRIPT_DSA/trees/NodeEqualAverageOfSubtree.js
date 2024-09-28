function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}
/**
 * @param {TreeNode} root
 * @return {number}
 */
var averageOfSubtree = function (root) {
  util1(root);
  return ans;
};

let ans = 0;

/**
 *
 * @param {TreeNode} root
 * @returns {number[]}
 */
let util1 = (root) => {
  //initilize all the values required
  let leftSum = 0,
    rightSum = 0;
  let leftNodes = 0,
    rightNodes = 0;
  //now call to get the values
  if (root.left != null) {
    let arr = util1(root.left);
    leftSum = arr[0];
    leftNodes = arr[1];
  }
  if (root.right != null) {
    let arr = util1(root.right);
    rightSum = arr[0];
    rightNodes = arr[1];
  }
  //calculate the avg
  let currentNodes = leftNodes + rightNodes + 1;
  let currentSum = leftSum + rightSum + root.val;
  let currentAvg = ((currentSum / currentNodes) | 0);
  //check is valid avg or not
  if (currentAvg == root.val) {
    ans++;
  }
  //send to recursion
  return [currentSum, currentNodes];
};

//console.log(Math.floor(2.5));
