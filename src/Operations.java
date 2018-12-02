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
    
    public static int[] xorVector(int[] vector, int xorValue){ return new int[]{};}
    public static int[] rotateBitwiseVector(int[] vector, int distance){ return new int[]{};}
    public static String vectorToText(int[] vector){return "";}
    public static int[] rotateVector(int[] vector, int distance){return new int[]{};}
    public static int[] addIterToVector(int[] vector, int iterStep){return new int[]{};}
    public static int[] addVectorToVector(int[] vector, int[] addVect){return new int[]{};}
    public static int[] chainXorVector(int[] vector){return new int[]{};}
    public static int[] reversedChainXorVector(int[] vector){return new int[]{};}


    public static void main(String[] args){
        int a = 11;
    }
}

