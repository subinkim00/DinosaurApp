package projects.femmehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void toDiffPage(View view) {
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivityForResult(myIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if(resultCode == AlarmActivity.RESULT_OK){
                CharSequence time = data.getCharSequenceExtra("time");
                TextView textView = findViewById(R.id.timeDisplay);
                textView.setText(time);


            }
            if (resultCode == AlarmActivity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult








}