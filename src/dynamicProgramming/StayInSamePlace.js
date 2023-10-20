/**
 * @param {number} steps
 * @param {number} arrLen
 * @return {number}
 */


//logic
var numWays = function (steps, arrLen) {
  hm = new Map();
  return util1(steps, arrLen, 0);
};

let hm;
let mod = 1000000007;

var util1 = function (steps, arrLen, currPos) {
  if (currPos < 0 || currPos >= arrLen) {
    return 0;
  }
  if (steps == 0) {
    if (currPos == 0) {
      return 1;
    } else {
      return 0;
    }
  }

  let key = steps + "-" + currPos;
  if (hm.has(key)) {
    return hm.get(key);
  }
  let ans = util1(steps - 1, arrLen, currPos);
  ans = (ans + util1(steps - 1, arrLen, currPos + 1)) % mod;
  ans = (ans + util1(steps - 1, arrLen, currPos - 1)) % mod;
  hm.set(key, ans);
  return ans;
};

console.log(numWays(3,2));