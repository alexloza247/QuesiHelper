# QuesiHelper 🍕

App web para digitalizar la **hojita del inventario del día** de **Fanáticos de la Pizza**, que se llena a la hora de cerrar.

Corre en el navegador del celular (o en GitHub Pages). Los datos se guardan solo en ese navegador (localStorage), no se sincronizan con otros dispositivos.

## Cómo se usa

### 1. Configuración (primera vez)
En **Configuración** están todos los insumos separados en **Contables** y **No contables**. Puedes mover un insumo de un grupo al otro.

- **Contable:** marca el check **"Viene en paquete"** si aplica y pon la **cantidad por paquete** (ej. Tortilla Familiar: 3 por caja; Tortilla Canelo: 1).
- **No contable:** pon el **peso o litros del envase** (ej. bolsa de queso de 5 kg) y, si el producto suelto se pesa en un recipiente, marca **"Agregar peso del recipiente"** y pon el **peso del recipiente**.

Los valores se ponen una vez y quedan guardados hasta que los cambies en Configuración. Ya vienen cargados valores iniciales sensatos: tortillas en paquete (Familiar 3, Chica 3, Canelo 1, Sartén 1 por caja); cajas, salsas, refrescos y desechables contables sin paquete; ingredientes y aderezos no contables (el Queso ya trae activado el check del recipiente como ejemplo).

### 2. Conteo en dos partes
En **Contar** llena el encabezado (Sucursal, Turno, Fecha, Hora) y empieza el conteo:

- **Parte 1 · Cuarto frío:** anota lo que hay en esa zona.
- **Parte 2 · Cocina:** anota lo que hay en la cocina (el refri es de la cocina).

En cada parte aparecen **todos los productos**, por si las moscas. El borrador se guarda solo: si cierras la app a mitad del conteo, no se pierde.

Cómo se calcula cada producto:

- **Contable en paquete:** cajas × cantidad por paquete + sueltas.
- **Contable sin paquete:** piezas.
- **No contable:** envases × tamaño del envase + kg sueltos + (peso en báscula − peso del recipiente, si aplica).

### 3. Hoja final
Al terminar las dos partes, la **Hoja** muestra la misma hoja de papel (secciones, columnas, encabezado y firmas), con:

- **INV** = suma de cuarto frío + cocina por producto.
- **KARDEX** editable por renglón.
- **DIF** = INV − KARDEX, automático.

Las columnas de las tortillas son las especialidades de pizza: C = Sin quesear, Q = Queso, PP = Peperonni, H = Hawaiana, Sup = Suprema, 3C = 3 carnes, P/H = Peperonni/Hawaiana, P/S = Peperonni/Suprema, P/M = Peperonni/Mexicana, Pas = Pastor, Jam = Jamón, Mex = Mexicana, Cub = Cubana. En esas casillas se anotan las tortillas que quedan de cada especialidad; se llenan a mano en la hoja. DEV y Dev/Mer también se llenan a mano.

Desde la hoja puedes **guardarla en el Historial**, **compartirla** (texto listo para WhatsApp) o **copiarla**.

### 4. Historial
En **Historial** se guardan los inventarios por fecha, turno y sucursal. Puedes ver la hoja guardada y borrarla.

## Productos (52, igual que la hoja)

- **Cajas (2):** Caja familiar QP, Caja Chica.
- **Tortillas (4):** Familiar, Chica, Canelo, Sartén.
- **Ingredientes (18):** Adobada cocida, Boneless Porción, Cajeta, Cebolla morada, Chorizo cocido, Glaseado, Goma para pasta, Jalapeño en salmuera, Jamón, Mantequilla preparada, Pasta p/ Pizza, Pepperoni, Piña, Queso, Queso Crema, Salchicha italiana, Salchicha polaca, Tocino cocido.
- **Salsas (5):** Habanera sobre, tradicional sobre, catsup botella, Habanera botella, tradicional botella.
- **Aderezos (5):** Ranch, chipotle, mango habanero, Buffalo, BB,Q.
- **Refrescos (10):** Pepsi 400 ml, Pepsi 600 ml, 7 Up 600 ml, Manzana Sol 600 ml, Lipton Te 600 ml, Epura Jugo 330 ml, Epura Agua 1 litro, Pepsi 2 lts, 7 Up 2 lts, Manzana Sol 2 lts.
- **Desechables (8):** Domo negro c/ tapa, Tenedor desechable, Contenedor 2 oz sufle, Tapa contenedor 2 oz, Vaso animado ICEE, Vaso regular ICEE, Popote, Tapa domo Pet.

## Estado

v1 — web app (sin APK por ahora). Pendiente por confirmar con el usuario: qué se anota en DEV y Dev/Mer.
