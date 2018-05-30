package batista.mateus.com.br.newsapp.view.di;

import batista.mateus.com.br.newsapp.view.ArticleListFragment;
import dagger.Subcomponent;

@ArticleListScope
@Subcomponent (modules = {ArticleListFragmentModule.class})
public interface ArticleListFragmentComponent {
    ArticleListFragment inject(ArticleListFragment fragment);
}
