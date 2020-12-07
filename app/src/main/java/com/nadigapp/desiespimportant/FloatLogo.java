package com.nadigapp.desiespimportant;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.cardview.widget.CardView;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorChangedListener;

import static java.lang.System.exit;

;

public class FloatLogo extends Service implements View.OnClickListener {

    private WindowManager mWindowManager;
    private View mFloatingView;
    int mDefaultColor;

    @SuppressLint("StaticFieldLeak")
    private static FloatLogo Instance;

    public FloatLogo() {
    }
    static {
        System.loadLibrary("native-lib");
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    View espView,logoView;
    {
        System.loadLibrary("native-lib");
    }
    @SuppressLint("CutPasteId")
    @Override
    public void onCreate() {
        super.onCreate();
        Instance=this;
        createOver();

        logoView = mFloatingView.findViewById(R.id.relativeLayoutParent);
        espView = mFloatingView.findViewById(R.id.expanded_container);
        Init();

    }

    @SuppressLint("InflateParams")
    void createOver(){
        //getting the widget layout from xml using layout inflater
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.float_logo, null);
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;

        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
        }
        //setting the layout parameters
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.RGBA_8888);
        params.gravity = Gravity.TOP | Gravity.LEFT;

        //getting windows services and adding the floating view to it
        mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);


        final GestureDetector gestureDetector = new GestureDetector(this, new SingleTapConfirm());

        //window funclion
        TextView closeBtn=mFloatingView.findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                espView.setVisibility(View.GONE);
                logoView.setVisibility(View.VISIBLE);
            }
        });


        final LinearLayout player =mFloatingView.findViewById(R.id.players);
        final LinearLayout items =mFloatingView.findViewById(R.id.items);
        final LinearLayout theme =mFloatingView.findViewById(R.id.settingmenu);
        final TextView playerBtn=mFloatingView.findViewById(R.id.playerBtn);
        final ImageView playerBtn2=mFloatingView.findViewById(R.id.playerBtn2);
        final ImageView itemBtn=mFloatingView.findViewById(R.id.itemBtn);
        final TextView vehicleBtn=mFloatingView.findViewById(R.id.vehicleBtn);
        final TextView setting=mFloatingView.findViewById(R.id.setting);
        final TextView setting2=mFloatingView.findViewById(R.id.setting2);

        final LinearLayout itemspecial =mFloatingView.findViewById(R.id.spesialsitem);
        final LinearLayout itemautoar =mFloatingView.findViewById(R.id.autoaritem);
        final LinearLayout itemscope =mFloatingView.findViewById(R.id.scoperitem);
        final LinearLayout itemsniper =mFloatingView.findViewById(R.id.snperitem);
        final LinearLayout itemshotgun =mFloatingView.findViewById(R.id.shotgunpitem);
        final LinearLayout itempistol =mFloatingView.findViewById(R.id.pidtolsitem);
        final LinearLayout itemammo =mFloatingView.findViewById(R.id.ammossitem);
        final LinearLayout itembaghelmet =mFloatingView.findViewById(R.id.baghelmetsitem);
        final LinearLayout itemhealt =mFloatingView.findViewById(R.id.healthkitsitem);
        final LinearLayout itemthrowble =mFloatingView.findViewById(R.id.throwblesitem);
        final LinearLayout itemother =mFloatingView.findViewById(R.id.othersitem);
        final LinearLayout itemvihicle =mFloatingView.findViewById(R.id.vihiclesitem);

        final TextView vihick=mFloatingView.findViewById(R.id.vihicleitem);
        final TextView spesial=mFloatingView.findViewById(R.id.spesitem);
        final TextView scope=mFloatingView.findViewById(R.id.scopeitem);
        final TextView auto=mFloatingView.findViewById(R.id.autoitem);
        final TextView sniper=mFloatingView.findViewById(R.id.sniperitem);
        final TextView shotgun=mFloatingView.findViewById(R.id.shotgunitem);
        final TextView pistol=mFloatingView.findViewById(R.id.pistolitem);
        final TextView ammot=mFloatingView.findViewById(R.id.ammoitem);
        final TextView baghelmat=mFloatingView.findViewById(R.id.baghelmetitem);
        final TextView healthkit=mFloatingView.findViewById(R.id.healthkititem);
        final TextView throwbles=mFloatingView.findViewById(R.id.Throwablesitem);
        final TextView othert=mFloatingView.findViewById(R.id.otheritem);

        final ToggleButton style1=mFloatingView.findViewById(R.id.showstyele);
        final ToggleButton style2=mFloatingView.findViewById(R.id.showstyele2);
        final ToggleButton style3=mFloatingView.findViewById(R.id.showstyele3);
        final ToggleButton style4=mFloatingView.findViewById(R.id.showstyele4);
        final ToggleButton style5=mFloatingView.findViewById(R.id.showstyele5);
        final ToggleButton style6=mFloatingView.findViewById(R.id.showstyele6);
        final ToggleButton style7=mFloatingView.findViewById(R.id.showstyele7);
        final ToggleButton style8=mFloatingView.findViewById(R.id.showstyele8);
        final ToggleButton style9=mFloatingView.findViewById(R.id.showstyele9);

        final CardView tema=mFloatingView.findViewById(R.id.themebox);
        final CardView tema2=mFloatingView.findViewById(R.id.themeskeleton);
        final CardView tema3=mFloatingView.findViewById(R.id.themeshead);
        final CardView tema4=mFloatingView.findViewById(R.id.themeline);
        final CardView tema5=mFloatingView.findViewById(R.id.themealert);
        final CardView tema6=mFloatingView.findViewById(R.id.themeitem);
        final CardView tema7=mFloatingView.findViewById(R.id.themeisname);
        final CardView tema8=mFloatingView.findViewById(R.id.themeisDist);
        final CardView tema9=mFloatingView.findViewById(R.id.themeisEnemyWeapon);

        style1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema.setVisibility(View.VISIBLE);
                }else {
                    tema.setVisibility(View.GONE);
                }
            }
        });

        style2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema2.setVisibility(View.VISIBLE);
                }else {
                    tema2.setVisibility(View.GONE);
                }
            }
        });

        style3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema3.setVisibility(View.VISIBLE);
                }else {
                    tema3.setVisibility(View.GONE);
                }
            }
        });

        style4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema4.setVisibility(View.VISIBLE);
                }else {
                    tema4.setVisibility(View.GONE);
                }
            }
        });

        style5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema5.setVisibility(View.VISIBLE);
                }else {
                    tema5.setVisibility(View.GONE);
                }
            }
        });

        style6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema6.setVisibility(View.VISIBLE);
                }else {
                    tema6.setVisibility(View.GONE);
                }
            }
        });

        style7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema7.setVisibility(View.VISIBLE);
                }else {
                    tema7.setVisibility(View.GONE);
                }
            }
        });

        style8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema8.setVisibility(View.VISIBLE);
                }else {
                    tema8.setVisibility(View.GONE);
                }
            }
        });

        style9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tema9.setVisibility(View.VISIBLE);
                }else {
                    tema9.setVisibility(View.GONE);
                }
            }
        });

        spesial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spesial.setBackgroundColor(Color.parseColor("#FFFFFF"));
                spesial.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.VISIBLE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        scope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scope.setBackgroundColor(Color.parseColor("#FFFFFF"));
                scope.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.VISIBLE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auto.setBackgroundColor(Color.parseColor("#FFFFFF"));
                auto.setTextColor(Color.parseColor("#000000"));

                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.VISIBLE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        sniper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sniper.setBackgroundColor(Color.parseColor("#FFFFFF"));
                sniper.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.VISIBLE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        shotgun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotgun.setBackgroundColor(Color.parseColor("#FFFFFF"));
                shotgun.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.VISIBLE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        pistol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pistol.setBackgroundColor(Color.parseColor("#FFFFFF"));
                pistol.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.VISIBLE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        ammot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ammot.setBackgroundColor(Color.parseColor("#FFFFFF"));
                ammot.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.VISIBLE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        baghelmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baghelmat.setBackgroundColor(Color.parseColor("#FFFFFF"));
                baghelmat.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.VISIBLE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        healthkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                healthkit.setBackgroundColor(Color.parseColor("#FFFFFF"));
                healthkit.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.VISIBLE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        throwbles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throwbles.setBackgroundColor(Color.parseColor("#FFFFFF"));
                throwbles.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.VISIBLE);
                itemother.setVisibility(View.GONE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        othert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                othert.setBackgroundColor(Color.parseColor("#FFFFFF"));
                othert.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));
                vihick.setBackgroundColor(Color.parseColor("#FF102030"));
                vihick.setTextColor(Color.parseColor("#FFFFFF"));

                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.VISIBLE);
                itemvihicle.setVisibility(View.GONE);

            }
        });

        vihick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vihick.setBackgroundColor(Color.parseColor("#FFFFFF"));
                vihick.setTextColor(Color.parseColor("#000000"));

                auto.setBackgroundColor(Color.parseColor("#FF102030"));
                auto.setTextColor(Color.parseColor("#FFFFFF"));
                scope.setBackgroundColor(Color.parseColor("#FF102030"));
                scope.setTextColor(Color.parseColor("#FFFFFF"));
                sniper.setBackgroundColor(Color.parseColor("#FF102030"));
                sniper.setTextColor(Color.parseColor("#FFFFFF"));
                shotgun.setBackgroundColor(Color.parseColor("#FF102030"));
                shotgun.setTextColor(Color.parseColor("#FFFFFF"));
                pistol.setBackgroundColor(Color.parseColor("#FF102030"));
                pistol.setTextColor(Color.parseColor("#FFFFFF"));
                ammot.setBackgroundColor(Color.parseColor("#FF102030"));
                ammot.setTextColor(Color.parseColor("#FFFFFF"));
                baghelmat.setBackgroundColor(Color.parseColor("#FF102030"));
                baghelmat.setTextColor(Color.parseColor("#FFFFFF"));
                healthkit.setBackgroundColor(Color.parseColor("#FF102030"));
                healthkit.setTextColor(Color.parseColor("#FFFFFF"));
                throwbles.setBackgroundColor(Color.parseColor("#FF102030"));
                throwbles.setTextColor(Color.parseColor("#FFFFFF"));
                othert.setBackgroundColor(Color.parseColor("#FF102030"));
                othert.setTextColor(Color.parseColor("#FFFFFF"));
                spesial.setBackgroundColor(Color.parseColor("#FF102030"));
                spesial.setTextColor(Color.parseColor("#FFFFFF"));

                itemvihicle.setVisibility(View.VISIBLE);
                itemspecial.setVisibility(View.GONE);
                itemscope.setVisibility(View.GONE);
                itemsniper.setVisibility(View.GONE);
                itemshotgun.setVisibility(View.GONE);
                itemautoar.setVisibility(View.GONE);
                itemammo.setVisibility(View.GONE);
                itembaghelmet.setVisibility(View.GONE);
                itemhealt.setVisibility(View.GONE);
                itempistol.setVisibility(View.GONE);
                itemthrowble.setVisibility(View.GONE);
                itemother.setVisibility(View.GONE);

            }
        });


        playerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemBtn.setBackgroundColor(Color.parseColor("#E4E4E4"));
