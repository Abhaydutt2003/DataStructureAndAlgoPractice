/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function (tokens) {
  let stack = [];
  let operators = getOperators();
  for (let token of tokens) {
    if (operators.has(token)) {
      let n1 = stack.pop();
      let n2 = stack.pop();
      if (token == "+") {
        stack.push(n2 + n1);
      } else if (token == "-") {
        stack.push(n2 - n1);
      } else if (token == "*") {
        stack.push(n2 * n1);
      } else {
        stack.push((n2 / n1) | 0);
      }
    } else {
      //is a number
      stack.push(+token);
    }
  }
  return stack.pop();
};

let getOperators = () => {
  let set = new Set();
  set.add("/");
  set.add("*");
  set.add("+");
  set.add("-");
  return set;
};

let tokens = [
  "10",
  "6",
  "9",
  "3",
  "+",
  "-11",
  "*",
  "/",
  "*",
  "17",
  "+",
  "5",
  "+",
];
console.log(evalRPN(tokens));

//char code of numbers are from 48 to 57
