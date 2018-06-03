package batista.mateus.com.br.newsapp;

import android.app.Application;

import batista.mateus.com.br.newsapp.di.ApplicationComponent;
import batista.mateus.com.br.newsapp.di.ApplicationModule;
import batista.mateus.com.br.newsapp.di.DaggerApplicationComponent;
import batista.mateus.com.br.newsapp.view.ArticleListFragment;
import batista.mateus.com.br.newsapp.view.di.ArticleListFragmentComponent;
import batista.mateus.com.br.newsapp.view.di.ArticleListFragmentModule;

public class BaseApplication extends Application {

    private ApplicationComponent applicationComponent;
    private ArticleListFragmentComponent ArticleListFragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public ArticleListFragmentComponent CreateArticleListFragmentComponent(ArticleListFragment context){
        ArticleListFragmentComponent = applicationComponent.plus(new ArticleListFragmentModule(context));
        return ArticleListFragmentComponent;
    }

    public void releaseArticleListFragmentComponent(){
        ArticleListFragmentComponent = null;
    }
}
