package app.zeon.models;

import java.io.File;
import java.util.List;

public class ZPackage {

    private String description;

    private String title;

    private List<File> files;

    public ZPackage(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    /**
     * @return the files
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     * @param files the files to set
     */
    public void setFiles(List<File> files) {
        this.files = files;
    }

}
