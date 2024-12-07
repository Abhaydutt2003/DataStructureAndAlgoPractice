function checkIfExist(arr: number[]): boolean {
  const map = new Set<number>();
  for (let i = 0; i < arr.length; i++) {
    if (map.has(arr[i] * 2) || map.has(arr[i] / 2)) {
      return true;
    }
    map.add(arr[i]);
  }
  return false;
}

const testArr = [3,1,7,11];
console.log(checkIfExist(testArr));
