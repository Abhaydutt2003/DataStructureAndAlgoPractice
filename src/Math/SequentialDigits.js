/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
var sequentialDigits = function (low, high) {
  let q = [],
    ans = [];
  //fill the q
  for (let i = 1; i <= 9; i++) q.push(i);
  //iterate till the q is not empty (simple bfs)
  while (q.length != 0) {
    let current = q.shift();
    if (current > high) break;
    if (current >= low) ans.push(current);
    let lastDigit = Math.floor(current % 10);
    if (lastDigit < 9) q.push(current * 10 + (lastDigit + 1));
  }
  return ans;
};

/**
 * @param {number} low
 * @param {number} high
 * @return {number[]}
 */
var sequentialDigits2 = function (low, high) {
  //sliding window solution
  let digits = "123456789";
  let ans = [];
  let minLen = Math.floor(Math.log10(low)) + 1;
  let maxLen = Math.floor(Math.log10(high)) + 1;
  console.log(minLen, maxLen);
  for (let windowLen = minLen; windowLen <= maxLen; windowLen++) {
    for (let i = 0; i + windowLen <= digits.length; i++) {
      let num = parseInt(digits.substring(i, i + windowLen));
      if (num <= high && num >= low) {
        ans.push(num);
      }
    }
  }
  return ans;
};

let low = 1000,
  high = 13000;
console.log(sequentialDigits2(low, high));

//Output: [1234,2345,3456,4567,5678,6789,12345]

//    first need to know how to get the first digit
//damn , sliding window????
//decalre a string of size high
//now traverse windows
