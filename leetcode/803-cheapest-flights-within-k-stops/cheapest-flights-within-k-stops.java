class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            prices[i] = Integer.MAX_VALUE;
        }

        for (int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adjList.get(from).add(new int[] {to, price});
        }

        Queue<int[]> pq = new LinkedList<>();

        pq.add(new int[] {src, 0, 0});
        prices[src] = 0;

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int flight = node[0];
            int currPrice = node[1];
            int stops = node[2];

            for(int[] next : adjList.get(flight)){
                int nFlight = next[0];
                int nPrice = currPrice + next[1];
                

                if(nPrice < prices[nFlight] && stops <= k){
                    prices[nFlight] = nPrice;
                    pq.add(new int[] {nFlight, nPrice, stops + 1});
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}