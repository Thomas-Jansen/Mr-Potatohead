// Author: Thomas Jansen 11008938


package jansen.thomas.mrpotatohead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

// Main activity, gets called when app is started
public class MainActivity extends AppCompatActivity {

    // Function which listens for checkboxen being checked
    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        // Get checkbox text
        String bodypart = checkbox.getText().toString();
        // Use checkbox text to make an ID to find the corresponding picture
        int bodypartID = getResources().getIdentifier("image" + bodypart, "id", getPackageName());
        /*
        bovenstaande methode gevonden op
        https://stackoverflow.com/questions/6679434/android-findviewbyid-with-a-variant-string/6679476
        */
        // Find the right image and change visibility
        ImageView image = (ImageView) findViewById(bodypartID);
        if (image.isShown())
            image.setVisibility(View.INVISIBLE);
        else
            image.setVisibility(View.VISIBLE);
    }
    // Load the layout when the app is opened
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Save current state when the app is closed, or orientation is changed
    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        for (int x = 1; x < 11; x++) {
            // Loop though every checkbox name
            int checkbox_id = getResources().getIdentifier("checkBox" + x, "id", getPackageName());
            CheckBox checkBox = (CheckBox) findViewById(checkbox_id);
            // Save checkbox state in outState
            String checkbox_ID = Integer.toString(checkbox_id);
                outState.putBoolean(checkbox_ID, checkBox.isChecked());
        }
    }

    // Load saved state when app is reopened
    @Override
    public void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        // Loop through checkbox names
        for (int x = 1; x < 11; x++) {
            int checkbox_id = getResources().getIdentifier("checkBox" + x, "id", getPackageName());
            String checkbox_ID = Integer.toString(checkbox_id);
            // Get the state in which the checkbox was saved
            boolean checkedBox = inState.getBoolean(checkbox_ID);
            // If checkbox was checked set corresponding image visible
            if (checkedBox){
                CheckBox checkBox = (CheckBox) findViewById(checkbox_id);
                String bodypart = checkBox.getText().toString();
                int bodypartID = getResources().getIdentifier("image" + bodypart, "id", getPackageName());
                ImageView image = (ImageView) findViewById(bodypartID);
                image.setVisibility(View.VISIBLE);
            }
        }
    }
}
