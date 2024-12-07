/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var getWinner = function (arr, k) {
  let max = arr[0];
  let streak = 0;
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
      streak = 1;
    } else {
      streak++;
    }
    if (streak >= k) break;
  }
  return max;
};

let arr = [1, 9, 8, 2, 3, 7, 6, 4, 5],
  k = 7;
console.log(getWinner(arr, k));

//a lot of things i can do in this question
//basically find the first max among >=k elements
