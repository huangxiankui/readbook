package bookreader.asuper.bookread.utils;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/22
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class StringUtils {
    public static String createAcacheKey(Object... obj) {
        String key = "";
        for (Object o : obj) {
            key += "-" + o;
        }
        return key.replaceFirst("-", "");
    }
}
