package task_general_type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class SortTable {
    public static void insertionSort(int[] sortArr, int [] dataSorted) {
        int j;
        for (int i = 1; i < sortArr.length; i++) {
            int swap = sortArr[i];
            int swapForSorted = dataSorted[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                sortArr[j] = sortArr[j - 1];
                dataSorted[j] = dataSorted [j - 1];
            }
            sortArr[j] = swap;
            dataSorted[j] = swapForSorted;
        }
    }

    public static List<String> getSortTable(int loops, List<int[][]>  allDataTable, int [] inputCountClick, List<int[]> inputNumberColumn, List<int[]> inputSizeArr) {
        List<String> endList = new ArrayList<>();
        for (int q = 0; q < loops; q++) {
            int [] sizeArr = inputSizeArr.get(q);
            int [] [] fromAllDataTab = allDataTable.get(q);
            List<int[]> dataTable = new ArrayList<>();
            for (int y = 0; y < sizeArr[0]; y++) {
                dataTable.add(y, fromAllDataTab[y]);
            }
            int countClick = inputCountClick[q];
            int [] fromInputNumColumn = inputNumberColumn.get(q);
            List<int[]> dataNumColumn = new ArrayList<>();
            dataNumColumn.add(fromInputNumColumn);
            int [] numberColumn = dataNumColumn.get(0);
            for (int w = 0; w < countClick; w++) {
                int clickColumn = numberColumn[w];
                int[] filledForSort = new int[dataTable.size()];
                for (int i = 0; i < dataTable.size(); i++) {
                    int[] copyData = dataTable.get(i);
                    filledForSort[i] = copyData[clickColumn - 1];
                }
                int[] dataSorted = new int[filledForSort.length];
                for (int g = 0; g < dataSorted.length; g++) {
                    dataSorted[g] = g;
                }
                insertionSort(filledForSort, dataSorted);
                List<int[]> newDataTable = new ArrayList<>();
                for (int i : dataSorted) {
                    newDataTable.add(dataTable.get(i));
                }
                for (int i = 0; (i < dataSorted.length) && ((w + 1) == countClick) ; i++) {
                    int [] forPutInEndList = newDataTable.get(i);
                    StringBuilder buildEndList = new StringBuilder();
                    for (int j = 0; j < forPutInEndList.length; j++) {
                        buildEndList.append(String.valueOf(forPutInEndList[j]));
                        if (j+1< forPutInEndList.length) {
                            buildEndList.append(" ");
                        }
                    }
                    endList.add(buildEndList.toString());
                }
                dataTable = newDataTable;
            }
            if (q + 1 < loops) {
                endList.add("");
            }
        }
        return endList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loops = Integer.parseInt(reader.readLine());
        ArrayList<int[][]> allDataTable = new ArrayList<>();
        ArrayList<int[]> allNumberColumn = new ArrayList<>();
        int [] countClick = new int[loops];

        List <int[]> outputSizeArr = new ArrayList<>();
        for (int i = 0; i < loops; i++) {
            String[] lineItems1 = reader.readLine().split(" ");
            lineItems1 = reader.readLine().split(" ");
            int [] sizeOfArray = {Integer.parseInt(lineItems1[0]), Integer.parseInt(lineItems1[1])};
            int [] [] buildArray = new int[sizeOfArray[0]][sizeOfArray[1]];
            outputSizeArr.add(sizeOfArray);
            for (int j = 0; j < sizeOfArray[0]; j++) {
                String[] lineItems2 = reader.readLine().split(" ");
                for (int k = 0; k < sizeOfArray[1]; k++) {
                    buildArray[j][k] = Integer.parseInt(lineItems2[k]);
                }
            }
            countClick[i] = Integer.parseInt(reader.readLine());
            String [] newLineItems = reader.readLine().split(" ");
            int [] numberColumn = new int[newLineItems.length];
            for (int k = 0; k < newLineItems.length; k++) {
                numberColumn[k] = Integer.parseInt(newLineItems[k]);
            }
            allDataTable.add(buildArray);
            allNumberColumn.add(numberColumn);
        }
        List<String> newList;
        newList = getSortTable(loops, allDataTable,countClick,allNumberColumn, outputSizeArr);
        for (String s : newList) {
            System.out.println(s);
        }
    }
}
