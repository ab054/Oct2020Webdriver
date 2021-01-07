import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class JavaEx01 {

    @Test
    public void test0001() {
        int myNumber = 5;

        int diffNumber = addTwo(myNumber);

        System.out.println(diffNumber);

        Assert.assertEquals(diffNumber,7);
    }

    public int addTwo(int parameter) {
        int result = parameter + 2;
        return result;
    }


    @Test
    public void test0002() {
        int myNumber = 7;
        int expectedValue = 4;

        int actualNumber = myNumber - 3;

        Assert.assertEquals(actualNumber, expectedValue);
    }


    @Test
    public void test0003() {
        String prefix = "Sentence: ";
        // Just using "" creates a string, so no need to write it the previous way.
        String sentence = "Who who who who!";                         // String literal stored in String pool
        // Java defined the operator + on strings to concatenate:
        String result = prefix + sentence;

        System.out.println(result);

        Assert.assertEquals(result, "Sentence: Who who who who!");
    }


    @Test
    public void testCombineTwoStrings() {
        String stringOne = "Hello Guys!";
        String stringTwo = "Let's start!";
        String newString = new String("value of the sting");

        String resultOfOutMethod = combineAndPrint(stringOne, stringTwo);

        Assert.assertEquals(resultOfOutMethod, "Hello Guys! Let's start!");
    }

    public String combineAndPrint(String stringParameterOne, String stringParameterTwo){
        String result;

        result = stringParameterOne + " " + stringParameterTwo;
        System.out.println(result);

        return result;
    }

    @Test
    public void testName() {
        int myNumber = 8;
        int divider = 2;
        int resultAfterDivision = 4;

        int reminder = 8%2;

        Assert.assertEquals(reminder, 0);

        if (reminder == 0) {
            System.out.println("Reminder is ZERO");
        } else {
            System.out.println("Reminder is NOT ZERO");
        }
    }


    @Test
    public void test0005() {
        boolean isVisible = false;

        if(isVisible){
            System.out.println("element is visible");
        } else {
            System.out.println("element is not visible");
        }
    }

    @Test
    public void testEvenNumber() {
        int el = 5;
        if ( el % 2 == 0){
            System.out.println("EL is EVEN number");
        } else {
            System.out.println("EL is ODD number");
        }
    }

    @Test
    public void testLogicalOperators() {
        boolean leftLight = true;
        boolean rightLight = true;

        boolean canWeDrive = leftLight && rightLight;

        if(canWeDrive){
            System.out.println("DRIVE");
        } else {
            System.out.println("CAR IS BROKEN");
        }
    }

    @Test
    public void testVisibleElements() {
        boolean isFirstButtonVisible = true;
        int numberOfSeconds = 3;
        boolean isFastEnough = numberOfSeconds < 5;

        if(isFastEnough && isFirstButtonVisible){
            System.out.println("CLICK");
        } else {
            System.out.println("NOTHING TO CLICK ON");
        }

    }


    @Test
    public void testArrays() {
        int[] arrayOfNumbers = {1, 2, 3, 4, 5};
        String[] arrayOfStrings = {"string01", "string02", "string03", "string04"};

        int arraysLength = arrayOfStrings.length;

        System.out.println(arraysLength);

        arrayOfStrings[3] = "newArrayValue";

        System.out.println(arrayOfStrings[3]);

        String convertedArray = Arrays.toString(arrayOfStrings);

        System.out.println(convertedArray);


        printStringArray(arrayOfStrings);
        printIntArray(arrayOfNumbers);
    }

    public void printStringArray(String[] arrayOfStrings){
        for (int i = 0; i < arrayOfStrings.length; i = i + 1) {
            System.out.println(arrayOfStrings[i]);
        }
    }

    public void printIntArray(int[] arrayOfStrings){
        for (int i = 0; i < arrayOfStrings.length; i = i + 1) {
            System.out.println(arrayOfStrings[i]);
        }
    }

    @Test
    public void testFindElement() {
        int[] inputArray = {1,2,3,4,5,6,8,9,22343,4,6,7,8};
        int valueToFind = 22343233;

        findElement(inputArray, valueToFind);
    }

    private void findElement(int[] inputArray, int elementToFind) {
        for(int i = 0; i < inputArray.length; i++){
            if(inputArray[i] == elementToFind){
                System.out.println("NUMBER " + elementToFind + " IS FOUND");
            }
        }
    }

    @Test
    public void testPoint() {
        Point myNewPoint = new Point(3, 4);

        Point myAnotherPoint = new Point(5, 6);

        int valueFromGetter = myNewPoint.getX();

        System.out.println(valueFromGetter);

    }

    @Test
    public void test009() {
        int a = 10;
        int b = 20;
        swap(a, b);

    }

    private void swap(int a, int b) {
        System.out.println("Before Swap");
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After Swap");
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    @Test
    public void testMyBike() {
        Bicycle myBike01 = new Bicycle("green");

        myBike01.ride();

        String bikesColor = myBike01.getColor();

        Assert.assertEquals(bikesColor, "green");
    }

    @Test
    public void testMountainBike() {
        MountainBike myNewBike = new MountainBike("blue");

        myNewBike.jump();

        Assert.assertEquals(myNewBike.getColor(), "blue");
    }
}
