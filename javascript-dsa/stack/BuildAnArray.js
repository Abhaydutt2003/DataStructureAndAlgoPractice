/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function (target, n) {
  let i = 0;
  let ans = [];
  for (let j = 1; j <= n; j++) {
    ans.push("Push");
    if (target[i] == j) {
      i++;
      if (i == target.length) break;
    } else {
      ans.push("Pop");
    }
  }
  return ans;
};

let target = [1,5];
let n = 6;
console.log(buildArray(target,n));
