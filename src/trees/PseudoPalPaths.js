function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var pseudoPalindromicPaths = function (root) {
  //base case
  if (root == null) {
    return null;
  }
  ans = 0;
  getAns(root, new Set());
  return ans;
};

let ans = 0;

/**
 *
 * @param {TreeNode} root
 * @param {Set} set
 */
let getAns = (root, set) => {
  if (root == null) {
    //base case
    return;
  }
  let put = false; //this variable will tell if we added the variable or removed it from the set
  if (set.has(root.val)) {
    set.delete(root.val);
  } else {
    set.add(root.val);
    put = true;
  }
  if (root.left == null && root.right == null) {
    //reached a leaf node, check the set to know is the path was palindrome or not
    if (set.size == 0 || set.size == 1) {
      ans++;
    }
  } else {
    //traverse in both the directions
    getAns(root.left, set);
    getAns(root.right, set);
  }
  //backtrack, make the set state as it was before
  if (put) {
    set.delete(root.val);
  } else {
    set.add(root.val);
  }
};

//traverse from the root to the leaf nodes
//while traversing , make sure to send a set
//in the set , make sure that every freq is even number of times
//only one element shall be allowed in the set, consider the case for more claritry---> (1 1 2 2 2 1 1)
