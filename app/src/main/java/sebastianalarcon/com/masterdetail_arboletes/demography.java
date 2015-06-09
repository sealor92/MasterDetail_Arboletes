package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link demography.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link demography#newInstance} factory method to
 * create an instance of this fragment.
 */
public class demography extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demography, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.title_activity_demografia);
    }
}
