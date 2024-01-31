let mod = 1000000007;
let dirs = [
  [0, 1],
  [1, 0],
  [-1, 0],
  [0, -1],
];
/**
 * @param {number} m
 * @param {number} n
 * @param {number} maxMove
 * @param {number} startRow
 * @param {number} startColumn
 * @return {number}
 */
var findPaths = function (m, n, maxMove, startRow, startColumn) {
  let q = [],
    ans = 0;
  q.push([maxMove, startRow, startColumn]); //push the initial position
  //iterate till the queue is not empty
  while (q.length > 0) {
    let current = q.shift();
    let leftMoves = current[0];
    let currentX = current[1];
    let currentY = current[2];
    if (leftMoves == 0) continue;
    //iterate in all the directions
    for (let dir of dirs) {
      let x = currentX + dir[0];
      let y = currentY + dir[1];
      //check if out of bounds
      if (x < 0 || x >= m || y < 0 || y >= n) {
        ans = (ans + 1) % mod;
        continue;
      }
      //push to further explore
      q.push([leftMoves - 1, x, y]);
    }
  }
  return ans;
};
//the above code will give tle, use dfs and dp

/**
 * @param {number} m
 * @param {number} n
 * @param {number} maxMove
 * @param {number} startRow
 * @param {number} startColumn
 * @return {number}
 */
let findPaths2 = (m, n, maxMove, startRow, startColumn) => {
  let memo = new Map();
  return dfsMemo(m, n, maxMove, startRow, startColumn, memo);
};

/**
 *
 * @param {number} m
 * @param {number} n
 * @param {number} MovesLeft
 * @param {number} i
 * @param {number} j
 * @param {Map} memo
 */
let dfsMemo = (m, n, MovesLeft, i, j, memo) => {
  if (i < 0 || j < 0 || i >= m || j >= n) {
    //reached out the matrix , return 1
    return 1;
  } else if (MovesLeft <= 0) {
    //moves finished
    return 0;
  }
  //check the memo
  let key = MovesLeft + " " + i + " " + j;
  if (memo.has(key)) {
    return memo.get(key);
  }
  let ans = 0;
  //iterate all the directions
  for (let dir of dirs) {
    let x = i + dir[0];
    let y = j + dir[1];
    ans = (ans+ dfsMemo(m, n, MovesLeft - 1, x, y, memo))%mod;
  }
  memo.set(key, ans);
  return ans;
};

let m = 1,
  n = 3,
  maxMove = 3,
  startRow = 0,
  startColumn = 1;
console.log(findPaths2(m, n, maxMove, startRow, startColumn));

//need to know the paths which we reach out of the matrix
