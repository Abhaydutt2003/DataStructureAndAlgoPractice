/**
 * @param {string} word
 * @return {number}
 */
var addMinimum = function (word) {
  let ans = 0;
  for (let i = -1; i < word.length; i++) {
    ans += howMuchAdd(word[i], word[i + 1]);
  }
  return ans;
};

/**
 *
 * @param {string} current
 * @param {string} prev
 */
let howMuchAdd = (current, next) => {
  if (current == "a") {
    if (next == "b") {
      return 0;
    } else if (next == "c") {
      return 1;
    } else {
      return 2;
    }
  } else if (current == "b") {
    if (next == "b") {
      return 2;
    } else if (next == "c") {
      return 0;
    } else {
      return 1;
    }
  } else if (current == "c") {
    if (next == "b") {
      return 1;
    } else if (next == "c") {
      return 2;
    } else {
      return 0;
    }
  } else {
    if (current == "b") {
      return 1;
    } else if (current == "c") {
      return 2;
    } else {
      return 0;
    }
  }
};

/**
 * @param {string} word
 * @return {number}
 */
let addMinimum2 = (word) => {
  let wordCount = 3,
    ans = 0;
  for (let i = 0; i < word.length; i++) {
    let count = 0;
    if (word[i] == "a") {
      count++;
      i++;
    }
    if (word[i] == "b") {
      count++;
      i++;
    }
    if (word[i] == "c") {
      count++;
      i++;
    }
    i--;
    ans += wordCount - count;
  }
  return ans;
};

let word = "aaa";
console.log(addMinimum(word));

// abcabcabc
