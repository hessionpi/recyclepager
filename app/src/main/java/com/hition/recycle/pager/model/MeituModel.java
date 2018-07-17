package com.hition.recycle.pager.model;

import com.hition.recycle.pager.api.MeiTuAPI;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MeituModel {

    private MeiTuAPI api;

    private IListener<List<MeiTu>> listener;

    public MeituModel(IListener<List<MeiTu>> listener) {
        this.listener = listener;
        api = new MeiTuAPI();
    }

    public Subscription getMeitus(int pageNo){
        Observable<BaseResponse<List<MeiTu>>> observable = api.getMeitus(pageNo);
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseResponse<List<MeiTu>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable t) {
                        listener.onFailed(t,0);
                    }

                    @Override
                    public void onNext(BaseResponse<List<MeiTu>> baseResponse) {
                        listener.onSuccess(baseResponse, 0);
                    }
                });
    }


}
