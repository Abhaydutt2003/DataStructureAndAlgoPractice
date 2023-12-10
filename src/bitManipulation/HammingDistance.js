/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function (x, y) {
  let newNo = x ^ y;
  let diff = parity(newNo);
  return diff;
};

/**
 *
 * @param {number} n
 */
let parity = (n) => {
  let ones = 0;
  while (n > 0) {
    ones++;
    n &= n - 1;
  }
  return ones;
};

/**
 *
 * @param {number} x
 * @param {number} y
 */
let hammingDistance2 = (x, y) => {
  let ans = 0;
  while (x != 0 || y != 0) {
    if (x % 2 != y % 2) ans++;
    x = (x / 2) | 0;
    y = (y / 2) | 0;
  }
  return ans;
};

console.log(hammingDistance2(1, 4));
