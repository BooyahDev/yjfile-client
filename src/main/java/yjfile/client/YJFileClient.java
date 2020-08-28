package yjfile.client;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class YJFileClient {
    private String baseUrl = "https://file.yjsnpi.club/";
    private String parentDir;
    private YJFileDirectory fileDirectory;

    public YJFileClient(String baseUrl, String parentDir) throws YJFileClientException {
        this.baseUrl = baseUrl;
        this.parentDir = parentDir;
        requestAPI();
    }

    public YJFileClient(String parentDir) throws YJFileClientException {
        this.parentDir = parentDir;
        requestAPI();
    }

    private  void requestAPI() throws YJFileClientException {

        try {
            List<String> files = new ArrayList<>();
            String url = baseUrl+parentDir;

            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("table tbody tr td a");
            for (Element element : elements) {
                if (!element.attr("title").equals("Delete") &&
                        !element.attr("href").equals("../") && !element.attr("title").equals("Rename")){
                    String img = element.text();
                    if (img.endsWith("/")) {
                        img = img.substring(0, img.length() - 1);
                    }
                    img = URLEncoder.encode(img, "UTF-8");
                    String fileUrl = url+"/"+img;
                    fileUrl = fileUrl.replaceAll("(?<!(http:|https:))[//]+", "/");
                    files.add(fileUrl);
                }
            }
            fileDirectory = new YJFileDirectory(parentDir,files);
        }catch (IOException e) {
            throw new YJFileClientException(e);
        }
    }

    public List<String> getFileList() {
        return fileDirectory.getFileList();
    }

    public String getParentPath() {
        return fileDirectory.getPath();
    }
}
