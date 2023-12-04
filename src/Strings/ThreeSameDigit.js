/**
 * @param {string} num
 * @return {string}
 */
var largestGoodInteger = function (num) {
  let map = new Map();
  let start = 0,
    end = 0,
    max = "-1";
  while (end < num.length) {
    let curr = num.charAt(end);
    map.set(curr, (map.get(curr) || 0) + 1);
    if (end >= 2) {
      if (map.size == 1) {
        max = Math.max(max, curr);
      }
      map.set(num.charAt(start), map.get(num.charAt(start)) - 1);
      if (map.get(num.charAt(start)) == 0) {
        map.delete(num.charAt(start));
      }
      start++;
    }
    end++;
  }
  if (max == -1) {
    return "";
  } else {
    return max + "" + max + "" + max;
  }
};

let num = "3200014888";
console.log(largestGoodInteger(num));
// let c = '7';
// let d = '6';
// console.log(Math.max(c,d));
