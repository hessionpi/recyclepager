package com.hition.recycle.pager.model;


public interface IListener<T> {

    // 请求响应成功
    void onSuccess(BaseResponse<T> data, int flag);

    // 请求响应失败
    void onFailed(Throwable e, int flag);

}
