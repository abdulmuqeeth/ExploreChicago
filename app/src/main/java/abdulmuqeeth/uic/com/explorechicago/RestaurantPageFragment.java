package abdulmuqeeth.uic.com.explorechicago;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RestaurantPageFragment extends Fragment {

    private WebView mWebView;
    private int currentIndex = -1;
    private int websiteArrayLength;

    public RestaurantPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurant_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWebView = (WebView) getActivity().findViewById(R.id.webview_rest);
        mWebView.setWebViewClient(new WebViewClient());

        websiteArrayLength = RestaurantsActivity.restaurantWebsites.length;
    }

    public void showRestaurantPage(int index){
        if(index < 0 || index >= websiteArrayLength){
            return;
        }
        currentIndex = index;
        mWebView.loadUrl(RestaurantsActivity.restaurantWebsites[currentIndex]);
    }

    public int getCurrentShownIndex(){
        return currentIndex;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
