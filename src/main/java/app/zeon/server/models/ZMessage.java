package app.zeon.server.models;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import app.zeon.crypt.HashAlgorithm;

public class ZMessage {

    private List<ZPackage> packages;

    private static final LocalDateTime createdAt = LocalDateTime.now(ZoneOffset.UTC);

    private byte[] hash;

    private HashAlgorithm hashAlgorithm;

    public ZMessage() {
        // TODO
        hash = generateHash();
    }

    private byte[] generateHash() {
        // TODO
        return null;
    }

    public byte[] getHash() {
        return hash;
    }

    /**
     * @return the createdat
     */
    public LocalDateTime getCreatedat() {
        return createdAt;
    }

    /**
     * @return the hashAlgorithm
     */
    public HashAlgorithm getHashAlgorithm() {
        return hashAlgorithm;
    }

    /**
     * @return the packages
     */
    public List<ZPackage> getPackages() {
        return packages;
    }

    /**
     * @param hash the hash to set
     */
    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    /**
     * @param packages the packages to set
     */
    public void setPackages(List<ZPackage> packages) {
        this.packages = packages;
    }

}