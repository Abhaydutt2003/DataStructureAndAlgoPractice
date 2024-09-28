/**
 * @param {number[][]} costs
 * @return {number}
 */
var twoCitySchedCost = function (costs) {
  costs.sort((a, b) => {
    let diff1 = a[0] - a[1];
    let diff2 = b[0] - b[1];
    if (diff1 > diff2) {
      return 1;
    } else {
      return -1;
    }
  });
  let ans = 0,
    n = costs.length / 2,
    count = 0;
  for (let arr of costs) {
    ans += count < n ? arr[0] : arr[1];
    count++;
  }
  return ans;
};

//send everyone to the city a, now we need to send half of them to the b city
//we will send the ones so that the refund is the maximum
//that is a[0]-a[1] should be sorted and then procced acc

let costs = [
  [259, 770],
  [448, 54],
  [926, 667],
  [184, 139],
  [840, 118],
  [577, 469],
];
console.log(twoCitySchedCost(costs));
// let arr = [4,23,5432,3423];
// arr.sort((a,b)=>{
//   if(a>b){
//     return 1;
//   }else{
//     return -1;
//   }
// });
// console.log(arr);
