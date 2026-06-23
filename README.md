# 🍕 Sistema de Gestión de Pedidos para Pizzería

---

## 📋 Descripción

La aplicación permite administrar clientes, empleados, productos, cupones de descuento y pedidos de una pizzería.

---

## 🚀 Tecnologías utilizadas

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* BCryptPasswordEncoder
* Maven

### Base de datos

* PostgreSQL
* Neon Database

### Frontend

* React
* JavaScript
* Axios

### Documentación

* Swagger OpenAPI

### Despliegue

* Render (Backend)
* Neon (Base de datos)

---

## 🏗 Arquitectura

```text
React Frontend
        │
        ▼
Spring Boot REST API
        │
        ▼
Spring Data JPA
        │
        ▼
PostgreSQL (Neon)
```

---

## 📦 Funcionalidades

### Autenticación

* Login de empleados.
* Registro de empleados.
* Contraseñas cifradas con BCrypt.

### Clientes

* Registrar clientes.
* Listar clientes.

### Productos

* Registrar productos.
* Listar productos.
* Buscar producto por ID.
* Actualizar producto.
* Eliminación lógica.

### Cupones

* Crear cupones de descuento.
* Listar cupones.

### Pedidos

* Registrar pedidos.
* Aplicar cupones.
* Calcular subtotales.
* Actualizar estados del pedido.
* Consultar pedidos.

### Empleados

* Registro de empleados.
* Consulta de empleados.

---

# ⚙ Requisitos

* Java 21
* Maven 3.9+
* PostgreSQL
* Node.js 20+
* npm

---

# 🔧 Configuración del Backend

Clonar el repositorio:

```bash
git clone https://github.com/Matias-cry/ProyectoDSWII_Pizzeria.git
```

Ingresar al proyecto:

```bash
cd ProyectoDSWII_Pizzeria
```

Configurar las variables de conexión:

```properties
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

Ejecutar:

```bash
mvn spring-boot:run
```

La API estará disponible en:

```text
http://localhost:8081
```

---

# 💻 Configuración del Frontend

```bash
npm install
npm run dev
```

---

# 📚 Documentación Swagger

La documentación de la API se encuentra disponible en:

```text
https://proyectodswii-pizzeria.onrender.com/swagger-ui/index.html#/
```

---

# 🧪 Pruebas

Las pruebas de los endpoints se realizaron utilizando:

* Postman
* Swagger UI

---

# 📡 Principales Endpoints

## Autenticación

```text
POST /api/auth/register
POST /api/auth/login
```

## Clientes

```text
GET  /api/clientes
POST /api/clientes
```

## Empleados

```text
GET /api/empleados
```

## Productos

```text
GET    /api/productos
GET    /api/productos/{id}
POST   /api/productos
PUT    /api/productos/{id}
DELETE /api/productos/{id}
```

## Cupones

```text
GET  /api/cupones
POST /api/cupones
```

## Pedidos

```text
GET   /api/pedidos
GET   /api/pedidos/{id}
POST  /api/pedidos
PATCH /api/pedidos/{id}/estado
```

---

# 📖 Curso

Desarrollo de Servicios Web II

Instituto Cibertec

---

# 📄 Licencia

Proyecto académico desarrollado con fines educativos.