//                playerBtn.setBackgroundColor(Color.parseColor("#150432"));
//                vehicleBtn.setBackgroundColor(Color.parseColor("#F3F3F3"));
//                playerBtn.setTextColor(Color.parseColor("#5EE863"));
//                setting.setBackgroundColor(Color.parseColor("#F3F3F3"));
//                itemBtn.setTextColor(Color.BLACK);
//                setting.setTextColor(Color.BLACK);
//                vehicleBtn.setTextColor(Color.BLACK);
                items.setVisibility(View.GONE);
                player.setVisibility(View.VISIBLE);
                theme.setVisibility(View.GONE);
            }
        });

        itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemBtn.setBackgroundColor(Color.parseColor("#150432"));
//                playerBtn.setBackgroundColor(Color.parseColor("#D5D5D5"));
//                vehicleBtn.setBackgroundColor(Color.parseColor("#F3F3F3"));
//                setting.setBackgroundColor(Color.parseColor("#F3F3F3"));
//                playerBtn.setTextColor(Color.BLACK);
//                setting.setTextColor(Color.BLACK);
//                itemBtn.setTextColor(Color.parseColor("#5EE863"));
//                vehicleBtn.setTextColor(Color.BLACK);
                items.setVisibility(View.VISIBLE);
                player.setVisibility(View.GONE);
                theme.setVisibility(View.GONE);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemBtn.setBackgroundColor(Color.parseColor("#E4E4E4"));
//                playerBtn.setBackgroundColor(Color.parseColor("#D5D5D5"));
//                setting.setBackgroundColor(Color.parseColor("#150432"));
//                vehicleBtn.setBackgroundColor(Color.parseColor("#F3F3F3"));
//                playerBtn.setTextColor(Color.BLACK);
//                itemBtn.setTextColor(Color.BLACK);
//                vehicleBtn.setTextColor(Color.BLACK);
//                setting.setTextColor(Color.parseColor("#5EE863"));
                items.setVisibility(View.GONE);
                player.setVisibility(View.GONE);
                theme.setVisibility(View.VISIBLE);
            }
        });

        setting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                itemBtn.setBackgroundColor(Color.parseColor("#E4E4E4"));
