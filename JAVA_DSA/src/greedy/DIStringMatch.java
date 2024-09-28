package greedy;

public class DIStringMatch {
    public static void main(String args[]){
        String s = "DDI";
        int arr[]= diStringMatch(s);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static int[] diStringMatch(String s){
        int low = 0,high = s.length();
        int ans[] = new int[s.length()+1];
        int k =0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == 'D'){
                ans[k] = high;
                k++;
                high--;
            }else{
                ans[k] = low;
                low++;
                k++;
            }
        }
        ans[k] = low;
        return ans;
    } 
    
}
