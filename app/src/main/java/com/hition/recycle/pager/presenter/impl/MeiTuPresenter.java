package com.hition.recycle.pager.presenter.impl;

import com.hition.recycle.pager.model.BaseResponse;
import com.hition.recycle.pager.model.IListener;
import com.hition.recycle.pager.model.MeiTu;
import com.hition.recycle.pager.model.MeituModel;
import com.hition.recycle.pager.view.IView;

import java.util.List;

public class MeiTuPresenter extends BasePresenter implements IListener<List<MeiTu>>{

    private IView<List<MeiTu>> mView;
    private MeituModel mModel;

    public MeiTuPresenter(IView<List<MeiTu>> mView){
        this.mView = mView;
        mModel = new MeituModel(this);
    }

    public void getMeitus(int pageNo){
        mModel.getMeitus(pageNo);
    }

    @Override
    public void onSuccess(BaseResponse<List<MeiTu>> data, int flag) {
        if(null != data){
            mView.onComplete(data,0);
        }
    }

    @Override
    public void onFailed(Throwable e, int flag) {
        mView.onFailShow(0);
    }
}
