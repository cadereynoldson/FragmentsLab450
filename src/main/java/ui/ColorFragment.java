package ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentslab.R;
import com.example.fragmentslab.databinding.FragmentColorBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {

    private FragmentColorBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        //Get a reference to the SafeArgs object
        ColorFragmentArgs args = ColorFragmentArgs.fromBundle(getArguments());

        //Set the text color of the label. NOTE no need to cast
        binding.colorLabel.setTextColor(args.getColor());
    }

    public void updateContent(int color) {
        binding.colorLabel.setTextColor(color);
    }
}