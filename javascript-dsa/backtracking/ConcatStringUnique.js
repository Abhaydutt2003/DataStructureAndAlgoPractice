/**
 * @param {string[]} arr
 * @return {number}
 */
var maxLength = function (arr) {
  let ans = 0;

  /**
   * check if the current String only has unique characters
   * @param {string} str
   */
  let isUnique = (str) => {
    let bits = 1 << 26;
    for (let ch of str) {
      let index = ch.charCodeAt(0) - 97;
      //condition to check if all unique or not
      if (bits & (1 << index)) {
        return false;
      }
      //set the bit
      bits |= 1 << index;
    }
    return true;
  };

  /**
   * backtrack function
   * @param {number} index
   * @param {string} prevStr
   */
  let getAns = (index, prevStr) => {
    ans = Math.max(ans, prevStr.length);
    if (index == arr.length) {
      return;
    }
    for (let i = index; i < arr.length; i++) {
      const newStr = prevStr + "" + arr[i];
      if (isUnique(newStr)) {
        getAns(i + 1, newStr);
      }
    }
  };

  getAns(0, "");
  return ans;
};

/**
 *
 * @param {string[]} arr
 * @param {number} index
 */

let util = (arr, index) => {
  let currentString = arr[index];
  for (let i = 0; i < currentString.length; i++) {
    if (set.has(currentString.charAt(i))) {
      //the root cause of problem
      return;
    } else {
      set.add(currentString.charAt(i));
    }
  }
  ans = Math.max(ans, set.size);
  for (let i = index + 1; i < arr.length; i++) {
    util(arr, i);
  }
  for (let i = 0; i < currentString.length; i++) {
    set.delete(currentString.charAt(i));
  }
};

let arr = ["cha", "r", "act", "ers"];
console.log(maxLength(arr));
