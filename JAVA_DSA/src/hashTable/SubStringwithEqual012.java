package hashTable;
import java.util.HashMap;
public class SubStringwithEqual012 {
	public static void main(String args[]) {
		String str = "0102010";
		System.out.println(count(str));
	}
	public static long count(String str) {
		int zc=0,zt=0,zo=0,result=0;
		HashMap<String,Integer> help = new HashMap<String,Integer>();
		String toPut ="0*0";
		help.put(toPut,1);
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i) == '1') {
				zo++;
			}else if(str.charAt(i) == '2') {
				zt++;
			}else {
				zc++;
			}
			String toPut2 = (zc-zo) + "*"+ (zc-zt);
			if(help.containsKey(toPut2)) {
				result+=help.get(toPut2);
				help.put(toPut2,help.get(toPut2)+1);
			}
			help.putIfAbsent(toPut2,1);
//			result+=help.getOrDefault(toPut2,0);
//			help.put(toPut2,help.getOrDefault(toPut2,0)+1);
		}
		return result;
	}

}
