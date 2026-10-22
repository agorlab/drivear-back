# Drivear

> Plataforma de delivery y cadetería para negocios, con seguro incluido y pagos en efectivo o billetera virtual.

---

## ¿Qué es Drivear?

Drivear es un servicio que conecta **negocios** con **repartidores** (cadetes) para entregar pedidos a los clientes finales. El negocio contrata un plan mensual que incluye el servicio de cadetería y un seguro, sin tener que armar ni gestionar su propio equipo de delivery.

> *Drivear es un nombre provisorio.*

---

## Actores del sistema

| Actor | Rol |
|-------|-----|
| **Negocio** | Contrata el servicio, carga pedidos y recibe el dinero de sus ventas. |
| **Repartidor** | Retira el pedido en el negocio y lo entrega al cliente. |
| **Cliente final** | Hace el pedido y paga en efectivo o con billetera virtual. |
| **Drivear** | Plataforma que intermedia, asegura los envíos y cobra las mensualidades. |

---

## Flujo general de un pedido

1. El cliente hace un pedido al negocio y elige su método de pago.
2. El negocio genera el envío en Drivear.
3. Un repartidor acepta el envío y retira el pedido.
4. El repartidor entrega el pedido al cliente.
5. Se liquida el dinero según el método de pago (ver siguiente sección).

---

## Métodos de pago

### 💳 Billetera virtual

El cliente paga digitalmente al momento de hacer el pedido.

- El dinero **va directamente al negocio**.
- El repartidor **no maneja dinero** en la entrega.
- No genera deuda entre el repartidor y el negocio.

### 💵 Efectivo

El cliente paga al repartidor en la puerta.

- El repartidor **cobra el monto del pedido** al cliente.
- Ese dinero **pertenece al negocio**, por lo que el repartidor queda con una **deuda hacia el negocio** por el monto cobrado.
- El repartidor debe rendir (entregar) ese dinero al negocio.
- Drivear registra cada pedido en efectivo para llevar el control de lo que cada repartidor debe.

```
Pago en efectivo:   Cliente ──$──▶ Repartidor ──(rinde)──▶ Negocio
Pago con billetera: Cliente ──────────────────────────────▶ Negocio
```

### Resumen comparativo

| | Efectivo | Billetera virtual |
|---|---|---|
| Quién recibe el dinero primero | Repartidor | Negocio |
| ¿Genera deuda del repartidor? | Sí | No |
| ¿Requiere rendición? | Sí | No |

---

## Seguro

Drivear cuenta con un **seguro** que cubre la operación de los envíos. Está **incluido en la mensualidad del negocio**, por lo que no hay que contratarlo por separado.

> Las coberturas exactas (accidentes del repartidor, daños o pérdida de mercadería, terceros, etc.) están **por definir** con la aseguradora.

---

## Modelo de negocio

Drivear se financia con **mensualidades**, tanto de los negocios como de los repartidores.

### Para negocios

El negocio paga una **mensualidad** que incluye:

- ✅ Servicio de cadetería
- ✅ Seguro

Hay **3 planes**, según la cantidad de envíos mensuales:

| Plan | Envíos mensuales | Precio mensual |
|------|------------------|----------------|
| **Básico** | Hasta _X_ envíos | $ _por definir_ |
| **Intermedio** | Hasta _Y_ envíos | $ _por definir_ |
| **Pro** | Hasta _Z_ envíos | $ _por definir_ |

> Los rangos (_X_, _Y_, _Z_) y los precios están por definir.

### Para repartidores

El repartidor también paga una **mensualidad**, que depende de la **cantidad de envíos realizados** dentro de un rango:

| Rango de envíos realizados | Mensualidad |
|----------------------------|-------------|
| 0 – _A_ | $ _por definir_ |
| _A+1_ – _B_ | $ _por definir_ |
| _B+1_ en adelante | $ _por definir_ |

> Los rangos y precios están por definir.

---

## Resumen de flujos de dinero

| Concepto | Quién paga | Quién recibe |
|----------|------------|--------------|
| Pedido (billetera virtual) | Cliente | Negocio |
| Pedido (efectivo) | Cliente | Repartidor → Negocio (rendición) |
| Mensualidad por plan | Negocio | Drivear |
| Mensualidad por envíos | Drivear | Repartidor |

---

## Funcionalidades previstas

**Negocio**
- Alta y elección de plan
- Carga y seguimiento de envíos
- Panel de pedidos y liquidaciones
- Control de efectivo pendiente de rendición

**Repartidor**
- Alta y verificación
- Recepción y aceptación de envíos
- Registro de cobros en efectivo y deuda con cada negocio
- Historial de envíos y mensualidad según rango

**Plataforma (Drivear)**
- Gestión de planes y facturación mensual
- Integración con billeteras virtuales
- Registro y conciliación de pagos en efectivo
- Gestión del seguro y siniestros

---

## Puntos a definir

- [ ] Nombre definitivo del servicio
- [ ] Cantidad de envíos y precios de cada plan de negocios
- [ ] Rangos y precios de la mensualidad de repartidores
- [ ] Qué pasa si un negocio supera el límite de envíos de su plan (¿bloqueo, cobro extra, upgrade automático?)
- [ ] Plazos y mecanismo de rendición del efectivo (diaria, semanal, etc.) y consecuencias por demora
- [ ] Coberturas y condiciones del seguro
- [ ] Billeteras virtuales a integrar (Mercado Pago, etc.)
- [ ] Modo de asignación de repartidores a los envíos
- [ ] Cobro de la tarifa de envío al cliente final (si aplica)

---

## Estado del proyecto

🚧 En etapa de definición del modelo de negocio.
