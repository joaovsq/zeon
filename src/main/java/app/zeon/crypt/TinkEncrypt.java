package app.zeon.crypt;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;

import java.security.GeneralSecurityException;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * A preconfigured wrapper around Google's Tink library
 */
public class TinkEncrypt implements Encrypt {

    private Aead aead;

    public TinkEncrypt() throws GeneralSecurityException {
        AeadConfig.register();

        KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES128_CTR_HMAC_SHA256);

        this.aead = AeadFactory.getPrimitive(keysetHandle);
    }

    @Override
    public byte[] encrypt(String payload, String key) throws GeneralSecurityException {
        return this.aead.encrypt(payload.getBytes(UTF_8), key.getBytes(UTF_8));
    }

    @Override
    public String decrypt(byte[] cipher, byte[] key) throws GeneralSecurityException {
        return new String(this.aead.decrypt(cipher, key), UTF_8);
    }

    @Override
    public String decrypt(byte[] cipher, String key) throws GeneralSecurityException {
        return new String(this.aead.decrypt(cipher, key.getBytes(UTF_8)), UTF_8);
    }

}
