package batista.mateus.com.br.newsapp.network;

import batista.mateus.com.br.newsapp.network.model.ResponseNews;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    @GET("/top-headlines")
    Single<ResponseNews> getNews(@Query("sources") String sources);
}
