//stack
class Stack {
    // Array is used to implement stack
    constructor() {
        this.items = [];
    }
    // push function
    push(element) {
        // push element into the list items
        this.items.push(element);
    }
    // pop function
    pop() {
        if (this.items.length == 0) return -1;
        return this.items.pop();
    }

    // isEmpty function
    isEmpty() {
        // return true if stack is empty
        return this.items.length == 0;
    }

    // peek function
    peek() {
        return this.items[this.items.length - 1];
    }
}


/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumScore = function (nums, k) {
    let s = new Stack();
    let left = new Array(nums.length).fill(0);
    for (let i = nums.length - 1; i >= 0; i--) {
        while (s.isEmpty() == false && nums[s.peek()] > nums[i]) {
            left[s.pop()] = i + 1;
        }
        s.push(i);
    }
    let right = new Array(nums.length).fill(nums.length - 1);
    s = new Stack();
    for (let i = 0; i < nums.length; i++) {
        while (s.isEmpty() == false && nums[s.peek()] > nums[i]) {
            right[s.peek()] = i - 1;
            s.pop();
        }
        s.push(i);
    }
    //start calculating the answer
    let ans = 0;
    for (let i = 0; i < left.length; i++) {
        if (left[i] <= k && right[i] >= k) {
            let candidate = (nums[i] * (right[i] - left[i] + 1));
            ans = Math.max(ans, candidate);
        }
    }
    return ans;
};
/**
 * @param {number[]} arr
 * @param {number} k
 * @return {number}
 */

var util1 = (arr, k) => {
    let left = k, right = k;
    let ans = arr[k];
    let min = arr[k];
    while (left > 0 || right < arr.length-1) {
        if ((left > 0 ? arr[left - 1] : 0) < (right < arr.length - 1 ? arr[right + 1] : 0)) {
            right++;
            min = Math.min(min, arr[right]);
        } else {
            left--;
            min = Math.min(min, arr[left]);
        }
        let score = min * (right - left + 1);
        ans = Math.max(ans, score);
    }
    return ans;
}

//for every elem calculate how far to left and right the element is the minimum
//the greedy method is basically expanding around the center

let nums = [5,5,4,5,4,1,1,1];
let k = 0;
console.log(util1(nums, k));

