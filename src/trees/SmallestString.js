/**
 * @param {TreeNode} root
 * @return {string}
 */
let smallestFromLeaf = (root) => {
  ans = "";
  updateAns(root, "");
};

let ans = "";

let updateAns = (root, tillNow) => {
  if (root.left == null && root.right == null) {
    //lead node
    if (tillNow.length < ans || tillNow < ans || ans == "") {
      ans = tillNow;
    }
    return;
  }else if (root == null) {
    return;
  }
  console.log(String.fromCharCode(97 + root.val) + tillNow);
  updateAns(root.left, String.fromCharCode(97 + root.val) + tillNow);
  updateAns(root.right, String.fromCharCode(97 + root.val) + tillNow);
};
