package ioter.commonadapter.item;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ioter.adapter.AdapterItem;
import ioter.commonadapter.R;
import ioter.commonadapter.model.ModelBean;

/**
 * Created by bin on 7/12/15.
 */
public class TextItem implements AdapterItem<ModelBean> {

    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_time_finish)
    TextView tvTimeFinish;
    @Bind(R.id.tv_des)
    TextView tvDes;

    @Override
    public int getLayoutResId() {
        return R.layout.item_text;
    }

    @Override
    public void onBindViews(View root) {
        //注意此处不能漏掉
        ButterKnife.bind(this, root);
    }

    @Override
    public void onInitViews() {
        Log.d(TextItem.class.getSimpleName(), "onSetViews--------->");
    }

    @Override
    public void onUpdateViews(ModelBean model, int position) {
        tvName.setText(model.content);
        tvTimeFinish.setText(model.content);
        tvDes.setText(model.content);
    }

}

