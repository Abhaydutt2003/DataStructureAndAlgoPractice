/**
 * @param {string[][]} equations
 * @param {number[]} values
 * @param {string[][]} queries
 * @return {number[]}
 */
var calcEquation = function (equations, values, queries) {
  //construct the graph
  let graph = {};
  for (let i = 0; i < equations.length; i++) {
    let [num, den] = equations[i];
    //if num || den do not exist in the graph, put them
    if (!graph[num]) graph[num] = {};
    if (!graph[den]) graph[den] = {};
    //set the edges
    graph[num][den] = values[i];
    graph[den][num] = 1 / values[i]; //we are using js here, so no need to take care of converting to double (js has floating point numbers)
  }
  //define the dfs function
  /**
   *
   * @param {number} num
   * @param {number} den
   * @param {Set} visited
   */
  let dfs = (num, den, visited) => {
    //check if the nodes exist or not
    if (!(num in graph) || !(den in graph)) return -1.0;
    //valid
    if (num == den) return 1.0;
    visited.add(num);
    let edges = graph[num];
    //traverse all the edges
    for (let edge in edges) {
      if (!visited.has(edge)) {
        let smallAns = dfs(edge, den, visited);
        if (smallAns != -1) {
          return smallAns * edges[edge];
        }
      }
    }
    return -1.0;
  };
  //call dfs for every query
  let ans = [];
  for (let query of queries) {
    let [num, den] = query;
    let visited = new Set();
    ans.push(dfs(num, den, visited));
  }
  return ans;
};

//there is a very important point that is not worked upon in the code above,
//whever we can get an answer, we will have one node between those two, meaning something like bellman ford

/**
 * solving using the floys warshall algorithm
 * @param {string[][]} equations
 * @param {number[]} values
 * @param {string[][]} queries
 * @return {number[]}
 */
var calcEquation2 = function (equations, values, queries) {
  //make the graph
  let graph = {};
  for (let i = 0; i < equations.length; i++) {
    let [num, den] = equations[i];
    //if num || den do not exist in the graph, put them
    if (!graph[num]) graph[num] = {};
    if (!graph[den]) graph[den] = {};
    //set the edges
    graph[num][den] = values[i];
    graph[den][num] = 1 / values[i]; //we are using js here, so no need to take care of converting to double (js has floating point numbers)
    graph[num][num] = 1;
    graph[den][den] = 1;
  }
  //apply floyd wahsrall on the graph
  for (let k in graph) {
    for (let i in graph) {
      for (let j in graph) {
        if (graph[i][k] && graph[k][j] && !graph[i][j]) {
          graph[i][j] = graph[i][k] * graph[k][j];
        }
      }
    }
  }
  //evaluate all the queries
  let ans = [];
  for (let [num, den] of queries) {
    if (graph[num] && graph[num][den]) {
      ans.push(graph[num][den]);
    } else {
      ans.push(-1);
    }
  }
  return ans;
};

let equations = [
    ["x1", "x2"],
    ["x2", "x3"],
    ["x3", "x4"],
    ["x4", "x5"],
  ],
  values = [3.0, 4.0, 5.0, 6.0];
queries = [
  ["x1", "x5"],
  ["x5", "x2"],
  ["x2", "x4"],
  ["x2", "x2"],
  ["x2", "x9"],
  ["x9", "x9"],
];

//let equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]];
console.log(calcEquation2(equations, values, queries));
