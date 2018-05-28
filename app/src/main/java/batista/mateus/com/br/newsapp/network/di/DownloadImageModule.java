package batista.mateus.com.br.newsapp.network.di;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import batista.mateus.com.br.newsapp.network.DownloadImage;
import dagger.Module;
import dagger.Provides;

@Module
public class DownloadImageModule {

    @Singleton
    @Provides
    DownloadImage provideDownloadImage(@Named("ApplicationContext") Context context){
        return new DownloadImage(context);
    }
}
