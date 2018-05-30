package com.example.ewaew.tvgallery;


import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v17.leanback.widget.OnItemViewSelectedListener;
import android.support.v17.leanback.widget.Presenter;
import android.support.v17.leanback.widget.PresenterSelector;
import android.support.v17.leanback.widget.Row;
import android.support.v17.leanback.widget.RowPresenter;


public class BlankFragment extends BrowseFragment {

    private ArrayObjectAdapter mRowsAdapter;
    private static SimpleBackgroundManager simpleBackgroundManager = null;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
        loadRows();
        setupEventListeners();
        simpleBackgroundManager = new SimpleBackgroundManager(getActivity());

    }

    private void setupEventListeners() {
        setOnItemViewSelectedListener(new ItemViewSelectedListener());
    }

    private final class ItemViewSelectedListener implements OnItemViewSelectedListener {
        @Override
        public void onItemSelected(Presenter.ViewHolder itemViewHolder, Object item,
                                   RowPresenter.ViewHolder rowViewHolder, Row row) {
            if (item instanceof String) {
                simpleBackgroundManager.clearBackground();
            } else if (item instanceof Picture) {
                simpleBackgroundManager.updateBackground(MainActivity.context.getDrawable(((Picture) item).getImage()));
            }

        }
    }
    private void setupUIElements() {
        setTitle(MainActivity.context.getString(R.string.hello));

        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);

        setBrandColor(getResources().getColor(R.color.fastlane_background));

        setSearchAffordanceColor(getResources().getColor(R.color.search_opaque));

        setHeaderPresenterSelector(new PresenterSelector() {
            @Override
            public Presenter getPresenter(Object o) {
                return new IconHeaderItemPresenter();
            }
        });
    }


    private void loadRows() {
        mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());

        /* GridItemPresenter */
        IconHeaderItem gridItemPresenterHeader = new IconHeaderItem(0, MainActivity.context.getString(R.string.hiszp),R.drawable.hiszpania);
        IconHeaderItem gridItemPresenterHeader1 = new IconHeaderItem(1, MainActivity.context.getString(R.string.wl),R.drawable.wlochy);
        IconHeaderItem gridItemPresenterHeader2 = new IconHeaderItem(2, MainActivity.context.getString(R.string.niem),R.drawable.niemcy);
        IconHeaderItem gridItemPresenterHeader3 = new IconHeaderItem(3, MainActivity.context.getString(R.string.szw),R.drawable.szwajcaria);
        IconHeaderItem gridItemPresenterHeader4 = new IconHeaderItem(4, MainActivity.context.getString(R.string.pol),R.drawable.polska);

        CardPresenter cardPresenter = new CardPresenter();
        ArrayObjectAdapter cardRowAdapter = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter1 = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter2 = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter3 = new ArrayObjectAdapter(cardPresenter);
        ArrayObjectAdapter cardRowAdapter4 = new ArrayObjectAdapter(cardPresenter);

        setA(cardRowAdapter);
        setA1(cardRowAdapter1);
        setA2(cardRowAdapter2);
        setA3(cardRowAdapter3);
        setA4(cardRowAdapter4);


        mRowsAdapter.add(new ListRow(gridItemPresenterHeader, cardRowAdapter));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader1,cardRowAdapter1));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader2, cardRowAdapter2));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader3,cardRowAdapter3));
        mRowsAdapter.add(new ListRow(gridItemPresenterHeader4, cardRowAdapter4));

        /* set */
        setAdapter(mRowsAdapter);
    }

    public void setA(ArrayObjectAdapter a) {
        Picture picture = new Picture( MainActivity.context.getString(R.string.hiszp1),R.drawable.hiszp1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.hiszp2),R.drawable.hiszp2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.hiszp3),R.drawable.hiszp3);
        picture.setTitle(picture2.getTitle());
        a.add(picture);
        a.add(picture1);
        a.add(picture2);
    }

    public void setA1(ArrayObjectAdapter a1) {
        Picture picture = new Picture(MainActivity.context.getString(R.string.wlo1),R.drawable.wlochy1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.wlo2),R.drawable.wlochy2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.wlo3),R.drawable.wlochy3);
        picture.setTitle(picture2.getTitle());
        a1.add(picture);
        a1.add(picture1);
        a1.add(picture2);
    }
    public void setA2(ArrayObjectAdapter a1) {
        Picture picture = new Picture(MainActivity.context.getString(R.string.niem1),R.drawable.niemcy1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.niem2),R.drawable.niemcy2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.niem3),R.drawable.niemcy3);
        picture.setTitle(picture2.getTitle());
        a1.add(picture);
        a1.add(picture1);
        a1.add(picture2);
    }
    public void setA3(ArrayObjectAdapter a1) {
        Picture picture = new Picture(getString(R.string.szw1),R.drawable.szwajcaria1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(getString(R.string.szw2),R.drawable.szwajcaria2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.szw3),R.drawable.szwajcaria1);
        picture.setTitle(picture2.getTitle());
        a1.add(picture);
        a1.add(picture1);
        a1.add(picture2);
    }
    public void setA4(ArrayObjectAdapter a1) {
        Picture picture = new Picture(MainActivity.context.getString(R.string.pol1),R.drawable.polska1);
        picture.setTitle(picture.getTitle());
        Picture picture1 = new Picture(MainActivity.context.getString(R.string.pol2),R.drawable.polska2);
        picture.setTitle(picture1.getTitle());
        Picture picture2 = new Picture(MainActivity.context.getString(R.string.pol3),R.drawable.polska3);
        picture.setTitle(picture2.getTitle());
        a1.add(picture);
        a1.add(picture1);
        a1.add(picture2);
    }


}
