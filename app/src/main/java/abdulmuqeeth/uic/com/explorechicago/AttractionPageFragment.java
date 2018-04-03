package abdulmuqeeth.uic.com.explorechicago;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class AttractionPageFragment extends Fragment {

    private WebView mWebView;
    private WebSettings mWebSettings;
    private int mWebsiteArrayLength;

    private int currentShownIndex = -1;
    // private OnFragmentInteractionListener mListener;

    public AttractionPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attraction_page, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWebView = (WebView) getActivity().findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebsiteArrayLength = AttractionsActivity.attractionWebsite.length;


    }

    public void showWebpageAtIndex(int index){
        if (index < 0 || index >= mWebsiteArrayLength){
            return;
        }
        currentShownIndex = index;
        mWebView.loadUrl(AttractionsActivity.attractionWebsite[index]);
    }

    public int getCurrentShownIndex(){
        return currentShownIndex;
    }

    //Other Methods

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
