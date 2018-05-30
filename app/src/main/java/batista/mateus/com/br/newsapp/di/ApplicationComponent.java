package batista.mateus.com.br.newsapp.di;


import javax.inject.Singleton;

import batista.mateus.com.br.newsapp.network.di.DownloadImageModule;
import batista.mateus.com.br.newsapp.network.di.NewsServiceModule;
import batista.mateus.com.br.newsapp.view.di.ArticleListFragmentComponent;
import batista.mateus.com.br.newsapp.view.di.ArticleListFragmentModule;
import dagger.Component;

@Singleton
@Component(modules = {NewsServiceModule.class, DownloadImageModule.class, ApplicationModule.class})
public interface ApplicationComponent {

    ArticleListFragmentComponent plus(ArticleListFragmentModule module);

}
