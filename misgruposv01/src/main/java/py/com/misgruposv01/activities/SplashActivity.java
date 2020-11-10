package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import py.com.misgruposv01.R;

public class SplashActivity extends Activity {

    private final int DURACION_SPLASH = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
    Animation animacion1 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this,R.anim.desplazamiento_abajo);

        //TextView deTextView = findViewById(R.id.deTextView);
        TextView bitacoraTextView = findViewById(R.id.bitacoraTextView);
        ImageView logoimagen = findViewById(R.id.logoimagen);

       // deTextView.setAnimation(animacion2);
        bitacoraTextView.setAnimation(animacion2);
        logoimagen.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(py.com.misgruposv01.activities.SplashActivity.this, MenuPrincipalActivity.class);
                startActivity(intent);
                desplegarMensaje();
                finish();
            };
        }, DURACION_SPLASH);
    }


    public void desplegarMensaje() {
        Toast toast = Toast.makeText( this, "Iniciando", Toast.LENGTH_SHORT);
        toast.show();
    }

}