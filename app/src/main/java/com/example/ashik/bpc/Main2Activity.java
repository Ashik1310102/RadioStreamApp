package com.example.ashik.bpc;

import android.annotation.SuppressLint;

import android.content.Intent;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

//it's main page for tab

public class Main2Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    TabLayout tabLayout;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // tab creation

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //icon set in tab

         int[] icons = {
                R.drawable.ic_home_black_24dp,
                R.drawable.ic_reporsts,
                R.drawable.ic_people_24dp,
                R.drawable.ic_6

        };

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }

    }
    boolean abc = false;
    @SuppressLint("ResourceAsColor")
    @Override
    public void onBackPressed() {

        if (abc ==true){
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
            System.exit(0);

        }
        Toast toast= new Toast(getApplicationContext());

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toastlayout,(ViewGroup) findViewById(R.id.myToast));
        toast.setView(layout);
        toast.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                abc = false;
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(i);


            }
        },1000);
        abc =true;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            LogerInfo logerInfo= new LogerInfo(Main2Activity.this);
            logerInfo.remove();
            Intent i = new Intent(Main2Activity.this,MainActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            //tab class open

            if(position==0){
                Home home = new Home();
                return home;
            }
            else if (position==1){
                Report ashik= new Report();
                return ashik;
            }
            else if (position==2){
                User user = new User();
                return user;
            }

            else{
                Target target = new Target();
                return target;
            }

        }

        @Override
        public int getCount() {
            // number of tab Show for a particular user.
            int t =0;
            LogerInfo logerInfo = new LogerInfo(getApplicationContext());
            String accessLevel = logerInfo.getaccessLevel();
            if(accessLevel.equals("Senior Management")||accessLevel.equals("Production Incharge")){
                t=2;
            }
            else if(accessLevel.equals("Dragon")){

                t=4;
            }
            else
                t=0;
            
            return t;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //name fo tab
            switch (position) {
                case 0:
                    return "Home";
                case 1:
                    return "Reports";
                case 2:
                    return "users";
                case 3:
                    return "Target";
            }
            return null;
        }
    }
}
