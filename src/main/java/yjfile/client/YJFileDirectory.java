package yjfile.client;

import java.util.ArrayList;
import java.util.List;

public class YJFileDirectory {
    private String path;
    private List<String> fileList;

    public YJFileDirectory(String path, List<String> fileList) {
        this.path = path;
        this.fileList = fileList;
    }

    public String getPath() {
        return path;
    }

    public List<String> getFileList() {
        return fileList;
    }
}
