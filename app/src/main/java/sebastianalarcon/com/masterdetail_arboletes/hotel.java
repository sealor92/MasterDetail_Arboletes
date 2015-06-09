package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class hotel extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_hotel, container, false);


        final TextView thoteles =(TextView) view.findViewById(R.id.thoteles);
        final ImageView ihoteles = (ImageView) view.findViewById(R.id.ihoteles);

        Spinner spinner = (Spinner) view.findViewById( R.id.hoteles_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.hoteles_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                switch(position) {
                    case 0:
                        ihoteles.setImageResource(R.drawable.hotel1);
                        thoteles.setText(R.string.hotel1);
                        break;

                    case 1:
                        ihoteles.setImageResource(R.drawable.hotel2);
                        thoteles.setText(R.string.hotel2);
                        break;

                    case 2:
                        ihoteles.setImageResource(R.drawable.hotel3);
                        thoteles.setText(R.string.hotel3);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.title_activity_hoteles);
    }

}
