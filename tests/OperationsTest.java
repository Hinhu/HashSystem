import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    /* textToVector method tests */
    /* converts String to int[] of ASCII codes */
    @Test
    public void textToVectorOrdinaryValues(){
        String text = "Testowe znaki";
        int[] expectedVector = {84, 101, 115, 116, 111, 119, 101, 32, 122, 110, 97, 107, 105};
        assertArrayEquals(expectedVector, Operations.textToVector(text));
    }

    @Test
    public void textToVectorExtendedValues(){
        String text = "śćąóÓŁźŹŻ";
        int[] expectedVector = {347, 263, 261, 243, 211, 321, 378, 377, 379};
        assertArrayEquals(expectedVector, Operations.textToVector(text));
    }

    @Test
    public void emptyTextToVector(){
        String text = "";
        int[] expectedVector = {};
        assertArrayEquals(expectedVector, Operations.textToVector(text));
    }


    /* addToVector method tests */
    /* increases each element of vector by certain value */
    @Test
    public void positiveIncreaseOfVector(){
        int[] startingVector = {26, 36, 84, 11, 86, 231, 223};
        int delta = 5;
        int[] expectedVector = {31, 41, 89, 16, 91, 236, 228};
        assertArrayEquals(expectedVector, Operations.addToVector(startingVector, delta));
    }

    @Test
    public void negativeIncreaseOfVector(){
        int[] startingVector = {57, 83, 78, 39, 30};
        int delta = -10;
        int[] expectedVector = {47, 73, 68, 29, 20};
        assertArrayEquals(expectedVector, Operations.addToVector(startingVector, delta));
    }


    /* xorVector method tests */
    /* XORs each element with xorValue */
    @Test
    public void xorByPositiveValue(){
        int[] startingVector = {74, 26, 99, 15, 58};
        int xorValue = 42;
        int[] expectedVector = {96, 48, 73, 37, 16};
        assertArrayEquals(expectedVector, Operations.xorVector(startingVector, xorValue));
    }

    @Test
    public void xorByNegativeValue(){
        int[] startingVector = {62, 78, 192, 111};
        int xorValue = -13;
        int[] expectedVector = {-51, -67, -205, -100};
        assertArrayEquals(expectedVector, Operations.xorVector(startingVector, xorValue));
    }


    /* rotateVector method tests */
    /* applies bitwise rotation on each element of vector */
    @Test
    public void rightRotateVector(){
        int[] startingVector = {28, 99, 115, 210};
        int distance = 25;
        int[] expectedVector = {3584, 12672, 14720, 26880};
        assertArrayEquals(expectedVector, Operations.rotateVector(startingVector, distance));
    }

    @Test
    public void leftRotateVector(){
        int[] startingVector = {17, 205, 25, 11};
        int distance = -4;
        int[] expectedVector = {272, 3280, 400, 176};
        assertArrayEquals(expectedVector, Operations.rotateVector(startingVector, distance));
    }

}