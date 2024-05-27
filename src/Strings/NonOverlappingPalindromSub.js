/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxPalindromes = function (s, k){
  let dpPal = new Array(s.length+1).fill().map(()=>{
    return new Array(s.length+1).fill(false);
  });
  let generateAllPalindromes = ()=>{
    //all one length substrings
    for(let i = 0;i<s.length;i++){
      dpPal[i][i] = true;
    }
    //will take care of 2 length 2 because of odd even length scenarios
    for(let i = 0;i<s.length-1;i++){
      if(s[i] === s[i+1])dpPal[i][i+1] = true;
    }
    //start to fill all the remaning substrings
    for(let k = 2;k<s.length;k++){
      let i = 0,j = k;
      while(j<s.length){
        if(s[i] === s[j] && dpPal[i+1][j-1])dpPal[i][j] = true;
        i++;j++;
      }
    }
  }
  generateAllPalindromes();
  let memo = new Map();

  let getAns = (start)=>{
    if(start>=s.length)return 0;
    if(memo.has(start))return memo.get(start);
    let answer = 0;
    for(let i = start;i<s.length;i++){
      let smallAns = getAns(i+1);
      if(i-start+1 >=k && dpPal[start][i] == true)smallAns++;
      answer = Math.max(answer,smallAns);
    }
    memo.set(start,answer);
    return answer;
  }
  return getAns(0);
}

let s = "waxrmmrxawehtdujvgvjudmpyjozoxozojilihjlyw", k = 8;
console.log(maxPalindromes(s, k));
