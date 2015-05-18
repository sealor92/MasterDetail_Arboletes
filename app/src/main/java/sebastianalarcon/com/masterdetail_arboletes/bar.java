package sebastianalarcon.com.masterdetail_arboletes;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class bar extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_bar, container, false);


        final TextView tbares =(TextView) view.findViewById(R.id.tbares);
        final ImageView ibares = (ImageView) view.findViewById(R.id.ibares);

        Spinner spinner = (Spinner) view.findViewById( R.id.bares_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.bares_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                switch(position) {
                    case 0:
                        ibares.setImageResource(R.drawable.bar1);
                        tbares.setText(R.string.bar1);
                        break;

                    case 1:
                        ibares.setImageResource(R.drawable.bar2);
                        tbares.setText(R.string.bar2);
                        break;

                    case 2:
                        ibares.setImageResource(R.drawable.bar3);
                        tbares.setText(R.string.bar3);
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
        getActivity().setTitle(R.string.title_activity_bares);
    }
}
