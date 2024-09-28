/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function (piles) {
  //sort the piles
  piles.sort((a, b) => {
    if (a > b) {
      return 1;
    } else {
      return -1;
    }
  });
  //now just calculate the answer
  let ans = 0,
    pilesAdded = 0,
    index = piles.length - 2;
  while (pilesAdded < piles.length / 3) {
    ans += piles[index];
    index -= 2;
    pilesAdded++;
  }
  return ans;
};

/**
 * a O(n) solution(very dumb though , consumes a lot of space)
 * @param {number[]} piles
 */
let util = (piles) => {
  let max = Number.MIN_SAFE_INTEGER;
  for (let i of piles) {
    max = Math.max(i, max);
  }
  let freqArr = new Array(max + 1).fill(0);
  for (let i of piles) {
    freqArr[i]++;
  }
  let ans = 0;
  let chance = piles.length / 3;
  let turn = 1;
  let i = max;
  while (chance != 0) {
    if (freqArr[i] > 0) {
      if (turn == 1) {
        turn = 0;
      } else {
        chance--;
        turn = 1;
        ans += i;
      }
      freqArr[i]--;
    } else {
      i--;
    }
  }
  return ans;
};
let piles = [2, 4, 1, 2, 7, 8];
console.log(util(piles));
