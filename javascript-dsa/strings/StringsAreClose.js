

/**
 * 
 * @param {string} word1 
 * @param {string} word2 
 * @returns {boolean}
 */
let closeStrings = (word1,word2)=>{
    //base case
    if(word1.length != word2.length)return false;
    //create freqArr for both the words
    let freq1 = new Array(26).fill(0),freq2 = new Array(26).fill(0);
    for(let ch of word1){
        let index = ch.charCodeAt(0)-97;
        freq1[index]++;
    }
    for(let ch of word2){
        let index = ch.charCodeAt(0)-97;
        freq2[index]++;
    }
    //check if their are no uncommon words
    for(let i = 0;i<freq1.length;i++){
        if((freq1[i] != 0 && freq2[i] == 0)||(freq1[i] == 0 && freq2[i] != 0)){
            return false;
        }
    }
    //make sure that the freq are in the same count in both the arrays
    let map = new Map();
    for(let freq of freq1){
        if(freq != 0){
            map.set(freq,(map.get(freq) || 0)+1);
        }
    }
    for(let freq of freq2){
        if(freq != 0){
            if(!map.has(freq)){
                return false;
            }else{
                if(map.get(freq) == 1){
                    map.delete(freq);
                }else{
                    map.set(freq,map.get(freq)-1);
                }
            }
        }
    }
    return map.size == 0;
}


let word1 = "uau", word2 = "ssx"
console.log(closeStrings(word1,word2));