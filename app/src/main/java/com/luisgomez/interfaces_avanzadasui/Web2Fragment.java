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


public class Web2Fragment extends Fragment {

    // Mismo sistema que para el fragment dos, solo cambian en el nombre de las variables

    private Web2FragmentListener listener;


    WebView webView2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof  Web2FragmentListener){
            this.listener = (Web2FragmentListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_tercero,null);

        webView2 = viewRoot.findViewById(R.id.WebView_Web2);

        return viewRoot;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){


            String url2 = listener.getUrl2();

            webView2.loadUrl(url2);

            WebSettings webSettings2 = webView2.getSettings();
            webSettings2.setJavaScriptEnabled(true);

            // Force links and redirects to open in the WebView instead of in a browser
            webView2.setWebViewClient(new WebViewClient());

        }
    }

    public static interface Web2FragmentListener{

        public String getUrl2();
    }
}