/**
 * @param {string} s
 * @return {boolean}
 */
var halvesAreAlike = function (s) {
  //define the regex to check vowels
  let vowelsRegex = /[aeiou]/gi;
  //get both the valid strings
  let str1 = s.substring(0, s.length / 2);
  let str2 = s.substring(s.length / 2);
  //check weather both have the same number of vowels
  let match1 = str1.match(vowelsRegex);
  let match2 = str2.match(vowelsRegex);
  return ((match1 && match1.length) || 0) == ((match2 && match2.length) || 0);
};

let s = "textbook";
console.log(halvesAreAlike(s));

//js regex works in the following way --->   /pattern/modifier(s);

//construct the left and right array
