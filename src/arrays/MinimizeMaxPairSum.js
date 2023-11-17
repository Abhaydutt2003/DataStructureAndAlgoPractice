/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function (nums) {
  //sort the array
  nums.sort((a, b) => {
    if (a > b) {
      return 1;
    } else {
      return -1;
    }
  });
  //now get the max sum pair
  let ans = Number.MIN_SAFE_INTEGER;
  for (let i = 0, j = nums.length - 1; i < j; i++, j--) {
    let smallAns = nums[i] + nums[j];
    ans = Math.max(smallAns, ans);
  }
  return ans;
};

//we can choose to get the sum of the max and min, but that can be lesser
//than the answer

let nums = [4,1,5,1,2,5,1,5,5,4]
console.log(minPairSum(nums));
