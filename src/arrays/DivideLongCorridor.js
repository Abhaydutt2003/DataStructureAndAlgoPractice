/**
 * @param {string} corridor
 * @return {number}
 */
var numberOfWays = function (corridor) {
  let left = [];
  let numS = 0;
  for (let ch of corridor) {
    if (ch == "S") {
      numS++;
    }
    left.push(numS);
  }
  let right = [];
  numS = 0;
  for (let i = corridor.length - 1; i >= 0; i--) {
    if (corridor[i] == "S") {
      numS++;
    }
    right.unshift(numS);
  }
  let ans = 0;
  for (let i = 0; i < left.length - 1; i++) {
    if (
      left[i] != 0 &&
      left[i] % 2 == 0 &&
      right[i + 1] != 0 &&
      right[i + 1] % 2 == 0
    ) {
      console.log(i);
      ans++;
    }
  }
  //edge case
  if (left[left.length - 1] == 2) {
    ans++;
  }
  return ans;
};

//above wrong

/**
 * @param {string} corridor
 * @return {number}
 */
let util = (corridor) => {
  let mod = 1000000007;
  let ans = 1,
    noS = 0,
    noP = 1;
  for (let i = 0; i < corridor.length; i++) {
    if (corridor[i] == "S") {
      noS++;
      if (noS % 2 == 0) {
        ans = (ans * noP) % mod;
        noP = 1;
      }
    } else if (noS > 0 && noS % 2 == 0) {
      noP++;
    }
  }
  if (noS > 0 && noS % 2 == 0) {
    return ans;
  } else {
    return 0;
  }
};
/**
 * @param {string} corridor
 * @return {number}
 */
let util2 = (corridor) => {
  let noS = 0,
    prevSeat = 0,
    ans = 1,
    mod = 1000000007;
  for (let i = 0; i < corridor.length; i++) {
    if (corridor[i] == "S") {
      noS++;
      //check if valid
      if (noS > 2 && noS % 2 == 1) {
        ans = (ans * (i - prevSeat)) % mod;
      }
      prevSeat = i;
    }
  }
  if (noS > 0 && noS % 2 == 0) {
    return ans;
  } else {
    return 0;
  }
};

let s = "SPPSSSSPPS";
console.log(numberOfWays(s));
