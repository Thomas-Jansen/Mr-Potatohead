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
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt(bodypartID, value);
//        outState.putString(bodypartID, value);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
