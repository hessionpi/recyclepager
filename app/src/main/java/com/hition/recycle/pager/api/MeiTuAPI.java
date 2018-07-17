package com.hition.recycle.pager.api;

import com.hition.recycle.pager.model.BaseResponse;
import com.hition.recycle.pager.model.MeiTu;

import java.util.List;

import rx.Observable;

public class MeiTuAPI {

    private APIService service;

    public MeiTuAPI() {
        service = APIManager.getInstance().retrofit.create(APIService.class);
    }

    public Observable<BaseResponse<List<MeiTu>>> getMeitus(int pageNo) {
        return service.getMeitu(pageNo);
    }

}
