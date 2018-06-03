package batista.mateus.com.br.newsapp.view;

import java.util.ArrayList;
import java.util.List;

import batista.mateus.com.br.newsapp.network.model.Article;
import batista.mateus.com.br.newsapp.network.model.ResponseNews;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

public class ArticleListPresenter implements ArticleListContracts.Presenter {

    private ArticleListContracts.View view;
    private ArticleListContracts.Interactor interactor;
    private CompositeDisposable disposable;

    private List<Article> articles;

    public ArticleListPresenter(ArticleListContracts.View view, ArticleListContracts.Interactor interactor, CompositeDisposable disposable) {
        this.view = view;
        this.interactor = interactor;
        this.disposable = disposable;
        articles = new ArrayList<>();
    }

    @Override
    public void fetchArticles() {
        disposable.add(interactor.fetchArticles("bbc-news")
                .map(response -> response.getArticles())
                .zipWith(interactor.fetchArticles("buzzfeed").map(response -> response.getArticles()),
                        (listBbc, listBuzz) -> {
                            List<Article> articles = new ArrayList<>();
                            articles.addAll(listBbc);
                            articles.addAll(listBuzz);
                            return articles;
                })
                .subscribeOn(io())
                .observeOn(mainThread())
                .subscribe(this::articlesFetched,this::errorDownloadingArticles));

    }

    public void articlesFetched(List<Article> articles) {
        this.articles.addAll(articles);
        view.showList(this.articles);
    }

    private void errorDownloadingArticles(Throwable throwable) {
        view.alertError(throwable.getMessage());
    }

    @Override
    public void onDestroy() {
        view = null;
        disposable.clear();
    }
}
