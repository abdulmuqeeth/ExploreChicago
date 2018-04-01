package abdulmuqeeth.uic.com.explorechicago;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AttractionNamesFragment extends ListFragment {

    private int mCurrentIndex =-1;


    private ListSelectionListener mListSelectionListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.title, AttractionsActivity.attractionTitles));

        if( mCurrentIndex != -1){
            getListView().setItemChecked(mCurrentIndex, true);
            mListSelectionListener.onListSelection(mCurrentIndex);
        }

    }

    //Declaring an interface to be used in the main activity to check if fragment gets attached
    public interface ListSelectionListener {
        public void onListSelection(int id);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(mCurrentIndex != position){
            mCurrentIndex = position;
            getListView().setItemChecked(position, true);
            mListSelectionListener.onListSelection(position);
        }
        getListView().setItemChecked(position, true);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mListSelectionListener = (ListSelectionListener) context;
        }catch (ClassCastException e){
            Toast.makeText(getActivity().getBaseContext(), "Fragment Not Attached", Toast.LENGTH_SHORT).show();
        }
    }

    //Other methods

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
