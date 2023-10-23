/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    if(n == 1){
        return true;
    }else if(n<=0){
        return false;
    }else{
        let logBase4 = Math.log(n)/Math.log(4);
        return (Math.round(logBase4) == logBase4);
    }
};

//based on change of base rule
console.log(isPowerOfFour(5));