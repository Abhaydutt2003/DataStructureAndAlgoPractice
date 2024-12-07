/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function (n, edges) {
  if (n == 1) return [0];
  let adjList = new Array(n).fill().map(() => {
    return [];
  });
  let indegree = new Array(n).fill(0);
  edges.forEach(([node1, node2]) => {
    adjList[node1].push(node2);
    adjList[node2].push(node1);
    indegree[node1]++;
    indegree[node2]++;
  });
  let q = [];
  indegree.forEach((i, index) => {
    if (i == 1) {
      q.push(index);
    }
  });
  //the last node to go in the queue will be the nodes which are the roots
  let leftNodes = n;
  while (q.length >= 1) {
    let qLength = q.length;
    leftNodes -= qLength;
    if (leftNodes == 0) break;
    for (let i = 0; i < qLength; i++) {
      let currNode = q.shift();
      let currentAdj = adjList[currNode];
      for (let node of currentAdj) {
        //input is garunteed to be a tree, so no need for a visited matrix
        indegree[node]--;
        if (indegree[node] == 1) {
          q.push(node);
        }
      }
    }
  }
  return [...q];
};

// let n = 6,
//   edges = [
//     [3, 0],
//     [3, 1],
//     [3, 2],
//     [3, 4],
//     [5, 4],
//   ];
let n = 1,
  edges = [];
console.log(findMinHeightTrees(n, edges));
