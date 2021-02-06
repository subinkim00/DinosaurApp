package projects.femmehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AlarmActivity extends AppCompatActivity {
    private String hour;
    private String minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        SeekBar hourBar= findViewById(R.id.hourSlider);
        // perform seek bar change listener event used for getting the progress value
        hourBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            String hour;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                TextView textView = (TextView) findViewById(R.id.hour);
                String hourTime;
                if (progress < 10) {
                    hourTime = Integer.toString(progress);
                    hourTime = "0" + hourTime;
                    textView.setText(hourTime);
                } else {
                    hourTime = Integer.toString(progress);
                    textView.setText(hourTime);
                }
                hour = hourTime;
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar minuteBar= findViewById(R.id.minuteSlider);
        // perform seek bar change listener event used for getting the progress value
        minuteBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                TextView textView = (TextView) findViewById(R.id.minute);
                String minuteTime;
                if (progress < 10) {
                    minuteTime = Integer.toString(progress);
                    minuteTime = "0" + minuteTime;
                    textView.setText(minuteTime);
                } else {
                    minuteTime = Integer.toString(progress);
                    textView.setText(minuteTime);
                }

            }
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.goal_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.goals_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void setAlarm(View view) {

        finish();
    }

}