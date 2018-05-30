package batista.mateus.com.br.newsapp.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import batista.mateus.com.br.newsapp.R;
import batista.mateus.com.br.newsapp.network.DownloadImage;
import batista.mateus.com.br.newsapp.network.model.Article;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.NewsViewHoder> {

    private List<Article> articles;
    private DownloadImage downloadImage;
    private ArticleAdapterListener listener;

    public ArticleListAdapter(List<Article> articles, DownloadImage downloadImage, ArticleAdapterListener listener) {
        this.articles = articles;
        this.downloadImage = downloadImage;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pattern_news_item,parent,false);

        return new NewsViewHoder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHoder holder, int position) {
        Article article = articles.get(position);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public interface ArticleAdapterListener {
        void onArticleSelected(Article article);
    }

    public class NewsViewHoder extends RecyclerView.ViewHolder{

        public NewsViewHoder(View itemView) {
            super(itemView);
        }
    }
}
