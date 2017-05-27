package bookreader.asuper.bookread.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bookreader.asuper.bookread.R;
import bookreader.asuper.bookread.bean.Recommend;

/**
 * @author hxk <br/>
 *         功能：
 *         创建日期   2017/5/16
 *         修改者：
 *         修改日期：
 *         修改内容:
 */

public class RecommendAdapter extends RecyclerView.Adapter {
    List<Recommend.RecommendBooks> mArticles;
    private Context mContext;


    private void setContext(Context context) {
        this.mContext = context;
    }

    public RecommendAdapter(List<Recommend.RecommendBooks> mArticle) {
        this.mArticles = mArticle;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_article_recycle_item, parent, false);
        return new ArticleViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
        final Recommend.RecommendBooks article = getItem(position);
        articleViewHolder.title.setText(article.title);
        articleViewHolder.content.setText(article.lastChapter);


    }

    public Recommend.RecommendBooks getItem(int position) {
        return mArticles.get(position);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView content;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.content);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
