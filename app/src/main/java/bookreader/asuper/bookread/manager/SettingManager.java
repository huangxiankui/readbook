package bookreader.asuper.bookread.manager;

import bookreader.asuper.bookread.common.Constanst;
import bookreader.asuper.bookread.utils.SharedPreferencesUtil;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/22
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class SettingManager {
    private volatile static SettingManager manager;

    public static SettingManager getInstance() {
        return manager != null ? manager : (manager = new SettingManager());
    }

    /**
     * 保存用户选择的性别
     *
     * @param sex male female
     */
    public void saveUserChooseSex(String sex) {
        SharedPreferencesUtil.getInstance().putString("userChooseSex", sex);
    }

    /**
     * 获取用户选择性别
     *
     * @return
     */
    public String getUserChooseSex() {
        return SharedPreferencesUtil.getInstance().getString("userChooseSex", Constanst.MALE);
    }
}
