package com.lin.canteen.bean;

//食堂分览一二echarts图对象
public class Window {
    private int cNum;
    private String mName;
    private float mPrice;
    private int mCanteen;
    private int mWindow;
    private double mSum;

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
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

    public double getmSum() {
        return cNum*mPrice;
    }

    public void setmSum(double mSum) {
        this.mSum = mSum;
    }
}
