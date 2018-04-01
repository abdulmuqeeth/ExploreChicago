package abdulmuqeeth.uic.com.explorechicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RestaurantsActivity extends AppCompatActivity {

    static String[] restaurantTitles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        restaurantTitles = getResources().getStringArray(R.array.restaurant_names);
    }
}
