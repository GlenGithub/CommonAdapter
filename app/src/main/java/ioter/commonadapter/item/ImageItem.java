package ioter.commonadapter.item;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ioter.adapter.AdapterItem;
import ioter.commonadapter.R;
import ioter.commonadapter.model.ModelBean;


/**
 * Created by bin on 7/12/15.
 */
public class ImageItem implements AdapterItem<ModelBean> {

    @Bind(R.id.imageView)
    ImageView imageView;
    @Bind(R.id.textView)
    TextView textView;
    private String TAG = getClass().getSimpleName();

    @Override
    public int getLayoutResId() {
        return R.layout.item_image;
    }

    @Override
    public void onBindViews(View root) {
        //注意此处不能漏掉
        ButterKnife.bind(this, root);
    }

    @Override
    public void onInitViews() {
        Log.d(TAG, "onInitViews");
    }

    @Override
    public void onUpdateViews(ModelBean model, int position) {
        imageView.setImageResource(R.mipmap.ic_launcher);
        textView.setText(model.content);
    }

}
