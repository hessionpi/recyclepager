package com.hition.recycle.pager.model;

import com.hition.recycle.pager.api.BookStoreAPI;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookStoreModel {

    private BookStoreAPI api;

    private IListener<List<Book>> listener;

    public BookStoreModel(IListener<List<Book>> listener) {
        this.listener = listener;
        api = new BookStoreAPI();
    }

    public Subscription getBooks(){
        Observable<BaseResponse<List<Book>>> observable = api.getBooks();
        return observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseResponse<List<Book>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable t) {
                        listener.onFailed(t,0);
                    }

                    @Override
                    public void onNext(BaseResponse<List<Book>> baseResponse) {
                        listener.onSuccess(baseResponse, 0);
                    }
                });
    }


}