//                playerBtn.setBackgroundColor(Color.parseColor("#D5D5D5"));
//                setting.setBackgroundColor(Color.parseColor("#150432"));
//                vehicleBtn.setBackgroundColor(Color.parseColor("#F3F3F3"));
//                playerBtn.setTextColor(Color.BLACK);
//                itemBtn.setTextColor(Color.BLACK);
//                vehicleBtn.setTextColor(Color.BLACK);
//                setting.setTextColor(Color.parseColor("#5EE863"));
                items.setVisibility(View.GONE);
                player.setVisibility(View.GONE);
                theme.setVisibility(View.VISIBLE);
            }
        });



        //floating window setting
        mFloatingView.findViewById(R.id.relativeLayoutParent).setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (gestureDetector.onTouchEvent(event)) {
                    espView.setVisibility(View.VISIBLE);
                    logoView.setVisibility(View.GONE);
                    return true;
                } else {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            initialX = params.x;
                            initialY = params.y;
                            initialTouchX = event.getRawX();
                            initialTouchY = event.getRawY();
                            return true;


                        case MotionEvent.ACTION_MOVE:
                            //this code is helping the widget to move around the screen with fingers
                            params.x = initialX + (int) (event.getRawX() - initialTouchX);
                            params.y = initialY + (int) (event.getRawY() - initialTouchY);

                            mWindowManager.updateViewLayout(mFloatingView, params);
                            return true;
                    }
                    return false;
                }
            }
        });




    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatingView != null) mWindowManager.removeView(mFloatingView);
    }

    @Override
    public void onClick(View v) {
       /* switch (v.getId()) {
            case R.id.floatLogo:
                //switching views
                espView.setVisibility(View.VISIBLE);
                logoView.setVisibility(View.GONE);
                break;

            case R.id.closeBtn:
                espView.setVisibility(View.GONE);
                logoView.setVisibility(View.VISIBLE);
                break;
        }*/
    }

    private String getType(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getString("type","1");
    }
    private void  setValue(String key,boolean b) {
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putBoolean(key,b);
        ed.apply();

    }

    boolean getConfig(String key){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
        // return !key.equals("");
    }
    void setFps(int fps){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("fps",fps);
        ed.apply();
    }
    void setPosition(int position){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("position",position);
        ed.apply();
    }

    void setSize(int size){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("size",size);
        ed.apply();
    }

    void setStrokeBox(int StrokeBox){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeBox",StrokeBox);
        ed.apply();
    }

    void setStrokeSkeleton(int StrokeSkeleton){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeSkeleton",StrokeSkeleton);
        ed.apply();
    }

    void setStrokeLine(int StrokeLine){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeLine",StrokeLine);
        ed.apply();
    }

    void setColorBox(int ColorBox){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorBox",ColorBox);
        ed.apply();
    }

    void setColorSkel(int ColorSkel){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorSkel",ColorSkel);
        ed.apply();
    }

    void setColorHead(int ColorHead){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorHead",ColorHead);
        ed.apply();
    }

    void setColorLine(int ColorLine){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorLine",ColorLine);
        ed.apply();
    }

    void setColorAlert(int ColorAlert){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorAlert",ColorAlert);
        ed.apply();
    }

    void setColorAlertText(int ColorAlertText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorAlertText",ColorAlertText);
        ed.apply();
    }

    void setItemSIze(int ItemSize){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ItemSize",ItemSize);
        ed.apply();
    }

    void setItemPosition(int ItemPosition){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ItemPosition",ItemPosition);
        ed.apply();
    }

    void setEnemyName(int EnemyName){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyName",EnemyName);
        ed.apply();
    }

    void setEnemyNameText(int EnemyNameText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyNameText",EnemyNameText);
        ed.apply();
    }

    void setEnemyDistance(int EnemyDistance){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyDistance",EnemyDistance);
        ed.apply();
    }

    void setEnemyDistanceText(int EnemyDistanceText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyDistanceText",EnemyDistanceText);
        ed.apply();
    }

    void setEnemyWeapon(int EnemyWeapon){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyWeapon",EnemyWeapon);
        ed.apply();
    }

    void setEnemyWeaponText(int EnemyWeaponText){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("EnemyWeaponText",EnemyWeaponText);
        ed.apply();
    }

    void setColorCrosHair(int ColorCrosHair){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("ColorCrosHair",ColorCrosHair);
        ed.apply();
    }

    void setStrokeCrosHair(int StrokeCrosHair){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeCrosHair",StrokeCrosHair);
        ed.apply();
    }

    void setStrokeCrosHair2(int StrokeCrosHair2){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("StrokeCrosHair2",StrokeCrosHair2);
        ed.apply();
    }

    void setIDBgt(int IDBgt){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed= sp.edit();
        ed.putInt("IDBgt",IDBgt);
        ed.apply();
    }

    int getColorCrosHair(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorCrosHair",100);
    }

    int getStrokeCrosHair(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeCrosHair",200);
    }

    int getStrokeCrosHair2(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeCrosHair2",0);
    }

    int getIDBgt(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("IDBgt",100);
    }

    int getEnemyName(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyName",100);
    }

    int getEnemyDistance(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyDistance",100);
    }

    int getEnemyWeapon(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyWeapon",100);
    }

    int getEnemyNameText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyNameText",100);
    }

    int getEnemyDistanceText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyDistanceText",100);
    }

    int getEnemyWeaponText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("EnemyWeaponText",100);
    }

    int getItemSize(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ItemSize",0);
    }

    int getItemPosition(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ItemPosition",0);
    }

    int getColorBox(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorBox",100);
    }

    int getColorSkel(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorSkel",100);
    }

    int getColorHead(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorHead",100);
    }

    int getColorLine(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorLine",100);
    }

    int getColorAlert(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorAlert",100);
    }

    int getColorAlertText(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("ColorAlertText",100);
    }

    int getFps(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("fps",100);
    }

    int getPosition(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("position",0);
    }

    int getSize(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("size",0);
    }

    int getStrokeBox(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeBox",0);
    }

    int getStrokeSkeleton(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeSkeleton",0);
    }

    int getStrokeLine(){
        SharedPreferences sp=this.getSharedPreferences("espValue",Context.MODE_PRIVATE);
        return sp.getInt("StrokeLine",0);
    }

    public static void HideFloat() {

        if (Instance != null)
        {
            Instance.Hide();
        }
    }
    public void Hide(){
        stopSelf();
        exit(-1);
        /*Instance = null;
        try {
            mWindowManager.removeView(mFloatingView);
        }catch (Exception e){
            System.out.println("-->"+e);
        }
        try {
        stopSelf();
        }catch (Exception e){
            System.out.println("-->"+e);
        }
            try {
        this.onDestroy();
            }catch (Exception e) {
                System.out.println("-->" + e);
            }*/
    }

    void Init(){
        final CheckBox Dual = mFloatingView.findViewById(R.id.dual);
        final CheckBox Material = mFloatingView.findViewById(R.id.meterial);
        final CheckBox MaterialDistance = mFloatingView.findViewById(R.id.meterialdistance);

        final CheckBox SQUARE = mFloatingView.findViewById(R.id.SQUARE);

        SQUARE.setChecked(getConfig((String) SQUARE.getText()));
        SQUARE.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SQUARE.getText()), SQUARE.isChecked());
            }
        });

        Material.setChecked(getConfig((String) Material.getText()));
        Material.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Material.getText()), Material.isChecked());
                if (isChecked) {
                    Dual.setChecked(false);
                    MaterialDistance.setChecked(false);
                }
            }
        });

        MaterialDistance.setChecked(getConfig((String) MaterialDistance.getText()));
        MaterialDistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MaterialDistance.getText()), MaterialDistance.isChecked());
                if (isChecked) {
                    Dual.setChecked(false);
                    Material.setChecked(false);
                }
            }
        });

        Dual.setChecked(getConfig((String) Dual.getText()));
        Dual.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Dual.getText()), Dual.isChecked());
                if (isChecked) {
                    Material.setChecked(false);
                    MaterialDistance.setChecked(false);
                }
            }
        });

        final CheckBox Buggy = mFloatingView.findViewById(R.id.Buggy);
        Buggy.setChecked(getConfig((String) Buggy.getText()));
        Buggy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Buggy.getText()), Buggy.isChecked());
            }
        });
        final CheckBox UAZ = mFloatingView.findViewById(R.id.UAZ);
        UAZ.setChecked(getConfig((String) UAZ.getText()));
        UAZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UAZ.getText()), UAZ.isChecked());
            }
        });
        final CheckBox Trike = mFloatingView.findViewById(R.id.Trike);
        Trike.setChecked(getConfig((String) Trike.getText()));
        Trike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Trike.getText()), Trike.isChecked());
            }
        });
        final CheckBox Bike = mFloatingView.findViewById(R.id.Bike);
        Bike.setChecked(getConfig((String) Bike.getText()));
        Bike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bike.getText()), Bike.isChecked());
            }
        });
        final CheckBox Dacia = mFloatingView.findViewById(R.id.Dacia);
        Dacia.setChecked(getConfig((String) Dacia.getText()));
        Dacia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Dacia.getText()), Dacia.isChecked());
            }
        });
        final CheckBox Jet = mFloatingView.findViewById(R.id.Jet);
        Jet.setChecked(getConfig((String) Jet.getText()));
        Jet.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Jet.getText()), Jet.isChecked());
            }
        });
        final CheckBox Boat = mFloatingView.findViewById(R.id.Boat);
        Boat.setChecked(getConfig((String) Boat.getText()));
        Boat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Boat.getText()), Boat.isChecked());
            }
        });
        final CheckBox Scooter = mFloatingView.findViewById(R.id.Scooter);
        Scooter.setChecked(getConfig((String) Scooter.getText()));
        Scooter.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Scooter.getText()), Scooter.isChecked());
            }
        });
        final CheckBox Bus = mFloatingView.findViewById(R.id.Bus);
        Bus.setChecked(getConfig((String) Bus.getText()));
        Bus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bus.getText()), Bus.isChecked());
            }
        });
        final CheckBox Mirado = mFloatingView.findViewById(R.id.Mirado);
        Mirado.setChecked(getConfig((String) Mirado.getText()));
        Mirado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mirado.getText()), Mirado.isChecked());
            }
        });
        final CheckBox Rony = mFloatingView.findViewById(R.id.Rony);
        Rony.setChecked(getConfig((String) Rony.getText()));
        Rony.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Rony.getText()), Rony.isChecked());
            }
        });
        final CheckBox Snowbike = mFloatingView.findViewById(R.id.Snowbike);
        Snowbike.setChecked(getConfig((String) Snowbike.getText()));
        Snowbike.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowbike.getText()), Snowbike.isChecked());
            }
        });
        final CheckBox Snowmobile = mFloatingView.findViewById(R.id.Snowmobile);
        Snowmobile.setChecked(getConfig((String) Snowmobile.getText()));
        Snowmobile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Snowmobile.getText()), Snowmobile.isChecked());
            }
        });
        final CheckBox Tempo = mFloatingView.findViewById(R.id.Tempo);
        Tempo.setChecked(getConfig((String) Tempo.getText()));
        Tempo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Tempo.getText()), Tempo.isChecked());
            }
        });
        final CheckBox Truck = mFloatingView.findViewById(R.id.Truck);
        Truck.setChecked(getConfig((String) Truck.getText()));
        Truck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Truck.getText()), Truck.isChecked());
            }
        });
        final CheckBox MonsterTruck = mFloatingView.findViewById(R.id.MonsterTruck);
        MonsterTruck.setChecked(getConfig((String) MonsterTruck.getText()));
        MonsterTruck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MonsterTruck.getText()), MonsterTruck.isChecked());
            }
        });
        final CheckBox BRDM = mFloatingView.findViewById(R.id.BRDM);
        BRDM.setChecked(getConfig((String) BRDM.getText()));
        BRDM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BRDM.getText()), BRDM.isChecked());
            }
        });
        final CheckBox LadaNiva = mFloatingView.findViewById(R.id.LadaNiva);
        LadaNiva.setChecked(getConfig((String) LadaNiva.getText()));
        LadaNiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LadaNiva.getText()), LadaNiva.isChecked());
            }
        });
        final CheckBox CheekPad = mFloatingView.findViewById(R.id.CheekPad);
        CheekPad.setChecked(getConfig((String) CheekPad.getText()));
        CheekPad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CheekPad.getText()), CheekPad.isChecked());
            }
        });
        final CheckBox AirDrop = mFloatingView.findViewById(R.id.AirDrop);
        AirDrop.setChecked(getConfig((String) AirDrop.getText()));
        AirDrop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AirDrop.getText()), AirDrop.isChecked());
            }
        });
        final CheckBox Crate = mFloatingView.findViewById(R.id.Crate);
        Crate.setChecked(getConfig((String) Crate.getText()));
        Crate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crate.getText()), Crate.isChecked());
            }
        });
        final CheckBox DropPlane = mFloatingView.findViewById(R.id.DropPlane);
        DropPlane.setChecked(getConfig((String) DropPlane.getText()));
        DropPlane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DropPlane.getText()), DropPlane.isChecked());
            }
        });
        final Switch isEnemyWeapon = mFloatingView.findViewById(R.id.isEnemyWeapon);
        isEnemyWeapon.setChecked(getConfig((String) isEnemyWeapon.getText()));
        SettingValue(10,getConfig((String) isEnemyWeapon.getText()));
        isEnemyWeapon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isEnemyWeapon.getText()), isEnemyWeapon.isChecked());
                SettingValue(10,isEnemyWeapon.isChecked());
            }
        });
        final Switch isGrenadeWarning = mFloatingView.findViewById(R.id.isGrenadeWarning);
        isGrenadeWarning.setChecked(getConfig((String) isGrenadeWarning.getText()));
        SettingValue(9,getConfig((String) isGrenadeWarning.getText()));
        isGrenadeWarning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isGrenadeWarning.getText()), isGrenadeWarning.isChecked());
                SettingValue(9,isGrenadeWarning.isChecked());
            }
        });
        final Switch isSkelton = mFloatingView.findViewById(R.id.isSkelton);
        isSkelton.setChecked(getConfig((String) isSkelton.getText()));
        SettingValue(8,getConfig((String) isSkelton.getText()));
        isSkelton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isSkelton.getText()), isSkelton.isChecked());
                SettingValue(8,isSkelton.isChecked());
            }
        });
        final Switch isHead = mFloatingView.findViewById(R.id.isHead);
        isHead.setChecked(getConfig((String) isHead.getText()));
        SettingValue(6,getConfig((String) isHead.getText()));
        isHead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHead.getText()), isHead.isChecked());
                SettingValue(6,isHead.isChecked());
            }
        });
        final Switch isBox = mFloatingView.findViewById(R.id.isBox);
        isBox.setChecked(getConfig((String) isBox.getText()));
        SettingValue(1,getConfig((String) isBox.getText()));
        isBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBox.getText()), isBox.isChecked());
                SettingValue(1,isBox.isChecked());
            }
        });
        final Switch isLine = mFloatingView.findViewById(R.id.isLine);
        isLine.setChecked(getConfig((String) isLine.getText()));
        SettingValue(2,getConfig((String) isLine.getText()));
        isLine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isLine.getText()), isLine.isChecked());
                SettingValue(2,isLine.isChecked());
            }
        });
        final Switch isBack = mFloatingView.findViewById(R.id.isBack);
        isBack.setChecked(getConfig((String) isBack.getText()));
        SettingValue(7,getConfig((String) isBack.getText()));
        isBack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isBack.getText()), isBack.isChecked());
                SettingValue(7,isBack.isChecked());
            }
        });

        final Switch isHealth = mFloatingView.findViewById(R.id.isHealth);
        isHealth.setChecked(getConfig((String) isHealth.getText()));
        SettingValue(4,getConfig((String) isHealth.getText()));
        isHealth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isHealth.getText()), isHealth.isChecked());
                SettingValue(4,isHealth.isChecked());
            }
        });

        final Switch isName = mFloatingView.findViewById(R.id.isName);
        isName.setChecked(getConfig((String) isName.getText()));
        SettingValue(5,getConfig((String) isName.getText()));
        isName.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isName.getText()), isName.isChecked());
                SettingValue(5,isName.isChecked());
            }
        });
        final Switch isDist = mFloatingView.findViewById(R.id.isDist);
        isDist.setChecked(getConfig((String) isDist.getText()));
        SettingValue(3,getConfig((String) isDist.getText()));
        isDist.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(isDist.getText()), isDist.isChecked());
                SettingValue(3,isDist.isChecked());
            }
        });




        final CheckBox canted = mFloatingView.findViewById(R.id.canted);
        canted.setChecked(getConfig((String) canted.getText()));
        canted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(canted.getText()),canted.isChecked());
            }
        });

        final CheckBox reddot = mFloatingView.findViewById(R.id.reddot);
        reddot.setChecked(getConfig((String) reddot.getText()));
        reddot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(reddot.getText()),reddot.isChecked());
            }
        });

        final CheckBox hollow = mFloatingView.findViewById(R.id.hollow);
        hollow.setChecked(getConfig((String) hollow.getText()));
        hollow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(hollow.getText()),hollow.isChecked());
            }
        });

        final CheckBox twox = mFloatingView.findViewById(R.id.twox);
        twox.setChecked(getConfig((String) twox.getText()));
        twox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(twox.getText()),twox.isChecked());
            }
        });

        final CheckBox threex = mFloatingView.findViewById(R.id.threex);
        threex.setChecked(getConfig((String) threex.getText()));
        threex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(threex.getText()),threex.isChecked());
            }
        });

        final CheckBox fourx = mFloatingView.findViewById(R.id.fourx);
        fourx.setChecked(getConfig((String) fourx.getText()));
        fourx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(fourx.getText()),fourx.isChecked());
            }
        });

        final CheckBox sixx = mFloatingView.findViewById(R.id.sixx);
        sixx.setChecked(getConfig((String) sixx.getText()));
        sixx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sixx.getText()),sixx.isChecked());
            }
        });

        final CheckBox eightx = mFloatingView.findViewById(R.id.eightx);
        eightx.setChecked(getConfig((String) eightx.getText()));
        eightx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(eightx.getText()),eightx.isChecked());
            }
        });

        final CheckBox AWM = mFloatingView.findViewById(R.id.AWM);
        AWM.setChecked(getConfig((String) AWM.getText()));
        AWM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AWM.getText()),AWM.isChecked());
            }
        });

        final CheckBox QBU = mFloatingView.findViewById(R.id.QBU);
        QBU.setChecked(getConfig((String) QBU.getText()));
        QBU.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBU.getText()),QBU.isChecked());
            }
        });

        final CheckBox SLR = mFloatingView.findViewById(R.id.SLR);
        SLR.setChecked(getConfig((String) SLR.getText()));
        SLR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SLR.getText()),SLR.isChecked());
            }
        });

        final CheckBox SKS = mFloatingView.findViewById(R.id.SKS);
        SKS.setChecked(getConfig((String) SKS.getText()));
        SKS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SKS.getText()),SKS.isChecked());
            }
        });

        final CheckBox Mini14 = mFloatingView.findViewById(R.id.Mini14);
        Mini14.setChecked(getConfig((String) Mini14.getText()));
        Mini14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mini14.getText()),Mini14.isChecked());
            }
        });

        final CheckBox M24 = mFloatingView.findViewById(R.id.M24);
        M24.setChecked(getConfig((String) M24.getText()));
        M24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M24.getText()),M24.isChecked());
            }
        });

        final CheckBox Kar98k = mFloatingView.findViewById(R.id.Kar98k);
        Kar98k.setChecked(getConfig((String) Kar98k.getText()));
        Kar98k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Kar98k.getText()),Kar98k.isChecked());
            }
        });

        final CheckBox VSS = mFloatingView.findViewById(R.id.VSS);
        VSS.setChecked(getConfig((String) VSS.getText()));
        VSS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VSS.getText()),VSS.isChecked());
            }
        });

        final CheckBox Win94 = mFloatingView.findViewById(R.id.Win94);
        Win94.setChecked(getConfig((String) Win94.getText()));
        Win94.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Win94.getText()),Win94.isChecked());
            }
        });

        final CheckBox AUG = mFloatingView.findViewById(R.id.AUG);
        AUG.setChecked(getConfig((String) AUG.getText()));
        AUG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AUG.getText()),AUG.isChecked());
            }
        });

        final CheckBox M762 = mFloatingView.findViewById(R.id.M762);
        M762.setChecked(getConfig((String) M762.getText()));
        M762.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M762.getText()),M762.isChecked());
            }
        });

        final CheckBox SCARL = mFloatingView.findViewById(R.id.SCARL);
        SCARL.setChecked(getConfig((String) SCARL.getText()));
        SCARL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SCARL.getText()),SCARL.isChecked());
            }
        });

        final CheckBox M416 = mFloatingView.findViewById(R.id.M416);
        M416.setChecked(getConfig((String) M416.getText()));
        M416.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M416.getText()),M416.isChecked());
            }
        });

        final CheckBox M16A4 = mFloatingView.findViewById(R.id.M16A4);
        M16A4.setChecked(getConfig((String) M16A4.getText()));
        M16A4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M16A4.getText()),M16A4.isChecked());
            }
        });

        final CheckBox Mk47Mutant = mFloatingView.findViewById(R.id.Mk47Mutant);
        Mk47Mutant.setChecked(getConfig((String) Mk47Mutant.getText()));
        Mk47Mutant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk47Mutant.getText()),Mk47Mutant.isChecked());
            }
        });

        final CheckBox G36C = mFloatingView.findViewById(R.id.G36C);
        G36C.setChecked(getConfig((String) G36C.getText()));
        G36C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(G36C.getText()),G36C.isChecked());
            }
        });

        final CheckBox QBZ = mFloatingView.findViewById(R.id.QBZ);
        QBZ.setChecked(getConfig((String) QBZ.getText()));
        QBZ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QBZ.getText()),QBZ.isChecked());
            }
        });

        final CheckBox AKM = mFloatingView.findViewById(R.id.AKM);
        AKM.setChecked(getConfig((String) AKM.getText()));
        AKM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AKM.getText()),AKM.isChecked());
            }
        });

        final CheckBox Groza = mFloatingView.findViewById(R.id.Groza);
        Groza.setChecked(getConfig((String) Groza.getText()));
        Groza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Groza.getText()),Groza.isChecked());
            }
        });

        final CheckBox S12K = mFloatingView.findViewById(R.id.S12K);
        S12K.setChecked(getConfig((String) S12K.getText()));
        S12K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S12K.getText()),S12K.isChecked());
            }
        });

        final CheckBox DBS = mFloatingView.findViewById(R.id.DBS);
        DBS.setChecked(getConfig((String) DBS.getText()));
        DBS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DBS.getText()),DBS.isChecked());
            }
        });

        final CheckBox S686 = mFloatingView.findViewById(R.id.S686);
        S686.setChecked(getConfig((String) S686.getText()));
        S686.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S686.getText()),S686.isChecked());
            }
        });

        final CheckBox S1897 = mFloatingView.findViewById(R.id.S1897);
        S1897.setChecked(getConfig((String) S1897.getText()));
        S1897.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(S1897.getText()),S1897.isChecked());
            }
        });

        final CheckBox SawedOff = mFloatingView.findViewById(R.id.SawedOff);
        SawedOff.setChecked(getConfig((String) SawedOff.getText()));
        SawedOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SawedOff.getText()),SawedOff.isChecked());
            }
        });

        final CheckBox TommyGun = mFloatingView.findViewById(R.id.TommyGun);
        TommyGun.setChecked(getConfig((String) TommyGun.getText()));
        TommyGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TommyGun.getText()),TommyGun.isChecked());
            }
        });

        final CheckBox MP5K = mFloatingView.findViewById(R.id.MP5K);
        MP5K.setChecked(getConfig((String) MP5K.getText()));
        MP5K.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(MP5K.getText()),MP5K.isChecked());
            }
        });

        final CheckBox Vector = mFloatingView.findViewById(R.id.Vector);
        Vector.setChecked(getConfig((String) Vector.getText()));
        Vector.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vector.getText()),Vector.isChecked());
            }
        });

        final CheckBox Uzi = mFloatingView.findViewById(R.id.Uzi);
        Uzi.setChecked(getConfig((String) Uzi.getText()));
        Uzi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Uzi.getText()),Uzi.isChecked());
            }
        });

        final CheckBox R1895 = mFloatingView.findViewById(R.id.R1895);
        R1895.setChecked(getConfig((String) R1895.getText()));
        R1895.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(R1895.getText()),R1895.isChecked());
            }
        });

        final CheckBox Vz61 = mFloatingView.findViewById(R.id.Vz61);
        Vz61.setChecked(getConfig((String) Vz61.getText()));
        Vz61.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vz61.getText()),Vz61.isChecked());
            }
        });

        final CheckBox P92 = mFloatingView.findViewById(R.id.P92);
        P92.setChecked(getConfig((String) P92.getText()));
        P92.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P92.getText()),P92.isChecked());
            }
        });

        final CheckBox P18C = mFloatingView.findViewById(R.id.P18C);
        P18C.setChecked(getConfig((String) P18C.getText()));
        P18C.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P18C.getText()),P18C.isChecked());
            }
        });

        final CheckBox R45 = mFloatingView.findViewById(R.id.R45);
        R45.setChecked(getConfig((String) R45.getText()));
        R45.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(R45.getText()),R45.isChecked());
            }
        });

        final CheckBox P1911 = mFloatingView.findViewById(R.id.P1911);
        P1911.setChecked(getConfig((String) P1911.getText()));
        P1911.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(P1911.getText()),P1911.isChecked());
            }
        });

        final CheckBox DesertEagle = mFloatingView.findViewById(R.id.DesertEagle);
        DesertEagle.setChecked(getConfig((String) DesertEagle.getText()));
        DesertEagle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DesertEagle.getText()),DesertEagle.isChecked());
            }
        });

        final CheckBox Sickle = mFloatingView.findViewById(R.id.Sickle);
        Sickle.setChecked(getConfig((String) Sickle.getText()));
        Sickle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Sickle.getText()),Sickle.isChecked());
            }
        });

        final CheckBox Machete = mFloatingView.findViewById(R.id.Machete);
        Machete.setChecked(getConfig((String) Machete.getText()));
        Machete.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Machete.getText()),Machete.isChecked());
            }
        });

        final CheckBox Pan = mFloatingView.findViewById(R.id.Pan);
        Pan.setChecked(getConfig((String) Pan.getText()));
        Pan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Pan.getText()),Pan.isChecked());
            }
        });

        final CheckBox Mk14 = mFloatingView.findViewById(R.id.Mk14);
        Mk14.setChecked(getConfig((String) Mk14.getText()));
        Mk14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Mk14.getText()),Mk14.isChecked());
            }
        });

        final CheckBox sst = mFloatingView.findViewById(R.id.sst);
        sst.setChecked(getConfig((String) sst.getText()));
        sst.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(sst.getText()),sst.isChecked());
            }
        });

        final CheckBox ffACP = mFloatingView.findViewById(R.id.ffACP);
        ffACP.setChecked(getConfig((String) ffACP.getText()));
        ffACP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffACP.getText()),ffACP.isChecked());
            }
        });

        final CheckBox ffs = mFloatingView.findViewById(R.id.ffs);
        ffs.setChecked(getConfig((String) ffs.getText()));
        ffs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ffs.getText()),ffs.isChecked());
            }
        });

        final CheckBox nmm = mFloatingView.findViewById(R.id.nmm);
        nmm.setChecked(getConfig((String) nmm.getText()));
        nmm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(nmm.getText()),nmm.isChecked());
            }
        });

        final CheckBox tzzMagnum = mFloatingView.findViewById(R.id.tzzMagnum);
        tzzMagnum.setChecked(getConfig((String) tzzMagnum.getText()));
        tzzMagnum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(tzzMagnum.getText()),tzzMagnum.isChecked());
            }
        });

        final CheckBox otGuage = mFloatingView.findViewById(R.id.otGuage);
        otGuage.setChecked(getConfig((String) otGuage.getText()));
        otGuage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(otGuage.getText()),otGuage.isChecked());
            }
        });

        final CheckBox Choke = mFloatingView.findViewById(R.id.Choke);
        Choke.setChecked(getConfig((String) Choke.getText()));
        Choke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Choke.getText()),Choke.isChecked());
            }
        });

        final CheckBox SniperCompensator = mFloatingView.findViewById(R.id.SniperCompensator);
        SniperCompensator.setChecked(getConfig((String) SniperCompensator.getText()));
        SniperCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SniperCompensator.getText()),SniperCompensator.isChecked());
            }
        });

        final CheckBox DP28 = mFloatingView.findViewById(R.id.DP28);
        DP28.setChecked(getConfig((String) DP28.getText()));
        DP28.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(DP28.getText()),DP28.isChecked());
            }
        });

        final CheckBox M249 = mFloatingView.findViewById(R.id.M249);
        M249.setChecked(getConfig((String) M249.getText()));
        M249.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(M249.getText()),M249.isChecked());
            }
        });

        final CheckBox Grenade = mFloatingView.findViewById(R.id.Grenade);
        Grenade.setChecked(getConfig((String) Grenade.getText()));
        Grenade.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Grenade.getText()),Grenade.isChecked());
            }
        });

        final CheckBox Smoke = mFloatingView.findViewById(R.id.Smoke);
        Smoke.setChecked(getConfig((String) Smoke.getText()));
        Smoke.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Smoke.getText()),Smoke.isChecked());
            }
        });

        final CheckBox Molotov = mFloatingView.findViewById(R.id.Molotov);
        Molotov.setChecked(getConfig((String) Molotov.getText()));
        Molotov.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Molotov.getText()),Molotov.isChecked());
            }
        });

        final CheckBox Painkiller = mFloatingView.findViewById(R.id.Painkiller);
        Painkiller.setChecked(getConfig((String) Painkiller.getText()));
        Painkiller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Painkiller.getText()),Painkiller.isChecked());
            }
        });

        final CheckBox Adrenaline = mFloatingView.findViewById(R.id.Adrenaline);
        Adrenaline.setChecked(getConfig((String) Adrenaline.getText()));
        Adrenaline.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Adrenaline.getText()),Adrenaline.isChecked());
            }
        });

        final CheckBox EnergyDrink = mFloatingView.findViewById(R.id.EnergyDrink);
        EnergyDrink.setChecked(getConfig((String) EnergyDrink.getText()));
        EnergyDrink.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(EnergyDrink.getText()),EnergyDrink.isChecked());
            }
        });

        final CheckBox FirstAidKit = mFloatingView.findViewById(R.id.FirstAidKit);
        FirstAidKit.setChecked(getConfig((String) FirstAidKit.getText()));
        FirstAidKit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FirstAidKit.getText()),FirstAidKit.isChecked());
            }
        });

        final CheckBox Bandage = mFloatingView.findViewById(R.id.Bandage);
        Bandage.setChecked(getConfig((String) Bandage.getText()));
        Bandage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bandage.getText()),Bandage.isChecked());
            }
        });

        final CheckBox Medkit = mFloatingView.findViewById(R.id.Medkit);
        Medkit.setChecked(getConfig((String) Medkit.getText()));
        Medkit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Medkit.getText()),Medkit.isChecked());
            }
        });

        final CheckBox FlareGun = mFloatingView.findViewById(R.id.FlareGun);
        FlareGun.setChecked(getConfig((String) FlareGun.getText()));
        FlareGun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlareGun.getText()),FlareGun.isChecked());
            }
        });

        final CheckBox GullieSuit = mFloatingView.findViewById(R.id.GullieSuit);
        GullieSuit.setChecked(getConfig((String) GullieSuit.getText()));
        GullieSuit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GullieSuit.getText()),GullieSuit.isChecked());
            }
        });

        final CheckBox UMP = mFloatingView.findViewById(R.id.UMP);
        UMP.setChecked(getConfig((String) UMP.getText()));
        UMP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(UMP.getText()),UMP.isChecked());
            }
        });

        final CheckBox Bizon = mFloatingView.findViewById(R.id.Bizon);
        Bizon.setChecked(getConfig((String) Bizon.getText()));
        Bizon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Bizon.getText()),Bizon.isChecked());
            }
        });

        final CheckBox CompensatorSMG = mFloatingView.findViewById(R.id.CompensatorSMG);
        CompensatorSMG.setChecked(getConfig((String) CompensatorSMG.getText()));
        CompensatorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CompensatorSMG.getText()),CompensatorSMG.isChecked());
            }
        });

        final CheckBox FlashHiderSMG = mFloatingView.findViewById(R.id.FlashHiderSMG);
        FlashHiderSMG.setChecked(getConfig((String) FlashHiderSMG.getText()));
        FlashHiderSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSMG.getText()),FlashHiderSMG.isChecked());
            }
        });

        final CheckBox FlashHiderAr = mFloatingView.findViewById(R.id.FlashHiderAr);
        FlashHiderAr.setChecked(getConfig((String) FlashHiderAr.getText()));
        FlashHiderAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderAr.getText()),FlashHiderAr.isChecked());
            }
        });

        final CheckBox ArCompensator = mFloatingView.findViewById(R.id.ArCompensator);
        ArCompensator.setChecked(getConfig((String) ArCompensator.getText()));
        ArCompensator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ArCompensator.getText()),ArCompensator.isChecked());
            }
        });

        final CheckBox TacticalStock = mFloatingView.findViewById(R.id.TacticalStock);
        TacticalStock.setChecked(getConfig((String) TacticalStock.getText()));
        TacticalStock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(TacticalStock.getText()),TacticalStock.isChecked());
            }
        });

        final CheckBox Duckbill = mFloatingView.findViewById(R.id.Duckbill);
        Duckbill.setChecked(getConfig((String) Duckbill.getText()));
        Duckbill.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Duckbill.getText()),Duckbill.isChecked());
            }
        });

        final CheckBox FlashHiderSniper = mFloatingView.findViewById(R.id.FlashHiderSniper);
        FlashHiderSniper.setChecked(getConfig((String) FlashHiderSniper.getText()));
        FlashHiderSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(FlashHiderSniper.getText()),FlashHiderSniper.isChecked());
            }
        });

        final CheckBox SuppressorSMG = mFloatingView.findViewById(R.id.SuppressorSMG);
        SuppressorSMG.setChecked(getConfig((String) SuppressorSMG.getText()));
        SuppressorSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSMG.getText()),SuppressorSMG.isChecked());
            }
        });

        final CheckBox HalfGrip = mFloatingView.findViewById(R.id.HalfGrip);
        HalfGrip.setChecked(getConfig((String) HalfGrip.getText()));
        HalfGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(HalfGrip.getText()),HalfGrip.isChecked());
            }
        });

        final CheckBox StockMicroUZI = mFloatingView.findViewById(R.id.StockMicroUZI);
        StockMicroUZI.setChecked(getConfig((String) StockMicroUZI.getText()));
        StockMicroUZI.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(StockMicroUZI.getText()),StockMicroUZI.isChecked());
            }
        });

        final CheckBox SuppressorSniper = mFloatingView.findViewById(R.id.SuppressorSniper);
        SuppressorSniper.setChecked(getConfig((String) SuppressorSniper.getText()));
        SuppressorSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorSniper.getText()),SuppressorSniper.isChecked());
            }
        });

        final CheckBox SuppressorAr = mFloatingView.findViewById(R.id.SuppressorAr);
        SuppressorAr.setChecked(getConfig((String) SuppressorAr.getText()));
        SuppressorAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(SuppressorAr.getText()),SuppressorAr.isChecked());
            }
        });

        final CheckBox ExQdSniper = mFloatingView.findViewById(R.id.ExQdSniper);
        ExQdSniper.setChecked(getConfig((String) ExQdSniper.getText()));
        ExQdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSniper.getText()),ExQdSniper.isChecked());
            }
        });

        final CheckBox QdSMG = mFloatingView.findViewById(R.id.QdSMG);
        QdSMG.setChecked(getConfig((String) QdSMG.getText()));
        QdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSMG.getText()),QdSMG.isChecked());
            }
        });

        final CheckBox ExSMG = mFloatingView.findViewById(R.id.ExSMG);
        ExSMG.setChecked(getConfig((String) ExSMG.getText()));
        ExSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSMG.getText()),ExSMG.isChecked());
            }
        });

        final CheckBox QdSniper = mFloatingView.findViewById(R.id.QdSniper);
        QdSniper.setChecked(getConfig((String) QdSniper.getText()));
        QdSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdSniper.getText()),QdSniper.isChecked());
            }
        });

        final CheckBox ExSniper = mFloatingView.findViewById(R.id.ExSniper);
        ExSniper.setChecked(getConfig((String) ExSniper.getText()));
        ExSniper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExSniper.getText()),ExSniper.isChecked());
            }
        });

        final CheckBox ExAr = mFloatingView.findViewById(R.id.ExAr);
        ExAr.setChecked(getConfig((String) ExAr.getText()));
        ExAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExAr.getText()),ExAr.isChecked());
            }
        });

        final CheckBox ExQdAr = mFloatingView.findViewById(R.id.ExQdAr);
        ExQdAr.setChecked(getConfig((String) ExQdAr.getText()));
        ExQdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdAr.getText()),ExQdAr.isChecked());
            }
        });

        final CheckBox QdAr = mFloatingView.findViewById(R.id.QdAr);
        QdAr.setChecked(getConfig((String) QdAr.getText()));
        QdAr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QdAr.getText()),QdAr.isChecked());
            }
        });

        final CheckBox ExQdSMG = mFloatingView.findViewById(R.id.ExQdSMG);
        ExQdSMG.setChecked(getConfig((String) ExQdSMG.getText()));
        ExQdSMG.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ExQdSMG.getText()),ExQdSMG.isChecked());
            }
        });

        final CheckBox QuiverCrossBow = mFloatingView.findViewById(R.id.QuiverCrossBow);
        QuiverCrossBow.setChecked(getConfig((String) QuiverCrossBow.getText()));
        QuiverCrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(QuiverCrossBow.getText()),QuiverCrossBow.isChecked());
            }
        });

        final CheckBox BulletLoop = mFloatingView.findViewById(R.id.BulletLoop);
        BulletLoop.setChecked(getConfig((String) BulletLoop.getText()));
        BulletLoop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(BulletLoop.getText()),BulletLoop.isChecked());
            }
        });

        final CheckBox ThumbGrip = mFloatingView.findViewById(R.id.ThumbGrip);
        ThumbGrip.setChecked(getConfig((String) ThumbGrip.getText()));
        ThumbGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(ThumbGrip.getText()),ThumbGrip.isChecked());
            }
        });

        final CheckBox LaserSight = mFloatingView.findViewById(R.id.LaserSight);
        LaserSight.setChecked(getConfig((String) LaserSight.getText()));
        LaserSight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LaserSight.getText()),LaserSight.isChecked());
            }
        });

        final CheckBox AngledGrip = mFloatingView.findViewById(R.id.AngledGrip);
        AngledGrip.setChecked(getConfig((String) AngledGrip.getText()));
        AngledGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(AngledGrip.getText()),AngledGrip.isChecked());
            }
        });

        final CheckBox LightGrip = mFloatingView.findViewById(R.id.LightGrip);
        LightGrip.setChecked(getConfig((String) LightGrip.getText()));
        LightGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(LightGrip.getText()),LightGrip.isChecked());
            }
        });

        final CheckBox VerticalGrip = mFloatingView.findViewById(R.id.VerticalGrip);
        VerticalGrip.setChecked(getConfig((String) VerticalGrip.getText()));
        VerticalGrip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(VerticalGrip.getText()),VerticalGrip.isChecked());
            }
        });

        final CheckBox GasCan = mFloatingView.findViewById(R.id.GasCan);
        GasCan.setChecked(getConfig((String) GasCan.getText()));
        GasCan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(GasCan.getText()),GasCan.isChecked());
            }
        });

        final CheckBox Arrow = mFloatingView.findViewById(R.id.Arrow);
        Arrow.setChecked(getConfig((String) Arrow.getText()));
        Arrow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Arrow.getText()),Arrow.isChecked());
            }
        });

        final CheckBox CrossBow = mFloatingView.findViewById(R.id.CrossBow);
        CrossBow.setChecked(getConfig((String) CrossBow.getText()));
        CrossBow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(CrossBow.getText()),CrossBow.isChecked());
            }
        });

        final CheckBox Baglvl1 = mFloatingView.findViewById(R.id.Baglvl1);
        Baglvl1.setChecked(getConfig((String) Baglvl1.getText()));
        Baglvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl1.getText()),Baglvl1.isChecked());
            }
        });

        final CheckBox Baglvl2 = mFloatingView.findViewById(R.id.Baglvl2);
        Baglvl2.setChecked(getConfig((String) Baglvl2.getText()));
        Baglvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl2.getText()),Baglvl2.isChecked());
            }
        });

        final CheckBox Baglvl3 = mFloatingView.findViewById(R.id.Baglvl3);
        Baglvl3.setChecked(getConfig((String) Baglvl3.getText()));
        Baglvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Baglvl3.getText()),Baglvl3.isChecked());
            }
        });

        final CheckBox Helmetlvl1 = mFloatingView.findViewById(R.id.Helmetlvl1);
        Helmetlvl1.setChecked(getConfig((String) Helmetlvl1.getText()));
        Helmetlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl1.getText()),Helmetlvl1.isChecked());
            }
        });

        final CheckBox Helmetlvl2 = mFloatingView.findViewById(R.id.Helmetlvl2);
        Helmetlvl2.setChecked(getConfig((String) Helmetlvl2.getText()));
        Helmetlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl2.getText()),Helmetlvl2.isChecked());
            }
        });

        final CheckBox Helmetlvl3 = mFloatingView.findViewById(R.id.Helmetlvl3);
        Helmetlvl3.setChecked(getConfig((String) Helmetlvl3.getText()));
        Helmetlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Helmetlvl3.getText()),Helmetlvl3.isChecked());
            }
        });

        final CheckBox Vestlvl1 = mFloatingView.findViewById(R.id.Vestlvl1);
        Vestlvl1.setChecked(getConfig((String) Vestlvl1.getText()));
        Vestlvl1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl1.getText()),Vestlvl1.isChecked());
            }
        });

        final CheckBox Vestlvl2 = mFloatingView.findViewById(R.id.Vestlvl2);
        Vestlvl2.setChecked(getConfig((String) Vestlvl2.getText()));
        Vestlvl2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl2.getText()),Vestlvl2.isChecked());
            }
        });

        final CheckBox Vestlvl3 = mFloatingView.findViewById(R.id.Vestlvl3);
        Vestlvl3.setChecked(getConfig((String) Vestlvl3.getText()));
        Vestlvl3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Vestlvl3.getText()),Vestlvl3.isChecked());
            }
        });

        final CheckBox Stung = mFloatingView.findViewById(R.id.Stung);
        Stung.setChecked(getConfig((String) Stung.getText()));
        Stung.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Stung.getText()),Stung.isChecked());
            }
        });

        final CheckBox Crowbar = mFloatingView.findViewById(R.id.Crowbar);
        Crowbar.setChecked(getConfig((String) Crowbar.getText()));
        Crowbar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setValue(String.valueOf(Crowbar.getText()),Crowbar.isChecked());
            }
        });

        final ColorPickerView Color=mFloatingView.findViewById(R.id.color_picker_view);
        if (getColorBox() == 100){
            Color.setColor(android.graphics.Color.RED,true);
            ESPView.ChangeColorBox(android.graphics.Color.RED);
        }else{
            Color.setColor(getColorBox(),true);
            ESPView.ChangeColorBox(getColorBox());
        }
        Color.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                setColorBox(selectedColor);
                ESPView.ChangeColorBox(selectedColor);
            }
        });

        final ColorPickerView Color1=mFloatingView.findViewById(R.id.color_picker_viewskel);
        if (getColorSkel() == 100){
            Color1.setColor(android.graphics.Color.YELLOW,true);
            ESPView.ChangeColorSkel(android.graphics.Color.YELLOW);
        }else {
            Color1.setColor(getColorSkel(),true);
            ESPView.ChangeColorSkel(getColorSkel());
        }
        Color1.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                setColorSkel(selectedColor);
                ESPView.ChangeColorSkel(selectedColor);
            }
        });

        final ColorPickerView Color2=mFloatingView.findViewById(R.id.color_picker_viewhead);
        if (getColorHead() == 100){
            Color2.setColor(android.graphics.Color.RED,true);
            ESPView.ChangeColorHead(android.graphics.Color.RED);
        }else {
            Color2.setColor(getColorHead(),true);
            ESPView.ChangeColorHead(getColorHead());
        }
        Color2.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                setColorHead(selectedColor);
                ESPView.ChangeColorHead(selectedColor);
            }
        });

        final ColorPickerView Color3=mFloatingView.findViewById(R.id.color_picker_viewline);
        if (getColorLine() == 100){
            Color3.setColor(android.graphics.Color.YELLOW,true);
            ESPView.ChangeColorLine(android.graphics.Color.YELLOW);
        }else{
            Color3.setColor(getColorLine(),true);
            ESPView.ChangeColorLine(getColorLine());
        }
        Color3.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                setColorLine(selectedColor);
                ESPView.ChangeColorLine(selectedColor);
            }
        });

        final ColorPickerView Color4=mFloatingView.findViewById(R.id.color_picker_viewalert);
        if (getColorAlert() == 100){
            Color4.setColor(android.graphics.Color.argb(120,255,0,0),true);
            ESPView.ChangeColorAlert(android.graphics.Color.argb(120,255,0,0));
        }else {
            Color4.setColor(getColorAlert(),true);
            ESPView.ChangeColorAlert(getColorAlert());
        }
        Color4.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                setColorAlert(selectedColor);
                ESPView.ChangeColorAlert(selectedColor);
            }
        });

        final ColorPickerView Color5=mFloatingView.findViewById(R.id.color_picker_viewalerttext);
        if (getColorAlertText() == 100){
            Color5.setColor(android.graphics.Color.WHITE,true);
            ESPView.ChangeColorAlertText(android.graphics.Color.WHITE);
        }else {
            Color5.setColor(getColorAlertText(),true);
            ESPView.ChangeColorAlertText(getColorAlertText());
        }
        Color5.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                setColorAlertText(selectedColor);
                ESPView.ChangeColorAlertText(selectedColor);
            }
        });

        final RadioButton fps1=mFloatingView.findViewById(R.id.fpsdefault);
        final RadioButton fps2=mFloatingView.findViewById(R.id.fps60);
        final RadioButton fps3=mFloatingView.findViewById(R.id.fps90);
        final RadioButton fps4=mFloatingView.findViewById(R.id.fps120);

        int CheckFps = getFps();
        if (CheckFps == 30){
            fps1.setChecked(true);
        }else if (CheckFps == 60){
            fps2.setChecked(true);
        }else if (CheckFps == 90){
            fps3.setChecked(true);
        }else {
            fps4.setChecked(true);
        }

        fps1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    fps2.setChecked(false);
                    fps3.setChecked(false);
                    fps4.setChecked(false);
                    setFps(30);
                    ESPView.ChangeFps(30);
                }
            }
        });

        fps2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    fps1.setChecked(false);
                    fps3.setChecked(false);
                    fps4.setChecked(false);
                    setFps(60);
                    ESPView.ChangeFps(60);
                }
            }
        });

        fps3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    fps2.setChecked(false);
                    fps1.setChecked(false);
                    fps4.setChecked(false);
                    setFps(90);
                    ESPView.ChangeFps(90);
                }
            }
        });

        fps4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    fps2.setChecked(false);
                    fps3.setChecked(false);
                    fps1.setChecked(false);
                    setFps(120);
                    ESPView.ChangeFps(120);
                }
            }
        });

        final ColorPickerView Color6=mFloatingView.findViewById(R.id.color_picker_viewisname);
        final ColorPickerView Color7=mFloatingView.findViewById(R.id.color_picker_viewisDist);
        final ColorPickerView Color8=mFloatingView.findViewById(R.id.color_picker_viewisEnemyWeapon);

        final RadioButton set1=mFloatingView.findViewById(R.id.bgName);
        final RadioButton set11=mFloatingView.findViewById(R.id.bgID);
        final RadioButton set2=mFloatingView.findViewById(R.id.clrname);
        final RadioButton set3=mFloatingView.findViewById(R.id.bgDist);
        final RadioButton set4=mFloatingView.findViewById(R.id.clrDist);
        final RadioButton set5=mFloatingView.findViewById(R.id.bgEnWeapon);
        final RadioButton set6=mFloatingView.findViewById(R.id.clrEnWeapon);

        set1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set2.setChecked(false);
                    set11.setChecked(false);
                    if (getEnemyName() == 100) {
                        Color6.setColor(android.graphics.Color.argb(180,0,0,0), true);
                    }else {
                        Color6.setColor(getEnemyName(), true);
                    }
                }

            }
        });

        set2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set1.setChecked(false);
                    set11.setChecked(false);
                    if (getEnemyNameText() == 100) {
                        Color6.setColor(android.graphics.Color.WHITE, true);
                    }else{
                        Color6.setColor(getEnemyNameText(), true);
                    }
                }

            }
        });

        set11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set1.setChecked(false);
                    set2.setChecked(false);
                    if (getIDBgt() == 100){
                        Color6.setColor(android.graphics.Color.BLUE,true);
                    }else {
                        Color6.setColor(getIDBgt(),true);
                    }
                }

            }
        });

        set3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set4.setChecked(false);
                    if (getEnemyDistance() == 100){
                        Color7.setColor(android.graphics.Color.RED,true);
                    }else{
                        Color7.setColor(getEnemyDistance(),true);
                    }
                }
            }
        });

        set4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set3.setChecked(false);
                    if (getEnemyDistanceText() == 100){
                        Color7.setColor(android.graphics.Color.WHITE,true);
                    }else{
                        Color7.setColor(getEnemyDistanceText(),true);
                    }
                }

            }
        });

        set5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set6.setChecked(false);
                    if (getEnemyWeapon() == 100){
                        Color8.setColor(android.graphics.Color.argb(180,0,0,0),true);
                    }else{
                        Color8.setColor(getEnemyWeapon(),true);
                    }
                }
            }
        });

        set6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    set5.setChecked(false);
                    if (getEnemyWeaponText() == 100){
                        Color8.setColor(android.graphics.Color.WHITE,true);
                    }else {
                        Color8.setColor(getEnemyWeaponText(),true);
                    }
                }

            }
        });

        if (getEnemyName() == 100 && getIDBgt() == 100 && getEnemyNameText() == 100){
            Color6.setColor(android.graphics.Color.WHITE,true);
            ESPView.ChangeBgName(android.graphics.Color.argb(180,0,0,0));
            ESPView.ChangeBgId(android.graphics.Color.BLUE);
            ESPView.ChangeTextName(android.graphics.Color.WHITE);
        }else {
            Color6.setColor(getEnemyName(),true);
            ESPView.ChangeBgName(getEnemyName());
            ESPView.ChangeBgId(getIDBgt());
            ESPView.ChangeTextName(getEnemyNameText());
        }
        Color6.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                if (set1.isChecked()) {
                    setEnemyName(selectedColor);
                    ESPView.ChangeBgName(selectedColor);
                }else if(set11.isChecked()){
                    setIDBgt(selectedColor);
                    ESPView.ChangeBgId(selectedColor);
                }else{
                    setEnemyNameText(selectedColor);
                    ESPView.ChangeTextName(selectedColor);
                }
            }
        });

        if (getEnemyDistance() == 100 && getEnemyNameText() == 100){
            Color7.setColor(android.graphics.Color.RED,true);
            ESPView.ChangeBgDist(android.graphics.Color.RED);
            ESPView.ChangeTextDist(android.graphics.Color.WHITE);
        }else {
            Color7.setColor(getEnemyDistance(),true);
            ESPView.ChangeBgDist(getEnemyDistance());
            ESPView.ChangeTextDist(getEnemyDistanceText());
        }
        Color7.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                if (set3.isChecked()) {
                    setEnemyDistance(selectedColor);
                    ESPView.ChangeBgDist(selectedColor);
                }else{
                    setEnemyDistanceText(selectedColor);
                    ESPView.ChangeTextDist(selectedColor);
                }
            }
        });

        if (getEnemyWeapon() == 100 && getEnemyWeaponText() == 100){
            Color8.setColor(android.graphics.Color.WHITE,true);
            ESPView.ChangeBgEnWeapon(android.graphics.Color.argb(180,0,0,0));
            ESPView.ChangeTextEnWeapon(android.graphics.Color.WHITE);
        }else{
            Color8.setColor(getEnemyWeapon(),true);
            ESPView.ChangeBgEnWeapon(getEnemyWeapon());
            ESPView.ChangeTextEnWeapon(getEnemyWeaponText());
        }
        Color8.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                if (set5.isChecked()) {
                    setEnemyWeapon(selectedColor);
                    ESPView.ChangeBgEnWeapon(selectedColor);
                }else{
                    setEnemyWeaponText(selectedColor);
                    ESPView.ChangeTextEnWeapon(selectedColor);
                }
            }
        });

        final TextView fpsText = mFloatingView.findViewById(R.id.fpsText);
        final TextView positionText = mFloatingView.findViewById(R.id.positionText);
        final SeekBar position = mFloatingView.findViewById(R.id.position);
        final TextView sizeText = mFloatingView.findViewById(R.id.SizeText);
        final SeekBar size = mFloatingView.findViewById(R.id.Size);

        final TextView strokeboxText = mFloatingView.findViewById(R.id.boxstrokeText);
        final SeekBar strokebox = mFloatingView.findViewById(R.id.boxstroke);
        final TextView strokeskelText = mFloatingView.findViewById(R.id.skeletonstrokeText);
        final SeekBar strokeskel = mFloatingView.findViewById(R.id.skeletonstroke);
        final TextView strokelineText = mFloatingView.findViewById(R.id.linestrokeText);
        final SeekBar strokeline = mFloatingView.findViewById(R.id.linestroke);

        final TextView itemSizeText = mFloatingView.findViewById(R.id.itemSizeText);
        final SeekBar itemSize = mFloatingView.findViewById(R.id.itemSize);
        final TextView itemPositionText = mFloatingView.findViewById(R.id.itemPositionText);
        final SeekBar itemPosition = mFloatingView.findViewById(R.id.itemPosition);

        strokebox.setProgress(getStrokeBox());
        String Nstroke = String.valueOf(getStrokeBox());
        strokeboxText.setText(Nstroke);
        ESPView.ChangeStrokeBox(getStrokeBox());
        strokebox.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fpsms=strokebox.getProgress();
                setStrokeBox(fpsms);
                ESPView.ChangeStrokeBox(fpsms);
                String a = String.valueOf(fpsms);
                strokeboxText.setText(a);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        strokeskel.setProgress(getStrokeSkeleton());
        String Nstroke1 = String.valueOf(getStrokeSkeleton());
        strokeskelText.setText(Nstroke1);
        ESPView.ChangeStrokeSkel(getStrokeSkeleton());
        strokeskel.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fpsms=strokeskel.getProgress();
                setStrokeSkeleton(fpsms);
                ESPView.ChangeStrokeSkel(fpsms);
                String a = String.valueOf(fpsms);
                strokeskelText.setText(a);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        strokeline.setProgress(getStrokeLine());
        String Nstroke2 = String.valueOf(getStrokeLine());
        strokelineText.setText(Nstroke2);
        ESPView.ChangeStrokeLine(getStrokeLine());
        strokeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fpsms=strokeline.getProgress();
                setStrokeLine(fpsms);
                ESPView.ChangeStrokeLine(fpsms);
                String a = String.valueOf(fpsms);
                strokelineText.setText(a);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        itemPosition.setProgress(getItemPosition());
        String bb = String.valueOf(getItemPosition());
        itemPositionText.setText(bb);
        ESPView.ChangeitemPosition(getItemPosition());
        itemPosition.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=itemPosition.getProgress();
                setItemPosition(pos);
                ESPView.ChangeitemPosition(pos);
                String a = String.valueOf(pos);
                itemPositionText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        itemSize.setProgress(getItemSize());
        String bbb = String.valueOf(getItemSize());
        itemSizeText.setText(bbb);
        ESPView.ChangeitemSize(getItemSize());
        itemSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=itemSize.getProgress();
                setItemSIze(pos);
                ESPView.ChangeitemSize(pos);
                String a = String.valueOf(pos);
                itemSizeText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final SeekBar fps = mFloatingView.findViewById(R.id.fps);
        fps.setProgress(getFps());
        String a = String.valueOf(getFps());
        fpsText.setText(a);
        ESPView.ChangeFps(getFps());
        fps.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int fpsms=fps.getProgress();
                setFps(fpsms);
                ESPView.ChangeFps(fpsms);
                String a = String.valueOf(fpsms);
                fpsText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        position.setProgress(getPosition());
        String b = String.valueOf(getPosition());
        positionText.setText(b);
        ESPView.ChangePosition(getPosition());
        position.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=position.getProgress();
                setPosition(pos);
                ESPView.ChangePosition(pos);
                String a = String.valueOf(pos);
                positionText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        size.setProgress(getSize());
        String c = String.valueOf(getSize());
        sizeText.setText(c);
        ESPView.ChangeSize(getSize());
        size.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int pos=size.getProgress();
                setSize(pos);
                ESPView.ChangeSize(pos);
                String a = String.valueOf(pos);
                sizeText.setText(a);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    public native void SettingValue(int setting_code,boolean value);


}

class SingleTapConfirm extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        return true;
    }
}

