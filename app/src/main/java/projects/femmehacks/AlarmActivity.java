package projects.femmehacks;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
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
                String item = spinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void setAlarm(View view) {
        Spinner spinner = findViewById(R.id.goal_spinner);
        String text = spinner.getSelectedItem().toString();
        EditText txtname = findViewById(R.id.goal1);
        String goal =  txtname.getText().toString();
        text = text + ": " + goal;
        TextView textView = findViewById(R.id.timeDisplay);
        CharSequence date = textView.getText();

        Intent returnIntent = new Intent();
        returnIntent.putExtra("time", date);
        returnIntent.putExtra("text", text);
        setResult(AlarmActivity.RESULT_OK,returnIntent);
        finish();
    }

}