package ioter.commonadapter.model;


/**
 * Created by bin on 7/12/15.
 * 我们的实体类一般会继承自BaseBean
 */
public class ModelBean extends BaseBean{

    public String content;

    public String type;
    /**
     * model中决定数据类型的字段
     */
    public Object getDataType() {
        return type;
    }

}
