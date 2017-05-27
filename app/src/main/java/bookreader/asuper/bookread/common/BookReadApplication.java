package bookreader.asuper.bookread.common;

import android.app.Application;
import android.content.Context;

import bookreader.asuper.bookread.utils.AppUtils;
import bookreader.asuper.bookread.utils.SharedPreferencesUtil;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/16
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class BookReadApplication extends Application {

    private static BookReadApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        AppUtils.init(this);
        initPrefs();
    }

    public static BookReadApplication getsInstance() {
        return sInstance;
    }
    /**
     * 初始化SharedPreference
     */
    protected void initPrefs() {
        SharedPreferencesUtil.init(getApplicationContext(), getPackageName() + "_preference", Context.MODE_MULTI_PROCESS);
    }
}
