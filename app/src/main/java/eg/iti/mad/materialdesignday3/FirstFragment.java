package eg.iti.mad.materialdesignday3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import eg.iti.mad.materialdesignday3.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {


    FragmentFirstBinding viewDataBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_first,container,false);
        return viewDataBinding.getRoot();
//        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        editText = view.findViewById(R.id.editTextText);
        viewDataBinding.editTextText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    if (!viewDataBinding.editTextText.getText().toString().trim().isEmpty()){
                        addChipToGroup(viewDataBinding.editTextText.getText().toString());
                        viewDataBinding.editTextText.setText("");
//                        Toast.makeText(requireContext(), "clicked", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });

//        chipGroup = view.findViewById(R.id.chipGroup);


        viewDataBinding.btnNext1.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment);
        });

    }

    private void addChipToGroup(String text){
        Chip chip = new Chip(requireContext());
        chip.setText(text);
        chip.setChipIcon(ContextCompat.getDrawable(requireContext(),R.drawable.ic_launcher_foreground));
        chip.setChipIconVisible(true);
        chip.setCloseIconVisible(true);
        viewDataBinding.chipGroup.addView(chip);
        chip.setOnCloseIconClickListener(view -> {
            viewDataBinding.chipGroup.removeView(chip);
        });

    }

}