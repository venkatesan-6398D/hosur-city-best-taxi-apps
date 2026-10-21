package com.hosurcitybesttaxi.customer;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
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

        root.addView(text("HOSUR CITY", 18, Color.WHITE, true));
        root.addView(text("BEST TAXI", 34, YELLOW, true));
        root.addView(text("Your ride. Your way.", 15, Color.LTGRAY, false));
        root.addView(space(28));
        root.addView(text("Where would you like to go?", 22, Color.WHITE, true));
        root.addView(space(12));
        EditText pickup = input("Enter pickup location");
        EditText drop = input("Enter drop location");
        root.addView(pickup);
        root.addView(space(10));
        root.addView(drop);
        root.addView(space(16));
        Button book = button("BOOK A TAXI");
        book.setOnClickListener(v -> {
            if (pickup.getText().toString().trim().isEmpty() || drop.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "Please enter pickup and drop locations", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "UI demo only — booking backend not connected yet", Toast.LENGTH_LONG).show();
            }
        });
        root.addView(book);
        root.addView(space(18));
        root.addView(text("QUICK ACCESS", 16, YELLOW, true));
        root.addView(space(8));
        Button bookings = button("MY BOOKINGS");
        bookings.setOnClickListener(v -> Toast.makeText(this, "Booking history needs backend connection", Toast.LENGTH_SHORT).show());
        root.addView(bookings);
        root.addView(space(8));
        Button profile = button("MY PROFILE");
        profile.setOnClickListener(v -> Toast.makeText(this, "Profile/login will be added next", Toast.LENGTH_SHORT).show());
        root.addView(profile);
        root.addView(space(20));
        root.addView(text("Premium black & yellow • Customer App", 12, Color.GRAY, false));
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
    private EditText input(String hint) {
        EditText e = new EditText(this); e.setSingleLine(true); e.setHint(hint);
        e.setHintTextColor(Color.GRAY); e.setTextColor(Color.WHITE);
        e.setPadding(16, 10, 16, 10);
        e.setBackgroundTintList(android.content.res.ColorStateList.valueOf(YELLOW));
        return e;
    }
    private Button button(String label) {
        Button b = new Button(this); b.setText(label); b.setTextColor(BLACK); b.setTextSize(14);
        b.setTypeface(Typeface.DEFAULT, Typeface.BOLD); b.setAllCaps(false);
        b.setBackgroundTintList(android.content.res.ColorStateList.valueOf(YELLOW));
        b.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return b;
    }
}
