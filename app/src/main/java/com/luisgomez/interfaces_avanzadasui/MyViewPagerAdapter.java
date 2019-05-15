package com.luisgomez.interfaces_avanzadasui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyViewPagerAdapter extends FragmentStatePagerAdapter {

    // En esta class no nos importa cuantos datos vamos a enviar ni cuantos fragment haya,
    // es decir, se usa tal cual sin añadir nada sobre los fragment o los datos a enviar

    protected final List<Fragment> fragmentList = new ArrayList<>();
    protected final List<String> fragmentTitleList = new ArrayList<>();
    protected final HashMap<Integer,Fragment> currentInstances = new HashMap<>();
    protected FragmentManager fm;

    public MyViewPagerAdapter(FragmentManager manager) {
        super(manager);
        this.fm = manager;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
        currentInstances.put(position, createdFragment);
        return createdFragment;
    }

    public Fragment getCurrentIntance(int position){
        return currentInstances.get(position);
    }
}