package br.gov.go.saude.security.crypt.test;

import br.gov.go.saude.security.crypt.AESencrp;

public class AEStest {

	public static void main(String[] args) throws Exception {

        String text = "portal";
        String textEnc = AESencrp.encrypt(text, "TheBestSecretKey");
        String textDec = AESencrp.decrypt(textEnc, "TheBestSecretKey");

        System.out.println("Plain Text : " + text);
        System.out.println("Encrypted Text : " + textEnc);
        System.out.println("Decrypted Text : " + textDec);
	}

}