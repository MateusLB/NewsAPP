package batista.mateus.com.br.newsapp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import batista.mateus.com.br.newsapp.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleListFragment extends Fragment implements ArticleListContracts.View {

    @BindView(R.id.news_list)
    RecyclerView mNewsList;

    @Inject
    ArticleListContracts.Presenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

}
