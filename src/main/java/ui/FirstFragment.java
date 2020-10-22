package ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentslab.R;
import com.example.fragmentslab.databinding.FragmentFirstFragmentBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment implements View.OnClickListener {


    private FragmentFirstFragmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstFragmentBinding.inflate(inflater, container, false);
        binding.redButton.setOnClickListener(this);
        binding.greenButton.setOnClickListener(button -> processColor(Color.GREEN));
        binding.blueButton.setOnClickListener(this::handleBlue);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void processColor(int color) {
        Log.d("ACTIVITY", "Red: " + Color.red(color) +
                " Green: " + Color.green(color) +
                " Blue: " + Color.blue(color));
        //The following object represents the action from first to color.
        FirstFragmentDirections.ActionFirstFragementToColorFragment directions =
                FirstFragmentDirections.actionFirstFragementToColorFragment(color);
        //Use the navigate method to perform the navigation.
        Navigation.findNavController(getView()).navigate(directions);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.redButton)
            processColor(Color.RED);
    }

    public void handleBlue(View v) {
        if (v == binding.blueButton)
            processColor(Color.BLUE);
    }
}