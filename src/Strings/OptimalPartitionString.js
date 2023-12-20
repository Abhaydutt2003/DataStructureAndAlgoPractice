/**
 * @param {string} s
 * @return {number}
 */
var partitionString = function (s) {
  let ans = 0;
  let set = new Set();
  for (let i = 0; i < s.length; i++) {
    if (set.has(s[i])) {
      ans++;
      set = new Set();
      set.add(s[i]);
    } else {
      set.add(s[i]);
    }
  }
  if (!set.size == 0) ans++;
  return ans;
};

let s = "abacaba";
console.log(partitionString(s));
