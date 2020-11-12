package py.com.misgruposv01.utils;

import android.content.Context;
import android.widget.Toast;

public class NotificationsUtils {
    public static void desplegarMensaje(String mensaje, Context contexto){
        int duracionCorta = Toast.LENGTH_SHORT;
        int duracionLarga = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(contexto, mensaje, duracionLarga);

        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();
}
}
