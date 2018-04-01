package abdulmuqeeth.uic.com.explorechicago;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    private static final String ATTRACTION_INTENT_ACTION = "abdulmuqeeth.uic.com.receiver_app.ATTRACTIONS";
    private static final String RESTAURANT_INTENT_ACTION = "abdulmuqeeth.uic.com.receiver_app.RESTAURANTS";

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent mIntent = new Intent();
        if (intent.getAction() != null){
            if(intent.getAction().equals(ATTRACTION_INTENT_ACTION)){

                mIntent.setClass(context, AttractionsActivity.class);
            }
            else if(intent.getAction().equals(RESTAURANT_INTENT_ACTION)){
                mIntent.setClass(context, RestaurantsActivity.class);
            }
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mIntent);
        }
    }
}
