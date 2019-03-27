package am.barcamp.official;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import am.barcamp.official.dto.ScheduleItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the "Explore Workshops" button */
    public void exploreWorkshops(View view) {
        Intent intent = new Intent(this, ExploreWorkshopsActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the "Saved Workshops" button */
    public void viewSavedWorkshops(View view) {
        Intent intent = new Intent(this, SavedWorkshopsActivity.class);
        startActivity(intent);
    }
}
