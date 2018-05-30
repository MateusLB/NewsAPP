package batista.mateus.com.br.newsapp.view;

import batista.mateus.com.br.newsapp.network.NewsService;

public class ArticleListInteractor implements ArticleListContracts.Interactor {

    private NewsService newsService;

    public ArticleListInteractor(NewsService newsService) {
        this.newsService = newsService;
    }
}
