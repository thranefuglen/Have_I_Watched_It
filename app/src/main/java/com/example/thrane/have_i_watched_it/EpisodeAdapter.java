package com.example.thrane.have_i_watched_it;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.R.id.message;
import static android.os.Build.VERSION_CODES.M;
import static com.example.thrane.have_i_watched_it.MainActivity.EXTRA_DETAILS;

/**
 * Created by Thrane on 28-07-2017.
 */

public class EpisodeAdapter extends BaseAdapter {
    private Context mContext;
    private List<Episode> mEpisodeList;
    private ListView mListView;

    public EpisodeAdapter(Context context, List<Episode> episodeList) {
        mContext = context;
        mEpisodeList = episodeList;
    }

    @Override
    public int getCount() {
        return mEpisodeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mEpisodeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //View v = View.inflate(mContext, R.layout.row, null);
        final ViewHolderItem viewHolder;


        if(convertView == null)
        {
            //Inflate the layout
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.row, parent, false);

            //Setup ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.name = (TextView) convertView.findViewById(R.id.textViewName);
            viewHolder.season = (TextView) convertView.findViewById(R.id.textViewSeason);
            viewHolder.episode = (TextView) convertView.findViewById(R.id.textViewEpisode);
            viewHolder.btn = (Button) convertView.findViewById(R.id.btn_addEpisode);

            //Store the holder with the view
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        //Set text
        String stringSeason = "S"+mEpisodeList.get(position).getSeason();
        String stringEpisode = "E"+mEpisodeList.get(position).getEpisode();
        viewHolder.name.setText(mEpisodeList.get(position).getName());
        viewHolder.season.setText(stringSeason);
        viewHolder.episode.setText(stringEpisode);


        // + Button, adds episode to counter
        Button btn = (Button) convertView.findViewById(R.id.btn_addEpisode);
        btn.setText("+");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "Btn was click " + position + " - " +mEpisodeList.get(position).getEpisode(), Toast.LENGTH_SHORT).show();
                mEpisodeList.get(position).setEpisode(mEpisodeList.get(position).getEpisode()+1);
                notifyDataSetChanged();

            }
        });

        //Adds button functionality to textview for Series name, it launches Series Details activity
        viewHolder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seriesDetailsActivity(v, viewHolder.name.getText().toString());
            }
        });




        //Save product id to tag
       // v.setTag(mEpisodeList.get(position).getId()); */
       //convertView.setTag(mEpisodeList.get(position).getId());

        return convertView;
    }
    static class ViewHolderItem {
        private TextView name;
        private TextView season;
        private TextView episode;
        private Button btn;
    }

    //Launches Series details activity
    public void seriesDetailsActivity(View view, String seriesName){
        Intent intent = new Intent(mContext, SeriesDetailsActivity.class);
        String message = seriesName;
        intent.putExtra(EXTRA_DETAILS, message);
        mContext.startActivity(intent);
    }


}


