package Easy.Best_Time_to_Buy_and_Sell_Stock;

public class bestTimeToBuyAndSellSolution {
    

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
        You want to maximize your profit by choosing a single day to buy one stock and choosing a 
        different day in the future to sell that stock. Return the maximum profit you can achieve from this
        transaction. If you cannot achieve any profit, return 0.
     * @param args
     */

     public static int maxProfit(int[] prices){
        int minVal = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minVal){
                minVal = prices[i];
                continue;
            }
            maxValue = Math.max(maxValue,  prices[i] - minVal);
        }
        return maxValue == Integer.MIN_VALUE ? 0 : maxValue;
     }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,3,5,6,4}) == 5);
        System.out.println(maxProfit(new int[] {7,6,5,4,3,2}) == 0);
    }
}
