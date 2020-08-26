package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author alen bakovic
 */
public class IndicesCalculatorTest {

    IndicesCalculator indicesCalculator = new IndicesCalculator();

    @Test
    public void test1() {
        int [] input = new int[]{ 7, 5, -3, 15, 7 , 5, 5, 5, 5, -3 };
        int sum = 12;

        var result = indicesCalculator.getIndices(sum, input);
        var expected = "[[0, 1], [0, 5], [0, 6], [0, 7], [0, 8], [1, 4], [2, 3], [3, 9], [4, 5], [4, 6], [4, 7], [4, 8]]";

        Assert.assertEquals(result.toString(), expected);
    }

    @Test
    public void test2() {
        int [] input = new int[]{ 7, 5, 5 };
        int sum = 12;

        var result = indicesCalculator.getIndices(sum, input);
        var expected = "[[0, 1], [0, 2]]";

        Assert.assertEquals(result.toString(), expected);
    }

    @Test
    public void test3() {
        int [] input = new int[]{ 7, 5 };
        int sum = 12;

        var result = indicesCalculator.getIndices(sum, input);
        var expected = "[[0, 1]]";

        Assert.assertEquals(result.toString(), expected);
    }

    @Test
    public void test4() {
        int [] input = new int[]{ 1 };
        int sum = 12;

        var result = indicesCalculator.getIndices(sum, input);
        var expected = "[]";

        Assert.assertEquals(result.toString(), expected);
    }

    @Test
    public void test5() {
        int [] input = new int[]{ 7, 3, -3, 13, 13, -5, 15, -5, 3 };
        int sum = 10;

        var result = indicesCalculator.getIndices(sum, input);
        var expected = "[[0, 1], [0, 8], [2, 3], [2, 4], [5, 6], [6, 7]]";

        Assert.assertEquals(result.toString(), expected);
    }
}
