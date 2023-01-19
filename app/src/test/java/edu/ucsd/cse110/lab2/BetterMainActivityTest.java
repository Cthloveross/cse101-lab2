package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equals_two(){
        var scenario =ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button button1 = (Button) activity.findViewById(R.id.btn_one);
            button1.performClick();

            // Find the "+" button and click it
            Button buttonAdd = (Button) activity.findViewById(R.id.btn_plus);
            buttonAdd.performClick();

            // Find the "1" button and click it again
            button1.performClick();

            // Find the "=" button and click it
            Button buttonEqual = (Button) activity.findViewById(R.id.btn_equals);
            buttonEqual.performClick();

            // Find the TextView with ID R.id.display and assert its value is "2"
            TextView display = (TextView) activity.findViewById(R.id.display);
            assertEquals("2", display.getText().toString());
        });
    }
}
