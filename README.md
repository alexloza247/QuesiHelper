# QuesiHelper 🍕

App web para digitalizar la **hojita del inventario del día** de **Fanáticos de la Pizza**, que se llena a la hora de cerrar.

Corre en el navegador del celular (o en GitHub Pages). Los datos se guardan solo en ese navegador (localStorage), no se sincronizan con otros dispositivos.

## Cómo se usa

### 1. Configuración (primera vez)
En **Configuración** están todos los insumos separados en **Contables** y **No contables**. Puedes mover un insumo de un grupo al otro.

- **Contable:** marca el check **"Viene en paquete"** si aplica y pon la **cantidad por paquete**. Para las **tortillas** hay dos cantidades: **Sin quesear** y **Con especialidad** (cada caja es de una sola especialidad, nunca mezclan). Ej. Tortilla Familiar: 3 por caja sin quesear, 2 con especialidad; Tortilla Canelo: 1 y 1.
- **No contable:** pon los **tipos de bolsa** que te traen (pueden ser varios: ej. queso en bolsas de 5 kg y de 3 kg — cada tipo con su peso y un nombre opcional; usa **"+ Agregar tipo de bolsa"**) y, si el producto suelto se pesa en un recipiente, marca **"Agregar peso del recipiente"** y pon el **peso del recipiente**. La báscula con recipiente solo se pesa en la **cocina**: en el cuarto frío el producto está en bolsas cerradas.

Los valores se ponen una vez y quedan guardados hasta que los cambies en Configuración. **Ya vienen cargados con la configuración real de Alejandro** (la que él ajustó en su inventario de prueba del 2026-11-15), para que no aparezcan vacíos al abrir la app por primera vez: tortillas en paquete — Sin quesear: Familiar 3, Chica 2, Canelo 1, Sartén 1 por caja; Con especialidad: Familiar 2, Chica 2, Canelo 1, Sartén 1 por caja; cajas, salsas, refrescos y desechables contables sin paquete; ingredientes y aderezos no contables, con sus tipos de bolsa y pesos de recipiente ya puestos (ej. el Queso trae dos tipos de bolsa — "Genérico" 4.5 kg y "Normal" 2.26 kg — y recipiente de 0.90 kg). Todo se puede cambiar aquí, y **"Restablecer valores iniciales"** vuelve a esta configuración. **Las cajas no se configuran ni se cuentan a mano: se calculan solas de las tortillas** (ver abajo).

**Compartir tu configuración con otra persona:** al inicio de **Configuración** está **"📤 Compartir configuración"**: genera un texto de una sola línea (empieza con `QUESIHELPER-CONFIG:`) con toda tu configuración — grupos, cantidades por paquete, tipos de bolsa, envases y recipientes — y lo comparte (o lo copia para pegarlo en WhatsApp). La otra persona lo pega en **"Importar configuración"** y toca **"📥 Importar configuración"**: la app valida el texto y, con una confirmación, reemplaza su configuración por la tuya. Si el texto está incompleto o dañado, muestra un error y no cambia nada. La sucursal/turno/fecha/hora no son parte de la configuración: son del encabezado de cada hoja.

**Sucursal y turno:** también se configuran una vez, en Configuración (sección "Sucursal y turno"): cada inventario nuevo ya trae la sucursal y el turno llenos, solo para confirmarlos. Si un día te toca otra sucursal u otro turno, cámbialos en el encabezado de ese inventario (solo vale para ese día). La fecha y la hora se ponen solas con las de hoy. Si aún no hay nada guardado, lo que escribas al empezar el primer conteo queda guardado como valor por defecto para los próximos.

### 2. Conteo en dos partes
En **Contar** el encabezado ya trae la **Sucursal** y el **Turno** llenos con lo configurado (solo confírmalos); la **Fecha** y la **Hora** se ponen solas con las de hoy. Llena el encabezado y empieza el conteo:

- **Parte 1 · Cuarto frío:** anota lo que hay en esa zona.
- **Parte 2 · Cocina:** anota lo que hay en la cocina (el refri es de la cocina).

