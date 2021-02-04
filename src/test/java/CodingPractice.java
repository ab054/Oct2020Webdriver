import org.junit.Test;

import java.util.Arrays;

public class CodingPractice {

    //1. create a method which take input array, index of the left element, index of the right element
    //2. using indexes and temp variable, perform a 3-step swap
    //3. print values of the array
    @Test
    public void swapTwoNumbersInArray() throws Exception {
        int[] array = {1, 2, 3, 4};
        int[] expectedResult = {1, 3, 2, 4};

        swap(array, 1, 2);
        printArray(array); //expected: {1,3,2,4}
    }

    @Test
    public void swap_Exception() throws Exception {
        int[] array = {1, 2, 3, 4};
        swap(array, 1, 5);
        printArray(array); //expected: {1,3,2,4}
    }

    private void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private void swap(int[] array, int indexL, int indexR) throws Exception {
        if (indexL > array.length || indexR > array.length) {
            throw new Exception("Input index are not within the bounds of array");
        }

        int temp = array[indexL];
        array[indexL] = array[indexR];
        array[indexR] = temp;
    }
}
