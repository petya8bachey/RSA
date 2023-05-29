import java.math.BigInteger;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random randomInteger = new Random();
        int bits = 1024;
        BigInteger p = BigInteger.probablePrime(bits, randomInteger);
        BigInteger q = BigInteger.probablePrime(bits, randomInteger);
        BigInteger n = p.multiply(q);
        BigInteger e = BigInteger.probablePrime(bits / 2, randomInteger);
        BigInteger d = e.modInverse(p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)));

        String message = "h" + "Нижегородский государственный технический университет";
        String code = String.valueOf((new BigInteger(message.getBytes())).modPow(e, n));
        //byte[] code = (new BigInteger(message.getBytes())).modPow(e, n).toByteArray();
        System.out.println(code);
        //System.out.println(new String(code));
        String decode = new String((new BigInteger(code)).modPow(d, n).toByteArray()).substring(1);
        //String decode = new String((new BigInteger(code1)).modPow(d, n).toByteArray())substring(1);
        System.out.println(decode);
    }
}