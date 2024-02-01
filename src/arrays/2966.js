/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[][]}
 */
var divideArray = function (nums, k) {
  nums.sort((a, b) => a - b);
  let ans = [];
  let current = [];
  for (let i of nums) {
    if (current.length <= 2) {
      //array length less than 3
      if (current.length == 0 || i - current[0] <= k) {
        current.push(i);
      } else {
        return [];
      }
    } else {
      //array length == 3
      ans.push(current);
      current = [i];
    }
  }
  if (current.length) {
    //edge case
    if (current.length == 3) {
      ans.push(current);
    } else {
      return [];
    }
  }
  return ans;
};

let nums = [1, 3, 3, 2, 7, 3],
  k = 3;
console.log(divideArray(nums, k));
