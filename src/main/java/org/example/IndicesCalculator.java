package org.example;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alen bakovic
 */
public class IndicesCalculator {

    public List<Pair<Integer, Integer>> getIndices(int sum, int[] array) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> indexedArray = getElementIndexes(array);
        for (int i = 0; i < array.length; i++) {
            if (indexedArray.get(sum - array[i]) != null) {
                final int index = i; // to be used in lambda
                indexedArray.get(sum - array[i])
                        .stream()
                        .filter(elementIndex -> index < elementIndex) // this will prevent duplicates
                        .forEach(elementIndex -> result.add(Pair.with(index, elementIndex)));
            }
        }
        return result;
    }

    private Map<Integer, List<Integer>> getElementIndexes(int[] array) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (indexes.get(array[i]) == null) {
                indexes.put(array[i], new ArrayList<>(List.of(i)));
            } else {
                indexes.get(array[i]).add(i);
            }
        }
        return indexes;
    }
}
