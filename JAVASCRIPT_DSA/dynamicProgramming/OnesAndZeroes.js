/**
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var findMaxForm = function (strs, m, n) {
  //make a 3-d dp
  let dp = new Array(strs.length).fill().map(() => {
    return new Array(m + 1).fill().map(() => {
      return new Array(n + 1).fill(-1);
    });
  });
  //now call the dp function
  return getAns(strs, m, n, 0, dp);
};
/**
 *
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @param {number} index
 * @param {number[][][]} dp
 */
let getAns = (strs, m, n, index, dp) => {
  //base case
  if (index >= strs.length) {
    return 0;
  }
  //check cache
  if (dp[index][m][n] != -1) {
    return dp[index][m][n];
  }
  //calculate ones and zeros
  let ones = strs[index].split("1").length - 1;
  let zeros = strs[index].length - ones;
  let ans;
  if (m >= zeros && n >= ones) {
    let ans1 = getAns(strs, m - zeros, n - ones, index + 1, dp) + 1;
    let ans2 = getAns(strs, m, n, index + 1, dp);
    ans = Math.max(ans1, ans2);
  } else {
    ans = getAns(strs, m, n, index + 1, dp);
  }
  return (dp[index][m][n] = ans);
};


//tabulation approach is useless









//above is giving errors

let strs = ["10", "0001", "111001", "1", "0"],
  m = 5,
  n = 3;
console.log(findMaxForm(strs, m, n));

/**
 * at most m 0's and n 1's,
 * 1-d dp?
 * will be given an array of strings
 *
 * hell not a 1-d dp question
 * either i choose a stirng or not (very knapsack, there are 2 limits here)
 * there will be a 3-d dp
 */
