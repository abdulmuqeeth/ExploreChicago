package abdulmuqeeth.uic.com.explorechicago;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import abdulmuqeeth.uic.com.explorechicago.RestaurantNamesFragment.ListSelectionListener;

public class RestaurantsActivity extends AppCompatActivity implements ListSelectionListener {

    static String[] restaurantTitles;
    static String[] restaurantWebsites;

    final static int ATTRACTIONS_ACT_ID = 0;
    final static int RESTAURANT_ACT_ID = 1;

    private final RestaurantPageFragment mRestaurantPageFragment = new RestaurantPageFragment();

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

        fragmentTransaction.replace(R.id.restaurant_name_frag_container, new RestaurantNamesFragment());

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
            Log.i("here", "inChangeLayout when not added");
            //Make Names Fragment Occupy all the space
            mNameFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            mPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
        }
        else{
            Log.i("here", "inChangeLayout");
            mNameFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            mPageFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 2f));
        }

    }

    //Implementing onListSelectionListener from interface ListSelectionListener of RestaurantNamesFragment
    @Override
    public void onListSelection(int index) {

        if(!mRestaurantPageFragment.isAdded()){
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.restaurant_page_frag_container, mRestaurantPageFragment);

            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();

            mFragmentManager.executePendingTransactions();
        }

        if (mRestaurantPageFragment.getCurrentShownIndex() != index) {
            mRestaurantPageFragment.showRestaurantPage(index);
        }
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
                goToAttractiosActivity();
                return true;
            case RESTAURANT_ACT_ID:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToAttractiosActivity() {
        if (!this.getLocalClassName().equals("AttractionsActivity")) {
            Intent mIntent = new Intent(RestaurantsActivity.this, AttractionsActivity.class);
            startActivity(mIntent);
        }
    }
}