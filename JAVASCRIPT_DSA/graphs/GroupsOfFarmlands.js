let DIR = [
  [0, 1],
  [0, -1],
  [1, 0],
  [-1, 0],
];

/**
 * @param {number[][]} land
 * @return {number[][]}
 */
var findFarmland = function (land) {
  let visited = new Array(land.length).fill().map(() => {
    return new Array(land[0].length).fill(false);
  });
  //traverse the entire array
  let ans = [];
  for (let i = 0; i < land.length; i++) {
    for (let j = 0; j < land[i].length; j++) {
      if (land[i][j] == 1 && visited[i][j] == false) {
        coordinates = [i, j, i, j];
        dfs(land, visited, i, j);
        ans.push([...coordinates]);
      }
    }
  }
  return ans;
};

let coordinates;

/**
 *
 * @param {number[][]} land
 * @param {number[][]} visited
 * @param {number} i
 * @param {number} j
 */
let dfs = (land, visited, i, j) => {
  visited[i][j] = true;
  //update the coordinates if necessary
  coordinates[0] = Math.min(i, coordinates[0]);
  coordinates[1] = Math.min(j, coordinates[1]);
  coordinates[2] = Math.max(i, coordinates[2]);
  coordinates[3] = Math.max(j, coordinates[3]);
  for (let dir of DIR) {
    let x = i + dir[0];
    let y = j + dir[1];
    if (
      x >= 0 &&
      y >= 0 &&
      x < land.length &&
      y < land[0].length &&
      visited[x][y] == false &&
      land[x][y] == "1"
    ) {
      dfs(land, visited, x, y);
    }
  }
};

let land = [
  [1, 0, 0],
  [0, 1, 1],
  [0, 1, 1],
];
//let land = [[1,1],[1,1]];
console.log(findFarmland(land));
