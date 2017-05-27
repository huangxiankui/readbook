package bookreader.asuper.bookread.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import bookreader.asuper.bookread.R;
import bookreader.asuper.bookread.bean.BookToc;
import bookreader.asuper.bookread.bean.Recommend;
import bookreader.asuper.bookread.compant.RecommendContract;
import bookreader.asuper.bookread.presenter.RecommendPresenter;
import bookreader.asuper.bookread.ui.adapter.RecommendAdapter;
import bookreader.asuper.bookread.view.DividerItemDecoration;
import butterknife.Bind;


public class RecommendFragment extends BaseFragment implements RecommendContract.View {
    @Bind(R.id.recycleview)
    RecyclerView mRecycleview;
    public Context mContext;
    RecommendAdapter mAdapter;
    private RecommendPresenter mPresenter;

    public RecommendFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = new RecommendPresenter(this);
        mPresenter.getRecommendList();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void initRecycleView() {
        mRecycleview.setLayoutManager(new LinearLayoutManager(mContext));
        mRecycleview.setHasFixedSize(true);
        //分割线
        mRecycleview.addItemDecoration(new DividerItemDecoration(mContext,
                DividerItemDecoration.VERTICAL_LIST));

        mRecycleview.setAdapter(mAdapter);
    }

    @Override
    public void showRecommendList(List<Recommend.RecommendBooks> list) {
        mAdapter = new RecommendAdapter(list);
        initRecycleView();
    }

    @Override
    public void showBookToc(String bookId, List<BookToc.mixToc.Chapters> list) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {

    }
}
