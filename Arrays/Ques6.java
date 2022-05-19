package Arrays;

class Solution {

    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if (op < pist) {
                op = pist;
            }
        }
        return op;
    }
}
// https://stats.g.doubleclick.net/j/collect?t=dc&aip=1&_r=3&v=1&_v=j96&tid=UA-159258186-1&cid=540090133.1642766270&jid=1924345677&uid=5311354&gjid=485991939&_gid=1642412929.1652768967&_u=SCCAgAABAAAAAE~&z=385507825