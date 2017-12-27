package com.technotalkative.beproject.Individual;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technotalkative.beproject.Aboutfragment;
import com.technotalkative.beproject.Helpfragment;
import com.technotalkative.beproject.Individual.List_indi;
import com.technotalkative.beproject.Education.m_DataObject.Spacecraft;
import com.technotalkative.beproject.Education.m_DataObject.Try;
import com.technotalkative.beproject.Education.m_MySQL.Connector;
import com.technotalkative.beproject.Education.m_UI.PicassoClient;
import com.technotalkative.beproject.Login;
import com.technotalkative.beproject.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.technotalkative.beproject.R.id.emailTxt;
import static com.technotalkative.beproject.R.id.uname;


public class Choose_indi extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager viewPager;
    CustomSwipeAdaptor adaptor;
    private Integer [] image_resources={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,
            R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,R.drawable.a5,R.drawable.a12};
    Button bupindividual,bhpindivual;
    TextView t1,t2;
    ImageView i1;
    String email_edu,profileurl_edu;


    @Override
    protected void onCreate(Bundle savedInstanceState)throws InflateException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_indi);
        bupindividual = (Button) findViewById(R.id.bupindi);
        bhpindivual = (Button) findViewById(R.id.bhpindi);
        viewPager = (ViewPager) findViewById(R.id.imageslider);
        adaptor = new CustomSwipeAdaptor();
        viewPager.setAdapter(adaptor);
        Timer tm = new Timer();
        tm.scheduleAtFixedRate(new MyTimer(), 3000, 2000);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "WELCOME TO OSSUP!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        System.out.println("Outside try----");


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(navigationView!=null) {
            View headerView = navigationView.getHeaderView(0);
            Intent ix = this.getIntent();
            final String us_name = ix.getExtras().getString("USERNAME");
            System.out.println("USERNAME IS " + us_name);
            TextView navUsername = (TextView) headerView.findViewById(R.id.indiusername);
            navUsername.setText(us_name);
        }

        bhpindivual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(Choose_indi.this,List_indi.class);
                String type="helpprovider";
                i1.putExtra("Type",type);
                startActivity(i1);
                System.out.println("In Intent");
            }
        });

        bupindividual.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent i2=new Intent(Choose_indi.this,List_indi.class);
                String type="helpseeker";
                i2.putExtra("Type",type);
                startActivity(i2);
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        System.out.println("ID IS"+id);
        if (id == R.id.nav_hpindi) {
            HpindividualFragment hpindividualFragment=new HpindividualFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_homei,hpindividualFragment,hpindividualFragment.getTag()).commit();
        } else if (id == R.id.nav_upindi) {
            UpindividualFragment upindividualFragment=new UpindividualFragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_homei,upindividualFragment,upindividualFragment.getTag()).commit();
        } else if (id == R.id.nav_help) {
            Helpfragment hp=new Helpfragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_homei,hp,hp.getTag()).commit();
        } else if (id == R.id.nav_about) {
            Aboutfragment aboutfragment=new Aboutfragment();
            FragmentManager manager=getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.content_homei,aboutfragment,aboutfragment.getTag()).commit();
        }
        else if (id == R.id.nav_logout) {
            Intent il=new Intent(this,Login.class);
            startActivity(il);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class MyTimer extends TimerTask {
        @Override
        public void run() {
            Choose_indi.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0)
                        viewPager.setCurrentItem(1);
                    else if (viewPager.getCurrentItem() == 1)
                        viewPager.setCurrentItem(2);
                    else if (viewPager.getCurrentItem() == 2)
                        viewPager.setCurrentItem(3);
                    else if (viewPager.getCurrentItem() ==3 )
                        viewPager.setCurrentItem(4);
                    else if (viewPager.getCurrentItem() == 4)
                        viewPager.setCurrentItem(5);
                    else if (viewPager.getCurrentItem() ==5 )
                        viewPager.setCurrentItem(6);
                    else if (viewPager.getCurrentItem() ==6 )
                        viewPager.setCurrentItem(7);
                    else if (viewPager.getCurrentItem() == 7)
                        viewPager.setCurrentItem(8);
                    else if (viewPager.getCurrentItem() == 8)
                        viewPager.setCurrentItem(9);
                    else if (viewPager.getCurrentItem() == 9)
                        viewPager.setCurrentItem(10);
                    else if (viewPager.getCurrentItem() ==10 )
                        viewPager.setCurrentItem(11);
                    else
                        viewPager.setCurrentItem(0);


                }
            });

        }
    }


    public class CustomSwipeAdaptor extends PagerAdapter {

        //private Context ctx;
        private LayoutInflater layoutInflater;


           /* public CustomSwipeAdaptor(Context ctx)
            {
                this.ctx=ctx;
            }*/

        @Override
        public int getCount() {
            return image_resources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view==(LinearLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater=(LayoutInflater)Choose_indi.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item_view=layoutInflater.inflate(R.layout.swipe,container,false);
            ImageView imageView=(ImageView)item_view.findViewById(R.id.imageview);
            imageView.setImageResource(image_resources[position]);
            ViewPager vp=(ViewPager)container;
            vp.addView(item_view,0);
            return item_view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager vp=(ViewPager)container;
            View v=(View)object;
            vp.removeView(v);
        }
    }


}
