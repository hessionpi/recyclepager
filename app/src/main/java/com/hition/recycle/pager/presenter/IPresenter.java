package com.hition.recycle.pager.presenter;

import rx.Subscription;

public interface IPresenter {

    // 取消订阅，防止出现内存泄漏
    void onUnsubscribe();

    // 订阅事件
    void addSubscription(Subscription subscriber);
}
