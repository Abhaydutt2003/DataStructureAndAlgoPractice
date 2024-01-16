var RandomizedSet = function () {
  //map to get the index of the value
  RandomizedSet.prototype.map = new Map();
  //arr to remove the value
  RandomizedSet.prototype.arr = [];
};

/**
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.insert = function (val) {
  let map = RandomizedSet.prototype.map;
  let arr = RandomizedSet.prototype.arr;
  if (map.has(val)) {
    //already present in the map
    return false;
  } else {
    map.set(val, arr.length);
    arr.push(val);
    return true;
  }
};

/**
 * @param {number} val
 * @return {boolean}
 */
RandomizedSet.prototype.remove = function (val) {
  let map = RandomizedSet.prototype.map;
  let arr = RandomizedSet.prototype.arr;
  if (!map.has(val)) {
    return false;
  } else {
    let index = map.get(val);
    //swap elements at arr.length-1 and index
    arr[index] = arr[index] ^ arr[arr.length - 1];
    arr[arr.length - 1] = arr[index] ^ arr[arr.length - 1];
    arr[index] = arr[index] ^ arr[arr.length - 1];
    //remove element at the last index
    arr.pop();
    map.delete(val);
    //update the index of the swapped number
    map.set(arr[index],index);
    return true;
  }
};

/**
 * @return {number}
 */
RandomizedSet.prototype.getRandom = function () {
  let arr = RandomizedSet.prototype.arr;
  let randomIndex = Math.floor(Math.random() * arr.length);
  return arr[randomIndex];
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = new RandomizedSet()
 * var param_1 = obj.insert(val)
 * var param_2 = obj.remove(val)
 * var param_3 = obj.getRandom()
 */
