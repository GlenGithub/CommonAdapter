package ioter.commonadapter.item;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import ioter.adapter.AdapterItem;
import ioter.commonadapter.R;
import ioter.commonadapter.model.ModelBean;


/**
 * Created by bin on 7/12/15.
 * 优化小技巧：这个就等于一个viewHolder，用于复用，所以不会重复建立对象
 */
public class ButtonItem implements AdapterItem<ModelBean> {


    @Bind(R.id.button)
    Button button;
    private int mPosition;

    @Override
    public int getLayoutResId() {
        return R.layout.item_button;
    }

    @Override
    public void onBindViews(final View root) {
        //注意此处不能漏掉
        ButterKnife.bind(this, root);
    }

    /**
     * @tips 优化小技巧：在这里直接设置按钮的监听器。
     * 因为这个方法仅仅在item建立时才调用，所以不会重复建立监听器。
     */
    @Override
    public void onInitViews() {
        // item构建时回调，不会重复建立监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(button.getContext(), "position = " + mPosition, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onUpdateViews(ModelBean model, int position) {
        // 在每次适配器getView的时候就会触发，这里避免做耗时的操作
        mPosition = position;
        button.setText(model.content);
    }

}
