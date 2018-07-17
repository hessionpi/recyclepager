package com.hition.recycle.pager.api;

import com.hition.recycle.pager.model.BaseResponse;
import com.hition.recycle.pager.model.Book;
import com.hition.recycle.pager.model.MeiTu;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIService {

    @GET("meituApi?")
    Observable<BaseResponse<List<MeiTu>>> getMeitu(@Query("page") int pageNo);

    @GET("novelApi")
    Observable<BaseResponse<List<Book>>> getBooks();


}
