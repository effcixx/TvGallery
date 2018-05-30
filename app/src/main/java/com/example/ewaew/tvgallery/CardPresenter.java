package com.example.ewaew.tvgallery;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ewa Lyko on 26.05.2018.
 */

public class CardPresenter extends Presenter {


    private static Context mContext;
    private static int CARD_WIDTH = 313;
    private static int CARD_HEIGHT = 176;

    static class ViewHolder extends Presenter.ViewHolder {
        private Picture mPicture;
        private ImageCardView mCardView;
        private Drawable mDefaultCardImage;

        public ViewHolder(View view) {
            super(view);
            mCardView = (ImageCardView) view;
            mDefaultCardImage = mContext.getResources().getDrawable(R.drawable.app_icon_your_company);
        }

        public void setMovie(Picture p) {
            mPicture = p;
        }

        public void setmDefaultCardImage(int i)
        {
            mDefaultCardImage = mContext.getDrawable(i);
        }

        public Picture getPicture() {
            return mPicture;
        }

        public ImageCardView getCardView() {
            return mCardView;
        }

        public Drawable getDefaultCardImage() {
            return mDefaultCardImage;
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();

        ImageCardView cardView = new ImageCardView(mContext);
        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);
        cardView.setBackgroundColor(mContext.getResources().getColor(R.color.fastlane_background));
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        Picture picture = (Picture) item;
        ((ViewHolder) viewHolder).setMovie(picture);
        ((ViewHolder) viewHolder).setmDefaultCardImage(picture.getImage());


        ((ViewHolder) viewHolder).mCardView.setTitleText(picture.getTitle());
        //((ViewHolder) viewHolder).mCardView.setContentText(picture.getStudio());
        ((ViewHolder) viewHolder).mCardView.setMainImageDimensions(CARD_WIDTH, CARD_HEIGHT);
        ((ViewHolder) viewHolder).mCardView.setMainImage(((ViewHolder) viewHolder).getDefaultCardImage());
        //((ViewHolder) viewHolder).mCardView.setMainImage(mContext.getResources().getDrawable(R.drawable.app_icon_your_company));
    }

    @Override
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }

    @Override
    public void onViewAttachedToWindow(Presenter.ViewHolder viewHolder) {
        // TO DO
    }

}