let mod = 1000000007;
/**
 * @param {number[]} nums
 * @return {number}
 */
var countNicePairs = function (nums) {
  let revArray = [];
  for (let num of nums) {
    let revNum = rev(num);
    revArray.push(revNum);
  }
  let map = new Map();
  let ans = 0;
  for (let i = 0; i < nums.length; i++) {
    let current = nums[i] - revArray[i];
    if (map.has(current)) {
      ans = (ans + map.get(current)) % mod;
    }
    map.set(current, (map.get(current) || 0) + 1);
  }
  return ans;
};

/**
 *
 * @param {number} n
 * @returns {number}
 */
let rev = (n) => {
  let ans = 0;
  while (n > 0) {
    let lastDigit = n % 10;
    ans = ans * 10 + lastDigit;
    n = Math.floor(n / 10);
  }
  return ans;
};

let nums = [13, 10, 35, 24, 76];
console.log(countNicePairs(nums));
