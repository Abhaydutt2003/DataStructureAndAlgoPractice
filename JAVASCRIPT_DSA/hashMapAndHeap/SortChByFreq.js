/**
 * @param {string} s
 * @return {string}
 */
var frequencySort = function (s) {
  let freq = new Map();
  //store all the freq in a map
  for (let ch of s) {
    if (freq.has(ch)) {
      freq.set(ch, freq.get(ch) + 1);
    } else {
      freq.set(ch, 1);
    }
  }
  //get the sorted map
  let sortFreq = sortMapByValue(freq);
  //append the characters to the answer
  let ans = "";
  for (let [key, value] of sortFreq) {
    ans += consString(key, value);
  }
  return ans;
};
/**
 *
 * @param {String} ch
 * @param {Number} n
 */
let consString = (ch, n) => {
  let string = "";
  while (n > 0) {
    string += ch;
    n--;
  }
  return string;
};

const sortMapByValue = (map) => {
  //will sort the map is decreasing order
  return new Map([...map].sort((a, b) => b[1] - a[1]));
};

let s = "Aabb";
console.log(frequencySort(s));

//why we do not need sorted map ?
//the thing is the insetion in map is O(n) and sorting it one time gives the complaxity of nlogn
//the same thing would be with heap or ordered set , it too gives the complaxity of O(nlogn)
