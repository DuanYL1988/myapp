package com.app.dto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.app.util.CommonUtils;
import com.app.util.JsonUtil;

public class Gallery {

    private String basePath;

    private List<Album> album;

    private String jsonText;

    public static void main(String[] args) {
        Gallery thisCl = new Gallery();
        thisCl.createObject("C:\\Users\\dylsw\\OneDrive\\图片\\gif");
    }

    public String createObject(String path) {
        Gallery gallery = new Gallery();
        gallery.basePath = path;
        gallery.album = new ArrayList<Gallery.Album>();
        loopFolder(path, gallery.album);

        JsonUtil jsonUtil = new JsonUtil();
        String rst = jsonUtil.praseObjToJson(gallery);
        System.out.println(rst);
        return rst;
    }

    private void loopFolder(String basePath, List<Album> albumGp) {
        File base = new File(basePath);
        File[] children = base.listFiles();

        Album album = new Album();
        album.setPath(base.getPath());

        List<String> images = new ArrayList<String>();

        for (File child : children) {
            if (child.isDirectory()) {
                loopFolder(child.getAbsolutePath(), albumGp);
            } else {
                CommonUtils util = new CommonUtils();
                if (util.isImage(child.getName())) {
                    images.add(child.getAbsolutePath());
                }
            }
        }

        album.setImages(images);

        if (images.size() > 0) {
            albumGp.add(album);
        }
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public String getJsonText() {
        return jsonText;
    }

    public void setJsonText(String jsonText) {
        this.jsonText = jsonText;
    }

    class Album {
        private String path;

        private List<String> images;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

}
