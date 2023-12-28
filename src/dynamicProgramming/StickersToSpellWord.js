const MAX_VALUE = (1 << 31) * -1 - 1;
/**
 * @param {string[]} stickers
 * @param {string} target
 * @return {number}
 */
var minStickers = function (stickers, target) {
  let memo = new Map();
  let ans = memoFunc(stickers, target, memo);
  return ans == MAX_VALUE ? -1 : ans;
};

/**
 *
 * @param {string[]} stickers
 * @param {string} target
 * @param {Map} memo
 */
let memoFunc = (stickers, target, memo) => {
  if (target == "") {
    //goal reached
    return 0;
  } else if (memo.has(target)) {
    //result present in cache
    return memo.get(target);
  }
  let ans = MAX_VALUE;
  for (let str of stickers) {
    let diff = stringDiff(target, str);
    if (diff.length === target.length) continue; //nothing in common
    let smallAns = memoFunc(stickers, diff, memo);
    smallAns += smallAns == MAX_VALUE ? 0 : 1;
    ans = Math.min(ans, smallAns);
  }
  memo.set(target, ans);
  return ans;
};

/**
 * to get the diff between the strings
 * @param {string} str1
 * @param {string} str2
 */
let stringDiff = (str1, str2) => {
  for (let ch of str2) {
    if (str1.includes(ch)) {
      //the char is present in the string
      str1 = str1.replace(ch, "");
    }
  }
  return str1;
};

let stickers = ["with","example","science"], target = "thehat"
console.log(minStickers(stickers, target));

//here freq array could do the trick
//one time sort??
