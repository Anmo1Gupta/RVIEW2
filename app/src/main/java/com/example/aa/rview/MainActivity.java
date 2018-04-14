package com.example.aa.rview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.l4digital.fastscroll.FastScroller;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
//    private int[] images = {Integer.parseInt("R.mipmap.ic_launcher"),
//            Integer.parseInt("R.mipmap.ic_launcher"),
//            Integer.parseInt("R.mipmap.ic_launcher_round"),
//            Integer.parseInt("R.mipmap.ic_launcher_round"),
//            Integer.parseInt("R.mipmap.ic_launcher"),
//            Integer.parseInt("R.mipmap.ic_launcher"),
//            Integer.parseInt("R.mipmap.ic_launcher_round"),
//            Integer.parseInt("R.mipmap.ic_launcher_round"),
//            Integer.parseInt("R.mipmap.ic_launcher"),
//            Integer.parseInt("R.mipmap.ic_launcher")};

    private int[] images = {
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp,
            R.drawable.ic_broken_image_black_24dp
    };

    private String[] data =  {"Avent 1",
        "Bvent 2",
        "Event 3",
        "Event 4",
        "Event 5",
        "Event 6",
        "Event 7",
        "Event 8",
        "Event 9",
        "Event 10"};
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter = new MyAdapter(data, images);
    private RecyclerView.LayoutManager mLayoutManager;

    @Override



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = (RecyclerView) findViewById(R.id.myrecyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        myRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        myRecyclerView.setAdapter(mAdapter);


    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements FastScroller.SectionIndexer{
        private String[] mDataset;
        private int[] mIcons;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder  extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public ImageView mImageView;

            public ViewHolder(View v) {
                super(v);
                mTextView = v.findViewById(R.id.list_item);
                mImageView = v.findViewById(R.id.iconsview);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(String[] myDataset, int[] myIcons) {
            mDataset = myDataset;
            mIcons = myIcons;

        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
            // create a new view

            Context mContext = parent.getContext();

            View v = LayoutInflater.from(mContext).inflate(R.layout.events, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextView.setText(mDataset[position]);
            holder.mImageView.setImageResource(mIcons[position]);

            if(position%2 == 0)
            {
                holder.itemView.setBackgroundColor(Color.parseColor("#919191"));
                holder.mImageView.setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.length;
        }

        @Override
        public String getSectionText(int position) {

            return mDataset[position].substring(0, 1);
        }
    }

}

