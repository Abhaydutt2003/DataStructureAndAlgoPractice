const tellDiff = (str1,str2,index)=>Math.abs(str1.charCodeAt(index)-str2.charCodeAt(index));
/**
 * @param {string} s
 * @param {string} t
 * @param {number} maxCost
 * @return {number}
 */
var equalSubstring = function(s, t, maxCost) {
    let start = 0,end = 0,answer = 1,window = 0;
    while(end<s.length){
        window += tellDiff(s,t,end);
        while(window>maxCost){
            window-=tellDiff(s,t,start);
            start++;
        }
        answer = Math.max(answer,end-start+1);        
    }
    return answer;
};

let s = "abcd", t = "bcdf", maxCost = 3;
console.log(equalSubstring(s,t,maxCost));