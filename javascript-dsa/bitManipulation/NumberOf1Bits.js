/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
  let num1 = 0;
  while (n != 0) {
    num1++;
    //remove one 1 from the binary representation
    n &= n - 1;
  }
  return num1;
};
/**
 * method no 2
 * @param {number} n - a positive integer
 * @return {number}
 */

var util = (n) => {
  let count = 0;
  for (let i = 0; i < 32; i++) {
    //loop till 32 because of the constraints
    if (n & 1) {
      count++;
    }
    n >>= 1;
  }
  return count;
};

console.log(hammingWeight(4294967293));
