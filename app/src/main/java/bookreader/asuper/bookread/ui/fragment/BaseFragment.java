package bookreader.asuper.bookread.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bookreader.asuper.bookread.R;
import bookreader.asuper.bookread.presenter.BasePresenter;
import bookreader.asuper.bookread.view.CustomDialog;
import butterknife.ButterKnife;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/15
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public abstract class BaseFragment extends Fragment {
    protected View mParentView;
    protected FragmentActivity fragmentActivity;
    private LayoutInflater mInfalter;
    private Context mContext;
    private CustomDialog mDialog;

    public BaseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_find, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        ButterKnife.unbind(this);
    }


}
