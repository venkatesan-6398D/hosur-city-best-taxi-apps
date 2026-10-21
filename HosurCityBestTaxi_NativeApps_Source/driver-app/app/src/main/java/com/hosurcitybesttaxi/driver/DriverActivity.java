package com.hosurcitybesttaxi.driver;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DriverActivity extends Activity {
    private final int BLACK = Color.rgb(15, 15, 15);
    private final int YELLOW = Color.rgb(255, 193, 7);
    private LinearLayout root;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(BLACK);
        getWindow().setNavigationBarColor(BLACK);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(24, 36, 24, 24);
        root.setBackgroundColor(BLACK);

        TextView brand = text("HOSUR CITY BEST TAXI", 23, YELLOW, true);
        root.addView(brand);
        root.addView(text("DRIVER PARTNER", 13, Color.WHITE, true));
        root.addView(space(28));
        root.addView(text("Welcome, Driver", 27, Color.WHITE, true));
        root.addView(text("Your trip requests will appear here.", 15, Color.LTGRAY, false));
        root.addView(space(22));
        Button online = button("GO ONLINE");
        online.setOnClickListener(v -> {
            online.setText(online.getText().toString().equals("GO ONLINE") ? "GO OFFLINE" : "GO ONLINE");
            Toast.makeText(this, "Demo only — backend connection not added yet", Toast.LENGTH_LONG).show();
        });
        root.addView(online);
        root.addView(space(20));
        root.addView(text("NEW BOOKING", 17, YELLOW, true));
        root.addView(space(8));
        root.addView(text("No active requests yet\\nBooking requests need a shared backend to appear here.", 15, Color.WHITE, false));
        root.addView(space(22));
        Button accept = button("ACCEPT REQUEST (DEMO)");
        accept.setOnClickListener(v -> Toast.makeText(this, "Backend not connected yet", Toast.LENGTH_SHORT).show());
        root.addView(accept);
        root.addView(space(10));
        Button trip = button("START / COMPLETE TRIP (DEMO)");
        trip.setOnClickListener(v -> Toast.makeText(this, "Trip status demo only", Toast.LENGTH_SHORT).show());
        root.addView(trip);
        setContentView(root);
    }

    private TextView text(String value, int size, int color, boolean bold) {
        TextView t = new TextView(this);
        t.setText(value); t.setTextSize(size); t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        t.setPadding(0, 5, 0, 5);
        return t;
    }
    private View space(int h) { View v = new View(this); v.setLayoutParams(new LinearLayout.LayoutParams(1, h)); return v; }
    private Button button(String label) {
        Button b = new Button(this); b.setText(label); b.setTextColor(BLACK); b.setTextSize(14);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD); b.setAllCaps(false); b.setText(label);
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(YELLOW));
        b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return b;
    }
}
