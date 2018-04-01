package abdulmuqeeth.uic.com.explorechicago;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import abdulmuqeeth.uic.com.explorechicago.AttractionNamesFragment.ListSelectionListener;

public class AttractionsActivity extends AppCompatActivity implements ListSelectionListener{

    static String[] attractionTitles;
    static String[] attractionWebsite;

    private  AttractionPageFragment mAttractionPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        attractionTitles = getResources().getStringArray(R.array.attraction_names);
        attractionWebsite = getResources().getStringArray(R.array.attraction_websites);

        mAttractionPageFragment = (AttractionPageFragment) getFragmentManager().findFragmentById(R.id.attraction_page_frag);
    }

    //Implementing the interface method so that fragment can check if it got attached
    @Override
    public void onListSelection(int id) {
        if(mAttractionPageFragment.getCurrentShownIndex() != id){
            mAttractionPageFragment.showWebpageAtIndex(id);
        }
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
