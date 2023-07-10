package dynamicProgramming;

//entire data structure is useless, we need the 
//highest and the lowest, this return the 
//second highest and the first highest

// class highestFreq {

//     private int firstHighestIndex;
//     private int secondHighestIndex;
//     private int firstHighest;
//     private int secondHighest;
//     private int freq[];

//     highestFreq() {
//         firstHighestIndex = -1;
//         secondHighestIndex = -1;
//         firstHighest = Integer.MIN_VALUE;
//         secondHighest = Integer.MIN_VALUE;
//         freq = new int[26];
//     }

//     // works only for lowercase characters
//     void add(char c) {
//         int currentIndex = c - 97;
//         freq[currentIndex]++;
//         if (currentIndex == firstHighestIndex) {
//             // only update the values
//             firstHighest = freq[currentIndex];
//         } else if (firstHighest < freq[currentIndex]) {
//             secondHighestIndex = firstHighestIndex;
//             secondHighest = firstHighest;
//             firstHighest = freq[currentIndex];
//             firstHighestIndex = currentIndex;
//         } else if (currentIndex == secondHighestIndex) {
//             // only update the values
//             secondHighest = freq[currentIndex];
//         } else if (secondHighest < freq[currentIndex]) {
//             secondHighest = freq[currentIndex];
//             secondHighestIndex = currentIndex;
//         }
//     }

//     int getHighest() {
//         return firstHighest;
//     }

//     int getSecondHighest() {
//         return secondHighest;
//     }

// }

// class highMin {
//     private int high;
//     // private int highIndex;
//     private int minIndex;
//     private int min;
//     int[] freq;

//     highMin() {
//         high = Integer.MIN_VALUE;
//         min = Integer.MAX_VALUE;
//         // highIndex = -1;
//         minIndex = -1;
//         freq = new int[26];
//     }

//     void add(char c) {
//         int current = c - 97;
//         freq[current]++;

//         // if (high < freq[current]) {
//         //     high = freq[current];
//         // }
//         // if (minIndex == -1) {
//         //     minIndex = current;
//         //     min = freq[current];
//         // } else if (minIndex == current) {
//         //     min = freq[current];
//         // } else if (freq[minIndex] > freq[current]) {
//         //     minIndex = current;
//         //     min = freq[current];
//         // }
//         // if (high < freq[current]) {
//         // if(minIndex == current){
//         // minIndex =
//         // }
//         // highIndex = current;
//         // high = freq[current];
//         // }

//         // if (freq[current] < min) {
//         // minIndex = current;
//         // min = freq[current];
//         // } else if (current == minIndex) {
//         // min = freq[current];
//         // }
//     }

//     int getHighest() {
//         return high;
//     }

//     int getLowest() {
//         return min;
//     }
// }

public class LargestVarianceSubstring {

    public static void main(String args[]) {
        String str = "aacccbbccb";
        System.out.print(util1(str));
    }

    // leetcode approach
    public static int util1(String str) {
        int freq[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int current = str.charAt(i) - 97;
            freq[current]++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || freq[i] == 0 || freq[j] == 0) {
                    continue;
                }
                char major = (char) (97 + i);
                char minor = (char) (97 + j);
                int majorFreq = 0;
                int minorFreq = 0;
                int allMinors = freq[j];
                for (int a = 0; a < str.length(); a++) {
                    if (str.charAt(a) == major) {
                        majorFreq++;
                    } else if (str.charAt(a) == minor) {
                        minorFreq++;
                        allMinors--;
                    }
                    int currentAns = majorFreq - minorFreq;
                    if (minorFreq > 0) {
                        ans = Math.max(ans, currentAns);
                    }
                    if (currentAns < 0 && allMinors > 0) {
                        majorFreq = 0;
                        minorFreq = 0;
                    }
                }
            }
        }
        return ans;
    }

    // i will always need to use a heap for the minimum in the array,because the
    // freq are dynamic

    // public static int util1(String str){
    // return helper(str);
    // }

    // public static int helper(String str){
    // if(str.length() == 0){
    // return 0;
    // }
    // int ans = Integer.MIN_VALUE;
    // highestFreq hq = new highestFreq();
    // for(int k = 1;k<=str.length();k++){
    // char currentChar = str.charAt(k-1);
    // hq.add(currentChar);
    // int firstHighest = hq.getHighest();
    // int secondHighest = hq.getSecondHighest();
    // if(secondHighest == Integer.MIN_VALUE){
    // int variance =
    // }else{

    // }
    // }
    // }

}
