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
        for(int i=0; i<vector.length; i++)
            vector[i] += delta;
        return vector;
    }

    /* XORs each element with xorValue */
    public static int[] xorVector(int[] vector, int xorValue){
        for(int i=0; i<vector.length; i++)
            vector[i] = vector[i] ^ xorValue;
        return vector;
    }

    /* applies bitwise rotation on each element of vector */
    public static int[] rotateBitwiseVector(int[] vector, int distance){
        for(int i=0; i<vector.length; i++){
            vector[i] = Integer.rotateRight(vector[i], distance);
        }
        return vector;
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
        for(int i=0; i<vector.length; i++){
            vector[i] += i*iterStep;
        }
        return vector;
    }

    /* increases each value from base vector by proper value from second vector */
    public static int[] addVectorToVector(int[] vector, int[] addVect){
        if(vector.length != addVect.length)
            throw new IllegalArgumentException("Vectors have different length");
        for(int i=0; i<vector.length; i++)
            vector[i] += addVect[i];
        return vector;
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
        for(int i=0; i<vector.length; i++)
            vector[i] = vector[i] ^ secondVector[i];
        return vector;
    }

    /* ANDs each value from vector with proper value from second vector */
    public static int[] andWithVector(int[] vector, int[] secondVector){
        if(vector.length != secondVector.length)
            throw new IllegalArgumentException("Vectors have different length");
        for(int i=0; i<vector.length; i++)
            vector[i] = vector[i] & secondVector[i];
        return vector;
    }

    public static void main(String[] args) {
        System.out.println((char)(Integer.MAX_VALUE));

    }
}

