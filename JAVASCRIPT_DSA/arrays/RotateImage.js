/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function (matrix) {
  //transpose the matrix
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < i; j++) {
      [matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
    }
  }
  //reverse each row
  for (let arr of matrix) {
    reverseArray(arr, 0, matrix[0].length - 1);
  }
};

/**
 * reverses a array with refrence to start and end index
 * @param {number[]} arr
 * @param {number} arr
 * @param {number} arr
 */
let reverseArray = (arr, i, j) => {
  if (i >= j) return;
  [arr[i], arr[j]] = [arr[j], arr[i]];
  reverseArray(arr, i + 1, j - 1);
};

//VERY EASY
const matrix = [
  [5, 1, 9, 11],
  [2, 4, 8, 10],
  [13, 3, 6, 7],
  [15, 14, 12, 16],
];
rotate(matrix);
console.log(matrix);



//the transpose of a matrix is when you swap the row with the columns and vice versa

