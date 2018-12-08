public class KeyGenerator {
    private final int valueA = 47;
    private final int valueB = 31;
    private final int valueC = 91;
    private String keyA;
    private String keyB;
    private String keyC;

    public KeyGenerator(String password){
        keyA = createKeyA(password);
        keyB = createKeyB(password);
        keyC = createKeyC(password);
    }

    private String createKeyA(String password){return new String();}
    private String createKeyB(String password){return new String();}
    private String createKeyC(String password){return new String();}
    int esincos2(int i){ return 0; }

    public String getKeyA() {
        return keyA;
    }

    public void setKeyA(String keyA) {
        this.keyA = keyA;
    }

    public String getKeyB() {
        return keyB;
    }

    public void setKeyB(String keyB) {
        this.keyB = keyB;
    }

    public String getKeyC() {
        return keyC;
    }

    public void setKeyC(String keyC) {
        this.keyC = keyC;
    }



}




     /*
        int x, e, s, m, d, c;
        for(int i=0; i<200; i++){
            e = (int)(Math.exp(i%7)*10);
            m = i%11;
            d = i%5;
            s = (int)(Math.sin(e+m*d)*m*10+d)+110;
            c = (int)(Math.cos(m*d*e)*Math.cos(m*m)*10);
            x = s-c;
            System.out.println(x);
        }
*/
