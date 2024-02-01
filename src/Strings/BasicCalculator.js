/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
  let stack = [],
    ans = 0,
    sign = 1;
  for (let i = 0; i < s.length; i++) {
    if (!isNaN(parseInt(s.charAt(i)))) {
      let number = s.charAt(i) - "0";
      while (i + 1 < s.length && !isNaN(parseInt(s.charAt(i + 1)))) {
        console.log(s.charAt(i + 1));
        number = number * 10 + (s.charAt(i + 1) - "0");
        i++;
      }
      ans += number * sign;
    } else if (s.charAt(i) == "+") {
      sign = 1;
    } else if (s.charAt(i) == "-") {
      sign = -1;
    } else if (s.charAt(i) == "(") {
      stack.push(ans);
      stack.push(sign);
      ans = 0;
      sign = 1;
    } else if (s.charAt(i) == ")") {
      ans = ans * stack.pop() + stack.pop();
    }
  }
  return ans;
};

let s = "(1+(4+5+2)-3)+(6+8)";
console.log(calculate(s));

//- can be used as a unary operator
//this makes this question a little bit tricky
//for example -(2+3) what would that be ? = -5