En cada parte aparecen **todos los productos**, por si las moscas. El borrador se guarda solo: si cierras la app a mitad del conteo, no se pierde.

Cómo se calcula cada producto:

- **Tortillas:** en cada parte se cuentan las **cajas por especialidad** (cada caja es de una sola especialidad) y las **sueltas**. Cada celda de especialidad = cajas × tortillas por caja + sueltas. Por caja: Sin quesear — Familiar 3, Chica 2, Canelo 1, Sartén 1; Con especialidad — Familiar 2, Chica 2, Canelo 1, Sartén 1. Ej. 81 cajas de Familiar sin quesear = 243 tortillas en la columna C.
- **Cajas:** no se cuentan a mano — **se calculan solas de las tortillas**, como las cuenta la gerenta: **Caja familiar QP** = cajas de Tortilla Familiar + Tortilla Sartén; **Caja Chica** = cajas de Tortilla Chica + Tortilla Canelo (la sartén se empaca en caja familiar y el canelo en caja chica). Una caja con sueltas cuenta como caja (ej. una caja con solo 1 tortilla suma 1 caja y 1 suelta). Con el conteo de prueba: 62 + 3 + 15 + 5 = 85 familiar; 8 + 1 + 3 = 12 chica.
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

**Imprimir en PDF igualita a la de papel:** el botón **"🖨️ Imprimir / PDF"** abre el diálogo de impresión del navegador (en Chrome del celular, elige **"Guardar como PDF"**). La hoja que sale es igualita a la de papel: mismo encabezado (Sucursal, Turno, Fecha, Hora y logo), mismo orden de secciones, Salsas con Aderezos y Refrescos con Desechables lado a lado, y las firmas al final; cabe en una sola página tamaño carta. La columna **CF / COC no sale en el PDF** (el papel no la tiene): solo se ve en la vista de la app. En el PDF, **las cajas llevan su desglose** como lo escribe la gerenta (familiar por especialidad y el total de sartén en Cub; chica por especialidad y el total de canelo en P/H; la caja parcial se escribe junto a las enteras, ej. "8-1") y **en el espacio en blanco de cada renglón van los dos números de cuarto frío y cocina**, sin etiquetas (ej. Queso 45.1 y 1.1). **DEV, Dev/Mer y DIF/T van en blanco** en el PDF (se llenan a mano en el papel) y **las casillas con valor 0 también van vacías**. No se necesita ninguna app ni librería extra.

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

v1.1 — web app (sin APK por ahora). Regla de tortillas confirmada: cajas por especialidad sin mezclar, por caja según tipo y especialidad, INV = suma de las 13 especialidades. **Corrección 2026-11-15: la Chica sin quesear son 2 por caja, no 3** (la gerenta multiplicaba por 2; Alejandro confirmó que se había confundido al validar la matriz). **Las cajas se calculan solas de las tortillas** (familiar = Familiar + Sartén; chica = Chica + Canelo; una caja con sueltas cuenta como caja). Báscula con recipiente solo en cocina; un no contable puede tener varios tipos de bolsa (mismo renglón en la hoja). La Hoja final se puede imprimir en PDF igualita a la de papel (botón "Imprimir / PDF", una página carta): con el desglose de cajas como lo escribe la gerenta, los parciales de cuarto frío y cocina en cada renglón, y DEV, Dev/Mer y DIF/T en blanco para llenarlos a mano; las casillas con 0 van vacías. **La configuración se puede compartir e importar** (botones al inicio de Configuración, texto `QUESIHELPER-CONFIG:` de una sola línea). **Los valores iniciales de la app son la configuración real de Alejandro** (2026-11-15): al abrirla por primera vez ya trae sus grupos, cantidades por paquete, tipos de bolsa, envases y recipientes; "Restablecer valores iniciales" vuelve a esa configuración. **La sucursal y el turno se configuran una vez** en Configuración y ya vienen llenos en cada inventario nuevo (el cambio en el encabezado de un inventario no sobrescribe lo guardado; si aún no hay nada guardado, lo que se escriba al empezar el primer conteo queda como valor por defecto). Pendiente por confirmar con el usuario: qué se anota en DEV y Dev/Mer.
