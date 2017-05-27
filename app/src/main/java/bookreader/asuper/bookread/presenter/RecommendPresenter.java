package bookreader.asuper.bookread.presenter;

import android.content.Context;
import android.util.Log;

import java.util.List;

import bookreader.asuper.bookread.api.BookApi;
import bookreader.asuper.bookread.bean.Recommend;
import bookreader.asuper.bookread.common.Constanst;
import bookreader.asuper.bookread.compant.RecommendContract;
import bookreader.asuper.bookread.manager.SettingManager;
import bookreader.asuper.bookread.utils.RxUtil;
import bookreader.asuper.bookread.utils.StringUtils;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/17
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class RecommendPresenter extends BasePresenter<RecommendContract.View>
        implements RecommendContract.Presenter<RecommendContract.View> {
    private Context mContext;
    private RecommendContract.View mView;
    private BookApi mBookApi;

    public RecommendPresenter(RecommendContract.View view) {
        this.mView = view;
        this.mBookApi = new BookApi();
    }

    public void getRecommendList() {
        String key = StringUtils.createAcacheKey("recommend-list", SettingManager.getInstance().getUserChooseSex());
        Observable<Recommend> fromNetWorkObservable = mBookApi.getRecommend(SettingManager.getInstance().getUserChooseSex())
                .compose(RxUtil.<Recommend>rxCacheListHelper(key));
        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, Recommend.class), fromNetWorkObservable)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Recommend>() {
                    @Override
                    public void onNext(Recommend recommend) {
                        if (recommend != null) {
                            List<Recommend.RecommendBooks> list = recommend.books;
                            if (list != null && !list.isEmpty() && mView != null) {
                                Log.e(Constanst.TAG, "list:" + list.toString());
                                mView.showRecommendList(list);
                            }
                        }
                    }

                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }
                });
        addSubscribe(rxSubscription);
    }
}
