package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FreqStack {

    Map<Integer, Integer> freq;
    PriorityQueue<int[]> pq;
    int idx;

    public FreqStack() {
        idx = 0;
        freq = new HashMap<>();
        // pq for int[] to store all frequency, idx and value
        pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                if (x[0] != y[0]) {
                    return y[0] - x[0];
                }
                return y[1] - x[1];
            }
        });
    }

    public void push(int x) {
        int count = freq.getOrDefault(x, 0);
        freq.put(x, count+1);

        pq.offer(new int[]{count+1, idx, x});
        idx++;
    }

    public int pop() {
        int val = pq.poll()[2];
        freq.put(val, freq.get(val) - 1);
        return val;
    }
}