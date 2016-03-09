package ioter.commonadapter.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bin on 7/12/15.
 * 所有实体类的基类，封装了一些通用的属性字段
 */
public class BaseBean implements Parcelable {

    protected int code;
    protected String codeMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public BaseBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.codeMsg);
    }

    protected BaseBean(Parcel in) {
        this.code = in.readInt();
        this.codeMsg = in.readString();
    }

    public static final Creator<BaseBean> CREATOR = new Creator<BaseBean>() {
        public BaseBean createFromParcel(Parcel source) {
            return new BaseBean(source);
        }

        public BaseBean[] newArray(int size) {
            return new BaseBean[size];
        }
    };
}

