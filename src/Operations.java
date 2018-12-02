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
    public static int[] addIterToVector(int[] vector, int iterStep){return new int[]{};}
    public static int[] addVectorToVector(int[] vector, int[] addVect){return new int[]{};}
    public static int[] chainXorVector(int[] vector){return new int[]{};}
    public static int[] reversedChainXorVector(int[] vector){return new int[]{};}


    public static void main(String[] args){
        int a = 11;
    }
}

