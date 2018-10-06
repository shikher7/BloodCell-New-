//package com.example.shikher.bloodcell.Views.Fragments;
//
//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.app.Fragment;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.ViewPager;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.shikher.bloodcell.R;
//import com.example.shikher.bloodcell.Utils.Adapter.SearchAdapter;
//
//
//public class FragmentSearch extends Fragment {
//
//    TabLayout.Tab map,city,name;
//
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View root = inflater.inflate(R.layout.fragment_search, container, false);
//
//        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabs_search);
//        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewpager_search);
//        SearchAdapter viewPagerAdapter = new SearchAdapter(getActivity().getSupportFragmentManager());
//
//        viewPager.setAdapter(viewPagerAdapter);
//
//        tabLayout.setupWithViewPager(viewPager);
//
//        map = tabLayout.newTab();
//        city = tabLayout.newTab();
//        name = tabLayout.newTab();
//
//
//
//        tabLayout.addTab(map, 0);
//        tabLayout.addTab(city, 1);
//        tabLayout.addTab(name, 2);
//
//
//
//        map.setText("Search by Map");
//        city.setText("Search by City");
//        name.setText("Search by Name");
//
//
//
//        tabLayout.setTabTextColors(ContextCompat.getColorStateList(getActivity() , R.drawable.tab_selector));
//        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity() , R.color.indicator));
//        map.select();
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        return root;
//    }
//
//}