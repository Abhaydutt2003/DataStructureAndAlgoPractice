/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxFrequency = function (nums, k) {
  nums.sort((a, b) => {
    if (a > b) {
      return 1;
    } else {
      return -1;
    }
  });
  let sum = 0,
    ans = 0;
  let left = 0,
    right = 0;
  while (right < nums.length) {
    sum += nums[right];
    while (sum + k < nums[right] * (right - left + 1)) {
      sum -= nums[left];
      left++;
    }
    ans = Math.max(ans, right - left + 1);
    right++;
  }
  return ans;
};

let nums = [1, 4, 8, 13],
  k = 5;
console.log(maxFrequency(nums, k));
