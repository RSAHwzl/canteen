package com.lin.canteen.bean;

//数据库对象
public class Menu {
    private int mId;
    private String mName;
    private float mPrice;
    private int mWindow;
    private int mCanteen;
    private int mCategory;

    @Override
    public String toString() {
        return "Menu{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mPrice=" + mPrice +
                ", mWindow=" + mWindow +
                ", mCanteen=" + mCanteen +
                ", mCategory=" + mCategory +
                '}';
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public float getmPrice() {
        return mPrice;
    }

    public void setmPrice(float mPrice) {
        this.mPrice = mPrice;
    }

    public int getmWindow() {
        return mWindow;
    }

    public void setmWindow(int mWindow) {
        this.mWindow = mWindow;
    }

    public int getmCanteen() {
        return mCanteen;
    }

    public void setmCanteen(int mCanteen) {
        this.mCanteen = mCanteen;
    }

    public int getmCategory() {
        return mCategory;
    }

    public void setmCategory(int mCategory) {
        this.mCategory = mCategory;
    }

}
