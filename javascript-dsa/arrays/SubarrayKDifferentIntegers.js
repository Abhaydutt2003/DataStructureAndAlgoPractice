/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var subarraysWithKDistinct = function (nums, k) {
  return getAns(nums, k) - getAns(nums, k - 1);
};

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
let getAns = (nums, k) => {
  let start = 0,
    end = 0,
    map = new Map(),
    ans = 0;
  while (end < nums.length) {
    map.set(nums[end], (map.get(nums[end]) || 0) + 1);
    while (map.size > k) {
      //shrink the window
      map.set(nums[start], map.get(nums[start]) - 1);
      if (map.get(nums[start]) == 0) {
        map.delete(nums[start]);
      }
      start++;
    }
    ans += end - start + 1;
    end++;
  }
  return ans;
};

// new process, whenever you get exaact k;
//can use at most k -   (at most k-1);

let nums = [1, 2, 1, 3, 4],
  k = 3;
console.log(subarraysWithKDistinct(nums, k));
