package app.zeon.models;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

/**
 *
 */
public class ZPackage {

    private String description;

    private String title;

    private byte[] signature;

    private static final LocalDateTime createdAt = LocalDateTime.now(ZoneOffset.UTC);

    public ZPackage(byte[] signature) {
        this.signature = signature;
    }

    public ZPackage(String description, String title, byte[] signature) {
        this.description = description;
        this.title = title;
        this.signature = signature;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public byte[] getSignature() {
        return signature;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "ZPackage{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", createdAt=" + createdAt +
                '}';
    }
}
