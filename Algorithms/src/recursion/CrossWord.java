package recursion;

import java.io.*;
import java.util.*;

public class CrossWord {

    // Complete the crosswordPuzzle function below.
    static String[] crosswordPuzzle(String[] crossword, String words) {
        String[] strings = words.split(";");
        Map<String, Boolean> map = new LinkedHashMap<>();
        for (String str : strings) {
            map.put(str, false);
        }
        char[][] puzzle = new char[10][10];
        for (int i = 0; i < 10; i++) {
            puzzle[i] = crossword[i].toCharArray();
        }
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 10; j++) {
                if (puzzle[i][j] == '-' || Character.isAlphabetic(puzzle[i][j])) {
                    int column = recursivecolumn(puzzle, i, j);
                    setWordC(puzzle, i, j, column, map);
                    int row = recursiverow(puzzle, i, j);
                    setWord(puzzle, i, j, row, map);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(puzzle[i]);
            crossword[i] = sb.toString();
        }
        return crossword;

    }




    private static int recursivecolumn(char[][] crossword, int i, int j) {
        if (i == 10 || j == 10 || (crossword[i][j] != '-' && !Character.isAlphabetic(crossword[i][j]))) {
            return 0;
        }

        int column = 0;
        char c = crossword[i][j];

        if (c == '-' || Character.isAlphabetic(c)) {
            column++;
            column += recursivecolumn(crossword, i, j+1);
        }
        return column;

    }

    private static void setWordC(char[][] crossword, int i, int j, int column, Map<String, Boolean> map) {
        if (j-1 >= 0 && j+column < 10) {
            if(crossword[i][j-1] == '-' || crossword[i][j+column] == '-')
                return;
            if((Character.isAlphabetic(crossword[i][j-1]) && crossword[i][j-1] != 'X')
                    || (Character.isAlphabetic(crossword[i][j+column]) && crossword[i][j+column] != 'X'))
                return;
        }
        if (j-1 < 0 && j+column < 10) {
            if(crossword[i][j+column] == '-')
                return;
            if(Character.isAlphabetic(crossword[i][j+column]) && crossword[i][j+column]!= 'X')
                return;
        }
        if (j-1 >= 0 && j+column >= 10) {
            if(crossword[i][j-1] == '-')
                return;
            if(Character.isAlphabetic(crossword[i][j-1]) && crossword[i][j-1] != 'X')
                return;
        }
        Set<String> set = map.keySet();
        for (String str: set) {
            if (!map.get(str) && str.length() == column) {
                boolean match = true;
                int index = 0;
                for (int x = j; x < column; x++) {
                    char temp = crossword[i][x];
                    if (Character.isAlphabetic(temp)) {
                        if (str.charAt(index) == temp) {
                            index++;
                            continue;
                        } else {
                            match = false;
                            break;
                        }
                    }
                    index++;
                }
                if (!match)
                    continue;
                for(int m =0; m < column; m++) {
                    crossword[i][j++] = str.charAt(m);
                }
                map.put(str, true);
                break;
            }
        }
    }

    private static int recursiverow(char[][] crossword, int i, int j) {
        if (i == 10 || j == 10 || (crossword[i][j] != '-' && !Character.isAlphabetic(crossword[i][j]))) {
            return 0;
        }

        int row = 0;
        char c = crossword[i][j];

        if (c == '-'  || Character.isAlphabetic(c)) {
            row++;
            row += recursiverow(crossword, i+1, j);
        }

        return row;
    }

    private static void setWord(char[][] crossword, int i, int j, int row, Map<String, Boolean> map) {
        if (i-1 >= 0 && i+row < 10) {
            if(crossword[i-1][j] == '-' || crossword[i+row][j] == '-')
                return;
            if((Character.isAlphabetic(crossword[i-1][j]) && crossword[i-1][j] !='X')
                    || (Character.isAlphabetic(crossword[i+row][j]) && crossword[i+row][j] !='X'))
                return;
        }
        if (i-1 < 0 && i+row < 10) {
            if(crossword[i+row][j] == '-')
                return;
            if(Character.isAlphabetic(crossword[i+row][j]) && crossword[i+row][j] !='X')
                return;
        }
        if (i-1 >= 0 && i+row >= 10) {
            if(crossword[i-1][j] == '-')
                return;
            if(Character.isAlphabetic(crossword[i-1][j])  && crossword[i-1][j] !='X')
                return;
        }
        Set<String> set = map.keySet();
        for (String str: set) {
            if (!map.get(str) && str.length() == row) {
                boolean match = true;
                int index = 0;
                for (int x = i; x < row; x++) {
                    char temp = crossword[x][j];
                    if (Character.isAlphabetic(temp)) {
                        if (str.charAt(index) == temp) {
                            index++;
                            continue;
                        } else {
                            match = false;
                            break;
                        }
                    }
                    index++;
                }
                if (!match)
                    continue;
                for(int m =0; m < row; m++) {
                    crossword[i++][j] = str.charAt(m);
                }
                map.put(str, true);
                break;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] crossword = new String[10];
        crossword[0] = "+-++++++++";
        crossword[1] = "+-++++++++";
        crossword[2] = "+-------++";
        crossword[3] = "+-++++++++";
        crossword[4] = "+-++++++++";
        crossword[5] = "+------+++";
        crossword[6] = "+-+++-++++";
        crossword[7] = "+++++-++++";
        crossword[8] = "+++++-++++";
        crossword[9] = "++++++++++";


        String[] result = crosswordPuzzle(crossword, "AGRA;NORWAY;ENGLAND;GWALIOR");

    }
}

