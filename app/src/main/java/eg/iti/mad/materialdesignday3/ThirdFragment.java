package eg.iti.mad.materialdesignday3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eg.iti.mad.materialdesignday3.databinding.FragmentThirdBinding;


public class ThirdFragment extends Fragment {

    List<PhoneData> input;
    MyAdapter myAdapter;


    FragmentThirdBinding viewDataBinding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_third,container,false);

        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpChoiceChip();


        input = Arrays.asList(
                new PhoneData("A","Apple","small description"),
                new PhoneData("S","Samsung","small description"),
                new PhoneData("O","Oppo","small description"),
                new PhoneData("A","Apple","small description"),
                new PhoneData("S","Samsung","small description"),
                new PhoneData("O","Oppo","small description"),
                new PhoneData("A","Apple","small description"),
                new PhoneData("S","Samsung","small description"),
                new PhoneData("O","Oppo","small description"),
                new PhoneData("A","Apple","small description"),
                new PhoneData("S","Samsung","small description"),
                new PhoneData("O","Oppo","small description")
        );

        myAdapter = new MyAdapter(requireContext(),input);
        viewDataBinding.recyclerView.setAdapter(myAdapter);

    }

    private void setUpChoiceChip(){
        for(int i=0;i<viewDataBinding.chipGroup2.getChildCount();i++){
            Chip chip = (Chip) viewDataBinding.chipGroup2.getChildAt(i);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked){
                        if (chip.getText().toString().equals("Apple")){
                            List<PhoneData> newList = search("Apple");
                            myAdapter.changeData(newList);
                        }else if (chip.getText().toString().equals("Samsung")){
                            List<PhoneData> newList = search("Samsung");
                            myAdapter.changeData(newList);
                        }else if (chip.getText().toString().equals("Oppo")){
                            List<PhoneData> newList = search("Oppo");
                            myAdapter.changeData(newList);
                        }
                        Toast.makeText(requireContext(), chip.getText().toString(), Toast.LENGTH_SHORT).show();
                    }else {
//                        Toast.makeText(requireContext(), "Unchecked", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    List<PhoneData> search(String name){
        List<PhoneData> newList = new ArrayList<>();
        for (int i=0;i<input.size();i++){
            if (input.get(i).getName().equals(name)){
                newList.add(input.get(i));
            }
        }
        return newList;
    }

}