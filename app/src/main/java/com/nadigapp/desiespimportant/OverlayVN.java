package com.nadigapp.desiespimportant;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import java.io.DataOutputStream;
import java.io.IOException;

//import com.Sharp.*;


public class OverlayVN extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    WindowManager windowManager;
    Process process;
    View mFloatingView;
    ESPView overlayView;
    @SuppressLint("StaticFieldLeak")
    private static Overlay Instance;

    static Context ctx;
    @SuppressLint("InflateParams")
    @Override
    public void onCreate() {
        super.onCreate();
        ctx=this;
        Start(ctx,3,1);
        windowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        overlayView = new ESPView(ctx);
        //  mFloatingView = LayoutInflater.from(ctx).inflate(R.layout.float_view, null);
        DrawCanvas();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Close();

        if(overlayView != null)
        {
            ((WindowManager)ctx.getSystemService(Context.WINDOW_SERVICE)).removeView(overlayView);
            overlayView = null;
        }

        process.destroy();
    }

    public  void Start(final Context context, final int gametype, final int bit) {

        if (Instance == null) {
            // Intent intent = new Intent(context, Overlay.class);

            Thread t=new Thread(new Runnable() {
                @Override
                public void run(){
                    //if())

                    getReady(gametype);

                }

            });
            t.start();

            //   context.startService(intent);
            Thread t2=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    StartDaemon(context,bit);

                }
            });
            t2.start();


//Toast.makeText(context,"Already Started !!",Toast.LENGTH_LONG).show();

        }
    }
    static native boolean getReady(int nameofgame);

    public void StartDaemon(final Context context, int bit){


	 /*  new Thread()
	   {
		   public void run()
		   {*/
        Shell(MainActivity.socket);


		 /*  }
	   }.start();*/

        //Toast.makeText(context,"Already Started !!",Toast.LENGTH_LONG).show();
    }

      /*  File del= new File(context.getFilesDir() + "/bitmap.so");
        del.delete();

        InputStream in=context.getResources().openRawResource(R.raw.view64);
        if(bit==1)
            in=context.getResources().openRawResource(R.raw.view32);
        FileOutputStream out ;

        try {
            out = new FileOutputStream(context.getFilesDir()+"/bitmap.so");
            byte[] buff = new byte[1024];
            int read ;

            try {
                while ((read = in.read(buff)) > 0) {
                    out.write(buff, 0, read);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                in.close();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         Shell.su("chmod +x "+context.getFilesDir()+"/bitmap.so").exec();
        Shell.su(context.getFilesDir()+"/bitmap.so").exec();*/



    public static void Stop(Context context) {

        Intent intent = new Intent(context, Overlay.class);
        context.stopService(intent);

        Intent floatLogo = new Intent(context, FloatLogo.class);
        context.stopService(floatLogo);



    }

    private native void Close();
    static boolean getConfig(String key){
        SharedPreferences sp=ctx.getSharedPreferences("espValue", Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
        // return !key.equals("");
    }
    private void DrawCanvas() {
        // mFloatingView = LayoutInflater.from(this).inflate(R.layout.float_view, null);
        int LAYOUT_FLAG;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
        }
        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT, 0, getNavigationBarHeight(),
                LAYOUT_FLAG,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_FULLSCREEN,
                PixelFormat.RGBA_8888);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;

        params.gravity = Gravity.TOP | Gravity.START;        //Initially view will be added to top-left corner
        params.x = 0;
        params.y = 0;
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        windowManager.addView(overlayView, params);
    }
    public static native void DrawOn(ESPView espView, Canvas canvas);
    private int getNavigationBarHeight() {
        boolean hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey();
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0 && !hasMenuKey) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    public void Shell(String str) {

        DataOutputStream dataOutputStream = null;
        try {
            process = Runtime.getRuntime().exec(str);
        } catch (IOException e) {
            e.printStackTrace();
            process = null;
        }
        if (process != null) {
            dataOutputStream = new DataOutputStream(process.getOutputStream());
        }
        try {
            dataOutputStream.flush();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

}
