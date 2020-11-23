package com.lin.canteen.bean;

//数据库对象
public class Consume {
    private int mId;
    private int cNum;
    private int cDate;
    private Menu menu; //映射对象，用于联表查询

    @Override
    public String toString() {
        return "Consume{" +
                "mId=" + mId +
                ", cNum=" + cNum +
                ", cDate=" + cDate +
                ", menu=" + menu +
                '}';
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

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }
}
