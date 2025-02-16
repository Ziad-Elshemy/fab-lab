package eg.iti.mad.materialdesignday3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import eg.iti.mad.materialdesignday3.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    FragmentSecondBinding viewDataBinding;

    Animation rotateOpen ;
    Animation rotateClose ;
    Animation fromBottom ;
    Animation toBottom ;

    boolean clicked = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewDataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_second,container,false);

        return viewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding.imageView.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment);
        });


        //
        rotateOpen = AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_open_anim);
        rotateClose = AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_close_anim);
        fromBottom = AnimationUtils.loadAnimation(requireContext(),R.anim.from_bottom_anim);
        toBottom = AnimationUtils.loadAnimation(requireContext(),R.anim.to_bottom_anim);
        
        
        viewDataBinding.btnAdd.setOnClickListener(view1 -> {
            onAddButtonClicked();
        });
        viewDataBinding.btnEmail.setOnClickListener(view1 -> {
            Toast.makeText(requireContext(), "btnEmail", Toast.LENGTH_SHORT).show();
        });

        viewDataBinding.btnNew.setOnClickListener(view1 -> {
            Toast.makeText(requireContext(), "btnNew", Toast.LENGTH_SHORT).show();
        });

        viewDataBinding.btnNew1.setOnClickListener(view1 -> {
            Toast.makeText(requireContext(), "btnNew1", Toast.LENGTH_SHORT).show();
        });

        viewDataBinding.btnNew2.setOnClickListener(view1 -> {
            Toast.makeText(requireContext(), "btnNew2", Toast.LENGTH_SHORT).show();
        });

        viewDataBinding.btnNew3.setOnClickListener(view1 -> {
            Toast.makeText(requireContext(), "btnNew3", Toast.LENGTH_SHORT).show();
        });

    }

    private void onAddButtonClicked() {
        setVisibilty(clicked);
        setAnimation(clicked);
        if (!clicked){
            clicked = true;
        }else {
            clicked = false;
        }
    }

    private void setVisibilty(boolean clicked) {
        if (!clicked){
            viewDataBinding.btnAdd.setImageResource(R.drawable.ic_add);
            viewDataBinding.btnEmail.setVisibility(View.VISIBLE);
            viewDataBinding.btnNew.setVisibility(View.VISIBLE);
            viewDataBinding.btnNew1.setVisibility(View.VISIBLE);
            viewDataBinding.btnNew2.setVisibility(View.VISIBLE);
            viewDataBinding.btnNew3.setVisibility(View.VISIBLE);
        }else {
            viewDataBinding.btnAdd.setImageResource(R.drawable.ic_share);
            viewDataBinding.btnEmail.setVisibility(View.INVISIBLE);
            viewDataBinding.btnNew.setVisibility(View.INVISIBLE);
            viewDataBinding.btnNew1.setVisibility(View.INVISIBLE);
            viewDataBinding.btnNew2.setVisibility(View.INVISIBLE);
            viewDataBinding.btnNew3.setVisibility(View.INVISIBLE);
        }
    }

    private void setAnimation(boolean clicked) {
        if (!clicked){
            viewDataBinding.btnEmail.startAnimation(fromBottom);
            viewDataBinding.btnAdd.startAnimation(rotateOpen);
            viewDataBinding.btnNew.startAnimation(fromBottom);
            viewDataBinding.btnNew1.startAnimation(fromBottom);
            viewDataBinding.btnNew2.startAnimation(fromBottom);
            viewDataBinding.btnNew3.startAnimation(fromBottom);
        }else {
            viewDataBinding.btnEmail.startAnimation(toBottom);
            viewDataBinding.btnAdd.startAnimation(rotateClose);
            viewDataBinding.btnNew.startAnimation(toBottom);
            viewDataBinding.btnNew1.startAnimation(toBottom);
            viewDataBinding.btnNew2.startAnimation(toBottom);
            viewDataBinding.btnNew3.startAnimation(toBottom);
        }
    }


}