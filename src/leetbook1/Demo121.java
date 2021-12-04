package leetbook1;

/**
 * @Author: lwa
 * @Date: 2021/12/4 17:00
 */
public class Demo121 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxMoney = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }else if(prices[i]-minPrice>maxMoney){
                maxMoney = prices[i]-minPrice;
            }
        }
        return maxMoney;
    }
}
