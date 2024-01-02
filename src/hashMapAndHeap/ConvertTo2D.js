/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findMatrix = function(nums) {
    //set the chars in map
    let map = new Map();
    for(let i of nums){
        map.set(i,(map.get(i)||0)+1);
    }
    //fill the answer array
    let mat = [];
    //iterate till the map is not empty
    while(map.size != 0){
        let row = [];
        //iterate each [key,value] pair
        for(let [key,value] of map){
            row.push(key);
            if(value == 1){
                map.delete(key);
            }else{
                map.set(key,value-1);
            }
        }
        //push the row in the mat
        mat.push(row);
    }
    return mat;
};


let nums = [1,3,4,1,2,3,1];
console.log(findMatrix(nums));


//very easy map based approach