package com.hition.recycle.pager.api;

import com.hition.recycle.pager.model.BaseResponse;
import com.hition.recycle.pager.model.Book;
import com.hition.recycle.pager.model.MeiTu;

import java.util.List;

import rx.Observable;

public class BookStoreAPI {

    private APIService service;

    public BookStoreAPI() {
        service = APIManager.getInstance().retrofit.create(APIService.class);
    }

    public Observable<BaseResponse<List<Book>>> getBooks() {
        return service.getBooks();
    }

}
