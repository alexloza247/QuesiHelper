package com.alejandro.printsheet;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.webkit.WebView;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

/**
 * Imprime la hoja del día con el PrintManager de Android.
 *
 * En la WebView de Android window.print() no hace nada, así que el botón
 * "Imprimir / PDF" de Quesi-Helper usa este plugin cuando corre en la app:
 * abre el diálogo de impresión del sistema, donde se puede elegir "Guardar
 * como PDF" o una impresora.
 *
 * La vista de impresión (#printSheet) solo se muestra con @media print y el
 * resto de la app se oculta con la misma regla; el adaptador de impresión
 * del WebView aplica esas reglas, así que lo que sale es la hoja igual a la
 * de papel, no la pantalla de la app.
 *
 * No pide ningún permiso. Si algo falla, el método rechaza la promesa y la
 * app muestra un aviso; nunca se dice que se imprimió cuando no se imprimió.
 */
@CapacitorPlugin(name = "PrintSheet")
public class PrintSheetPlugin extends Plugin {

    @PluginMethod
    public void print(PluginCall call) {
        if (getActivity() == null) {
            call.reject("La app no está en primer plano");
            return;
        }
        getActivity().runOnUiThread(() -> {
            try {
                WebView webView = getBridge().getWebView();
                if (webView == null) {
                    call.reject("No hay vista web para imprimir");
                    return;
                }
                PrintManager printManager =
                        (PrintManager) getContext().getSystemService(Context.PRINT_SERVICE);
                if (printManager == null) {
                    call.reject("El teléfono no tiene servicio de impresión");
                    return;
                }
                String jobName = "Hoja del dia - Quesi-Helper";
                PrintDocumentAdapter adapter = webView.createPrintDocumentAdapter(jobName);
                // Tamaño carta y márgenes mínimos fijos: sin esto, el diálogo
                // usa los valores por defecto del sistema/impresora (tamaño
                // de papel y márgenes variables), y la hoja puede salir
                // partida en dos páginas. Con carta + 5mm la hoja siempre
                // cabe en una página.
                PrintAttributes attributes = new PrintAttributes.Builder()
                        .setMediaSize(PrintAttributes.MediaSize.NA_LETTER)
                        .setMinMargins(new PrintAttributes.Margins(0.197f, 0.197f, 0.197f, 0.197f))
                        .build();
                printManager.print(jobName, adapter, attributes);
                JSObject ret = new JSObject();
                ret.put("ok", true);
                call.resolve(ret);
            } catch (Exception e) {
                call.reject("No se pudo abrir la impresión: " + e.getMessage());
            }
        });
    }
}
