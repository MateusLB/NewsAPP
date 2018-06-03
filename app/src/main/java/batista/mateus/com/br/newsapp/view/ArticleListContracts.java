package batista.mateus.com.br.newsapp.view;

import java.util.List;

import batista.mateus.com.br.newsapp.network.model.Article;
import batista.mateus.com.br.newsapp.network.model.ResponseNews;
import io.reactivex.Single;

public class ArticleListContracts {

    public interface View{
        void showList(List<Article> articles);
        void alertError(String erroMessage);
    }

    public interface Presenter{
        void fetchArticles();
        void onDestroy();
    }

    public interface Interactor{
        Single<ResponseNews> fetchArticles(String sources);
    }
}
