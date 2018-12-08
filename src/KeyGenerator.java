class KeyGenerator {
    private final int valueA = 47;
    private final int valueB = 31;
    private final int valueC = 91;
    private String keyA;
    private String keyB;
    private String keyC;
    private String password;

    KeyGenerator(String password){
        if(password.length() < 4)
            throw new IllegalArgumentException("Password must be at least 4 characters long");
        keyA = createKeyA(password);
        keyB = createKeyB(password);
        keyC = createKeyC(password);
        this.password = password;
    }

    private String createKeyA(String password){
        int[] vector = Operations.textToVector(password);
        int[] xorWithValA = Operations.xorVector(vector, valueA);
        int[] rotatedVector = Operations.rotateVector(xorWithValA, 7);
        int[] chainedVector = Operations.chainXorVector(rotatedVector);
        int[] incVector = Operations.addToVector(chainedVector, valueA);
        return Operations.vectorToText(incVector);
    }
    private String createKeyB(String password){
        int[] vector = Operations.textToVector(password);
        int[] xorWithValB = Operations.xorVector(vector, valueB);
        int[] rotatedVector = Operations.rotateVector(xorWithValB, 11);
        int[] chainedVector = Operations.chainXorVector(rotatedVector);
        int[] incVector = Operations.addToVector(chainedVector, 2*valueB);
        return Operations.vectorToText(incVector);
    }
    private String createKeyC(String password){
        int[] vector = Operations.textToVector(password);
        int[] iter = Operations.addIterToVector(Operations.textToVector(keyB), 3);
        int[] xorIter = Operations.xorWithVector(vector, iter);
        int[] xorKeyA = Operations.xorWithVector(xorIter, Operations.textToVector(keyA));
        int[] chainedVector = Operations.chainXorVector(xorKeyA);
        int[] xorValC = Operations.xorVector(chainedVector, valueC);
        return Operations.vectorToText(xorValC);
    }

    int esincos2(int i){
        int x, e, s, m, d, c;
        e = (int)(Math.exp(i%7)*10);
        m = i%11;
        d = i%5;
        s = (int)(Math.sin(e+m*d)*m*10+d)+110;
        c = (int)(Math.cos(m*d*e)*Math.cos(m*m)*10);
        x = s-c;
        return x;
    }

    String createSubKey(int seed){
        int[] a = Operations.textToVector(keyA);
        int[] b = Operations.textToVector(keyB);
        int[] c = Operations.textToVector(keyC);
        int[] p = Operations.textToVector(password);

        int esc = esincos2(seed);
        int[] x = Operations.xorWithVector(p, a);
        int[] x2 = Operations.xorWithVector(x, b);
        int[] x3 = Operations.xorWithVector(x2, c);
        int[] xch = Operations.chainXorVector(x3);
        int[] xit = Operations.addIterToVector(xch, -1);

        int[] aandb = Operations.andWithVector(a, b);
        int[] xorab = Operations.xorWithVector(xit, aandb);
        int[] xesc = Operations.addToVector(xorab, esc);
        int[] result = Operations.chainXorVector(xesc);
        return Operations.vectorToText(result);
    }

    String getKeyA() {
        return keyA;
    }

    String getKeyB() {
        return keyB;
    }

    String getKeyC() {
        return keyC;
    }
}
