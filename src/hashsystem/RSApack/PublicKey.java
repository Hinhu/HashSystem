/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem.RSApack;

/**
 *
 * @author Maciek
 */
public class PublicKey implements Key{

    private long n;
    private long e;

    public PublicKey(long n, long e) {
        this.n = n;
        this.e = e;
    }

    public long getN() {
        return n;
    }

    public long getE() {
        return e;
    }

}
