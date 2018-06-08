package diegorys.es.ejemplosonido;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    Button btnPlay, btnstop;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnstop = (Button) findViewById(R.id.btnStop);

        btnPlay.setOnClickListener(this);
        btnstop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                this.play();
                break;
            case R.id.btnStop:
                this.stop();
                break;
        }
    }

    private void play(){
        this.stop();
        mp = MediaPlayer.create(this, R.raw.sonido);
        mp.start();
    }

    private void stop(){
        if(mp != null && mp.isPlaying()) {
            mp.stop();
        }
    }
}
