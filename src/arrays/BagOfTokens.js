/**
 * @param {number[]} tokens
 * @param {number} power
 * @return {number}
 */
var bagOfTokensScore = function (tokens, power) {
  tokens.sort((a, b) => a - b);
  let i = 0,
    j = tokens.length - 1,
    ans = 0,
    score = 0;
  while (i <= j) {
    if (power >= tokens[i]) {
      //move i forwards , and increase the score
      score++;
      power -= tokens[i++];
    } else if (score < 1) {
      break;
    } else {
      power += tokens[j--];
      score--;
    }
    ans = Math.max(score, ans);
  }
  return ans;
};

let tokens = [71, 55, 82],
  power = 54;
console.log(bagOfTokensScore(tokens, power));
