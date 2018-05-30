package batista.mateus.com.br.newsapp.di;


import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    @Named("ApplicationContext")
    Context provideContext(){
        return context;
    }
}
