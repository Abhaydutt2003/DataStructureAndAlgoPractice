let mod = Math.pow(10, 9) + 7;
/**
 * @param {number} n
 * @param {number} k
 * @param {number} target
 * @return {number}
 */
var numRollsToTarget = function (n, k, target) {
  let dp = new Array(n + 1).fill().map(() => {
    return new Array(target + 1).fill(-1);
  });
  return memoFunc(n, k, target, dp);
};

/**
 * @param {number} n
 * @param {number} k
 * @param {number} target
 * @param {number[][]} dp
 * @return {number}
 */
let memoFunc = (n, k, target, dp) => {
  //base case
  if (n == 0 && target == 0) {
    //reached the goal
    return 1;
  } else if (n == 0 || target <= 0) {
    //either the dices finished or the target was achived earlier
    return 0;
  } else if (dp[n][target] != -1) {
    return dp[n][target];
  }
  //traverse for all the faces
  let ans = 0;
  for (let i = 1; i <= k; i++) {
    ans = (ans + memoFunc(n - 1, k, target - i, dp)) % mod;
  }
  return (dp[n][target] = ans);
};
let n = 30,
  k = 30,
  target = 500;
console.log(numRollsToTarget(n, k, target));
