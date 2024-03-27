/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var numSubarrayProductLessThanK = function (nums, k) {
  if (k <= 1) return 0;
  let start = 0,
    end = 0,
    prod = 1,
    total = 0;
  while (end < nums.length) {
    prod *= nums[right];
    while (prod >= k) {
      prod /= nums[start++];
    }
    total += end - start + 1;
    end++;
  }
  return total;
};

//by (end-start+1) we are enumarating all the subarrays that end with arr[end]

let nums = [10, 5, 2, 6],
  k = 100;
console.log(numSubarrayProductLessThanK(nums, k));
