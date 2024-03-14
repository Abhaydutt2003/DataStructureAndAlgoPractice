/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  let k = 1,
    start = 1,
    end = 1;
  while (end < nums.length) {
    if (nums[start - 1] != nums[end]) {
      nums[start++] = nums[end++];
      k++;
    } else {
      end++;
    }
  }
  return k;
};

let nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4];
console.log(removeDuplicates(nums), nums);
