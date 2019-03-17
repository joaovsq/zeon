package app.zeon.crypt;

public interface Encrypt {

    byte[] encrypt(String payload, String key) throws Exception;

    String decrypt(byte[] cipher, byte[] key) throws Exception;

    String decrypt(byte[] cipher, String key) throws Exception;

}
