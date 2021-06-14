package hust.soict.sportnews;

public class Sport {
    private String title;
    private String info;
    private int imageResource;
    Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getTitle() {
        return title;
    }
    void setTitle(String title) {
        this.title = title;
    }
    String getInfo() {
        return info;
    }
    void setInfo(String info) {
        this.info = info;
    }
    int getImageResource() {
        return imageResource;
    }
    void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
