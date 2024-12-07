/**
 * @param {number[][]} matrix
 * @return {number}
 */
var countSquares = function (matrix) {
  let dp = new Array(matrix.length).fill().map(() => {
    return new Array(matrix[0].length).fill(0);
  });
  let ans = 0;
  for (let i = 0; i < dp.length; i++) {
    for (let j = 0; j < dp[0].length; j++) {
      if (matrix[i][j] == 0) {
        //do not do anything
      } else if (i == 0 || j == 0) {
        dp[i][j] = 1;
        ans += dp[i][j];
      } else {
        let side = Math.min(
          dp[i - 1][j],
          Math.min(dp[i - 1][j - 1], dp[i][j - 1])
        );
        dp[i][j] = side + 1;
        ans += dp[i][j];
      }
    }
  }
  return ans;
};

let matrix = [
  [0, 1, 1, 1],
  [1, 1, 1, 1],
  [0, 1, 1, 1],
];
console.log(countSquares(matrix));
