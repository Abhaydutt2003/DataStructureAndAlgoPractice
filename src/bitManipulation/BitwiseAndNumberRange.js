/**
 * @param {number} left
 * @param {number} right
 * @return {number}
 */
var rangeBitwiseAnd = function (left, right) {
  while (right > left) right &= right - 1;
  return right;
};
//what x&(x-1) does is that it removes the rightmost set bit from the number
//now we will keep on removing rightmost set bits until right is equal or less
//than the left

/**
 *
 * @param {number} num
 */
let convertDecimal = (num) => {
  let pv = 1;
  let ans = 0;
  while (num > 0) {
    let lastTerm = num % 2;
    ans = ans + lastTerm * pv;
    pv = pv * 10;
    num = (num / 2) | 0;
  }
  return ans;
};

let left = 5,
  right = 7;
console.log(rangeBitwiseAnd(left, right));

// let n = 89898;
// console.log(convertDecimal(n),convertDecimal((n&(n-1))));
//console.log(rangeBitwiseAnd(left,right));

//some trick behind

//what x&(x-1) does is that it removes the rightmost set bit from the number
