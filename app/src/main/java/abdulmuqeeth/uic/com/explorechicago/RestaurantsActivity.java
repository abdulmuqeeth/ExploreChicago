package abdulmuqeeth.uic.com.explorechicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import abdulmuqeeth.uic.com.explorechicago.RestaurantNamesFragment.ListSelectionListener;

public class RestaurantsActivity extends AppCompatActivity implements ListSelectionListener {

    static String[] restaurantTitles;
    static String[] restaurantWebsites;

    private RestaurantPageFragment mRestaurantPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        restaurantTitles = getResources().getStringArray(R.array.restaurant_names);
        restaurantWebsites = getResources().getStringArray(R.array.restaurant_websites);

        mRestaurantPageFragment = (RestaurantPageFragment) getFragmentManager().findFragmentById(R.id.restaurant_page_frag);
    }

    //Implementing onListSelectionListener from interface ListSelectionListener of RestaurantNamesFragment
    @Override
    public void onListSelection(int index) {
        if(mRestaurantPageFragment.getCurrentShownIndex() != index){
            mRestaurantPageFragment.showRestaurantPage(index);
        }
    }
}
