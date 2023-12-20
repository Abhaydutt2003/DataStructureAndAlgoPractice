// /**
//  * @param {string} s
//  * @param {string} locked
//  * @return {boolean}
//  */
// var canBeValid = function (s, locked) {
//   let stack = [];
//   for (let i = 0; i < s.length; i++) {
//     if (stack.length > 0 && canBoom(s, i, stack, locked)) {
//       stack.pop();
//     } else {
//       stack.push([s[i], locked[i] == "0"]);
//     }
//   }
//   return stack.length == 0;
// };

// /**
//  *
//  * @param {string} s
//  * @param {number} i
//  * @param {Array} stack
//  * @param {string} locked
//  */
// let canBoom = (s, i, stack, locked) => {
//   let prevCh = stack[stack.length - 1][0];
//   let prevChange = stack[stack.length - 1][1];
//   let currentChange = locked[i] == "0";
//   let currentCh = s[i];
//   if ((prevChange || prevCh == "(") && (currentChange || currentCh == ")")) {
//     return true;
//   } else {
//     return false;
//   }
// };

//above approaches wrong , use left-right traversal

/**
 * @param {string} s
 * @param {string} locked
 * @return {boolean}
 */
var canBeValid = function (s, locked) {
  if (s.length & 1) return false;
  let open = 0,
    close = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] == "(" || locked[i] == "0") {
      open++;
    } else {
      close++;
    }
    if (open - close < 0) {
      return false;
    }
  }
  open = close = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    if (s[i] == ")" || locked[i] == "0") {
      close++;
    } else {
      open++;
    }
    if (close - open < 0) {
      return false;
    }
  }
  return true;
};

//  orphan ( and )

let s = "))()))";
locked = "010100";
console.log(canBeValid(s, locked));

//FIRST OF ALL I HAVE FULFILLED THE BASIC CRITERIS FOR THIS JOB AND WITH THE EXIXTITNG SKILLSET THAT I POSSES I CAN BE A LONGTERM AN PROFITABLE EMPLYEE FOR THE ORG AND BECAUSE MY GOALS CAN BE SIMILAR TO THE ORGANIZATION GOALS I WILL BE ABLE TO CONTRIBUTE TOWARDS THE GROWTH OF THIS COMPANY
