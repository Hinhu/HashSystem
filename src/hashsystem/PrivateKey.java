/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashsystem;

/**
 *
 * @author Maciek
 */
public class PrivateKey implements Key{

    private long n;
    private long d;

    public PrivateKey(long n, long d) {
        this.n = n;
        this.d = d;
    }

    public long getN() {
        return n;
    }

    public long getD() {
        return d;
    }
}
