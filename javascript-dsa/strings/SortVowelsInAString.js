/**
 * @param {string} s
 * @return {string}
 */
var sortVowels = function (s) {
  let vowels = [];
  let charArr = s.split("");
  for (let i = 0; i < s.length; i++) {
    let c = charArr[i].toLowerCase();
    console.log(c);
    if (c == "a" || c == "e" || c == "i" || c == "o" || c == "u") {
      vowels.push(charArr[i]);
      charArr[i] = "#";
    }
  }
  vowels.sort((a, b) => {
    if (a > b) {
      return 1;
    } else {
      return -1;
    }
  });
  for (let i = 0; i < charArr.length; i++) {
    if (charArr[i] == "#") {
      charArr[i] = vowels.shift();
    }
  }
  return charArr.join("");
};

let s = "lEetcOde";
console.log(sortVowels(s));
