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

    public String createKeyA(String password){return new String();}
    public String createKeyB(String password){return new String();}
    public String createKeyC(String password){return new String();}
}
