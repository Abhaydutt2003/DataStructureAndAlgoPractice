/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var beautifulSubsets = function (nums, k) {
  let map = new Map();
  let answer = 0;
  const getAns = (start) => {
    if (map.size > 0) answer++;
    if (start >= nums.length) return;
    for (let i = start; i < nums.length; i++) {
      if (map.has(nums[i] - k) || map.has(nums[i] + k)) continue;
      map.set(nums[i], (map.get(nums[i]) || 0) + 1);
      getAns(i + 1);
      map.set(nums[i], map.get(nums[i]) - 1);
      if (map.get(nums[i]) === 0) map.delete(nums[i]);
    }
  };
  getAns(0);
  return answer;
};

// 11  13  13  1  1  2  3  113
let nums = [1, 1, 2, 3],
  k = 1;
console.log(beautifulSubsets(nums, k));
