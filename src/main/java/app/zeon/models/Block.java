package app.zeon.models;

public class Block {

    private String hash;

    private String previousHash;

    public Block(){

    }

    public Block(String hash, String previousHash) {
        this.hash = hash;
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "hash='" + hash + '\'' +
                ", previousHash='" + previousHash + '\'' +
                '}';
    }
}

