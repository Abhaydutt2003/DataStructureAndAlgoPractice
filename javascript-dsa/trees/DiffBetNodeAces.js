function TreeNode(val, left, right) {
  this.val = val === undefined ? 0 : val;
  this.left = left === undefined ? null : left;
  this.right = right === undefined ? null : right;
}

// /**
//  *
//  * @param {TreeNode} root
//  * @returns {number}
//  */

// let maxAncestorDiff = (root)=>{
//   //intially set the value of maxDiff as MIN_VALUE
//   maxDiff = MIN_VALUE;
//   //call the func to calc the maxDiff
//   maxDiffHelper(root);
//   return maxDiff;
// }

// let maxDiff;

// /**
//  * calc the min node as well as the maxDiff
//  * @param {TreeNode} root
//  */
// let maxDiffHelper = (root)=>{
//   if(root == null){
//     //reached the end , return the MAX_VALUE as the min node
//     return MAX_VALUE;
//   }

//   let leftMinNode = maxDiffHelper(root.left);
//   if(leftMinNode!= MAX_VALUE){
//     //the left subTree was not null
//     maxDiff = Math.max(maxDiff,Math.abs(leftMinNode-root.val));
//   }
//   let rightMinNode = maxDiffHelper(root.right);
//   if(rightMinNode!=MAX_VALUE){
//     //the right subTree was not null
//     maxDiff = Math.max(maxDiff,Math.abs(rightMinNode-root.val));
//   }
//   //return the minNode
//   return Math.min(root.val,Math.min(leftMinNode,rightMinNode));
// }

//firstly traverse all the way down
//while coming up keep a track of the smallest node in the subtree
//calc the answer considering yourself too

//well the approach failed

//try 2

//this time while coming up we will make sure to have both the max as well as
//the min node , then we will calc the result

let MAX_VALUE = (1 << 31) * -1 - 1;
let MIN_VALUE = 1 << 31;

/**
 * @param {TreeNode} root
 */
let maxAncestorDiff = (root) => {
  maxDiff = MIN_VALUE;
  maxDiffHelper(root);
  return maxDiff;
};

let maxDiff;

/**
 *
 * @param {TreeNode} root
 */
let maxDiffHelper = (root) => {
  if (root == null) {
    return null;
  }
  let obj1 = maxDiffHelper(root.left);
  let obj2 = maxDiffHelper(root.right);
  if (obj1) {
    maxDiff = Math.max(
      maxDiff,
      Math.max(Math.abs(obj1[0] - root.val), Math.abs(obj1[1] - root.val))
    );
  }
  if (obj2) {
    maxDiff = Math.max(
      maxDiff,
      Math.max(Math.abs(obj2[0] - root.val), Math.abs(obj2[1] - root.val))
    );
  }
  let newObj;
  if (obj1 && obj2) {
    newObj = [
      Math.min(root.val, Math.min(obj1[0], obj2[0])),
      Math.max(root.val, Math.max(obj1[1], obj2[1])),
    ];
  } else if (obj1) {
    newObj = [Math.min(root.val, obj1[0]), Math.max(root.val, obj1[1])];
  } else if (obj2) {
    newObj = [Math.min(root.val, obj2[0]), Math.max(root.val, obj2[1])];
  } else {
    newObj = [root.val, root.val];
  }
  return newObj;
};
