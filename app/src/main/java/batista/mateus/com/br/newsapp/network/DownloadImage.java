package batista.mateus.com.br.newsapp.network;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DownloadImage {

    private Context context;

    //if you need change for Glide or similar library, this class is prepared for using context
    public DownloadImage(Context context) {
        this.context = context;
    }

    private void downloadImg(String url, ImageView target){
        Picasso.get().load(url).into(target);
    }
}
