package hust.soict.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Princess> mPrincesses;
    private RecyclerView mRecycler;
    private PrincessAdapter princessAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycler = findViewById(R.id.recyclerView);
        mPrincesses = new ArrayList<>();
        createList();
        princessAdapter = new PrincessAdapter(this, mPrincesses);
        mRecycler.setAdapter(princessAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
    private void createList() {
        mPrincesses.add(new Princess("Elsa", R.drawable.elsa));
        mPrincesses.add(new Princess("Merida", R.drawable.merida));
        mPrincesses.add(new Princess("Moana", R.drawable.moana));
        mPrincesses.add(new Princess("Mulan", R.drawable.mulan));
        mPrincesses.add(new Princess("Rapunzel", R.drawable.rapunzel));
        mPrincesses.add(new Princess("Aurora", R.drawable.aurora));

    }
}