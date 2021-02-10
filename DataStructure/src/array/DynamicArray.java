package array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAns = 0;
        List<List<Integer>> seqList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<>());
        }
        List<Integer> list = new ArrayList<>();
        for (List<Integer> q : queries) {
            int rowIndex = ((q.get(1) ^ lastAns) % n);
            int y = q.get(2);
            if (q.get(0) == 1) {
                seqList.get(rowIndex).add(y);
            } else if (q.get(0) == 2) {
                int colIndex = y % seqList.get(rowIndex).size();
                lastAns = seqList.get(rowIndex).get(colIndex);
                list.add(lastAns);

            }
        }
        return list;
    }

}

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/HackerRank/text.txt"));

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
