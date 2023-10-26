//thing to note that the array consists of values greater than 2

/**
 * @param {number[]} arr
 * @return {number}
 */
var numFactoredBinaryTrees = function (arr) {
    arr.sort((a, b) => a - b);
    dp = [];
    map = new Map();
    for (let i = 0; i < arr.length; i++) {
        map.set(arr[i], i);
        dp[i] = -1;
    }
    let ans = 0;
    //now start keeping every node as the root
    for (let i = 0; i < arr.length; i++) {
        ans = (ans + util1(arr, i)) % mod;
    }
    return ans;
};
let mod = 1000000007;
let map;
let dp;

/**
 * 
 * @param {number[]} arr 
 * @param {number} index 
 * @returns 
 */
let util1 = (arr, index) => {
    if (dp[index] != -1) {
        return dp[index];
    }
    let ans = 1;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > Math.sqrt(arr[index])) break;
        if (arr[index] % arr[i] == 0 && map.has(arr[index] / arr[i])) {
            let leftAns = util1(arr, i);
            let rightAns = util1(arr, map.get(arr[index] / arr[i]));
            let res = (leftAns * rightAns) % mod;
            res = (res * ((arr[i] == arr[index] / arr[i]) ? 1 : 2)) % mod;
            ans = (ans + res) % mod;
        }
    }
    dp[index] = ans;
    return ans;
}
//index indicates the current node in tree


let arr = [2, 4, 5, 10];
console.log(numFactoredBinaryTrees(arr));