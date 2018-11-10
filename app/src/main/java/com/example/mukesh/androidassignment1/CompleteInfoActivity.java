package com.example.mukesh.androidassignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CompleteInfoActivity extends AppCompatActivity {
    private TextView name;
    private TextView country;
    private TextView ranking;
    private TextView info;
    private Button webviewBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_info);

        name = findViewById(R.id.textViewNameData);
        country = findViewById(R.id.textViewCountryData);
        ranking = findViewById(R.id.textViewRankData);
        info = findViewById(R.id.textViewInfoData);

        final Bundle bundle = getIntent().getExtras();
        Players player = (Players)bundle.getSerializable("data");

        setTitle(player.getName());

        name.setText(player.getName());
        country.setText(player.getCountry());
        ranking.setText(Integer.toString(player.getWorldRanking()));
        info.setText(player.getCompleteInfo());

        webviewBtn = findViewById(R.id.buttonWebView);
        webviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),WebViewActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
