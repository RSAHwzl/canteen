package com.lin.canteen.bean;

//食堂总览一二echarts图对象
public class Canteen {
    private int cNum;
    private String mName;
    private float mPrice;
    private int mCanteen;
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

    public double getmSum() {
        return cNum*mPrice;
    }

    public void setmSum(float mSum) {
        this.mSum = mSum;
    }
}
