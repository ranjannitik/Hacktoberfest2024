import java.util.*;

class Solution {
    public static List<Integer> mergeKSortedArrays(List<List<Integer>> arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<Integer> result = new ArrayList<>();

        // Add the first element of each array to the heap
        for (int i = 0; i < arrays.size(); i++) {
            if (!arrays.get(i).isEmpty()) {
                minHeap.offer(new int[] {arrays.get(i).get(0), i, 0});
            }
        }

        // Extract minimum element and add the next element from the same array
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int arrayIndex = current[1];
            int elementIndex = current[2];

            result.add(value);

            if (elementIndex + 1 < arrays.get(arrayIndex).size()) {
                minHeap.offer(new int[] {arrays.get(arrayIndex).get(elementIndex + 1), arrayIndex, elementIndex + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(
            Arrays.asList(1, 5, 8),
            Arrays.asList(2, 3, 7),
            Arrays.asList(4, 6, 9)
        );

        List<Integer> mergedArray = mergeKSortedArrays(arrays);
        System.out.println(mergedArray);
    }
}
