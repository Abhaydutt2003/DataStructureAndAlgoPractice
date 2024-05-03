/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
var compareVersion = function (version1, version2) {
  let arr1 = version1.split(".").map((i) => {
    return parseInt(i);
  });
  let arr2 = version2.split(".").map((i) => {
    return parseInt(i);
  });
  let i = 0,
    j = 0;
  while (i < arr1.length && j < arr2.length) {
    if (arr1[i] < arr2[j]) {
      return -1;
    } else if (arr1[i] > arr2[j]) {
      return 1;
    } else {
      i++;
      j++;
    }
  }
  //edge cases
  while (i < arr1.length) {
    if (arr1[i++] != 0) {
      return 1;
    }
  }
  while (j < arr2.length) {
    if (arr2[j++] != 0) {
      return -1;
    }
  }
  return 0;
};

let version1 = "1.1.1",
  version2 = "1.1.1.2";
console.log(compareVersion(version1, version2));
