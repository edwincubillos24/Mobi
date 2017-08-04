package com.walloom.mobi.controlador;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.walloom.mobi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TabLayout tabLayout =  (TabLayout) view.findViewById(R.id.tabs);


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        return view;


    }

    public class PagerAdapter extends FragmentPagerAdapter {



        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: PrimerFragment tab1 = new PrimerFragment();
                    return tab1;
                case 1: SegundoFragment tab2 =  new SegundoFragment();
                    return tab2;
                default: return null;

            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "Primer";
                case 1: return "Segundo";

            }
            return super.getPageTitle(position);
        }
    }

}
