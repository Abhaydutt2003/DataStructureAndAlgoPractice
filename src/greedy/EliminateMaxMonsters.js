/**
 * @param {number[]} dist
 * @param {number[]} speed
 * @return {number}
 */
var eliminateMaximum = function (dist, speed) {
    let time_to_city = dist.map((d,index)=>{
        return d/speed[index];
    })
    time_to_city.sort((a,b)=>a-b);
    console.log(time_to_city);
    let time = 0;
    let monstersKilled = 0;
    for(let i of time_to_city){
        if(i<=time){
            break;
        }else{
            time++;
            monstersKilled++;
        }
    }
    return monstersKilled;
};

let dist = [3,2,4],
  speed = [5,3,2];
console.log(eliminateMaximum(dist, speed));
