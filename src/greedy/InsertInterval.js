"use strict";
// /**
//  * @param {number[][]} intervals
//  * @param {number[]} newInterval
//  * @return {number[][]}
//  */
// var insert = function (intervals, newInterval) {
//   //traverse to find the overlapping intervals
//   let ans = [];
//   let a = false;
//   for (let i = 0; i < intervals.length; i++) {
//     if (overlaps(intervals[i],newInterval)) {
//       //overlapping interval found
//       let start = Math.min(intervals[i][0], newInterval[0]);
//       let end = Math.max(intervals[i][1], newInterval[1]);
//       i++;
//       while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
//         end = Math.max(intervals[i][1], newInterval[1]);
//         i++;
//       }
//       if (i != intervals.length) {
//         i--;
//       }
//       ans.push([start, end]);
//       a = true;
//     } else if (intervals[i][0] > newInterval[1] && a == false) {
//       //to check if no overlapping found
//       ans.push([newInterval[0], newInterval[1]]);
//       ans.push(intervals[i]);
//     } else {
//       ans.push(intervals[i]);
//     }
//   }
//   if (intervals.length == 0) {
//     ans.push([newInterval[0], newInterval[1]]);
//   } else if (ans[ans.length - 1][1] < newInterval[0]) {
//     ans.push([newInterval[0], newInterval[1]]);
//   }
//   return ans;
// };

// /**
//  *
//  * @param {number[]} currentInterval
//  * @param {number[]} newInterval
//  */
// let overlaps = (currentInterval, newInterval)=>{
//   //to check weather the intervals overlap

// }
/**
 * @param {number[][]} intervals
 * @param {number[]} newInterval
 * @return {number[][]}
 */
var insert = (intervals, newInterval) => {
  let [start, end] = newInterval;
  let ans = [];
  let pushed = false;
  for (let [currStart, currEnd] of intervals) {
    if (currEnd < start) {
      ans.push([currStart, currEnd]);
    } else if (currStart > end) {
      if (!pushed) {
        ans.push([start, end]);
        pushed = true;
      }
      ans.push([currStart, currEnd]);
    } else {
      start = Math.min(start, currStart);
      end = Math.max(end, currEnd);
    }
  }
  if (!pushed) {
    ans.push([start, end]);
  }
  return ans;
};

let intervals = [
  [1, 2],
  [3, 5],
  [6, 7],
  [8, 10],
  [12, 16],
];
let newInterval = [4, 8];

console.log(insert(intervals, newInterval));
