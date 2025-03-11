
function maximumLength(s: string): number {
    let map = new Map<String,number>();
    let i = 0;//i to traverse the stirng

    const setInMap = (currentWord:string)=>{
        if(map.has(currentWord)){
            map.set(currentWord,map.get(currentWord)!+1);
        }else{
            map.set(currentWord, 1);
        }
    }


    const traverseString = ()=>{
        let currentWord = s[i];
        setInMap(currentWord);
        while(i+1<s.length && s[i] === s[i+1]){
            currentWord = currentWord+currentWord[0];
            setInMap(currentWord);
            i++;
        }
    } 

    while(i<s.length){
        traverseString();
        i++;
    }
    //check for the longest present.
    console.log(map);
    return 0;
};


let s = "aabbaaabbb";
console.log(maximumLength(s));
// class Solution {

//     public int maximumLength(String s) {
//         // Create a map to store the count of all substrings
//         Map<Pair<Character, Integer>, Integer> count = new HashMap<>();
//         int substringLength = 0;

//         for (int start = 0; start < s.length(); start++) {
//             char character = s.charAt(start);
//             substringLength = 0;

//             for (int end = start; end < s.length(); end++) {
//                 // If the current character matches the initial character, increment the count
//                 if (character == s.charAt(end)) {
//                     substringLength++;
//                     Pair<Character, Integer> key = new Pair<>(
//                         character,
//                         substringLength
//                     );
//                     count.put(key, count.getOrDefault(key, 0) + 1);
//                 } else {
//                     break;
//                 }
//             }
//         }

//         // Variable to store the longest substring length with frequency at least 3
//         int ans = 0;
//         for (Map.Entry<
//             Pair<Character, Integer>,
//             Integer
//         > entry : count.entrySet()) {
//             int length = entry.getKey().getValue();
//             if (entry.getValue() >= 3 && length > ans) {
//                 ans = length;
//             }
//         }

//         return ans == 0 ? -1 : ans;
//     }
// }
