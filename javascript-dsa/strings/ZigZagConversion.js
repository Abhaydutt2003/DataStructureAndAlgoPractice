/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows == 1) return s;
  let rows = new Array(Math.min(s.length, numRows)).fill("");
  let goDown = true;
  let currentRow = 0;
  for (let ch of s) {
    rows[currentRow] += ch;
    currentRow += goDown ? 1 : -1;
    goDown =
      currentRow == 0 || currentRow == rows.length - 1 ? !goDown : goDown;
  }
  return rows.join("");
};

let s = "PAYPALISHIRING",
  numRows = 3;
console.log(convert(s, numRows));
