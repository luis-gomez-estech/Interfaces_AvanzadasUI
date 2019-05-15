package com.luisgomez.interfaces_avanzadasui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Web1Fragment extends Fragment {

    // declaramos fragment para que sea escuchado cuando queramos obtener algo de él
    private Web1FragmentListener listener;

    WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  Web1FragmentListener){
            this.listener = (Web1FragmentListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_segundo,null);

        // Instanciamos el webView
        webView = viewRoot.findViewById(R.id.WebView_Web1);

        return viewRoot;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){

            // obtengo el valor de urlWeb1 a traves  del metodo getUrl y asi obtengo el string que necesito para pasarselo al webView y haga la busqyeda
            String url1 = listener.getUrl1();


            // WebView
            webView.loadUrl(url1);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

            webView.setWebViewClient(new WebViewClient());

            //Fin WebView

        }
    }

    public static interface Web1FragmentListener{

        public String getUrl1();
    }
}