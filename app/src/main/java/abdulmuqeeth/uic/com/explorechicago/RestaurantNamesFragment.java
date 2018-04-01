package abdulmuqeeth.uic.com.explorechicago;

import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class RestaurantNamesFragment extends ListFragment {

    private ListSelectionListener mListSelectionListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

       setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.title, RestaurantsActivity.restaurantTitles));
    }

    //Declaring interface to be implemented inside activity
    public interface ListSelectionListener{
        public void onListSelection(int index);
    }

    //Checks if the fragment is attached by checking if the RestaurantActivity implemented the onListSelection Method
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListSelectionListener = (ListSelectionListener) context;
        }catch (ClassCastException e){
            Toast.makeText(getActivity().getBaseContext(), "Fragment Not Attached", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        getListView().setItemChecked(position, true);
        mListSelectionListener.onListSelection(position);
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
