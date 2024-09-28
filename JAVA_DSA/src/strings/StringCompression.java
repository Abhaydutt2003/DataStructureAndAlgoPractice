package strings;

import java.util.*;

public class StringCompression {

    public static void main(String args[]) {
        // int i = 5;
        // int converted = 48+i;
        // char c = (char)converted;
        // System.out.print(c);

        // ArrayList<Character> al = new ArrayList<>();
        // int i = 198;
        // while(i>0){
        // int lastDigit = i%10;
        // char c = (char)(48+lastDigit);
        // al.add(0,c);
        // i/=10;
        // }
        // for(char c:al){
        // System.out.print(c+" ");
        // }
        char arr[] = { 'a', 'a', 'a', 'b', 'b', 'b', 'b' };
        util1(arr);
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static int getFreq(char arr[], int i) {
        int ans = 0;
        while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
            ans++;
            i++;
        }
        return ++ans;
    }

    public static int util1(char[] arr) {
        ArrayList<Character> al = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            char currentChar = arr[i];
            al.add(currentChar);

            // part to calculate the cont. frequency of the character
            int freq = getFreq(arr, i);
            i += freq;
            int indexToPutIn = al.size();
            if (freq > 1) {
                while (freq > 0) {
                    int lastDigit = (freq % 10) + 48;
                    char c = (char) lastDigit;
                    al.add(indexToPutIn, c);
                    freq /= 10;
                }
            }
        }
        for (int a = 0; a < al.size(); a++) {
            arr[a] = al.get(a);
        }
        return al.size();
    }

}
