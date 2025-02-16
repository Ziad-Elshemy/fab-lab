package eg.iti.mad.materialdesignday3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private final Context context;
    private List<PhoneData> my_list;
    private static final String TAG = "RecyclerView";

    public MyAdapter(Context context, List<PhoneData> list) {
        this.context = context;
        this.my_list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.phone_item,parent,false);
        ViewHolder vh = new ViewHolder(view);
        Log.i(TAG, "=========onCreateViewHolder=========");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtLetter.setText(my_list.get(position).getLetter());
        holder.txtPhoneName.setText(my_list.get(position).getName());
        holder.txtPhoneDesc.setText(my_list.get(position).getDesc());
        holder.constraintLayout.setOnClickListener(view -> {
            Toast.makeText(context, my_list.get(position).getName(), Toast.LENGTH_SHORT).show();
        });
        Log.i(TAG, "=========onBindViewHolder===========");

    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtLetter;
        public TextView txtPhoneName;
        public TextView txtPhoneDesc;
        public CardView constraintLayout;
        public View layout;

        public ViewHolder(View view){
            super(view);
            layout = view;
            txtLetter = layout.findViewById(R.id.ic_text_letter);
            txtPhoneName = layout.findViewById(R.id.txtPhoneName);
            txtPhoneDesc = layout.findViewById(R.id.txtPhoneDesc);
            constraintLayout = layout.findViewById(R.id.row_item);
        }

    }

    void changeData(List<PhoneData> newList){
        my_list = newList;
        notifyDataSetChanged();
    }

}
