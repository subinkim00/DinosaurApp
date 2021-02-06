package projects.femmehacks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;
import android.widget.TimePicker;



public class AlarmActivity extends AppCompatActivity {
    private TimePicker timePicker;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        this.timePicker = timePicker;

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute){
                String date = hourOfDay + ":" + minute;
                TextView textView = findViewById(R.id.timeDisplay);
                textView.setText(date);
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
        TextView textView = findViewById(R.id.timeDisplay);
        CharSequence date = textView.getText();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("time", date);
        setResult(AlarmActivity.RESULT_OK,returnIntent);
        finish();
    }

}