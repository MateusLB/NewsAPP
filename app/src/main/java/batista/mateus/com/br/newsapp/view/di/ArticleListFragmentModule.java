package batista.mateus.com.br.newsapp.view.di;

import javax.inject.Named;

import batista.mateus.com.br.newsapp.network.NewsService;
import batista.mateus.com.br.newsapp.view.ArticleListContracts;
import batista.mateus.com.br.newsapp.view.ArticleListFragment;
import batista.mateus.com.br.newsapp.view.ArticleListInteractor;
import batista.mateus.com.br.newsapp.view.ArticleListPresenter;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ArticleListFragmentModule {

    ArticleListFragment context;

    public ArticleListFragmentModule(ArticleListFragment context) {
        this.context = context;
    }

    @ArticleListScope
    @Provides
    @Named("NewsFragmentContext")
    ArticleListFragment provideNewsFragmentContext(){
        return context;
    }

    @ArticleListScope
    @Provides
    ArticleListContracts.Presenter providePresenter(ArticleListContracts.View view, ArticleListContracts.Interactor interactor,
                                                    CompositeDisposable disposable){
        return new ArticleListPresenter(view,interactor,disposable);
    }

    @ArticleListScope
    @Provides
    ArticleListContracts.Interactor provideInteractor(NewsService service){
        return new ArticleListInteractor(service);
    }

    @ArticleListScope
    @Provides
    ArticleListContracts.View provideView(){
        return context;
    }

    @ArticleListScope
    @Provides
    CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }


}
