package jansen.thomas.mrpotatohead;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public void checkClicked(View v) {
        CheckBox checkbox = (CheckBox) v;
        String bodypart = checkbox.getText().toString();
        int bodypartID = getResources().getIdentifier("image" + bodypart, "id", getPackageName());
        //bovenstaande methode gevonden op
        // https://stackoverflow.com/questions/6679434/android-findviewbyid-with-a-variant-string/6679476
        ImageView image = (ImageView) findViewById(bodypartID);

        if (image.isShown())
            image.setVisibility(View.INVISIBLE);
        else
            image.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        for (int x = 1; x < 11; x++) {
            int checkbox_id = getResources().getIdentifier("checkBox" + x, "id", getPackageName());
            CheckBox checkBox = (CheckBox) findViewById(checkbox_id);
            String checkbox_ID = Integer.toString(checkbox_id);
                outState.putBoolean(checkbox_ID, checkBox.isChecked());

        }
    }


    @Override
    public void onRestoreInstanceState(Bundle inState) {

        super.onRestoreInstanceState(inState);
        for (int x = 1; x < 11; x++) {
            int checkbox_id = getResources().getIdentifier("checkBox" + x, "id", getPackageName());
            String checkbox_ID = Integer.toString(checkbox_id);
            boolean checkedBox = inState.getBoolean(checkbox_ID);

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
