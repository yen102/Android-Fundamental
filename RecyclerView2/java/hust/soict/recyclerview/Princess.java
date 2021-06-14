package hust.soict.recyclerview;

public class Princess {
    private  String mName;
    private int mImage;

    public Princess(String mName, int mImage) {
        this.mImage = mImage;
        this.mName = mName;
    }
    public String getName(){
        return mName;
    }
    public void setName(String mName) {
        this.mName = mName;
    }

    public int getImage() {
        return mImage;
    }
    public void setImage(int mImage){
        this.mImage = mImage;
    }
}
