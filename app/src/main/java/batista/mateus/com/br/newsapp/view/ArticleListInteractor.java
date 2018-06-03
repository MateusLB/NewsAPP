package batista.mateus.com.br.newsapp.view;

import batista.mateus.com.br.newsapp.network.NewsService;
import batista.mateus.com.br.newsapp.network.model.ResponseNews;
import io.reactivex.Single;

import static batista.mateus.com.br.newsapp.utils.Const.API_KEY;

public class ArticleListInteractor implements ArticleListContracts.Interactor {

    private NewsService newsService;

    public ArticleListInteractor(NewsService newsService) {
        this.newsService = newsService;
    }

    @Override
    public Single<ResponseNews> fetchArticles(String sources) {
        return newsService.getNews(sources,API_KEY);
    }
}
