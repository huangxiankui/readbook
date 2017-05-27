package bookreader.asuper.bookread.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import bookreader.asuper.bookread.R;
import bookreader.asuper.bookread.presenter.BasePresenter;
import bookreader.asuper.bookread.utils.StatusBarCompat;
import butterknife.ButterKnife;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/15
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public abstract class BaseActivity extends AppCompatActivity {
    private View statusBarView = null;
    protected int statusBarColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (statusBarColor == 0) {
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        } else if (statusBarColor != -1) {
            statusBarView = StatusBarCompat.compat(this, statusBarColor);
        }
        ButterKnife.bind(this);
        initData();
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if (statusBarView != null) {
            statusBarView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    protected void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if (statusBarView != null) {
            statusBarView.setBackgroundColor(statusBarColor);
        }
    }
}
