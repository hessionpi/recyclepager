package com.hition.recycle.pager.view.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.hition.recycle.pager.R;
import com.hition.recycle.pager.model.BaseResponse;
import com.hition.recycle.pager.model.MeiTu;
import com.hition.recycle.pager.presenter.impl.MeiTuPresenter;
import com.hition.recycle.pager.view.IView;
import com.hition.recycle.pager.view.ui.adapter.MeiTuAdapter;
import com.hition.recycle.pager.view.ui.adapter.recycleview.XMBaseAdapter;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView<List<MeiTu>> {

    @BindView(R.id.rv_meitu)
    RecyclerView mRvMeitu;

    private MeiTuPresenter presenter;
    private MeiTuAdapter adapter;
    private int pageNo = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        presenter = new MeiTuPresenter(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRvMeitu.setLayoutManager(layoutManager);
        adapter = new MeiTuAdapter(this);
        mRvMeitu.setAdapter(adapter);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRvMeitu);
        adapter.setMore(R.layout.view_recyclerview_more,new OnLoadMoreMeituListener());

        presenter.getMeitus(pageNo);
    }

    @Override
    public void onPrepare() {

    }

    @Override
    public void onComplete(BaseResponse<List<MeiTu>> data, int flag) {
        if(data.getCode() == 200){
            List<MeiTu> bookList = data.getData();
            if(null != bookList && !bookList.isEmpty()){
                adapter.addAll(bookList);
            }
        }else{
            Toast.makeText(this,data.getMsg(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailShow(int errorCode) {

    }

    private class OnLoadMoreMeituListener implements XMBaseAdapter.OnLoadMoreListener {
        @Override
        public void onLoadMore() {
            pageNo ++ ;
            presenter.getMeitus(pageNo);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onUnsubscribe();
    }

}
