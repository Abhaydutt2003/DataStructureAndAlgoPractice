/**
 * @param {number} n
 * @param {number[]} left
 * @param {number[]} right
 * @return {number}
 */
var getLastMoment = function(n, left, right) {
    let ans = Number.MIN_SAFE_INTEGER;
    for(let i of left){
        ans = Math.max(ans,i);
    }
    for(let i of right){
        ans = Math.max(ans,(n-i));
    }
    return ans;
};

//dumb af


