/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @param {number[][]} queries
 * @return {boolean[]}
 */
var checkIfPrerequisite = function (numCourses, prerequisites, queries) {
  //make the graph and build the indegree array
  let indegree = new Array(numCourses).fill(0);
  let adjList = new Array(numCourses).fill().map(() => {
    return [];
  });
  for (let [from, to] of prerequisites) {
    indegree[to]++;
    adjList[from].push(to);
  }
  //get the node with 0 indegree and push it in the queue
  let q = [];
  for (let i = 0; i < indegree.length; i++) {
    if (!indegree[i]) {
      q.push(i);
    }
  }
  //start to operate on the graph
  let topo = new Array(numCourses).fill().map(() => {
    return new Set();
  });
  while (q.length) {
    let currentNode = q.shift();
    let currentList = adjList[currentNode];
    for (let nextNode of currentList) {
      indegree[nextNode]--;
      if (!indegree[nextNode]) q.push(nextNode);
      topo[nextNode] = new Set([
        ...topo[nextNode],
        ...topo[currentNode],
        currentNode,
      ]);
    }
  }
  return queries.map(([from, to]) => topo[to].has(from));
};

//will use khan's algo to solve the problem (TOPO SORT)

//can get the answer using floys warhsall algorithm but the complexity of
//O(V^3) is just absurd

let numCourses = 3,
  prerequisites = [
    [1, 2],
    [1, 0],
    [2, 0],
  ],
  queries = [
    [1, 0],
    [1, 2],
  ];
console.log(checkIfPrerequisite(numCourses, prerequisites, queries));
