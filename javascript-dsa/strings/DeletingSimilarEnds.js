/**
 * @param {string} s
 * @return {number}
 */
var minimumLength = function (s) {
  let start = 0,
    end = s.length - 1;
  while (start < end) {
    //as suffix and prefix cannot intersect
    if (s[start] == s[end]) {
      let theChar = s[start];
      while (s[start] == theChar && start < end) {
        start++;
      }
      if (start == end) {
        //EDGE CASE
        return 0;
      }
      while (s[end] == theChar && start < end) {
        end--;
      }
    } else {
      //cannot proceed further
      break;
    }
  }
  return end - start + 1;
};

let s = "aabccabba";
console.log(minimumLength(s));
