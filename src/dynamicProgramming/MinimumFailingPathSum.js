let MAX_VALUE = (1 << 31) * -1 - 1;

/**
 * @param {number[][]} matrix
 * @return {number}
 */
var minFallingPathSum = function (matrix) {
  //create the dp array
  let dp = new Array(matrix.length).fill().map(() => {
    return new Array(matrix[0].length).fill(0);
  });
  let ans = MAX_VALUE;
  //now start filling the dp array
  for (let i = 0; i < dp.length; i++) {
    for (let j = 0; j < dp[0].length; j++) {
      //base case
      if (i == 0) {
        dp[i][j] = matrix[i][j];
      } else {
        let candidate1 = MAX_VALUE,
          candidate2 = MAX_VALUE,
          candidate3 = MAX_VALUE;
        //check if the indexes are not out of bounds
        candidate2 = dp[i - 1][j] + matrix[i][j];
        if (j - 1 >= 0) {
          candidate1 = dp[i - 1][j - 1] + matrix[i][j];
        }
        if (j + 1 < matrix[0].length) {
          candidate3 = dp[i - 1][j + 1] + matrix[i][j];
        }
        dp[i][j] = Math.min(candidate1, candidate2, candidate3);
      }
      if (i == matrix.length - 1) {
        ans = Math.min(ans, dp[i][j]);
      }
    }
  }
  return ans;
};

let matrix = [[-19,57],[-40,-5]]
console.log(minFallingPathSum(matrix));

//very similar to that robot dp problem
