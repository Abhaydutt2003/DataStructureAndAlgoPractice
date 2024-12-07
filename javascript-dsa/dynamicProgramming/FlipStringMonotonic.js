//2-d dp will not work , only 1-d or differnt approach

/**
 * @param {string} s
 * @return {number}
 */
var minFlipsMonoIncr = function (s) {
  //define the suffix and prefix arrays
  let suff = new Array(s.length).fill(0);
  let pre = new Array(s.length).fill(0);
  //fill the suff
  for (let i = s.length - 1; i >= 0; i--) {
    if (i == s.length - 1) {
      suff[i] = s[i] == "0" ? 1 : 0;
    } else {
      suff[i] = suff[i + 1];
      suff[i] += s[i] == "0" ? 1 : 0;
    }
  }
  //fill the pre
  for (let i = 0; i < s.length; i++) {
    if (i == 0) {
      pre[i] == (s[i] == "1") ? 1 : 0;
    } else {
      pre[i] = pre[i - 1];
      pre[i] += s[i] == "1" ? 1 : 0;
    }
  }
  //now start traversing form back for the answer
  let ans = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    let cost1 = suff[i + 1] || 0;
    let cost0 = pre[i - 1] || 0;
    s[i] == "1" ? cost0++ : cost1++;
    if (cost0 < cost1) {
      ans += cost0;
      break;
    } else {
      ans += cost1;
      suff[i] = s.length - i;
    }
  }
  return ans;
};

//give up

/**
 *
 * @param {string} s
 */
let util = (s) => {
  let flip1 = 0,
    flip0 = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    flip0 += s[i] == "0" ? 1 : 0;
  }
  let ans = flip0 + flip1;
  for (let ch of s) {
    if (ch == "1") {
      flip1++;
    } else {
      flip0--;
    }
    ans = Math.min(ans, flip0 + flip1);
  }
  return ans;
};

let s = "010110";
console.log(util(s));
