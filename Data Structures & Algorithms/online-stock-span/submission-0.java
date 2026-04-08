class StockSpanner {

    private Stack<Integer> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        st.push(price);

        Stack<Integer> tmp = new Stack<>();

        int span = 0;

        while (!st.isEmpty() && st.peek() <= price){
            int top = st.pop();
            // System.out.println(String.format("price=%d, popped=%d",price,top));
            tmp.push(top);
            span++;
        }

        while (!tmp.isEmpty()){
            st.push(tmp.pop());
        }

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */