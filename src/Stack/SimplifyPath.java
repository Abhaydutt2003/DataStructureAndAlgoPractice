package stackAndQueues;

import java.util.*;

public class SimplifyPath {
	
	public static void main(String args[]) {
		String path = "/home/../aloo/asdasd/./ddfdf/../";
		System.out.print(util1(path));
	}
	
	
	//using str.split
	public static String util1(String path) { 
		String arr[] = path.split("/");
		Stack<String> s = new Stack<String>();
		for(String str:arr) {
			if(str.equals("..")){
				if(s.size()>0) {
					s.pop();
				}
			}else if(str.equals("") || str.equals(".") ){
				//do nothing
			}else {
				s.push(str);
			}
		}
		String ans = "";
		while(s.size() >0) {
			ans = "/"+s.pop()+ans;
		}
		if(ans.equals("")) {
			return "/";
		}else {
			return ans;
		}
	}
	
	
	
	
	
	
	
	

}
