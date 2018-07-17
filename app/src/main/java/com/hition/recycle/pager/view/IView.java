package com.hition.recycle.pager.view;

import com.hition.recycle.pager.model.BaseResponse;

public interface IView<T> {

    void onPrepare();

    // data  响应返回数据源，flag    API接口请求标识
    void onComplete(BaseResponse<T> data, int flag);

    // 数据获取失败，View显示
    void onFailShow(int errorCode);

}