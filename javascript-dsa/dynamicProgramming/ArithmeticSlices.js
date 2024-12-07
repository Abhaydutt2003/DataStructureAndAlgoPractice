/**
 * @param {number[]} nums
 * @return {number}
 */
var numberOfArithmeticSlices = function(nums) {
    let ans = 0;
    for(let i = 0;i<nums.length;){
        if(i+1<nums.length){
            //the length of the remaning subarray is atleast 2
            let cd = nums[i+1]-nums[i],subLen = 1;
            //loop till the cd is the same
            while(i<nums.length-1 && nums[i+1]-nums[i] == cd){
                subLen++;
                i++;
            }
            //the length of the sub should be atleast 3
            if(subLen>=3){
                //calc all the subarrays
                let allSub = ((subLen*(subLen+1))/2);
                //subtract 2 length and 1 length sub
                let validSub = allSub-(subLen-1)-subLen;
                ans+=validSub;
            }
        }else{
            //the length of the rem subarray is less than 2
            break;
        }
    }
    return ans;
};


let nums = [1,2,3,4];
console.log(numberOfArithmeticSlices(nums));







/**
 * based on substrings, not subsequence
 * suppose we have a valid string
 * 1,2,3,4, how many substrings can this shit form ?
 * do we need a map here?
 * simple looping?yup seem like simple looping, but we need to know how many substring can be formed from a valid string
 * 1,2,3,4 makes 2,3,4, 1,2,3, 1234 3 substrings
 * 1,2,3,4,5 ?    1,2,3  |  1,2,3,4 | 1,2,3,4,5 | then 2,3,4 | and so on
 * the number of subarrays that can be formed from an array are n * (n+1)/2
 * i need to substract the invalid subarrays, what are they/
 * all the subarrays that are of length 2 or less, 
 * any subarray can from n-1 2 length subarrays, and of course n 1 length subarrays
 * we have got the answer in O(n)
*/