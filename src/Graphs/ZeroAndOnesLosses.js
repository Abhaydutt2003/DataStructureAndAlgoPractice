/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
var findWinners = function (matches) {
  let max = 1 << 31;
  for (let match of matches) {
    max = Math.max(max, Math.max(match[0], match[1]));
  }
  //-1 will indicate that the person never played a match
  let indegree = new Array(max + 1).fill(-1);
  //calculate the indegree of the nodes
  for (let match of matches) {
    let winner = match[0];
    let loser = match[1];
    indegree[winner] += indegree[winner] == -1 ? 1 : 0;
    indegree[loser] += indegree[loser] == -1 ? 2 : 1;
  }
  let ans = [[], []];
  for (let i = 0; i < indegree.length; i++) {
    if (indegree[i] == 0) {
      ans[0].push(i);
    } else if (indegree[i] == 1) {
      ans[1].push(i);
    }
  }
  return ans;
};

let matches = [
  [2, 3],
  [1, 3],
  [5, 4],
  [6, 4],
];
console.log(findWinners(matches));

//based on graph
//return nodes that have 0 indegree and 1 indegree


