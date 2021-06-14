package hust.soict.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private TextView mItem;
    private EditText mStore;
    int[] textViewIDs = new int[]{R.id.text_1, R.id.text_2, R.id.text_3,
                            R.id.text_4, R.id.text_5, R.id.text_6,
                            R.id.text_7, R.id.text_8, R.id.text_9,
                            R.id.text_10};

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i < textViewIDs.length; i++) {
            String key = Integer.toString(i);
            mItem = findViewById(textViewIDs[i]);
            if (mItem.getVisibility() == View.VISIBLE) {
                outState.putBoolean(key, true);
                outState.putString(key+key, mItem.getText().toString());
            } else outState.putBoolean(key, false);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStore = findViewById(R.id.store);
        if (savedInstanceState != null) {
            Log.d("State", "Not null");
            for (int i = 0; i < textViewIDs.length; i++) {
                String key = Integer.toString(i);
                mItem = findViewById(textViewIDs[i]);
                boolean isVisible = savedInstanceState.getBoolean(key);
                String logTag;
                if (isVisible) logTag = "VISIBLE";
                else logTag = "INVISIBLE";
                Log.d(key, logTag);
                if (isVisible) {
                    String item = savedInstanceState.getString(key+key);
                    mItem.setText(item);
                    mItem.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                for (int i = 0; i < textViewIDs.length; i++) {
                    mItem = findViewById(textViewIDs[i]);
                    if (mItem.getVisibility() == View.INVISIBLE) {
                        mItem.setText(item);
                        mItem.setVisibility(View.VISIBLE);
                        break;
                    }
                }
            }
        }
    }

    public void openStore(View view) {
        String loc = mStore.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, address);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("Implicit Intent", "Can't handle this intent!");
        }
    }
}