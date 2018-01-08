package com.example.thrane.have_i_watched_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_DETAILS = "com.example.thrane.have_i_watched_it.DETAILS";
    String[] arrOfSeriesItems;
    ListView listView;
   // ArrayAdapter<String> arrayAdapter;
    private EpisodeAdapter episodeAdapter;
    private List<Episode> mEpisodeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.the_listView);


        //Static episode list
        mEpisodeList = new ArrayList<>();
        mEpisodeList.add(new Episode(1, "Game of Thrones",3,4));
        mEpisodeList.add(new Episode(2, "Games of Thrones",5,7));
        mEpisodeList.add(new Episode(3, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(4, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(5, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(6, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(7, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(8, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(9, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(10, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(11, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(12, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(13, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(14, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(15, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(16, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(17, "Gamez of Thrones",5,6));
        mEpisodeList.add(new Episode(18, "Gamez of Thrones",5,6));

        episodeAdapter = new EpisodeAdapter(this, mEpisodeList);
        listView.setAdapter(episodeAdapter);

        //Add Series to list
        Button btnAddSeries = (Button) findViewById(R.id.btn_addSeries);
        btnAddSeries.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView txtViewAddSeries = (TextView) findViewById(R.id.txtEdit_addSeries);
                String txt = txtViewAddSeries.getText().toString();
                mEpisodeList.add(new Episode(19, txt, 1,1));
                episodeAdapter.notifyDataSetChanged();
            }
        });
    }

}






