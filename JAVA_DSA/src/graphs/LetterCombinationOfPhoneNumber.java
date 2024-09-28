package graphs;
import java.util.List;
import java.util.ArrayList;
public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		String digits = "23";
		List<String> ans = letterCombinations(digits);
		for(int i = 0;i<ans.size();i++) {
			System.out.print(ans.get(i)+" ");
		}
	}
	private static String[] getArr(char n) {
		String arr[];
		if(n == '2') {
			arr = new String[3];
			arr[0] = "a";arr[1] = "b";arr[2] = "c";
			return arr;
		}else if(n =='4') {
			arr = new String[3];
			arr[0] = "g";arr[1] = "h";arr[2] = "i";
			return arr;
		}else if(n == '3') {
			arr = new String[3];
			arr[0] = "d";arr[1] = "e";arr[2] = "f";
			return arr;
		}else if(n == '5') {
			arr = new String[3];
			arr[0] = "j";arr[1] = "k";arr[2] = "l";
			return arr;
		}else if(n == '6') {
			arr = new String[3];
			arr[0] = "m";arr[1] = "n";arr[2] = "o";
			return arr;
		}else if(n == '7') {
			arr = new String[4];
			arr[0] = "p";arr[1] = "q";arr[2] = "r";arr[3] = "s";
			return arr;
		}else if(n == '8') {
			arr = new String[3];
			arr[0] = "t";arr[1] = "u";arr[2] = "v";
			return arr;
		}else {
			arr = new String[4];
			arr[0] = "w";arr[1] = "x";arr[2] = "y";arr[3]="z";
			return arr;
		}
	}
	public static List<String> letterCombinations(String digits){
		if(digits.length() == 0){return new ArrayList<String>();}
		if(digits.length() == 1) {
			ArrayList<String> ans =new ArrayList<String>();
			String[] got = getArr(digits.charAt(0));
			for(int i = 0;i<got.length;i++) {
				ans.add(got[i]);
			}
			return ans;
		}
		List<String> small = letterCombinations(digits.substring(1));
		List<String> ans = new ArrayList<String>();
		String[] got = getArr(digits.charAt(0));
		int jLimit = small.size();
		for(int i = 0;i<got.length;i++) {
			String toAdd = got[i];
			for(int j = 0;j<jLimit;j++) {
				String Add = small.get(j);
				String Add2 = toAdd + Add;
				ans.add(Add2);
			}
		}
		return ans;
	}

}
