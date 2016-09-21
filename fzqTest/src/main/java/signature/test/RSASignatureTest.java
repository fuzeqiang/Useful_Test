package signature.test;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fuzeqiang(100918) on 2016/8/12 0012.
 */
public class RSASignatureTest {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String PUBLIC_KEY = "public";
    public static final String PRIVATE_KEY = "private";

    private static final Map<String, Object> keyMap;
    public static final String SIGNATURE_ALGORITHM = "MD5WithRSA";

    static {
        keyMap = new HashMap<String, Object>();
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        KeyPair pair = keyPairGenerator.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) pair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) pair.getPrivate();
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
    }

    public static byte[] getPublicKey() {
        RSAPublicKey key = (RSAPublicKey) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    public static byte[] getPrivateKey() {
        RSAPrivateKey key = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    public static byte[] sign(byte[] data, byte[] privateKeyByte) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyByte);
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = factory.generatePrivate(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verify(byte[] data, byte[] publicKeyByte, byte[] sign) throws Exception{
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyByte);
        KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = factory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(sign);
    }

    public static void main(String[] args) throws Exception {
        byte[] publicKey = getPublicKey();
        byte[] privateKey = getPrivateKey();
//        System.out.println("public key:" + publicKey);
//        System.out.println("private key:" + privateKey);
        byte[] sign = sign("tes t".getBytes(), privateKey);
        System.out.println(verify("test".getBytes(), publicKey, sign));
    }

}
