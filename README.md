# Proyecto final DWES - Javier Gámez Mendoza

## Información general

Proyecto final de Despliegue de Aplicaciones Web.
Esta aplicación realizada integramente en Springboot permite la administración de Vehículos, Motores y Marcas del mundo del motor a través de una API REST que gestiona los registros de una base de datos MySQL.

## Acciones

Esta aplicación es desplegada en la dirección:

`http://localhost:8081/api/v1/`

Y permite peticiones **GET**, **POST**, **PUT** y **DELETE** en cualquiera de los siguientes puntos de acceso:

`http://localhost:8081/api/v1/brands`
<sub>*Gestiona las marcas de vehículos</sub>

`http://localhost:8081/api/v1/vehicles`
<sub>*Gestiona los vehiculos</sub>

`http://localhost:8081/api/v1/engines`
<sub>*Gestiona los motores de los vehículos</sub>

Todos los puntos de acceso permiten acceso a un elemento concreto mediante ID.

`http://localhost:8081/api/v1/vehicles/{id}`

Además, en el caso concreto de los vehículos, es posible buscar un modelo concreto utilizando su nombre como parámetro.

`http://localhost:8081/api/v1/vehicles/model?model={nombreModelo}`

## 




