package lluis.bayersoler.com.magiccards;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import app.models.Card;
import lluis.bayersoler.com.magiccards.databinding.FragmentDetailsBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false);
        View view = binding.getRoot();
        Intent i = getActivity().getIntent();
        if(i != null){
            Card card = (Card) i.getSerializableExtra("card");
            if(card != null){
                loadCardView(card);
                getActivity().setTitle(card.getName());
                ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle(card.getType());

            }
        }
        return view;
    }

    private void loadCardView(Card card){
        binding.setCard(card);
    }

}
