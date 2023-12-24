/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function (s) {
  let way1 = 0;
  let way2 = 0;
  for (let i = 0; i < s.length; i++) {
    if (i & 1) {
      //odd
      if (s[i] == "1") {
        way1++;
      } else {
        way2++;
      }
    } else {
      //even
      if (s[i] == "0") {
        way1++;
      } else {
        way2++;
      }
    }
  }
  return Math.min(way1, way2);
};

console.log(minOperations("10101010101010100101"));

//example
//10101010101010100101
//simulataneously, we will take both the cases, start is 1 and start is 0
//way1 would mean 01010101010101010.....(0 at odd)
//way2 would mean 10100101010101....(0 at even)
