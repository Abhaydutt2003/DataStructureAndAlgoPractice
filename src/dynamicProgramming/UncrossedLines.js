/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var maxUncrossedLines2 = function (nums1, nums2) {
  map = new Map();
  dp = new Map();
  //fill the map with nums2 values
  for (let i = 0; i < nums2.length; i++) {
    if (!map.has(nums2[i])) {
      let arr = [];
      arr.push(i);
      map.set(nums2[i], arr);
    } else {
      map.get(nums2[i]).push(i);
    }
  }
  return check(nums1, 0, 0, 0);
};

let map = new Map();
let dp = new Map();

/**
 *
 * @param {number[]} nums1
 * @param {number} index
 * @param {number} matches
 * @param {number} lastMatch
 */
let check = (nums1, index, matches, lastMatch) => {
  //base case
  if (index >= nums1.length) {
    return matches;
  }
  //not to pick
  let ans = check(nums1, index + 1, matches, lastMatch);
  //to pick
  if (map.has(nums1[index])) {
    let match = getMatch(nums1, index, lastMatch);
    //console.log(nums1[index],match);
    if (match != -1) {
      match = Math.max(index, match);
      ans = Math.max(check(nums1, match + 1, matches + 1, match), ans);
    }
  }
  return ans;
};

/**
 *
 * @param {number} nums1
 * @param {number} index
 * @param {number} lastMatch
 */
let getMatch = (nums1, index, lastMatch) => {
  let match = -1;
  let matchArr = map.get(nums1[index]);
  if (nums1[index] == 5) {
    console.log(matchArr, lastMatch);
  }
  for (let i = 0; i < matchArr.length; i++) {
    if (matchArr[i] <= lastMatch) {
      console.log(matchArr.shift());
    } else {
      match = matchArr[i];
    }
  }
  if (matchArr.length == 0) {
    map.delete(nums1[index]);
  }
  return match;
};

//giveup

//very similar to edit distance

/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var maxUncrossedLines = function (nums1, nums2) {
  tab = new Array(nums1.length).fill().map(() => {
    return new Array(nums2.length).fill(-1);
  });
  return helper(nums1, nums2, 0, 0);
};

let tab;

/**
 *
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @param {number} i
 * @param {number} j
 */
let helper = (nums1, nums2, i, j) => {
  if (i >= nums1.length || j >= nums2.length) {
    return 0;
  } else if (tab[i][j] != -1) {
    return tab[i][j];
  }
  let ans;
  if (nums1[i] == nums2[j]) {
    ans = 1 + helper(nums1, nums2, i + 1, j + 1);
  } else {
    ans = Math.max(
      helper(nums1, nums2, i + 1, j),
      helper(nums1, nums2, i, j + 1)
    );
  }
  tab[i][j] = ans;
  return ans;
};


let tabulation = ()=>{
  let table = new Array(nums1.length+1).fill().map(() => {
    return new Array(nums2.length+1).fill(0);
  });
  for(let i = 1;i<=nums1.length;i++){
    for(let j = 1;j<=nums2.length;j++){
      if(nums1[i-1]  == nums2[j-1]){
        table[i][j] = 1+table[i-1][j-1];
      }else{
        table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
      }
    }
  }
  return table[nums1.length][nums2.length];
}

let nums1 = [2, 5, 1, 2, 5],
  nums2 = [10, 5, 2, 1, 5, 2];

console.log(tabulation(nums1, nums2));
