class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }

        double[] dist = new double[n];
        dist[start_node] = 1.0;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            double prob = curr.prob;

            if (node == end_node) return prob;
            if (prob < dist[node]) continue;

            for (Pair nei : adj.get(node)) {
                double newProb = prob * nei.prob;
                if (newProb > dist[nei.node]) {
                    dist[nei.node] = newProb;
                    pq.add(new Pair(nei.node, newProb));
                }
            }
        }
        return 0.0;
    }
}

class Pair {
    int node;
    double prob;
    Pair(int n, double p) {
        node = n;
        prob = p;
    }
}
    