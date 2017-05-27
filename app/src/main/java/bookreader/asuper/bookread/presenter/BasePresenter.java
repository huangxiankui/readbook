package bookreader.asuper.bookread.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import bookreader.asuper.bookread.compant.BaseContract;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/17
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
    protected T mView;
    protected CompositeSubscription mCompositeSubscription;

    protected void unSubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();

    }
}
