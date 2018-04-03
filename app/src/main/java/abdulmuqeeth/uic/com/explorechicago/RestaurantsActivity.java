package abdulmuqeeth.uic.com.explorechicago;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import abdulmuqeeth.uic.com.explorechicago.RestaurantNamesFragment.ListSelectionListener;

public class RestaurantsActivity extends AppCompatActivity implements ListSelectionListener {

    static String[] restaurantTitles;
    static String[] restaurantWebsites;

    final static int ATTRACTIONS_ACT_ID = 0;
    final static int RESTAURANT_ACT_ID = 1;

    private final RestaurantPageFragment mRestaurantPageFragment = new RestaurantPageFragment();
    private final RestaurantNamesFragment mRestaurantNamesFragment = new RestaurantNamesFragment();

    private FragmentManager mFragmentManager;
    private FrameLayout mNameFrameLayout;
    private FrameLayout mPageFrameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Reading restaurant names and websites from resources
        restaurantTitles = getResources().getStringArray(R.array.restaurant_names);
        restaurantWebsites = getResources().getStringArray(R.array.restaurant_websites);

        setContentView(R.layout.activity_restaurants);

        mNameFrameLayout = (FrameLayout) findViewById(R.id.restaurant_name_frag_container);
        mPageFrameLayout = (FrameLayout) findViewById(R.id.restaurant_page_frag_container);

        mFragmentManager = getFragmentManager();

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.restaurant_name_frag_container, mRestaurantNamesFragment);

        fragmentTransaction.commit();

        //Reset the layout when backstack changes
        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                changeLayout();
            }
        });
    }

    private void changeLayout(){

        if(!mRestaurantPageFragment.isAdded()){
            //Make Names Fragment Occupy all the space
            mNameFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            mPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
        }
        else{
            if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
                mNameFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
                mPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            }else{
                mNameFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
                mPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));
            }

        }

    }

    //Implementing onListSelectionListener from interface ListSelectionListener of RestaurantNamesFragment
    @Override
    public void onListSelection(int index) {

        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.restaurant_page_frag_container, mRestaurantPageFragment);

            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            mFragmentManager.executePendingTransactions();
        }
        else{
            if(!mRestaurantPageFragment.isAdded()){
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

                fragmentTransaction.add(R.id.restaurant_page_frag_container, mRestaurantPageFragment);

                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

                mFragmentManager.executePendingTransactions();
            }
        }

        //made change here : removed current index check
        mRestaurantPageFragment.showRestaurantPage(index);
    }

    //Method to check if the activity should display an Options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        onPrepareOptionsMenu(menu);
        return true;
    }

    /*
    *This method is called every time the Menu option is selected
    *This method is used to populate the Menu and SubMenu dynamically
    */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(Menu.NONE, ATTRACTIONS_ACT_ID, Menu.NONE, R.string.attractions);
        menu.add(Menu.NONE, RESTAURANT_ACT_ID, Menu.NONE, R.string.restaurants);
        return super.onPrepareOptionsMenu(menu);
    }

    //Handling a Menu Item Click Event
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case ATTRACTIONS_ACT_ID:
                goToAttractionsActivity();
                break;
            case RESTAURANT_ACT_ID:
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void goToAttractionsActivity() {
            Intent mIntent = new Intent(RestaurantsActivity.this, AttractionsActivity.class);
            startActivity(mIntent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        changeLayout();
    }

    @Override
    public void onBackPressed() {
        mRestaurantNamesFragment.getListView().clearChoices();
        super.onBackPressed();
    }

    //Other Methods
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}