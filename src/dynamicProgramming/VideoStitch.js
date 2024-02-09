let MAX_VALUE = (1 << 31) * -1;

/**
 * @param {number[][]} clips
 * @param {number} time
 * @return {number}
 */
var videoStitching = function (clips, time) {
  clips.sort((a, b) => a[0] - b[0]);
  let memo = new Map();
  let ans = getAns(clips, time, 0, memo, 0);
  return ans == MAX_VALUE ? -1 : ans;
};

/**
 *
 * @param {number[][]} clips
 * @param {number} time
 * @param {number} currentMax
 * @param {Map} memo
 * @param {number} index
 */
let getAns = (clips, time, currentMax, memo, index) => {
  if (index == clips.length) {
    //reached the end
    if (currentMax >= time) {
      //valid, covered all the points
      return 0;
    } else {
      //was not able to cover all the points
      return MAX_VALUE;
    }
  }
  //check the state in the memo
  let state = index + " " + currentMax;
  if (memo.has(state)) return memo.get(state);
  //do not include
  let ans1 = getAns(clips, time, currentMax, memo, index + 1);
  //or to choose the current clip
  let ans2 = MAX_VALUE;
  if (clips[index][0] <= currentMax) {
    //this is the condition when there are gaps present in the given clips
    ans2 =
      getAns(
        clips,
        time,
        Math.max(currentMax, clips[index][1]),
        memo,
        index + 1
      ) + 1;
  }
  //set the answer in the memo
  memo.set(state, Math.min(ans1, ans2));
  return Math.min(ans1, ans2);
};

//can be solved using greedy too 


let clips = [
    [0, 2],
    [4, 6],
    [8, 10],
    [1, 9],
    [1, 5],
    [5, 9],
  ],
  time = 10;
console.log(videoStitching(clips, time));

//saw two ways, one with lis and with knapsack
//the think with knapscak is that we do not know the middle intervals
//that were left
