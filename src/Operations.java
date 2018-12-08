import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Operations {

    /* converts String to int[] of ASCII codes */
    public static int[] textToVector(String text){
        int[] vector = new int[text.length()];
        char[] chars = text.toCharArray();
        for(int i=0; i<text.length(); i++){
            vector[i] = (int)chars[i];
        }
        return vector;
    }

    /* increases each element of vector by certain value */
    public static int[] addToVector(int[] vector, int delta){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] + delta;
        return result;
    }

    /* XORs each element with xorValue */
    public static int[] xorVector(int[] vector, int xorValue){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] ^ xorValue;
        return result;
    }

    /* applies bitwise rotation on each element of vector */
    public static int[] rotateBitwiseVector(int[] vector, int distance){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++){
            result[i] = Integer.rotateRight(vector[i], distance);
        }
        return result;
    }

    /* converts int[] of ASCII codes to String */
    public static String vectorToText(int[] vector){
        char[] chars = new char[vector.length];
        for(int i=0; i<vector.length; i++)
            chars[i] = (char)vector[i];
        String text = String.valueOf(chars);
        return text;
    }

    /* rotates elements of vector */
    public static int[] rotateVector(int[] vector, int distance){
        int[] tmp = new int[vector.length];
        System.arraycopy(vector, 0, tmp, 0, vector.length);
        for(int i=0; i<vector.length; i++){
            int vectPos = distance < 0 ? (i-distance)%vector.length : (i+distance)%vector.length;
            tmp[i] = vector[vectPos];
        }
        return tmp;
    }

    /* increments each element by its index multiplied by iterStep */
    public static int[] addIterToVector(int[] vector, int iterStep){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++){
            result[i] = vector[i] + i*iterStep;
        }
        return result;
    }

    /* increases each value from base vector by proper value from second vector */
    public static int[] addVectorToVector(int[] vector, int[] addVect){
        if(vector.length != addVect.length)
            throw new IllegalArgumentException("Vectors have different length");
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] + addVect[i];
        return result;
    }

    /* XORs i'th element with i+1'th. Last element is XORed with the first of modified vector */
    public static int[] chainXorVector(int[] vector){
        if(vector.length == 0)
            return new int[]{};
        if(vector.length == 1)
            return vector;
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length-1; i++){
            result[i] = vector[i] ^ vector[i+1];
        }
        result[result.length-1] = vector[vector.length-1] ^ result[0];
        return result;
    }

    /* XORs i'th element with i-1'th, starting from last element of vector */
    public static int[] reversedChainXorVector(int[] vector){
        if(vector.length == 0)
            return new int[]{};
        if(vector.length == 1)
            return vector;
        int[] result = new int[vector.length];
        result[vector.length-1] = vector[vector.length-1] ^ vector[0];
        for(int i=vector.length-2; i>=0; i--)
            result[i] = vector[i] ^ result[i+1];
        return result;
    }

    /* XORs each value from vector with proper value from second vector */
    public static int[] xorWithVector(int[] vector, int[] secondVector){
        if(vector.length != secondVector.length)
            throw new IllegalArgumentException("Vectors have different length");
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] ^ secondVector[i];
        return result;
    }

    /* ANDs each value from vector with proper value from second vector */
    public static int[] andWithVector(int[] vector, int[] secondVector){
        if(vector.length != secondVector.length)
            throw new IllegalArgumentException("Vectors have different length");
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] & secondVector[i];
        return result;
    }

    public static void main(String[] args) {
        int[] t = {84, 111, 112, 83, 101, 99, 114, 101, 116};
        int[] i = Operations.addIterToVector(t, 3);
        int[] x = Operations.xorWithVector(t, i);

        List<Integer> list = Arrays.stream(x).boxed().collect(Collectors.toList());

        System.out.println(list);
    }
}

