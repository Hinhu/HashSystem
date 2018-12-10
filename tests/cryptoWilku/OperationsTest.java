package cryptoWilku;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class OperationsTest {

    /* textToVector method tests */
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


    /* rotateBitwiseVector method tests */
    @Test
    public void rightRotateBitwiseVector(){
        int[] startingVector = {28, 99, 115, 210};
        int distance = 25;
        int[] expectedVector = {3584, 12672, 14720, 26880};
        assertArrayEquals(expectedVector, Operations.rotateBitwiseVector(startingVector, distance));
    }

    @Test
    public void leftRotateBitwiseVector(){
        int[] startingVector = {17, 205, 25, 11};
        int distance = -4;
        int[] expectedVector = {272, 3280, 400, 176};
        assertArrayEquals(expectedVector, Operations.rotateBitwiseVector(startingVector, distance));
    }


    /* vectorToText method tests */
    @Test
    public void testPositiveValues(){
        int[] startingVector = {68, 122, 96, 56};
        String expectedText = "Dz`8";
        assertEquals(expectedText, Operations.vectorToText(startingVector));
    }

    @Test
    public void testNegativeValues(){
        int[] startingVector = {-20000, -35000, -45123};
        String expectedText = "뇠睈侽";
        assertEquals(expectedText, Operations.vectorToText(startingVector));
    }

    @Test
    public void testEmptyVector(){
        int[] startingVector = {};
        String expectedText = "";
        assertEquals(expectedText, Operations.vectorToText(startingVector));
    }

    /* rotateVector method tests */
    @Test
    public void rotateRightVector(){
        int[] startingVector = {67, 27, 83, 55};
        int distance = 2;
        int[] expectedVector = {83, 55, 67, 27};
        assertArrayEquals(expectedVector, Operations.rotateVector(startingVector, distance));
    }

    @Test
    public void rotateLeftVector(){
        int[] startingVector = {102, 89, 56, 111};
        int distance = -1;
        int[] expectedVector = {89, 56, 111, 102};
        assertArrayEquals(expectedVector, Operations.rotateVector(startingVector, distance));
    }

    /* addIterToVector method tests */
    @Test
    public void addPositiveIterToVector(){
        int[] startingVector = {67, 57, 200, 143};
        int iterStep = 2;
        int[] expectedVector = {67, 59, 204, 149};
        assertArrayEquals(expectedVector, Operations.addIterToVector(startingVector, iterStep));

    }

    @Test
    public void addNegativeIterToVector(){
        int[] startingVector = {155, 127, 76};
        int iterStep = -1;
        int[] expectedVector = {155, 126, 74};
        assertArrayEquals(expectedVector, Operations.addIterToVector(startingVector, iterStep));

    }

    /* addVectorToVector method tests */
    @Test
    public void addPositiveVector(){
        int[] startingVector = {100, 162, 99, 56};
        int[] secondVector = {56, 22, 109, 78};
        int[] expectedVector = {156, 184, 208, 134};
        assertArrayEquals(expectedVector, Operations.addVectorToVector(startingVector, secondVector));
    }

    @Test
    public void addNegativeVector(){
        int[] startingVector = {200, 158, 109};
        int[] secondVector = {-67, -42, -112};
        int[] expectedVector = {133, 116, -3};
        assertArrayEquals(expectedVector, Operations.addVectorToVector(startingVector, secondVector));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addVectorDifferentSize(){
        int[] startingVector = {175, 89, 157};
        int[] secondVector = {156, -142, 642, 251};
        Operations.addVectorToVector(startingVector, secondVector);
    }

    @Test
    public void addTwoEmptyVectors(){
        int[] startingVector = {};
        int[] secondVector = {};
        int[] expectedVector = {};
        assertArrayEquals(expectedVector, Operations.addVectorToVector(startingVector, secondVector));
    }

    /* chainXorVector method test */
    @Test
    public void chainXorVector(){
        int[] startingVector = {27, 37, 45, 15};
        int[] expectedVector = {62, 8, 34, 49};
        assertArrayEquals(expectedVector, Operations.chainXorVector(startingVector));
    }

    @Test
    public void chainXorOneElementVector(){
        int[] startingVector = {65};
        int[] expectedVector = {65};
        assertArrayEquals(expectedVector, Operations.chainXorVector(startingVector));
    }

    @Test
    public void chainXorEmptyVector(){
        int[] startingVector = {};
        int[] expectedVector = {};
        assertArrayEquals(expectedVector, Operations.chainXorVector(startingVector));
    }

    /* reversedChainXorVector method test */
    @Test
    public void reversedChainXorVector(){
        int[] startingVector = {62, 8, 34, 49};
        int[] expectedVector = {27, 37, 45, 15};
        assertArrayEquals(expectedVector, Operations.reversedChainXorVector(startingVector));
    }

    @Test
    public void reversedChainXorOneElementVector(){
        int[] startingVector = {56};
        int[] expectedVector = {56};
        assertArrayEquals(expectedVector, Operations.reversedChainXorVector(startingVector));
    }

    @Test
    public void reversedChainXorEmptyVector(){
        int[] startingVector = {};
        int[] expectedVector = {};
        assertArrayEquals(expectedVector, Operations.reversedChainXorVector(startingVector));
    }

    /* xorWithVector method tests */
    @Test
    public void xorWithPositiveVector(){
        int[] startingVector = {22, 67, 91};
        int[] secondVector = {72, 56, 112};
        int[] expectedVector = {94, 123, 43};
        assertArrayEquals(expectedVector, Operations.xorWithVector(startingVector, secondVector));
    }

    @Test
    public void xorWithNegativeVector(){
        int[] startingVector = {141, 46, 110};
        int[] secondVector = {-15, -78, -189};
        int[] expectedVector = {-132, -100, -211};
        assertArrayEquals(expectedVector, Operations.xorWithVector(startingVector, secondVector));
    }

    @Test
    public void xorBothEmptyVectors(){
        int[] startingVector = {};
        int[] secondVector = {};
        int[] expectedVector = {};
        assertArrayEquals(expectedVector, Operations.xorWithVector(startingVector, secondVector));
    }

    @Test(expected = IllegalArgumentException.class)
    public void xorWithVectorDifferentSize(){
        int[] startingVector = {156, 26, 22};
        int[] secondVector = {91, 72, 187, 281};
        Operations.xorWithVector(startingVector, secondVector);
    }


    /* andWithVector method tests */
    @Test
    public void andWithPositiveVector(){
        int[] startingVector = {22, 67, 91};
        int[] secondVector = {72, 56, 112};
        int[] expectedVector = {0, 0, 80};
        assertArrayEquals(expectedVector, Operations.andWithVector(startingVector, secondVector));
    }

    @Test
    public void andWithNegativeVector(){
        int[] startingVector = {141, 46, 110};
        int[] secondVector = {-15, -78, -189};
        int[] expectedVector = {129, 34, 66};
        assertArrayEquals(expectedVector, Operations.andWithVector(startingVector, secondVector));
    }

    @Test
    public void andBothEmptyVectors(){
        int[] startingVector = {};
        int[] secondVector = {};
        int[] expectedVector = {};
        assertArrayEquals(expectedVector, Operations.andWithVector(startingVector, secondVector));
    }

    @Test(expected = IllegalArgumentException.class)
    public void andWithVectorDifferentSize(){
        int[] startingVector = {156, 126, 122};
        int[] secondVector = {191, 272, 187, 281, 90};
        Operations.andWithVector(startingVector, secondVector);
    }





}