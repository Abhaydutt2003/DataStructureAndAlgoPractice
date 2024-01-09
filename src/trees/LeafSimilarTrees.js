
function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
    let seq1 = getSeq(root1,"");
    let seq2 = getSeq(root2,"");
    console.log(seq1,seq2);
    return seq1 == seq2;   
};

/**
 * 
 * @param {TreeNode} root 
 * @param {string} currSeq
 */
let getSeq = (root,currSeq)=>{
    //check if the current node is null
    if(root == null){
        return currSeq;
    }
    //check if the node is a leaf node
    if(root.left == null && root.right == null){
        return currSeq+"-"+root.val;
    }
    //current node is not a leaf node, get the result from the subTrees
    let leftSeq = getSeq(root.left,currSeq);
    let rightSeq = getSeq(root.right,leftSeq);
    return rightSeq;
}