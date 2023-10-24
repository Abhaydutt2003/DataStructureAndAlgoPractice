/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */


function TreeNode(val, left, right) {
    this.val = (val === undefined ? 0 : val)
    this.left = (left === undefined ? null : left)
    this.right = (right === undefined ? null : right)
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function (root) {
    let queue = [];
    queue.push(current);
    queue.push(null);
    let currMax = Number.MIN_SAFE_INTEGER;
    let ans = [];
    while (queue.length != 0) {
        let current = queue.shift();
        if (current == null) {
            ans.push(currMax);
            currMax = Number.MIN_SAFE_INTEGER;
            if (queue.length == 0) {
                break;
            }
            queue.push(null);
        } else {
            if (current.left != null) {
                queue.push(current.left);
            }
            if (current.right != null) {
                queue.push(current.right);
            }
            currMax = Math.max(currMax, current.val);
        }
    }
};

//typical level order traversal problem