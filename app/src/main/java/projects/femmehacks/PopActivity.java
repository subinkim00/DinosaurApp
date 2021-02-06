package projects.femmehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class PopActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton[][] bubbles = new ImageButton[4][4];
    private ImageButton goalBubble;

    private int goalRow = (int)(Math.random() * 5);
    private int goalCol = (int)(Math.random() * 5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < bubbles.length; i++) {
            for (int j = 0; j < bubbles[i].length; j++) {
                String bubbleID = "bubble_" + i + j;
                int resID = getResources().getIdentifier(bubbleID, "id", getPackageName());
                bubbles[i][j] = findViewById(resID);
                bubbles[i][j].setOnClickListener(this);
            }
        }

        goalBubble = bubbles[goalRow][goalCol];
    }

    @Override
    public void onClick(View v) {
        if (v.equals(goalBubble)) {
            Intent myIntent = new Intent(v.getContext(), EndActivity.class);
            startActivity(myIntent);
        } else {
            v.setEnabled(false);
        }
    }
}