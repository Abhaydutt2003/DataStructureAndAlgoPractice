/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var minSteps = function (s, t) {
  //create the freq array
  let freq = new Array(26).fill(0);
  //fill the freq array with t
  for (let ch of t) {
    let index = ch.charCodeAt(0) - 97;
    freq[index]++;
  }
  //now decrease the characters common in both the strings
  for (let ch of s) {
    let index = ch.charCodeAt(0) - 97;
    freq[index]--;
  }
  //anything positive is uncommon
  let uncommon = 0;
  for (let i of freq) {
    if (i > 0) {
      uncommon += i;
    }
  }
  return uncommon;
};

let s = "anagram",
  t = "mangaar";
console.log(minSteps(s, t));
