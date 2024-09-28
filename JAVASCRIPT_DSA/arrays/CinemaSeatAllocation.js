/**
 * @param {number} n
 * @param {number[][]} reservedSeats
 * @return {number}
 */
var maxNumberOfFamilies = function (n, reservedSeats) {
  let map = new Map();
  for (let [row, col] of reservedSeats) {
    let set = map.get(row) || new Set();
    set.add(col);
    map.set(row, set);
  }
  let res = (n - map.size) * 2;
  for (let cols of map.values()) {
    let first = ![2, 3, 4, 5].some((col) => cols.has(col));
    let last = ![6, 7, 8, 9].some((col) => cols.has(col));
    let mid = ![4, 5, 6, 7].some((col) => cols.has(col));
    res += Math.max(first + last, mid);
  }
  return res;
};
//their are only 2 max ways that the group can sit
//in 2,3,4,5, or in the 6,7,8,9, or in the 4 , 5,6,7
//now we see if their is no reserved seats in the possible ways

//there are only 3 possible outcomes from a row, 1 allocation, 2 allocation, 0 allocation

let n = 3,
  reservedSeats = [
    [1, 2],
    [1, 3],
    [1, 8],
    [2, 6],
    [3, 1],
    [3, 10],
  ];
console.log(maxNumberOfFamilies(n, reservedSeats));
