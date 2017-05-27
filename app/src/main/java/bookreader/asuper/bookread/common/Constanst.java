package bookreader.asuper.bookread.common;

import bookreader.asuper.bookread.utils.AppUtils;
import bookreader.asuper.bookread.utils.FileUtils;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/16
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class Constanst {
    public static final String TAG = "BKRD";
    public static final String API_BASE_URL = "http://api.zhuishushenqi.com";
    public static final String MALE = "male";
    public static final String PATH_DATA = FileUtils.createRootPath(AppUtils.getAppContext())+"/cache";
    public static String BASE_PATH = FileUtils.createRootPath(AppUtils.getAppContext()) + "/book/";
}
