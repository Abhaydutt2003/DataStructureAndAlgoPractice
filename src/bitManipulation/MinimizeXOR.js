/**
 * @param {number} num1
 * @param {number} num2
 * @return {number}
 */
var minimizeXor = function (num1, num2) {
  /**
   *
   * @param {number} num
   */
  let getParity = (num) => {
    let numOnes = 0;
    while (num > 0) {
      numOnes++;
      num &= num - 1;
    }
    return numOnes;
  };
  let num2Parity = getParity(num2);
  let ans = 0;
  //start setting the bits that are already set in num1
  for (let i = 31; i > -1 && num2Parity > 0; i--) {
    if ((num1 >> i) & 1) {
      //checks if the ith bit is set
      ans |= 1 << i;
      num2Parity--;
    }
  }
  //if there are bits left, start setting them from the lsb(which are not already set)
  for (let i = 0; i < 32 && num2Parity > 0; i++) {
    if (!((ans >> i) & 1)) {
      ans |= 1 << i;
      num2Parity--;
    }
  }
  return ans;
};

//( num >>i ) & 1, tells if the ith bit is set
// ans|=(1<<i)

console.log(minimizeXor(1, 12));

//determine the number of set bits in num2
//after that , we start to mark set bits in the exact postions
//where the num1 has set bits, if still the number of bits are left
//we start to set bits from the lsb (that is the way we get the leaset XOR value)

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
