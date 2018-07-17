package com.hition.recycle.pager.presenter.impl;

import com.hition.recycle.pager.model.BaseResponse;
import com.hition.recycle.pager.model.Book;
import com.hition.recycle.pager.model.BookStoreModel;
import com.hition.recycle.pager.model.IListener;
import com.hition.recycle.pager.view.IView;
import java.util.List;

public class BookStorePresenter extends BasePresenter implements IListener<List<Book>>{

    private IView<List<Book>> mView;
    private BookStoreModel mModel;

    public BookStorePresenter(IView<List<Book>> mView){
        this.mView = mView;
        mModel = new BookStoreModel(this);
    }

    public void getBooks(){
        mModel.getBooks();
    }

    @Override
    public void onSuccess(BaseResponse<List<Book>> data, int flag) {
        if(null != data){
            mView.onComplete(data,0);
        }
    }

    @Override
    public void onFailed(Throwable e, int flag) {
        mView.onFailShow(0);
    }
}
