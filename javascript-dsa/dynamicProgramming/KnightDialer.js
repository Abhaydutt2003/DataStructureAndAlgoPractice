/**
 * @param {number} n
 * @return {number}
 */
var knightDialer = function (n) {
  let ans = 0;
  map = new Map();
  for (let i = 0; i <= 9; i++) {
    ans = (ans + util(n - 1, i)) % mod;
  }
  return ans;
};

let map;
let mod = 1e9 + 7;
/**
 * @param {number} digitsDialed
 * @param {number} currentNumber
 * @return {number}
 */
let util = (digitsDialed, currentNumber) => {
  if (digitsDialed == 0) {
    return 1;
  }
  let ans = 0;
  let currentKey = digitsDialed + " " + currentNumber;
  if (map.has(currentKey)) {
    return map.get(currentKey);
  } else if (currentNumber == 5) {
    ans = 0;
  } else if (currentNumber == 1) {
    ans = util(digitsDialed - 1, 6) % mod;
    ans += util(digitsDialed - 1, 8) % mod;
  } else if (currentNumber == 2) {
    ans = util(digitsDialed - 1, 7) % mod;
    ans += util(digitsDialed - 1, 9) % mod;
  } else if (currentNumber == 3) {
    ans = util(digitsDialed - 1, 4) % mod;
    ans += util(digitsDialed - 1, 8) % mod;
  } else if (currentNumber == 4) {
    ans = util(digitsDialed - 1, 0) % mod;
    ans += util(digitsDialed - 1, 3) % mod;
    ans += util(digitsDialed - 1, 9) % mod;
  } else if (currentNumber == 6) {
    ans = util(digitsDialed - 1, 0) % mod;
    ans += util(digitsDialed - 1, 1) % mod;
    ans += util(digitsDialed - 1, 7) % mod;
  } else if (currentNumber == 7) {
    ans = util(digitsDialed - 1, 2) % mod;
    ans += util(digitsDialed - 1, 6) % mod;
  } else if (currentNumber == 8) {
    ans = util(digitsDialed - 1, 1) % mod;
    ans += util(digitsDialed - 1, 3) % mod;
  } else if (currentNumber == 9) {
    ans = util(digitsDialed - 1, 2) % mod;
    ans += util(digitsDialed - 1, 4) % mod;
  } else {
    ans = util(digitsDialed - 1, 4) % mod;
    ans += util(digitsDialed - 1, 6) % mod;
  }
  map.set(currentKey, ans);
  return ans;
};

//4 and 6 have three options
//5 has 0 options
//and rest other have 2 options

console.log(knightDialer(3131));
