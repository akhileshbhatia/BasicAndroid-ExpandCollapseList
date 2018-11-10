package com.example.mukesh.androidassignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BasicInfoActivity extends AppCompatActivity {
    private ImageView playerImageView;
    private TextView playerBasicInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);

        final Bundle b = getIntent().getExtras();
        Players selectedPlayer = (Players)b.getSerializable("data");

        setTitle(selectedPlayer.getName());

        playerImageView = findViewById(R.id.playerImageView);
        playerBasicInfo = findViewById(R.id.playerBasicInfo);

        String imageName = selectedPlayer.getImage().substring(0,selectedPlayer.getImage().lastIndexOf("."));
        int imageResId = getResources().getIdentifier(imageName,"drawable",getPackageName());

        playerImageView.setImageResource(imageResId);
        playerBasicInfo.setText(selectedPlayer.getCompleteInfo());

        Button completeInfoBtn = findViewById(R.id.completeInfobtn);
        completeInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CompleteInfoActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
}
