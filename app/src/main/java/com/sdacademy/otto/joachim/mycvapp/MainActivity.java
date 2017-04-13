package com.sdacademy.otto.joachim.mycvapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.j256.ormlite.stmt.query.In;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vpPager)
    ViewPager vpPager;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tablayout)
    TabLayout tabLayout;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;

    private final String PHONE_NUMBER = "609320082";


    private static final String TAG_EMAIL = "joachimotto@wp.pl";
    private static final String TAG_SUBJECT = "Wiadomość z aplikacji CV";
    private static final String TAG_MAIL_TO = "mailto:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();
        vpPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(vpPager);
        ChooseIteamInNV();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainActivityMenuSettings:
                openSettings();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openSettings() {

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open_drawer, R.string.Close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                                             @Override
                                                             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                                                                 for (int i = 0; i < navigationView.getMenu().size(); i++)

                                                                     navigationView.getMenu().getItem(i).setChecked(false);


                                                                 item.setChecked(true);
                                                                 toolbar.setTitle(item.getTitle());
                                                                 drawerLayout.closeDrawer(GravityCompat.START);

                                                                 return false;



                                                             }
                                                         }

        );

    }
    private void ChooseIteamInNV(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.phone:
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel: " + PHONE_NUMBER));
                        startActivity(intent);
                        break;
                    case R.id.mail:
                        Intent intent2 = new Intent(Intent.ACTION_SENDTO);
                        intent2.setData(Uri.parse(TAG_MAIL_TO));
                        intent2.putExtra(Intent.EXTRA_EMAIL, new String[]{TAG_EMAIL});
                        intent2.putExtra(Intent.EXTRA_SUBJECT, TAG_SUBJECT);
                        startActivity(intent2);
                        break;

                }
                return false;
            }
        });
    }


    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public int getCount() {
            return NUM_ITEMS;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FirstFragment.newInstance();
                case 1:
                    return SecondFragment.newInstance();
                case 2:
                    return ThirdFragment.newInstance();
                default:
                    return null;
            }
        }


        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "Education";
                case 1:
                    return "Work Experience";
                case 2:
                    return "Certyfication";
                default:
                    return null;

            }


        }

    }

}



