package array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SiblingSearch {

    public static void main(String[] args) throws IOException {

        int[] inputArray = new int[] {1, 2, 3, 4, 5, 6,7};
        int siblingsToFindOf = 5;
        int[] results = findSiblings(inputArray.length, inputArray, siblingsToFindOf);//lenth as array len

        for(int i=0;i<results.length;i++){ //be aware of output arrays item by item. println cant print arrays as well
            System.out.print(String.valueOf(results[i]) + ",");
        }

    }

    public static int[] findSiblings(int input1, int[] input2, int input3) {
        int[] result = new int[] {-1};
        if (input2[0] == input3) {
            return result;
        }

        boolean isSibling = false;
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i=0;i<input2.length;i++){
            int x = 0;
            list = new ArrayList<>();
            while (x < (Math.pow(2, j)) && x < input2.length) {
                if(input2[i]==input3) { //If element at i position is search element
                    isSibling = true;
                } else {
                    list.add(input2[i]);
                }
                i++;
                x++;
            }
            if (isSibling) {
                break;
            }
            i--;
            j++;
        }
        if (!isSibling)
            return result;

        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;

    }
}
