/**
 * @param {number} n
 * @return {number}
 */
var checkRecord = function (n) {
  const MOD = 1000000000 + 7;
  let memo = new Array(n).fill().map(() => {
    return new Array(2).fill().map(() => {
      return new Array(3).fill(-1);
    });
  });
  let getAns = (index, leftA, leftP) => {
    if (index == n) {
      return 1;
    }
    if (memo[index][leftA][leftP] !== -1) return memo[index][leftA][leftP];
    let total = 0;
    //call for P
    total += getAns(index + 1, leftA, 2);
    total %= MOD;
    //call for A
    if (leftA > 0) {
      total += getAns(index + 1, leftA - 1, 2);
      total %= MOD;
    }
    //call for L
    if (leftP > 0) {
      total += getAns(index + 1, leftA, leftP - 1);
      total %= MOD;
    }
    return (memo[index][leftA][leftP] = total);
  };
  return getAns(0, 1, 2);
};

let n = 10101;
console.log(checkRecord(n));
