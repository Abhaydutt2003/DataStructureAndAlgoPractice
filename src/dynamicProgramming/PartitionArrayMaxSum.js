let MIN_VALUE = 1 << 31;

/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */
var maxSumAfterPartitioning = function (arr, k) {
  let cache = new Map();
  return ansFunc(arr, k, 0,cache);
};

/**
 *
 * @param {number[]} arr
 * @param {number} k
 * @param {number} index
 * @param {Map} cache
 */
let ansFunc = (arr, k, index, cache) => {
  if (index == arr.length) {
    //reached the end
    return 0;
  }
  //handle the states and look into the cache
  if (cache.has(index)) return cache.get(index);
  //handle left than go right
  let maxNumber = MIN_VALUE;
  let maxAns = MIN_VALUE;
  for (
    let i = index, subLength = 1;
    subLength <= k && i < arr.length;
    i++, subLength++
  ) {
    maxNumber = Math.max(arr[i], maxNumber);
    let currentAns = ansFunc(arr, k, i + 1,cache) + maxNumber * subLength;
    maxAns = Math.max(currentAns, maxAns);
  }
  cache.set(index, maxAns);
  return maxAns;
};

let arr = [1,15,7,9,2,5,10], k = 3;
console.log(maxSumAfterPartitioning(arr, k));
