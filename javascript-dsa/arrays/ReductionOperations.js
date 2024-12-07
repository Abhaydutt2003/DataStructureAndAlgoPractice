/**
 * @param {number[]} nums
 * @return {number}
 */
var reductionOperations = function (nums) {
  //set the freq of each element
  let freq = new Map();
  for (let i of nums) {
    freq.set(i, (freq.get(i) || 0) + 1);
  }
  //now sort the unique elements
  let unique = Array.from(freq.keys());
  unique.sort((a, b) => {
    if (a > b) {
      return -1;
    } else {
      return 1;
    }
  });
  //now calculate the cost for each element
  let ans = 0;
  for (let i = 0; i < unique.length; i++) {
    //cost for each element would be how many times the element would get converted
    let smaller = unique.length - (i + 1);
    let cost = freq.get(unique[i]) * smaller;
    ans += cost;
  }
  return ans;
};

let nums = [5, 1, 3];
console.log(reductionOperations(nums));
