# QuesiHelper 🍕

App web para digitalizar la **hojita del inventario del día** de **Fanáticos de la Pizza**, que se llena a la hora de cerrar.

Corre en el navegador del celular (o en GitHub Pages). Los datos se guardan solo en ese navegador (localStorage), no se sincronizan con otros dispositivos.

## Cómo se usa

### 1. Configuración (primera vez)
En **Configuración** están todos los insumos separados en **Contables** y **No contables**. Puedes mover un insumo de un grupo al otro.

- **Contable:** marca el check **"Viene en paquete"** si aplica y pon la **cantidad por paquete**. Para las **tortillas** hay dos cantidades: **Sin quesear** y **Con especialidad** (cada caja es de una sola especialidad, nunca mezclan). Ej. Tortilla Familiar: 3 por caja sin quesear, 2 con especialidad; Tortilla Canelo: 1 y 1.
- **No contable:** pon los **tipos de bolsa** que te traen (pueden ser varios: ej. queso en bolsas de 5 kg y de 3 kg — cada tipo con su peso y un nombre opcional; usa **"+ Agregar tipo de bolsa"**) y, si el producto suelto se pesa en un recipiente, marca **"Agregar peso del recipiente"** y pon el **peso del recipiente**. La báscula con recipiente solo se pesa en la **cocina**: en el cuarto frío el producto está en bolsas cerradas.

Los valores se ponen una vez y quedan guardados hasta que los cambies en Configuración. Ya vienen cargados valores iniciales sensatos: tortillas en paquete — Sin quesear: Familiar 3, Chica 3, Canelo 1, Sartén 1 por caja; Con especialidad: Familiar 2, Chica 2, Canelo 1, Sartén 1 por caja; cajas, salsas, refrescos y desechables contables sin paquete; ingredientes y aderezos no contables (el Queso ya trae activado el check del recipiente como ejemplo).

### 2. Conteo en dos partes
En **Contar** llena el encabezado (Sucursal, Turno, Fecha, Hora) y empieza el conteo:

- **Parte 1 · Cuarto frío:** anota lo que hay en esa zona.
- **Parte 2 · Cocina:** anota lo que hay en la cocina (el refri es de la cocina).

En cada parte aparecen **todos los productos**, por si las moscas. El borrador se guarda solo: si cierras la app a mitad del conteo, no se pierde.

Cómo se calcula cada producto:

- **Tortillas:** en cada parte se cuentan las **cajas por especialidad** (cada caja es de una sola especialidad) y las **sueltas**. Cada celda de especialidad = cajas × tortillas por caja + sueltas. Por caja: Sin quesear — Familiar 3, Chica 3, Canelo 1, Sartén 1; Con especialidad — Familiar 2, Chica 2, Canelo 1, Sartén 1. Ej. 81 cajas de Familiar sin quesear = 243 tortillas en la columna C.
- **Contable en paquete (otros):** cajas × cantidad por paquete + sueltas.
- **Contable sin paquete:** piezas.
- **No contable:** suma de bolsas por tipo (bolsas × peso de cada tipo) + kg sueltos + (peso en báscula − peso del recipiente, si aplica — **solo en cocina**; en cuarto frío no se pesa con recipiente).

### 3. Hoja final
Al terminar las dos partes, la **Hoja** muestra la misma hoja de papel (secciones, columnas, encabezado y firmas), con:

- **INV** = suma de cuarto frío + cocina por producto.
- **KARDEX** editable por renglón.
- **DIF** = INV − KARDEX, automático.

Las columnas de las tortillas son las especialidades de pizza: C = Sin quesear, Q = Queso, PP = Peperonni, H = Hawaiana, Sup = Suprema, 3C = 3 carnes, P/H = Peperonni/Hawaiana, P/S = Peperonni/Suprema, P/M = Peperonni/Mexicana, Pas = Pastor, Jam = Jamón, Mex = Mexicana, Cub = Cubana. En esas casillas van las tortillas que quedan de cada especialidad; ya no se llenan a mano: la app las calcula sumando cuarto frío + cocina. El **INV de cada tortilla = suma de sus 13 especialidades**. DEV y Dev/Mer se llenan a mano. En **Ingredientes** hay una columna **CF / COC** entre UM y Dev/Mer que muestra lo contado en cuarto frío y en cocina (ej. CF 5 kg, Coc 3 kg); el texto para compartir también incluye ese desglose.

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

v1.1 — web app (sin APK por ahora). Regla de tortillas confirmada: cajas por especialidad sin mezclar, por caja según tipo y especialidad, INV = suma de las 13 especialidades. Báscula con recipiente solo en cocina; un no contable puede tener varios tipos de bolsa (mismo renglón en la hoja). Pendiente por confirmar con el usuario: qué se anota en DEV y Dev/Mer.
