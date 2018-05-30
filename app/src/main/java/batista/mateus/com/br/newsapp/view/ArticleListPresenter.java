package batista.mateus.com.br.newsapp.view;

import java.util.List;

import batista.mateus.com.br.newsapp.network.model.Article;
import io.reactivex.disposables.CompositeDisposable;

public class ArticleListPresenter implements ArticleListContracts.Presenter {

    private ArticleListContracts.View view;
    private ArticleListContracts.Interactor interactor;
    private CompositeDisposable disposable;

    private List<Article> articles;

    public ArticleListPresenter(ArticleListContracts.View view, ArticleListContracts.Interactor interactor, CompositeDisposable disposable) {
        this.view = view;
        this.interactor = interactor;
        this.disposable = disposable;
    }
}
