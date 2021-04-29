package com.lin.canteen.bean;

//食堂总览一二echarts图对象
public class Canteen {
    private int cNum;
    private int cDelivery;
    private int cMale;
    private int mId;
    private float mPrice;
    private int mCanteen;
    private double mSum;

    public int getcNum() {
        return cNum;
    }

    public void setcNum(int cNum) {
        this.cNum = cNum;
    }

    public int getmId() {
        return mId;
    }

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

    public void setmId(int mId) {
        this.mId = mId;
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
        return cNum * mPrice;
    }

    public void setmSum(float mSum) {
        this.mSum = mSum;
    }
}
