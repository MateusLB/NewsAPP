package batista.mateus.com.br.newsapp.view;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import batista.mateus.com.br.newsapp.BaseApplication;
import batista.mateus.com.br.newsapp.R;
import batista.mateus.com.br.newsapp.network.DownloadImage;
import batista.mateus.com.br.newsapp.network.model.Article;
import batista.mateus.com.br.newsapp.view.adapter.ArticleListAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleListFragment extends Fragment implements ArticleListContracts.View, ArticleListAdapter.ArticleAdapterListener {

    @BindView(R.id.news_list)
    RecyclerView mNewsList;
    private Unbinder unbinder;
    private ArticleListAdapter mAdapter;

    @Inject
    ArticleListContracts.Presenter presenter;

    @Inject
    DownloadImage downloadImage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ((BaseApplication) getActivity().getApplication()).CreateArticleListFragmentComponent(this).inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this,view);
        presenter.fetchArticles();
        return view;
    }

    @Override
    public void showList(List<Article> articles) {
        mAdapter = new ArticleListAdapter(articles,downloadImage,this);
        mNewsList.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsList.setAdapter(mAdapter);
    }

    @Override
    public void alertError(String erroMessage) {
        Toast.makeText(getContext(),erroMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onArticleSelected(Article article) {
        Uri uri = Uri.parse(article.getUrl());
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(getContext(), uri);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
        unbinder.unbind();
        ( (BaseApplication) getActivity().getApplication()).releaseArticleListFragmentComponent();
    }
}
