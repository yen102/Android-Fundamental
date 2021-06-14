package hust.soict.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private TextView mItem;
    public static final String EXTRA_REPLY = "Item";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addItem(View view) {
        mItem = (TextView) view;
        String item = mItem.getText().toString();
        Log.d("Clicked to: ", item);
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, item);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}