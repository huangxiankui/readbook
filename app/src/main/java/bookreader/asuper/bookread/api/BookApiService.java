package bookreader.asuper.bookread.api;

import bookreader.asuper.bookread.bean.Recommend;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/19
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public interface BookApiService {

    @GET("/book/recommend")
    Observable<Recommend> getRecommend(@Query("gender") String gender);

    @GET("/mix-atoc/{bookId}")
    Observable<Recommend> getBookToc(@Path("bookId") String bookId, @Query("view") String view);
}
