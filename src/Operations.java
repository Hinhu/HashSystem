public class Operations {

    public static int[] textToVector(String text){
        int[] vector = new int[text.length()];
        char[] chars = text.toCharArray();
        for(int i=0; i<text.length(); i++){
            vector[i] = (int)chars[i];
        }
        return vector;
    }

    public static int[] addToVector(int[] vector, int delta){
        for(int i=0; i<vector.length; i++)
            vector[i] += delta;
        return vector;
    }

    public static int[] xorVector(int[] vector, int xorValue){
        for(int i=0; i<vector.length; i++)
            vector[i] = vector[i] ^ xorValue;
        return vector;
    }

    public static int[] rotateBitwiseVector(int[] vector, int distance){
        for(int i=0; i<vector.length; i++){
            vector[i] = Integer.rotateRight(vector[i], distance);
        }
        return vector;
    }

    public static String vectorToText(int[] vector){
        char[] chars = new char[vector.length];
        for(int i=0; i<vector.length; i++)
            chars[i] = (char)vector[i];
        String text = String.valueOf(chars);
        return text;
    }

    public static int[] rotateVector(int[] vector, int distance){
        int[] tmp = new int[vector.length];
        System.arraycopy(vector, 0, tmp, 0, vector.length);
        for(int i=0; i<vector.length; i++){
            int vectPos = distance < 0 ? (i-distance)%vector.length : (i+distance)%vector.length;
            tmp[i] = vector[vectPos];
        }
        return tmp;
    }

    public static int[] addIterToVector(int[] vector, int iterStep){
        for(int i=0; i<vector.length; i++){
            vector[i] += i*iterStep;
        }
        return vector;
    }

    public static int[] addVectorToVector(int[] vector, int[] addVect){
        if(vector.length != addVect.length)
            throw new IllegalArgumentException("Vectors have different length");
        for(int i=0; i<vector.length; i++)
            vector[i] += addVect[i];
        return vector;
    }

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


    public static void main(String[] args){
        int a = 11;
    }
}

