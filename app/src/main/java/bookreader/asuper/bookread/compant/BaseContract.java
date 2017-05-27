package bookreader.asuper.bookread.compant;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/22
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public interface BaseContract {

    interface BasePresenter<T> {
        void attachView(T view);

        void detachView();
    }

    interface BaseView {
        void showError();

        void complete();
    }
}
