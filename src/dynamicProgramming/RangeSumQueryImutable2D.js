/**
 * @param {number[][]} matrix
 */
var NumMatrix = function (matrix) {
  let mat = new Array(matrix.length + 1).fill().map(() => {
    return new Array(matrix[0].length + 1).fill(0);
  });
  for (let i = 1; i <= matrix.length; i++) {
    for (let j = 1; j <= matrix[0].length; j++) {
      mat[i][j] =
        matrix[i - 1][j - 1] +
        (mat[i][j - 1] + mat[i - 1][j] - mat[i - 1][j - 1]);
    }
  }
  NumMatrix.prototype.mat = mat;
};

/**
 * @param {number} row1
 * @param {number} col1
 * @param {number} row2
 * @param {number} col2
 * @return {number}
 */
NumMatrix.prototype.sumRegion = function (row1, col1, row2, col2) {
  let mat = NumMatrix.prototype.mat;
  return (
    mat[row2 + 1][col2 + 1] -
    (mat[row2 + 1][col1] - mat[row1][col1] + mat[row1][col2 + 1])
  );
};

let matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5],
];
NumMatrix(matrix);
console.log(NumMatrix.prototype.sumRegion(1, 2, 2, 4));

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = new NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */

//   +---------------+   +---------+----+   +---+-----------+   +---------+----+   +---+----------+
//   |               |   |         |    |   |   |           |   |         |    |   |   |          |
//   |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
//   |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
//   |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
//   |   |      |    |   |         |    |   |   |           |   |              |   |              |
//   |   +------+    |   +---------+    |   +---+           |   |              |   |              |
//   |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
//   +---------------+   +--------------+   +---------------+   +--------------+   +--------------+
