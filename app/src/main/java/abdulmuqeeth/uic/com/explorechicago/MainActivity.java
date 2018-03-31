package abdulmuqeeth.uic.com.explorechicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static String[] attractionTitles;
    static String[] attractionWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attractionTitles = getResources().getStringArray(R.array.attraction_names);
    }
}
