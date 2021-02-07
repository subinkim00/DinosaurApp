package projects.femmehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    String goalTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toDiffPage(View view) {
        Intent myIntent = new Intent(view.getContext(), AlarmActivity.class);
        startActivityForResult(myIntent, 0);
    }

    public void goPop(View v) {
        Intent myIntent = new Intent(v.getContext(), PopActivity.class);
        myIntent.putExtra("goals", this.goalTxt); // Sends goals to the next activity
        startActivityForResult(myIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        CharSequence timeSeq = data.getCharSequenceExtra("time");

        if (requestCode == 0) {
            if (resultCode == AlarmActivity.RESULT_OK){
                // CharSequence time = data.getCharSequenceExtra("time");
                String time = timeSeq.toString();
                int hour = Integer.parseInt(time.substring(0, 2));
                int minute = Integer.parseInt(time.substring(3, timeSeq.length()));
                Calendar calendar = GregorianCalendar.getInstance();
                TextView textView = findViewById(R.id.timeDisplay);
                textView.setText(timeSeq);
                String text = data.getStringExtra("text");
                goalTxt = text;
                TextView textView2 = findViewById(R.id.textDisplay);
                textView2.setText(text);

//                Timer timer = new Timer();
//                Intent myIntent = new Intent(this, PopActivity.class);
//
//                if (hour == calendar.get(Calendar.HOUR_OF_DAY) && minute == calendar.get(Calendar.MINUTE)) {
//                    startActivity(myIntent);
//                }
//
//                timer.schedule( new TimerTask() {
//                    public void run() {
//                        if (hour == calendar.get(Calendar.HOUR_OF_DAY) && minute == calendar.get(Calendar.MINUTE)) {
//                            startActivity(myIntent);
//                            timer.cancel();
//                        } else {
//                            System.out.println("hi");
//                        }
//                    }
//                }, 0, 60*1000);

            }
            if (resultCode == AlarmActivity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }


    }//onActivityResult


}