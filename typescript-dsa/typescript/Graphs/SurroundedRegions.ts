/**
 Do not return anything, modify board in-place instead.
 */
function solve(board: string[][]): void {
  let m = board.length;
  let n = board[0].length;
  let DIR = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
  ]; //to traverse .

  //construct the 2-d visited array.
  let visited = new Array(m).fill("").map(() => {
    return new Array(n).fill(false);
  });

  //the DFS function
  const DFS = (i: number, j: number): boolean => {
    visited[i][j] = true;
    //check if not boundry
    if (i === m - 1 || j === n - 1) {
      return false;
    } else {
      let flag = true;
      for (let [x, y] of DIR) {
        if (visited[i + x][j + y] === false) {
          flag = DFS(i + x, j + y);
        }
      }
      board[i][j] = flag ? "O" : "X";
      return flag;
    }
  };

  //traverse the board.
  for (let i = 0; i < m; i < board.length) {
    for (let j = 0; j < n; j++) {
      if (!visited[i][j]) {
        //only process further if not visited.
        DFS(i, j);
      }
      visited[i][j] = true;
    }
  }
}

let board: string[][] = [
  ["X", "X", "X", "X"],
  ["X", "O", "O", "X"],
  ["X", "X", "O", "X"],
  ["X", "O", "X", "X"],
];

solve(board);
console.log(board);