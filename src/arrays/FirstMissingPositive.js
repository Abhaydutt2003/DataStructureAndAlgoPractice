/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function (nums) {
  //index sort(1-indexed)
  for (let i = 0; i < nums.length; ) {
    if (nums[i] == 0) {
      //ignore the 0
      i++;
      continue;
    }
    let indexToPut = nums[i] - 1;
    if (nums[i] == indexToPut + 1) {
      //in correct place
      i++;
      continue;
    } else if (indexToPut >= 0 && indexToPut <= nums.length) {
      let temp = nums[i];
      nums[i] = nums[indexToPut];
      nums[indexToPut] = temp;
    } else {
      //number out of the array
      i++;
      continue;
    }
  }
  console.log(nums);
  //get the smallest number
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != nums[i] + 1) {
      return i + 1;
    }
  }
  //edge case
  if (nums[nums.length - 1] == nums.length) {
    return nums.length + 1;
  }
  //just for the sake of it
  return -1;
};
//above does not work, but tried my best

/**
 * @param {number[]} nums
 * @return {number}
 */
let util = (nums) => {
  //index sort(1-indexed)
  for (let i = 0; i < nums.length; i++) {
    let current = nums[i];
    while (
      current > 0 &&
      current <= nums.length &&
      current != nums[current - 1]
    ) {
      let temp = nums[current - 1];
      nums[current - 1] = current;
      current = temp;
    }
  }
  //now check for the smallest
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] != i + 1) return i + 1;
  }
  //edge case
  return nums.length + 1;
};

let nums = [3,4,-1,1];
console.log(util(nums));

//index sort??? almost similar concept
//start to track the numbers from 1-the max positive in the array
//will use index sort
//keep the number in order [1,2,3,4,------];
//the index that does not match ois the answer.
//should the sorted array be 1 indexed?
