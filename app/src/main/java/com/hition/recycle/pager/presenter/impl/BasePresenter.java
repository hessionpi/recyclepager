package com.hition.recycle.pager.presenter.impl;

import com.hition.recycle.pager.presenter.IPresenter;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter implements IPresenter{

    private CompositeSubscription mCompositeSubscription;

    @Override
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void addSubscription(Subscription subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscriber);
    }
}
