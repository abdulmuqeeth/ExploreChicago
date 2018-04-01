package abdulmuqeeth.uic.com.explorechicago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import abdulmuqeeth.uic.com.explorechicago.AttractionNamesFragment.ListSelectionListener;

public class AttractionsActivity extends AppCompatActivity implements ListSelectionListener{

    static String[] attractionTitles;
    static String[] attractionWebsite;

    private  AttractionPageFragment mAttractionPageFragment;

    final static int ATTRACTIONS_ACT_ID =0;
    final static int RESTAURANT_ACT_ID = 1;

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
            case ATTRACTIONS_ACT_ID :
                return true;
            case RESTAURANT_ACT_ID :
                goToRestaurantsActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToRestaurantsActivity(){
        if(!this.getLocalClassName().equals("RestaurantsActivity")){
            Intent mIntent = new Intent(AttractionsActivity.this, RestaurantsActivity.class);
            startActivity(mIntent);
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
