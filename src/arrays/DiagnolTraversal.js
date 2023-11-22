/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var findDiagonalOrder = function (nums) {
  let map = new Map();
  for (let i = 0; i < nums.length; i++) {
    for (let j = 0; j < nums[i].length; j++) {
      let current = i + j;
      if (map.has(current)) {
        map.get(current).push(nums[i][j]);
      } else {
        let arr = [nums[i][j]];
        map.set(current, arr);
      }
    }
  }
  let ans = [];
  for (let [key, value] of map) {
    for (let i = value.length - 1; i >= 0; i--) {
      ans.push(value[i]);
    }
  }
  return ans;
};

let nums = [[1, 2, 3, 4, 5], [6, 7], [8], [9, 10, 11], [12, 13, 14, 15, 16]];
console.log(findDiagonalOrder(nums));
