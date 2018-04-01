package abdulmuqeeth.uic.com.explorechicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import abdulmuqeeth.uic.com.explorechicago.RestaurantNamesFragment.ListSelectionListener;

public class RestaurantsActivity extends AppCompatActivity implements ListSelectionListener {

    static String[] restaurantTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        restaurantTitles = getResources().getStringArray(R.array.restaurant_names);
    }

    //Implementing onListSelectionListener from interface ListSelectionListener of RestaurantNamesFragment
    @Override
    public void onListSelection(int index) {
        //TODO
    }
}
