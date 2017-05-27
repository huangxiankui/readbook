package bookreader.asuper.bookread.compant;

import java.util.List;

import bookreader.asuper.bookread.bean.BookToc;
import bookreader.asuper.bookread.bean.Recommend;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/22
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public interface RecommendContract {
    interface View extends BaseContract.BaseView {
        void showRecommendList(List<Recommend.RecommendBooks> list);

        void showBookToc(String bookId, List<BookToc.mixToc.Chapters> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getRecommendList();
    }
}
