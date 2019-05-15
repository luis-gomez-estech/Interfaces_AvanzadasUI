package com.luisgomez.interfaces_avanzadasui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity

    implements IntroducirURLFragment.IntroducirURLFragmentListener, Web1Fragment.Web1FragmentListener, Web2Fragment.Web2FragmentListener {

    // Aqui con estas variables recogemos en el MainActivity el valor introducido para las variables o los textEdit urlWeb1 y urlWeb2 en el Fragment 1

    private String url1SegunIntroducidoEnFragmet1;
    private String url2SegunIntroducidoEnFragmet1;

    // Declaro ViewPager y Adaptador
    private ViewPager viewPager;
    private MyViewPagerAdapter viewPagerAdapter;

    //Declaro tabs para abrir en pestañas
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());

        //Declaro los fragment que vamos a usar, para añadir cada uno de ellos a cada tab

        Fragment IntroducirURLFragment = new IntroducirURLFragment();
        viewPagerAdapter.addFragment(IntroducirURLFragment,"Añadir las URLs");
        Fragment web1Fragment = new Web1Fragment();
        viewPagerAdapter.addFragment(web1Fragment,"WEB 1");
        Fragment web2Fragment = new Web2Fragment();
        viewPagerAdapter.addFragment(web2Fragment,"WEB 2");

        // Tabs
        tabs = findViewById(R.id.tabs);

        // y aqui le decimos en que tabs va a verse de cada fragment, eso si, se empieza desde cero
        tabs.addTab(tabs.newTab().setText(viewPagerAdapter.getPageTitle(0)),0); // En el tabs 0 va a verse el primer fragment declarado y asi con todos
        tabs.addTab(tabs.newTab().setText(viewPagerAdapter.getPageTitle(1)),1);
        tabs.addTab(tabs.newTab().setText(viewPagerAdapter.getPageTitle(2)),2);


        // Para movernos entre tabs
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        // Actualizaomos el viewpager con el adaptador

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
    }


    // Metodo que va a recoger el valor de la url1 introducido en el Fragment 1

    public void onUrl1Ingresada(String url1) {
        this.url1SegunIntroducidoEnFragmet1 = url1;
        viewPager.setCurrentItem(0,true); // Aqui si ponemos 1, cuando pulsemos el boton, se va a ir al tab 1,

        //Si tuvieramos solo 2 Fragment, estaria bien esa opcion de que se abra directamente, pero en este caso le voy a decir que se quede en el mismo fragment poniendo 0
    }

    // Su getter
    @Override
    public String getUrl1() {

        //Imprimo en un Toast cuando accedo al tab de la WEB 1
        Toast toast1 = Toast.makeText(getApplicationContext(),"Espere, cargando la WEB 1...", Toast.LENGTH_SHORT);
        toast1.show();

        return this.url1SegunIntroducidoEnFragmet1;
    }

    // Metodo que va a recoger el valor de la url2 introducido en el Fragment 1
    public void onUrl2Ingresada(String url2) {

        this.url2SegunIntroducidoEnFragmet1 = url2;
        viewPager.setCurrentItem(0,true);
    }

    @Override
    public String getUrl2() {

        Toast toast1 = Toast.makeText(getApplicationContext(),"Espere, cargando la WEB 2...", Toast.LENGTH_SHORT);
        toast1.show();

        return this.url2SegunIntroducidoEnFragmet1;
    }


}