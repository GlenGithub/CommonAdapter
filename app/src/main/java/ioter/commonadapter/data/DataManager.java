package ioter.commonadapter.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ioter.commonadapter.model.ModelBean;

/**
 * Created by bin on 7/12/15.
 */
public class DataManager {

    /**
     * 初始化数据
     */
    public static List<ModelBean> loadData(Context context) {
        List<ModelBean> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int type = (int) (Math.random() * 3);
            ModelBean model = new ModelBean();
            switch (type) {
                case 0:
                    model.type = "text";
                    model.content = "测试数据" + i;
                    break;
                case 1:
                    model.type = "button";
                    model.content = "测试数据" + i;
                    break;
                case 2:
                    model.type = "image";
                    model.content = "http://www.google.com";
                    break;
                default:
            }
            list.add(model);
        }
        return list;
    }
}
