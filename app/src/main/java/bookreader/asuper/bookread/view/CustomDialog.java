package bookreader.asuper.bookread.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;

import bookreader.asuper.bookread.R;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/24
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
       this(context,0);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }
//    public static CustomDialog instance(Activity activity)
//    {
////        LoadingView v = View.inflate(activity, R.layout.common_progress_view,null);
//
//    }
}
