package p63股票的最大利润;

/**
 * ClassName p63股票的最大利润
 * Description TODO 股票的最大利润
 * Author 30712
 * Date 2021-07-02
 * Time 21:58
 */
public class Solution {
    /**
     *
     * @param prices 股票的价格按照时间先后顺序存储在数组中
     * @return
     */
    public int maxProfit(int[] prices) {
        //股票的最大利润
        //卖出的价格需要大于买入的价格，那么就把买入的价格作为最小值，再后序的元素中找卖出的价格
        /**
         * 买股票在最低点买股票最好
         * 只需要遍历价格数组一边，记录历史最低点，在每一天再考虑：
         *  如果我是在历史最低点买进的，那么我今天卖出能赚多少钱？当考虑完所有的天数时，就得到了最好的答案
         * 时间复杂度：O（n）遍历一次数组
         */
        if(prices == null || prices.length <=1){
            return 0;
        }
        int result =0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }else{
                result = Math.max(result,prices[i]-min);
            }
        }
        return result;
    }
}
