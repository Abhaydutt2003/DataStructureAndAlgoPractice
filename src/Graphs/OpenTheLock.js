// // /**
// //  * @param {string[]} deadends
// //  * @param {string} target
// //  * @return {number}
// //  */
// // var openLock = function (deadends, target) {
// //   //put all the deadends in the set
// //   let set = new Set();
// //   for (let deadend of deadends) {
// //     set.add(deadend);
// //   }
// //   //run bfs on the start
// //   let queue = [];
// //   let visited = new Set();
// //   queue.push(["0000", 0]);
// //   while (queue.length > 0) {
// //     let [curr, moves] = queue.shift();
// //     if (target == curr) {
// //       //reached the target
// //       return moves;
// //     }
// //     if (set.has(curr) || visited.has(curr)) {
// //       //either state is visited, or the state is a deadend
// //       continue;
// //     }
// //     visited.add(curr);
// //     //continue exploring all the other options
// //     for (let i = 0; i < curr.length; i++) {
// //       let newNo, newNo2;
// //       if (curr[i] == "9") {
// //         newNo = "0";
// //         newNo2 = "8";
// //       } else {
// //         newNo = (curr[i]++ + 1).toString();
// //         newNo2 = (curr[i]++ - 1).toString();
// //       }
// //       let newCurr = curr.substring(0, i) + newNo + curr.substring(i + 1);
// //       let newCurr2 = curr.substring(0, i) + newNo2 + curr.substring(i + 1);
// //       queue.push([newCurr, moves + 1]);
// //       queue.push([newCurr2, moves + 1]);
// //     }
// //   }
// //   //was not able to find any solution
// //   return -1;
// // };

// //above gives tle

/**
 * @param {string[]} deadends
 * @param {string} target
 * @return {number}
 */
let openLock = (deadends, target) => {
  let set = new Set();
  for (let deadend of deadends) {
    set.add(deadend);
  }
  let queue = [];
  let visited = new Set();
  queue.push(["0000", 0]);
  while (queue.length > 0) {
    let [curr, moves] = queue.shift();
    if (curr == target) {
      return moves;
    }
    if (set.has(curr)) {
      continue;
    }
    //traverse to all the possible options
    let possibleStates = getNextStates(curr);
    for (let state of possibleStates) {
      if (!visited.has(state)) {
        visited.add(state);
        queue.push([state, moves + 1]);
      }
    }
  }
  return -1;
};

/**
 *
 * @param {string} str
 */
let getNextStates = (str) => {
  let states = [];
  for (let i = 0; i < str.length; i++) {
    let str1 =
      str.slice(0, i) + ((str[i]++ + 1) % 10).toString() + str.slice(i + 1);
    let str2 =
      str.slice(0, i) + ((str[i]++ + 9) % 10).toString() + str.slice(i + 1);
    states.push(str1);
    states.push(str2);
  }
  return states;
};

// let deadends = ["0201", "0101", "0102", "1212", "2002"],
//   target = "0202";
let deadends = ["8888"],
  target = "0009";
console.log(openLock(deadends, target));

// function someFunction(username){
//   return new Promise((resolve,reject)=>{
//     if(username == "Abhay"){
//       resolve('yeeeee');
//     }else{
//       reject('nooo');
//     }
//   })
// }

// someFunction('Abhay').then((result)=>{
//   console.log(result);
// }).catch((error)=>{
//   console.log(error);
// })
