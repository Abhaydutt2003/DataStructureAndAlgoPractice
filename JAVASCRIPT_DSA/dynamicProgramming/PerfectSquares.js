/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function (n) {
  let memo = new Map();
  return getAns(n, memo);
};

/**
 *
 * @param {number} n
 * @param {Map} memo
 */
let getAns = (n, memo) => {
  if (n == 0) {
    return 0;
  }
  if (memo.has(n)) return memo.get(n);
  let ans = n;
  for (let i = 1; i * i <= n; i++) {
    let smallAns = getAns(n - i * i, memo) + 1;
    ans = Math.min(smallAns, ans);
  }
  memo.set(n, ans);
  return ans;
};

let MAX_VALUE = (1 << 31) * -1 - 1;
/**
 *
 * @param {number} n
 * @return {number}
 */
let getAns2 = (n) => {
  let dp = new Array(n + 1).fill(MAX_VALUE);
  dp[0] = 0;
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j * j <= i; j++) {
      dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    }
  }
  return dp[n];
};

let n = 1989;
console.log(getAns2(n));
