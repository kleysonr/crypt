package br.gov.go.saude.security.crypt;

/*
 * 
 * Source code from: http://www.code2learn.com/2011/06/encryption-and-decryption-of-data-using.html
 * 
 */

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*
 * 
 * AES 128 algorithm
 * 
 */
public class AESencrp {
	
	private static final String ALGO = "AES";

	public static String encrypt(String Data, String secretKey) throws Exception 
	{
        Key key = generateKey(secretKey);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData, String secretKey) throws Exception 
    {
        Key key = generateKey(secretKey);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    
    /*
     * Method to generate a secret key for AES algorithm with a given secret key.
     */
    private static Key generateKey(String secretKey) throws Exception 
    {
        Key key = new SecretKeySpec(secretKey.getBytes(), ALGO);
        return key;
    }	
	
}
