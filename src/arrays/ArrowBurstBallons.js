/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function (points) {
  points.sort((a, b) => {
    if (a[1] == b[1]) {
      return a[0] - b[0];
    } else {
      return a[1] - b[1];
    }
  });
  console.log(points);
  let arrows = 0,
    start = points[0][1];
  for (let i = 1; i < points.length; i++) {
    if (points[i][0] > start) {
      //increase the number of arrows
      arrows++;
      start = points[i][1];
    } else {
      //no need to increase the number of arrows
      continue;
    }
  }
  return arrows + 1;
};

//the condition of overlapping of intervals is a little different here
//will need to make sure that atleast the max of first interval is included

let points = [
  [1, 2],
  [3, 4],
  [5, 6],
  [7, 8],
];
console.log(findMinArrowShots(points));
