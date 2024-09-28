/**
 * @param {number[][]} intervals
 * @return {number}
 */
var removeCoveredIntervals = function(intervals) {
    //sort the intervals, according to the ending times
    intervals.sort((a,b)=>{
        if(a[1] == b[1]){
            //the ending times of the intervals are the same
            if(a[0]>b[0]){
                return -1;
            }else{
                return 1;
            }
        }else{
            if(a[1]>b[1]){
                return 1;
            }else{
                return -1;
            }
        }
    });
    let removed = 0,nextStart = 0,nextEnd = 0;
    for(let i = intervals.length-1;i>=0;i--){
        if(i == intervals.length-1){
            nextStart = intervals[i][0];
            nextEnd = intervals[i][1];
        }else{
            if(intervals[i][0]>=nextStart && intervals[i][1]<=nextEnd){
                //the interval is overlapping
                removed++;
            }else{
                //the intervals are different
                nextEnd = intervals[i][1];
                nextStart = intervals[i][0];
            }
        }
    }
    return intervals.length-removed;
};


let intervals = [[1,4],[2,3]];
console.log(removeCoveredIntervals(intervals));


//to sort or not to sort?sorting will help big time
//sort descending order releated to ending times , if the ending time are the same, make sure that the one with the earliest start time is at the start
