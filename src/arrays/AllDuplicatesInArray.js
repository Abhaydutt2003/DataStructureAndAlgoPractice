/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function (nums) {
  for (let i = 0; i < nums.length; i++) {
    while (nums[nums[i] - 1] != nums[i]) {
      [nums[nums[i] - 1], nums[i]] = [nums[i], nums[nums[i] - 1]];
    }
  }
  let ans = [];
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != i + 1) {
      ans.push(nums[i]);
    }
  }
  return ans;
};
//index sort

let nums = [4, 3, 2, 7, 8, 2, 3, 1];
console.log(findDuplicates(nums));

//range of integers is 1 to n
