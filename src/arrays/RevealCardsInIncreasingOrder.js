/**
 * @param {number[]} deck
 * @return {number[]}
 */
var deckRevealedIncreasing = function (deck) {
  deck.sort((a, b) => b - a);
  let dq = [];
  for (let i = 0; i < deck.length; i++) {
    dq.length > 0 && dq.unshift(dq.pop());
    dq.unshift(deck[i]);
  }
  return dq;
};

let deck = [17, 13, 11, 2, 3, 5, 7];
console.log(deckRevealedIncreasing(deck));
