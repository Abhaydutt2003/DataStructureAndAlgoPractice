/**
 * @param {string[]} words
 * @param {character[]} letters
 * @param {number[]} score
 * @return {number}
 */
var maxScoreWords = function (words, letters, score) {
  let wordScores = new Map();
  for (let word of words) {
    let wordScore = 0;
    for (let ch of word) {
      wordScore += score[ch.charCodeAt(0) - 97];
    }
    wordScores.set(word, wordScore);
  }
  let currentLetters = new Array(26).fill(0);
  for (let letter of letters) {
    currentLetters[letter.charCodeAt(0) - 97]++;
  }

  let recur = (index) => {
    if (index === words.length) return 0;
    let word = words[index];
    let canAdd = true;
    let letters = new Array(26).fill(0);
    for (let ch of word) {
      letters[ch.charCodeAt(0) - 97]++;
      if (
        letters[ch.charCodeAt(0) - 97] > currentLetters[ch.charCodeAt(0) - 97]
      ) {
        canAdd = false;
        break;
      }
    }
    let answer = 0;
    if (canAdd) {
      for (let i = 0; i < letters.length; i++) {
        currentLetters[i] -= letters[i];
      }
      let smallAns = recur(index + 1) + wordScores.get(word);
      answer = Math.max(answer, smallAns);
      for (let i = 0; i < letters.length; i++) {
        currentLetters[i] += letters[i];
      }
    }
    let smallAns = recur(index + 1);
    answer = Math.max(answer, smallAns);
    return answer;
  };
  return recur(0);
};

let words = ["dog", "cat", "dad", "good"],
  letters = ["a", "a", "c", "d", "d", "d", "g", "o", "o"],
  score = [
    1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0,
  ];

console.log(maxScoreWords(words, letters, score));

/**
//  * @param {string[]} words
//  * @param {character[]} letters
//  * @param {number[]} score
//  * @return {number}
//  */
// var maxScoreWords = function (words, letters, score) {
//   //build the demand map of words
//   let demands = new Map();
//   for(let word of words){
//     let wordDemand = new Map();
//     let wordScore = 0;
//     for(let ch of word){
//       wordDemand.set(ch,(wordDemand.get(ch) || 0)+1);
//       wordScore+=score[ch.charCodeAt(0)-97];
//     }
//     demands.set(word,[wordDemand,wordScore]);
//   }
//   //traditional knapsack below
//   let currentLetters = new Map();
//   for(let letter of letters){
//     currentLetters.set(letter,(currentLetters.get(letter) || 0)+1);
//   }

//   const canFulfilDemand = (word,index = 0)=>{
//     if(index === word.length)return true;
//     if(!currentLetters.has(word[index]))return false;
//     currentLetters.set(word[index],currentLetters.get(word[index])-1);
//     if(currentLetters.get(word[index]) === 0)currentLetters.delete(word[index]);
//     let answer = canFulfilDemand(word,index+1);
//     currentLetters.set(word[index],(currentLetters.get(word[index]) || 0)+1);
//     return answer;
//   }

//   let memo = new Map();
//   let knapsack = (index)=>{
//     if(index === words.length){
//       return 0;
//     }

//   }
// };
