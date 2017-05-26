package droidudes.fix.it.modules.livewall.models;

import java.util.List;

/**
 * Created by Zare Ahmed on 12/15/2016.
 */
public class LiveWallPostBO {

    private String title;
    private String description;
    private List<String> imagePaths;
    private int typeOfPost;

    public int getTypeOfPost() {
        return typeOfPost;
    }

    public void setTypeOfPost(int typeOfPost) {
        this.typeOfPost = typeOfPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImagePaths() {
        return imagePaths;
    }

    public void setImagePaths(List<String> imagePaths) {
        this.imagePaths = imagePaths;
    }
}
