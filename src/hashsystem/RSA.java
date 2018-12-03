package hashsystem;

/**
 *
 * @author Maciek
 */
public class RSA {

    public static String encode(PublicKey key, String text) {
        StringBuilder cryptogram=new StringBuilder();
        for(int i=0;i<text.length();i++){
            long t=text.charAt(i);
            cryptogram.append(powMod(t,key.getE(),key.getN())+" ");
        }
        return cryptogram.toString();
    }

    public static String decode(PrivateKey key, String cryptogram) {
        StringBuilder text=new StringBuilder();
        String crypt[]=cryptogram.split(" ");
        for(int i=0;i<crypt.length;i++){          
            long c=Long.parseLong(crypt[i]);
            text.append((char)powMod(c,key.getD(),key.getN()));
        }
        return text.toString();
    }

    public static Key[] generateKeys(long p, long q) {
        long n = p * q;
        long fi = (p - 1) * (q - 1);
        long e;
        while (true) {
            e = (long) (Math.random() * fi);
            if (gcd(e, fi) == 1) {
                break;
            }
        }
        long d = modInv(e, fi);
        Key keys[] = new Key[2];
        keys[0] = new PublicKey(n, d);
        keys[1] = new PrivateKey(n, e);
        return keys;
    }

    private static long powMod(long a, long b, long m) {
        int i;
        long result = 1;
        long x = a % m;

        for (i = 1; i <= b; i <<= 1) {
            x %= m;
            if ((b & i) != 0) {
                result *= x;
                result %= m;
            }
            x *= x;
        }
        return result;
    }

    private static long modInv(long a, long b) {
        long u, w, x, z, q;
        u = 1;
        w = a;
        x = 0;
        z = b;
        while (w > 0) {
            if (w < z) {
                q = u;
                u = x;
                x = q;
                q = w;
                w = z;
                z = q;
            }
            q = w / z;
            u -= q * x;
            w -= q * z;
        }
        if (z == 1) {
            if (x < 0) {
                x += b;
            }
            return x;
        } else {
            return -1;
        }
    }

    private static long gcd(long a, long b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
