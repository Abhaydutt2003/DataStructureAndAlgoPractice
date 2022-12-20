package adityaVermaBinarySearch;

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[] = {'c','f','j'};
		System.out.print(nextGreaterLetter(arr,'e'));

	}
	public static char nextGreaterLetter(char [] letters,char target) {
		char res = letters[0];
		int start =0,end = letters.length-1,mid = 0;
		int toCompare =(int)target;
		while(start<=end) {
			mid = start + (end-start)/2;
			int a = (int)letters[mid];
			if(a>toCompare) {
				res = letters[mid];
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	}

}
