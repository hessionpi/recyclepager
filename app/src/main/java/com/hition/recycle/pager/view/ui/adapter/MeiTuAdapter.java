package com.hition.recycle.pager.view.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.hition.recycle.pager.R;
import com.hition.recycle.pager.model.MeiTu;
import com.hition.recycle.pager.view.ui.adapter.recycleview.BaseViewHolder;
import com.hition.recycle.pager.view.ui.adapter.recycleview.XMBaseAdapter;

public class MeiTuAdapter extends XMBaseAdapter<MeiTu> {

    public MeiTuAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeituHolder(parent,R.layout.item_meitu);
    }

    private class MeituHolder extends BaseViewHolder<MeiTu>{

        private ImageView imageView;

        public MeituHolder(ViewGroup parent, int res) {
            super(parent, res);
            imageView = $(R.id.iv_cover);
        }

        @Override
        public void setData(MeiTu data) {
            Glide.with(mContext).load(data.getUrl()).into(imageView);
        }
    }
}
