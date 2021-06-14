package hust.soict.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PrincessAdapter extends RecyclerView.Adapter<PrincessAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Princess> mPrincesses;
    public PrincessAdapter(Context mContext, ArrayList<Princess> mPrincesses) {
        this.mContext = mContext;
        this.mPrincesses = mPrincesses;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.custom, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Princess princess = mPrincesses.get(position);
        holder.mImagePrincess.setImageResource(princess.getImage());
        holder.mTextName.setText(princess.getName());
    }

    @Override
    public int getItemCount() {
        return mPrincesses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImagePrincess;
        private TextView mTextName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImagePrincess = itemView.findViewById(R.id.image_princess);
            mTextName = itemView.findViewById(R.id.text_name);
        }
    }
}
