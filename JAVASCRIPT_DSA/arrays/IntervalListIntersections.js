/**
 * @param {number[][]} firstList
 * @param {number[][]} secondList
 * @return {number[][]}
 */
var intervalIntersection = function (firstList, secondList) {
  let ans = [],
    i = 0,
    j = 0;
  while (i < firstList.length && j < secondList.length) {
    let interval1 = firstList[i],
      interval2 = secondList[j];
    //check if the intervals are not over
    if (interval1[0] > interval2[1]) {
      //the first interval is ahead
      j++;
    } else if (interval2[0] > interval1[1]) {
      //the second intervals is ahead
      i++;
    } else {
      //there are overlapping intervals
      ans.push([
        Math.max(interval1[0], interval2[0]),
        Math.min(interval1[1], interval2[1]),
      ]);
      //check in which direction to go ahead
      if (interval1[1] == interval2[1]) {
        j++;
        i++;
      } else if (interval1[1] < interval2[1]) {
        i++;
      } else {
        j++;
      }
    }
  }
  return ans;
};

let firstList = [
    [0, 2],
    [5, 10],
    [13, 23],
    [24, 25],
  ],
  secondList = [
    [1, 5],
    [8, 12],
    [15, 24],
    [25, 26],
  ];
console.log(intervalIntersection(firstList, secondList));

