package com.lin.canteen.bean;

//数据库对象
public class Consume {
    private int mId;
    private int cNum;
    private int cDate;
    private int cDelivery;
    private int cMale;
    private float mSum;
    private String mName;
    private float mPrice;
    private int mWindow;
    private int mCanteen;
    private int mCategory;

    public int getcDelivery() {
        return cDelivery;
    }

    public void setcDelivery(int cDelivery) {
        this.cDelivery = cDelivery;
    }

    public int getcMale() {
        return cMale;
    }

    public void setcMale(int cMale) {
        this.cMale = cMale;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public int getcDate() {
        return cDate;
    }

    public void setcDate(int cDate) {
        this.cDate = cDate;
    }

    public float getmSum() {
        return cNum * mPrice;
    }

    public void setmSum(float mSum) {
        this.mSum = mSum;
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
