package ioter.commonadapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ioter.adapter.AdapterItem;
import ioter.adapter.CommonAdapter;
import ioter.adapter.CommonRcvAdapter;
import ioter.commonadapter.data.DataManager;
import ioter.commonadapter.item.ButtonItem;
import ioter.commonadapter.item.ImageItem;
import ioter.commonadapter.item.TextItem;
import ioter.commonadapter.model.ModelBean;

/**
 * Created by bin on 7/12/15.
 */
public class MainActivity extends Activity {

    @Bind(R.id.listView)
    ListView listView;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_listview)
    void showListView() {
        listView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        if (listView.getAdapter() == null) {
            listView.setAdapter(new CommonAdapter<ModelBean>(DataManager.loadData(getBaseContext())) {

               /* @Override
                public Object getItemViewType(ModelBean modelBean) {
                    return modelBean.getDataType();
                }*/

                @NonNull
                @Override
                public AdapterItem<ModelBean> getItemView(Object type) {
                    return new TextItem();
                }
            });
        } else {
            ((CommonAdapter) listView.getAdapter()).updateData(DataManager.loadData(getBaseContext()));
        }
    }

    @OnClick(R.id.btn_recview)
    void showRecyclerView() {
        recyclerView.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);

        if (recyclerView.getAdapter() == null) {
            addDataToRecyclerView(DataManager.loadData(getBaseContext()));
        } else {
            if (recyclerView.getAdapter() instanceof CommonRcvAdapter) {
                ((CommonRcvAdapter<ModelBean>) recyclerView.getAdapter()).updateData(DataManager.loadData(getBaseContext()));
            }
        }
    }

    private void addDataToRecyclerView(List<ModelBean> data) {
        //GridLayoutManager layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.setRecycleChildrenOnDetach(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new CommonRcvAdapter<ModelBean>(data) {


            @Override
            public Object getItemViewType(ModelBean item) {
                return item.getDataType();

            }

            @NonNull
            @Override
            public AdapterItem<ModelBean> getItemView(Object type) {
                return initItem(type);
            }
        });
    }

    private AdapterItem<ModelBean> initItem(Object type) {
        switch ((String) type) {
            case "text":
                return new TextItem();
            case "button":
                return new ButtonItem();
            case "image":
                return new ImageItem();
            default:
                return new TextItem();
        }
    }


}
