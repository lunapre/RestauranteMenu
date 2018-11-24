package com.example.lbeltran.restaurante.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentos;

    public PageAdapter(FragmentManager fm,
                       ArrayList<Fragment> fragmentos) {
        super(fm);
        this.fragmentos = fragmentos;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentos.get(i);
    }

    @Override
    public int getCount() {
        return fragmentos.size();
    }

}
