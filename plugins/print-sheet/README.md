# print-sheet (plugin local)

Imprime la hoja del día con el PrintManager de Android: abre el diálogo de
impresión del sistema, donde se puede elegir **Guardar como PDF** o una
impresora. Lo usa el botón **🖨️ Imprimir / PDF** de Quesi-Helper.

## Por qué existe

En la WebView de Android `window.print()` no hace nada, así que en la app el
botón de imprimir no serviría sin este plugin. La vista de impresión
(`#printSheet`) solo se muestra con `@media print` y el resto de la app se
oculta con la misma regla; el adaptador de impresión del WebView aplica esas
reglas, así que lo que sale es la hoja igual a la de papel, no la pantalla
de la app.

## Uso (desde `index.html`, sin importar nada)

```js
// En la app (Capacitor): abre el diálogo de impresión del sistema.
window.Capacitor.Plugins.PrintSheet.print().then(function () {
  // Diálogo abierto (el usuario elige PDF o impresora).
});
// En el navegador: window.print() como siempre.
```

Si el plugin falla, la app muestra un aviso y no dice que se imprimió.

## Instalación

Es una dependencia local del `package.json` raíz
(`"print-sheet": "file:./plugins/print-sheet"`). El workflow de GitHub
Actions hace `npm install` y `npx cap sync`, y `cap sync` registra el plugin
en el proyecto Android automáticamente. No hay que tocar el workflow.

## Advertencia

El Java de este plugin **no se compila en local** (no hay JDK/Android SDK):
la primera compilación real es el build de GitHub Actions. Si el build
falla, no se genera APK.
