package bookreader.asuper.bookread.api;

import java.util.concurrent.TimeUnit;

import bookreader.asuper.bookread.bean.Recommend;
import bookreader.asuper.bookread.common.Constanst;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/19
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class BookApi {
    public static BookApi mInstance;
    private BookApiService mService;

    public BookApi() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(3000, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constanst.API_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        mService = retrofit.create(BookApiService.class);
    }

    public static BookApi getInstance() {
        if (mInstance == null) {
            synchronized (BookApi.class) {
                if (mInstance == null) {
                    mInstance = new BookApi();
                }
            }
        }
        return mInstance;
    }

    public Observable<Recommend> getRecommend(String gender) {
        return mService.getRecommend(gender);
    }
    public Observable<Recommend> getBookToc(String bookId,String view)
    {
        return mService.getBookToc(bookId,view);
    }
}
