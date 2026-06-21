INSERT INTO clientes (cliente_nombre, direccion, dni, telefono) VALUES
('Juan Perez', 'Av. Larco 123, Trujillo', '71234567', '987654321'),
('Maria Silva', 'Calle Las Flores 456, Trujillo', '72345678', '912345678');

INSERT INTO productos (activo, descripcion, nombre, precio) VALUES
(true, 'Pizza clásica con salsa de tomate y queso mozzarella', 'Pizza Margarita', 25.00),
(true, 'Pizza con pepperoni y extra queso', 'Pizza Pepperoni', 30.00),
(true, 'Pizza con jamón y piña', 'Pizza Hawaiana', 28.00),
(true, 'Pizza con carne, tocino, pepperoni y jamón', 'Pizza Carnívora', 35.00),
(true, 'Gaseosa Coca Cola 1 Litro', 'Coca Cola 1L', 8.00),
(true, 'Pan al ajo con queso (Porción)', 'Pan al ajo', 10.00);

INSERT INTO cupones_descuento (activo, codigo, fecha_expiracion, porcentaje_descuento, uso_actual, uso_maximo) VALUES
(true, 'BIENVENIDA20', '2026-12-31 23:59:59', 20.00, 0, 100),
(true, 'PIZZA10', '2026-07-31 23:59:59', 10.00, 5, 50);

INSERT INTO promociones (activo, descripcion, fecha_fin, fecha_inicio, nombre, porcentaje_descuento) VALUES
(true, 'Descuento especial por el mes patrio en pizzas clásicas', '2026-07-31 23:59:59', '2026-07-01 00:00:00', 'Promo Fiestas Patrias', 15.00);

INSERT INTO promocion_productos (promocion_id, producto_id) VALUES
(1, 1),
(1, 2);

INSERT INTO pedidos (estado, fecha_pedido, total, cliente_nombre_fk, cupon_id) VALUES
('COMPLETADO', '2026-06-20 19:30:00', 33.00, 'Juan Perez', NULL),
('PENDIENTE', '2026-06-21 14:00:00', 35.00, 'Maria Silva', NULL);

INSERT INTO detalle_pedidos (cantidad, precio_unitario, subtotal, pedido_id, producto_id) VALUES
(1, 25.00, 25.00, 1, 1),
(1, 8.00, 8.00, 1, 5);

INSERT INTO detalle_pedidos (cantidad, precio_unitario, subtotal, pedido_id, producto_id) VALUES
(1, 35.00, 35.00, 2, 4);