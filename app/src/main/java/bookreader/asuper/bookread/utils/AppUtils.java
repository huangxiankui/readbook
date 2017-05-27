package bookreader.asuper.bookread.utils;

import android.content.Context;
import android.util.Log;

import bookreader.asuper.bookread.common.BookReadApplication;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/22
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class AppUtils {
    private static Context mContext;
    private static Thread mUIThread;

    public static void init(Context context) {
        mContext = context;
        mUIThread = Thread.currentThread();
    }

    public static Context getAppContext() {
        return mContext;
    }
}
