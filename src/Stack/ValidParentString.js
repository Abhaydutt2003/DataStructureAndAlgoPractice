/**
 * @param {string} s
 * @return {boolean}
 */
var checkValidString = function (s) {
  let op = 0,
    cl = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] == "(" || s[i] == "*") {
      op++;
    } else {
      cl++;
    }
    if (op - cl < 0) return false;
  }
  op = cl = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    if (s[i] == ")" || s[i] == "*") {
      cl++;
    } else {
      op++;
    }
    if (cl - op < 0) return false;
  }
  return true;
};

//the logic is to check if during -> there is no orphan ) and vice-versa..