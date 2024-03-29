/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var countSubarrays = function (nums, k) {
  let max = nums[0];
  for (let i of nums) {
    max = Math.max(i, max);
  }
  let start = 0,
    end = 0,
    ans = 0,
    maxFreq = 0;
  while (end < nums.length) {
    maxFreq += nums[end] == max ? 1 : 0;
    while (maxFreq >= k) {
      maxFreq -= nums[start++] == max ? 1 : 0;
    }
    ans += start;
    end++;
  }
  return ans;
};

let nums = [1, 4, 2, 1],
  k = 3;
console.log(countSubarrays(nums, k));
