package bookreader.asuper.bookread.compant;

import java.util.List;

import bookreader.asuper.bookread.bean.Recommend;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/17
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public interface IRecommendViewInterface {
    void showArticles(List<Recommend.RecommendBooks> list);

    void showLoading();

    void hideLoading();
}
