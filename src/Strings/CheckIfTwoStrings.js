/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 */
var arrayStringsAreEqual = function (word1, word2) {
  let i = 0,
    j = 0;
  let a = 0,
    b = 0;
  while (i < word1.length && j < word2.length) {
    let crr1 = word1[i];
    let crr2 = word2[j];
    while (a < crr1.length && b < crr2.length) {
      if (crr1[a] != crr2[b]) {
        return false;
      }
      a++;
      b++;
    }
    if (a >= crr1.length) {
      i++;
      a = 0;
    }
    if (b >= crr2.length) {
      j++;
      b = 0;
    }
  }
  if (i == word1.length && j == word2.length) {
    return true;
  } else {
    return false;
  }
};

//with concat very easy, solve without concat

let word1 = ["abc", "d", "defg"],
  word2 = ["abcddefg"];

console.log(arrayStringsAreEqual(word1, word2));
