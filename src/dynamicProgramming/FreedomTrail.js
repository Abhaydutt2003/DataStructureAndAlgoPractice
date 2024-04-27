/**
 * @param {string} ring
 * @param {string} key
 * @return {number}
 */
var findRotateSteps = function (ring, key) {
  let memo = new Map();
  return getAns(0, 0, ring, key, memo);
};

/**
 * finds the minimum distance between 2 indexes
 * @param {number} index1
 * @param {number} index2
 * @param {number} ringLength
 * @returns {number}
 */
let findMinimum = (index1, index2, ringLength) => {
  let way1 = Math.abs(index1 - index2);
  let way2 = ringLength - way1;
  return Math.min(way1, way2);
};

/**
 *
 * @param {number} i
 * @param {number} j
 * @param {String} ring
 * @param {String} key
 * @param {Map} memo
 */
let getAns = (i, j, ring, key, memo) => {
  if (j == key.length) {
    //entire key is made
    return 0;
  }
  let state = i + "-" + j;
  if (memo.has(state)) {
    return memo.get(state);
  }
  let minSteps = Number.MAX_SAFE_INTEGER;
  for (let a = 0; a < ring.length; a++) {
    if (ring[a] == key[j]) {
      let smallAns =
        findMinimum(a, i, ring.length) + 1 + getAns(a, j + 1, ring, key, memo);
      minSteps = Math.min(smallAns, minSteps);
    }
  }
  memo.set(state, minSteps);
  return minSteps;
};

//one of those questions where you can go both back and front
//traditional knapsack will not work

//find the minimum between two indexes

// let ring = "godding",
//   key = "gd";
let ring = "godding",
  key = "gd";
console.log(findRotateSteps(ring, key));
