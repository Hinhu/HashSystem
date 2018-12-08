public final class Operations {

    /* converts String to int[] of ASCII codes */
    static int[] textToVector(String text){
        int[] vector = new int[text.length()];
        char[] chars = text.toCharArray();
        for(int i=0; i<text.length(); i++){
            vector[i] = (int)chars[i];
        }
        return vector;
    }

    /* increases each element of vector by certain value */
    static int[] addToVector(int[] vector, int delta){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] + delta;
        return result;
    }

    /* XORs each element with xorValue */
    static int[] xorVector(int[] vector, int xorValue){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] ^ xorValue;
        return result;
    }

    /* applies bitwise rotation on each element of vector */
    static int[] rotateBitwiseVector(int[] vector, int distance){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++){
            result[i] = Integer.rotateRight(vector[i], distance);
        }
        return result;
    }

    /* converts int[] of ASCII codes to String */
    static String vectorToText(int[] vector){
        char[] chars = new char[vector.length];
        for(int i=0; i<vector.length; i++)
            chars[i] = (char)vector[i];
        String text = String.valueOf(chars);
        return text;
    }

    /* rotates elements of vector */
    static int[] rotateVector(int[] vector, int distance){
        int[] tmp = new int[vector.length];
        System.arraycopy(vector, 0, tmp, 0, vector.length);
        for(int i=0; i<vector.length; i++){
            int vectPos = distance < 0 ? (i-distance)%vector.length : (i+distance)%vector.length;
            tmp[i] = vector[vectPos];
        }
        return tmp;
    }

    /* increments each element by its index multiplied by iterStep */
    static int[] addIterToVector(int[] vector, int iterStep){
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++){
            result[i] = vector[i] + i*iterStep;
        }
        return result;
    }

    /* increases each value from base vector by proper value from second vector */
    static int[] addVectorToVector(int[] vector, int[] addVect){
        if(vector.length != addVect.length)
            throw new IllegalArgumentException("Vectors have different length");
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] + addVect[i];
        return result;
    }

    /* XORs i'th element with i+1'th. Last element is XORed with the first of modified vector */
    static int[] chainXorVector(int[] vector){
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
    static int[] reversedChainXorVector(int[] vector){
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
    static int[] xorWithVector(int[] vector, int[] secondVector){
        if(vector.length != secondVector.length)
            throw new IllegalArgumentException("Vectors have different length");
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] ^ secondVector[i];
        return result;
    }

    /* ANDs each value from vector with proper value from second vector */
    static int[] andWithVector(int[] vector, int[] secondVector){
        if(vector.length != secondVector.length)
            throw new IllegalArgumentException("Vectors have different length");
        int[] result = new int[vector.length];
        for(int i=0; i<vector.length; i++)
            result[i] = vector[i] & secondVector[i];
        return result;
    }

    public static void main(String[] args) {
        String pass = "Haslo";
        String text = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...";
        KeyGenerator keygen = new KeyGenerator(pass);
        String keyA = keygen.getKeyA();
        String keyB = keygen.getKeyB();
        String keyC = keygen.getKeyC();

        System.out.println("PASS: "+pass);
        System.out.println("A: "+keyA);
        System.out.println("B: "+keyB);
        System.out.println("C: "+keyC);

        int[] a = Operations.textToVector(keyA);
        int[] b = Operations.textToVector(keyB);
        int[] c = Operations.textToVector(keyC);
        int[] p = Operations.textToVector(pass);

        int esc = keygen.esincos2(0);
        int[] x = Operations.xorWithVector(p, a);
        int[] x2 = Operations.xorWithVector(x, b);
        int[] x3 = Operations.xorWithVector(x2, c);
        int[] xch = Operations.chainXorVector(x3);
        int[] xit = Operations.addIterToVector(xch, -1);

        int[] aandb = Operations.andWithVector(a, b);
        int[] xorab = Operations.xorWithVector(xit, aandb);
        int[] xesc = Operations.addToVector(xorab, esc);
        int[] result = Operations.chainXorVector(xesc);
        System.out.println("SUBKEY: "+Operations.vectorToText(Operations.addToVector(result, 0)));
    }
}

