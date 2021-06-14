package hust.soict.sportnews;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;

public class SecondFragment extends Fragment {
    Bundle bundle;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView newsTitle = view.findViewById(R.id.titleDetail);
        ImageView sportsImage = view.findViewById(R.id.sportsImageDetail);

        newsTitle.setText(MainActivity.sport.getTitle());
        Glide.with(getContext())
                .load(MainActivity.sport.getImageResource())
                .into(sportsImage);
    }

}