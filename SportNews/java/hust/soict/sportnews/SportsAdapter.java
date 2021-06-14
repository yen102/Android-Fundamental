package hust.soict.sportnews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import androidx.navigation.fragment.NavHostFragment;
import androidx.fragment.app.FragmentActivity;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder> {
    private ArrayList<Sport> mSports;
    private Context mContext;


    SportsAdapter(Context context, ArrayList<Sport> sports) {
        this.mContext = context;
        this.mSports = sports;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sport currentSport = mSports.get(position);
        holder.bindTo(currentSport);
    }

    @Override
    public int getItemCount() {
        return mSports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mSportsImage = itemView.findViewById(R.id.sportsImage);
            itemView.setOnClickListener(this);
        }

        public void bindTo(Sport currentSport) {
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());
            Glide.with(mContext).load(currentSport.getImageResource()).into(mSportsImage);
        }

        @Override
        public void onClick(View view) {
            Sport currentSport = mSports.get(getAdapterPosition());
            Bundle bundle = new Bundle();
            bundle.putString("title", currentSport.getTitle());
            bundle.putInt("image_resource", currentSport.getImageResource());
            MainActivity.sport.setTitle(currentSport.getTitle());
            MainActivity.sport.setImageResource(currentSport.getImageResource());
            Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
        }
    }
}
