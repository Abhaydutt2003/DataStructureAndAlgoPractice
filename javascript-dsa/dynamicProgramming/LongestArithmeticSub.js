/**
 * @param {number[]} nums
 * @return {number}
 */
var longestArithSeqLength = function (nums) {
  //check if the length is less than equal to 2
  if (nums.length <= 2) {
    return 2;
  }
  //create a dp array
  let dp = [];
  for (let i = 0; i < nums.length; i++) {
    dp.push(new Map());
  }
  //start to fill the dp array (LIS)
  let ans = 1 << 31;
  for (let i = 0; i < dp.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      let diff = nums[j] - nums[i];
      if (dp[i].has(diff)) {
        //the cd was seen before
        dp[j].set(diff, dp[i].get(diff) + 1);
      } else {
        //the first two elements
        dp[j].set(diff, 2);
      }
      ans = Math.max(ans, dp[j].get(diff));
    }
  }
  return ans;
};

let nums = [3, 6, 9, 12];
console.log(longestArithSeqLength(nums));

//lis? lcs? does not seem lcs based, seems more like lis
//the common difference can be negative
/**
 * constraints suggest lis, is it really lis ?
 * seems like knapsack,hnmmnmmnmnmn
 * no it is lis , but with the variation of a map in dp table
 */
