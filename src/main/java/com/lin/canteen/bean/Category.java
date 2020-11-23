package com.lin.canteen.bean;

public class Category {
    private int cNum;
    private float mPrice;
    private double mSum;
    private int mCanteen;
    private int mWindow;
    private int mCategory;

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public float getmPrice() {
        return mPrice;
    }

    public void setmPrice(float mPrice) {
        this.mPrice = mPrice;
    }

    public double getmSum() {
        return cNum*mPrice;
    }

    public void setmSum(double mSum) {
        this.mSum = mSum;
    }

    public int getmCategory() {
        return mCategory;
    }

    public void setmCategory(int mCategory) {
        this.mCategory = mCategory;
    }

    public int getmCanteen() {
        return mCanteen;
    }

    public void setmCanteen(int mCanteen) {
        this.mCanteen = mCanteen;
    }

    public int getmWindow() {
        return mWindow;
    }

    public void setmWindow(int mWindow) {
        this.mWindow = mWindow;
    }
}
