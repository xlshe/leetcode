import java.util.LinkedList;
import java.util.PriorityQueue;

public class SellStock_IV {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> profit = new PriorityQueue<>(prices.length, new CompareInt());
        LinkedList<Pair> queue = new LinkedList<>();
        int valey = 0;
        int peak = -1;
        do {
            valey = peak + 1;
            while(valey < prices.length-1 && prices[valey] >= prices[valey+1]) {
                valey ++;
            }
            peak = valey + 1;
            while (peak < prices.length-1 && prices[peak] <= prices[peak+1]) {
                peak ++;
            }

            if (peak > prices.length-1) {
                break;
            }


            while (true) {
                if (queue.isEmpty()) {
                    break;
                }

                Pair pair = queue.getFirst();
                if (prices[valey] < prices[pair.v]) {
                    profit.add(prices[pair.p] - prices[pair.v]);
                    queue.pop();
                    continue;
                } else if (prices[peak] >= prices[pair.p]) {
                    profit.add(prices[pair.p] - prices[valey]);
                    queue.pop();
                    valey = pair.v;
                } else {
                    break;
                }
            }
            queue.push(new Pair(valey, peak));
        } while(true);

        while (!queue.isEmpty()) {
            Pair pair = queue.pop();
            profit.add(prices[pair.p] - prices[pair.v]);
        }

        int cnt = 0, total = 0;
        while (!profit.isEmpty() && (cnt < k)) {
            total += profit.poll();
            cnt ++;
        }
        return total;
    }

    private class CompareInt implements Comparator<Integer> {

        @Override
        public int compare (Integer x, Integer y) {
            return y.compareTo(x);
        }
    }

    private class Pair {
        public int v;
        public int p;

        public Pair(int valey, int peak) {
            v = valey;
            p = peak;
        }
    }
}
