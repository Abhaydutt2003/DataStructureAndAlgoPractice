/**
 *
 * @param {string[]} bank
 * @returns {number}
 */
let numberOfBeams = (bank) => {
  /**
   * to calculate the number of lasers in a row
   * @param {number} index
   * @returns {number}
   */
  let calcLasers = (index) => {
    let lasers = 0;
    for (let ch of bank[index]) {
      if (ch == "1") lasers++;
    }
    return lasers;
  };
  let prev = 0,
    ans = 0;
  for (let i = 0; i < bank.length; i++) {
    let numLasers = calcLasers(i);
    if (numLasers != 0) {
      if (i == 0) {
        prev = numLasers;
      } else {
        ans += prev * numLasers;
        prev = numLasers;
      }
    }
  }
  return ans;
};

let bank = ["000", "111", "000"];
console.log(numberOfBeams(bank));

//high constraints , but i think O(n)
