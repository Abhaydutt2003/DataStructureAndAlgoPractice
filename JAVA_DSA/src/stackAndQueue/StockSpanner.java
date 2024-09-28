package stackAndQueue;

import java.util.Stack;
public class StockSpanner {

    Stack<SpanNode> s;
    public StockSpanner() {
        s = new Stack<SpanNode>();
    }
    
    public int next(int price) {
        int toReturn = 1;
        while(s.isEmpty() != false){
            if(s.peek().a<=price){
                toReturn+=s.pop().b;
            }else{
                break;
            }
        }
        SpanNode sn = new SpanNode(price, toReturn);
        s.push(sn);
        return toReturn;
    }
}
class SpanNode{
    int a;
    int b;
    SpanNode(int a, int b){
        this.a = a;this.b = b;
    }
}
