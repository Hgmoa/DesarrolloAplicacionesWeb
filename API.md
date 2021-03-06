# On Control Home - API REST System

## Acerca de nuestra API:
Lo que se encuentra en nuestra API Rest es información sobre nuestros usuarios, tanto administradores como clientes y sus datos adjuntos como nombres, apellidos, telefono..., los productos con sus características, precio y cantifades, las casas con sus direcciones, analíticas de consumos, facturas de los clientes y ordenes de pedidos.

## Cómo usar nuestra API:
-   Descargar Postman.
-  Solo puede enviar solicitudes GET, POST, PUT y DELETE.
-  Nuestra API tiene un lado público donde puedes ver la información de quienes somos, lo que hacemos y nuestros productos. 
    Dos partes privadas. La primera como cliente registrado puediendo ver tus facturas, graficas, consumos y pedidos, para ello debes iniciar sesión como usuario. Una segunda parte privada que es como administrador, que tienes acceso a los pedidos y a las características de los usuarios, para ello tienes que registrarte con los permisos de administrador
-  Una vez que haya iniciado sesión o sin iniciarla, puede enviar todas las solicitudes que desee (siempre siguiendo nuestras reglas).
-  Si quieres terminar tu sesión, simplemente cierra sesión en la API.

## Solicitudes API:

### Productos:
La API de productos tiene métodos GET, - POST, - PUT
 
El usuario no registrado, solo puede enviar solicitudes GET. 
Igual que el usuario registrado, solo puede enviar solicitudes GET. 
Un usuario administrador, puede enviar cualquier solicitud de las opciones posibles de Productos.
Todas las URL de solicitud se pueden enviar escribiendo http://localhost:8443 seguido de la URL de solicitud contenida en las siguientes tablas.

###### Métodos GET

| Tipo | Permisos | Solicitud de descripción | URL de solicitud | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Usuario sin registrar | Muestra todos los productos. | /api/products | Lista de productos y OK (200). | NOT_FOUND (404) |
| 2 | Usuario sin registrar |Muestra un producto determinado. | /api/products/id | Producto y OK (200). | NOT_FOUND (404) |
| 3 | Usuario Registrado | Muestra todos los productos adquiridos | /api/dashboard/ | Lista de productos adquiridos y OK (200). | NOT_FOUND (404) |
| 4 | Administrador | Muestra todos los productos | /api/adminDashboard/inventory/?page=1&size=1 | Lista de productos y OK (200). | NOT_FOUND (404) |

[1]
```
    {
        "id": 1,
        "description": "Actuador de bombilla para domótica.  Así, podrás subir o bajar las persianas desde la App, ya sea desde dispositivos móviles, ordenador o incluso hacer que estas persianas se bajen de forma automática.",
        "cost": 15.5,
        "type": "LIGHT",
        "img": "product-1.jpg",
        "stock": 36
    },
    {
        "id": 2,
        "description": "Motor actuador de persiana para domótica. Así, podrás subir o bajar las persianas desde la App, ya sea desde dispositivos móviles, ordenador o incluso hacer que estas persianas se bajen de forma automática.",
        "cost": 32.5,
        "type": "BLIND",
        "img": "product-2.jpg",
        "stock": 34
    },
    {
        "id": 3,
        "description": "Raspberry pi programada para domótica. Así, podrás actuar desde la App, ya sea desde dispositivos móviles, ordenador sobre los diferentes elementos domóticos.",
        "cost": 32.5,
        "type": "RASPBERRYPI",
        "img": "product-3.jpg",
        "stock": 67
    }

```

[4]	
```
{
    "content": [
        {
            "id": 2,
            "description": "Motor actuador de persiana para domótica. Así, podrás subir o bajar las persianas desde la App, ya sea desde dispositivos móviles, ordenador o incluso hacer que estas persianas se bajen de forma automática.",
            "cost": 32.5,
            "type": "BLIND",
            "img": "product-2.jpg",
            "stock": 34
        }
    ],
    "last": false,
    "totalElements": 3,
    "totalPages": 3,
    "size": 1,
    "number": 1,
    "sort": null,
    "numberOfElements": 1,
    "first": false
}
```


###### Método POST
| Tipo | Permisos | Solicitud de descripción |	URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | Administrador | Crea un nuevo producto. | /api/adminDashboard/addProduct | Vea abajo |	Nuevo recurso y CREADO (201) | NOT_FOUND (404)

[Solicitud 1]
```
{
    "description": "Motor actuador de persiana para domótica. Así, podrás subir o bajar las persianas desde la App, ya sea desde dispositivos móviles, ordenador o incluso hacer que estas persianas se bajen de forma automática.",
    "cost": 80,
    "type": "BLIND",
    "img": "product-2.jpg",
    "stock": 12
}
```
[Respuesta 1]
   ```
   {
       "id":4,
       "description": "Motor actuador de persiana para domótica. Así, podrás subir o bajar las persianas desde la App, ya sea desde dispositivos móviles, ordenador o incluso hacer que estas persianas se bajen de forma automática.",
       "cost": 80,
       "type": "BLIND",
       "img": "product-2.jpg",
        "stock": 12
   }
   ```

###### Método PUT
| Tipo | Permisos |Solicitud de descripción |	URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- | --- |
| 1 | Administrador | Modifica un recurso existente (puede modificar precio, cantidad, descripción e imagen). | /api/adminDashboard/inventory/id | Vea abajo | Recurso modificado y OK (200) | NOT_FOUND (404) |

[1] (ejemplo usando ID 1)

```
{
    "id": 1,
    "description": "Actuador de bombilla para domótica.  Así, podrás subir o bajar las persianas desde la App, ya sea desde dispositivos móviles, ordenador o incluso hacer que estas persianas se bajen de forma automática.",
    "cost": 20,
    "type": "LIGHT",
    "img": "product-1.jpg",
    "stock": 40
}
```


### Usuarios
La API de los usuarios tiene métodos GET, POST, PUT. 
Un usuario registrado, puede enviar solicitudes POST y puede modificar sus datos con PUT. 
Un usuario administrador, puede enviar cualquier solicitud.  
Todas las URL de solicitud se pueden enviar escribiendo https://localhost:8443 seguido de la URL de solicitud indicada en las siguientes tablas.

###### Métodos GET
| Tipo | Permisos | Solicitud de descripción |	URL de solicitud | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Administrador | Muestra a todos los usuarios. | /api/adminDashboard/users/?page=0&size=2 | Lista de usuario y OK (200). | NOT_FOUND (404) |
| 2	| Administrador | Muestra un usuario determinado. | /api/adminDashboard/users/id |	Usuario y OK (200). | NOT_FOUND (404) |
| 3	| Usuario |	Muestra información sobre su cuenta. | /api/dashboard/profile	| Usuario y OK (200). | NOT_FOUND (404) |
| 4	| Usuario |	Muestra información sobre su cuenta. | /dashboard/see	| Usuario con sus casas y OK (200). | NOT_FOUND (404) |

[2]
```
{
    "content": [
        {
            "id": 1,
            "firstName": "Amador",
            "lastName": "Rivas",
            "email": "amador@merengue.com",
            "passwordHash": "$2a$10$AVnpgYcf/YU69DTXPd8rqOA2imoicuUndgRkTotWNQ7OQ4V2N9qEe",
            "homeList": [],
            "phone": "98663631",
            "notificationList": [],
            "photo": null,
            "orderList": []
        },
        {
            "id": 2,
            "firstName": "Teodoro",
            "lastName": "Rivas",
            "email": "teodor69@merengue.com",
            "passwordHash": "$2a$10$ELiXVX0Vr3L/ZefW8VWkduWLAmAv6UYbeP3WqS4YnVas47CLfjvHu",
            "homeList": [],
            "phone": "98663632",
            "notificationList": [],
            "photo": null,
            "orderList": []
        }
    ],
    "last": false,
    "totalElements": 7,
    "totalPages": 4,
    "size": 2,
    "number": 0,
    "sort": null,
    "numberOfElements": 2,
    "first": true
}

```

###### Método POST
| Tipo | Solicitud de descripción | URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Crea un nuevo usuario | /api/register | Vea abajo | Nuevo usuario y CREADO (201) | NOT_FOUND (404) |

[1]
```

{
   "id": 8,
   "firstName": "Persona",
   "lastName": "prueba",
   "email": "personaprueba@gmail.com",
   "phone": null,
   "photo": null
}
```

###### Método PUT
| Tipo | Solicitud de descripción | URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Modifica un usuario existente (puede modificar nombre, correo electrónico ...). | /dashboard/profile | Vea abajo | Usuario modificado y OK (200) | NOT_FOUND (404) |

[1]
```

{
   "id": 8,
   "firstName": "Antonio",
   "lastName": "prueba",
   "email": "personaprueba@gmail.com",
   "phone": 611111111,
   "photo": null
}

```

### Pedidos
La API de préstamos tiene métodos GET, POST, PUT y DELETE. 
Un usuario no registrado, no tiene permitido enviar solicitudes. 
Un usuario registrado, solo puede enviar solicitudes GET y POST que purede crear y ver información sobre sus pedidos. 
Un usuario administrador, puede enviar las solicitudes de GET, POST y DELETE. 
Todas las URL de solicitud se pueden enviar escribiendo http://localhost:8443 seguido de la URL de solicitud contenida en las siguientes tablas.

###### Métodos GET
| Tipo | Permisos | Solicitud de descripción | URL de solicitud | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Administrador |	Muestra todos los pedidos. | /api/adminDashboard/orders |	Lista de pedidos y OK (200). | NOT_FOUND (404) |
| 2 | Administrador |	Muestra todos los pedidos. | /api/adminDashboard |	Lista de pedidos y OK (200). | NOT_FOUND (404) |
| 3 | Administrador |	Muestra un pedido determinado. | /api//adminDashboard/orders | Pedido y OK (200).	| NOT_FOUND (404) |
| 4 | Usuario | Muestra todos los pedidos de los usuarios. | /dashboard/see | Lista de pedidos y OK (200). | NOT_FOUND (404) |

[1]
```
{
    "OrdersNotComplete": {
        "content": [
            {
                "id": 1,
                "cost": 31,
                "completed": false,
                "date": 1521311658000,
                "home": {
                    "id": 1,
                    "postCode": 28045,
                    "address": "c/montepinar",
                    "activated": true,
                    "deviceList": [],
                    "deviceQuantity": 0
                },
                "deviceList": [
                    {
                        "id": 1,
                        "description": "Actuador de bombilla",
                        "cost": 30,
                        "type": "LIGHT",
                        "status": "ON",
                        "img": null,
                        "activated": false,
                        "activatedStatus": false,
                        "serialNumber": null,
                        "favorite": false
                    },
                    {
                        "id": 2,
                        "description": "Actuador de persiana",
                        "cost": 150,
                        "type": "BLIND",
                        "status": "UP",
                        "img": null,
                        "activated": false,
                        "activatedStatus": false,
                        "serialNumber": null,
                        "favorite": false
                    }
                ],
                "observation": "Mi observacion",
                "dateAsString": "2018-34-17 19:34:18"
            }
        ],
        "last": true,
        "totalElements": 1,
        "totalPages": 1,
        "size": 20,
        "number": 0,
        "sort": null,
        "numberOfElements": 1,
        "first": true
    },
    "OrdersComplete": {
        "content": [
            {
                "id": 1,
                "cost": 31,
                "completed": false,
                "date": 1521311658000,
                "home": {
                    "id": 1,
                    "postCode": 28045,
                    "address": "c/montepinar",
                    "activated": true,
                    "deviceList": [],
                    "deviceQuantity": 0
                },
                "deviceList": [
                    {
                        "id": 1,
                        "description": "Actuador de bombilla",
                        "cost": 30,
                        "type": "LIGHT",
                        "status": "ON",
                        "img": null,
                        "activated": false,
                        "activatedStatus": false,
                        "serialNumber": null,
                        "favorite": false
                    },
                    {
                        "id": 2,
                        "description": "Actuador de persiana",
                        "cost": 150,
                        "type": "BLIND",
                        "status": "UP",
                        "img": null,
                        "activated": false,
                        "activatedStatus": false,
                        "serialNumber": null,
                        "favorite": false
                    }
                ],
                "observation": "Mi observacion",
                "dateAsString": "2018-34-17 19:34:18"
            }
        ],
        "last": true,
        "totalElements": 1,
        "totalPages": 1,
        "size": 20,
        "number": 0,
        "sort": null,
        "numberOfElements": 1,
        "first": true
    }
}

```
###### Método POST
| Tipo | Solicitud de descripción | URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1	| Crea un nuevo pedido | /dashboard/shop | Vea abajo | Nuevo pedido y CREADO (201) | NOT_FOUND(404) |

[1]
```
 {
    "id": 1,
        "cost": 31,
        "completed": false,
        "date": 1521311658000,
        "home": {
            "id": 1,
                "postCode": 28045,
                "address": "c/montepinar",
                "activated": true,
                "deviceList": [],
                "deviceQuantity": 0
          },
                "deviceList": [
          {
                "id": 1,
                "description": "Actuador de bombilla",
                "cost": 30,
                "type": "LIGHT",
                "status": "ON",
                "img": null,
                "activated": false,
                "activatedStatus": false,
                "serialNumber": null,
                "favorite": false
           },
           {
                "id": 2,
                "description": "Actuador de persiana",
                "cost": 150,
                "type": "BLIND",
                "status": "UP",
                "img": null,
                "activated": false,
                "activatedStatus": false,
                "serialNumber": null,
                "favorite": false
            }
        ],
    "observation": "Mi observacion",
    "dateAsString": "2018-34-17 19:34:18"
}
```
###### Método DELETE
| Tipo | Solicitud de descripción | URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Elimina un pedido. | /adminDashboard/orders/id |	Pedido eliminado y OK (200) | CONFLICTO (409) o NOT_FOUND (404)

###### Método PUT
| Tipo | Solicitud de descripción | URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1	 | Modifica el pedido con el numero de serie. |	/adminDashboard/orders/id  | Vea abajo	| Pedido modificado y OK (200) | NOT_FOUND (404) |

[1]

```
{
    "orderData": [
        {
            "id": 1,
            "cost": 31,
            "completed": false,
            "date": 1521244071000,
            "home": {
                "id": 1,
                "postCode": 28045,
                "address": "c/montepinar",
                "activated": true,
                "deviceList": [],
                "deviceQuantity": 0
            },
            "deviceList": [
                {
                    "id": 1,
                    "description": "Actuador de bombilla",
                    "cost": 30,
                    "type": "LIGHT",
                    "status": "ON",
                    "img": null,
                    "activated": false,
                    "activatedStatus": false,
                    "serialNumber": "A123Z",
                    "favorite": false
                },
                {
                    "id": 2,
                    "description": "Actuador de persiana",
                    "cost": 150,
                    "type": "BLIND",
                    "status": "UP",
                    "img": null,
                    "activated": false,
                    "activatedStatus": false,
                    "serialNumber": "B111X",
                    "favorite": false
                }
            ],
            "observation": "Mi observacion"
        }
    ],
    "userHomeData": [
        null
    ]
}
```

### Casas
La API de géneros tiene métodos GET, POST. 
Un usuario registrado, solo puede enviar solicitudes GET. 
Un usuario administrador, puede enviar cualquier solicitud. 
Todas las URL de solicitud se pueden enviar escribiendo http://localhost:8443 seguido de la URL de solicitud contenida en las siguientes tablas.

###### Métodos GET
| Tipo | Permisos | Solicitud de descripción |	URL de solicitud | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Usuario | Muestra todas las casas. | /api/dashboard/homes | Lista de casas y OK (200). | NOT_FOUND (404) |
| 2 | Usuario | Muestra todas las casas junto a los datos del usuario y pedidos. | /api/dashboard/see | Lista de casas con su usuario y pedido y OK (200). | NOT_FOUND (404) |
| 3	| Administrador | Muestra la casas junto al pedidos. | /api/adminDashboard/ | Casas con pedidos y OK (200).	| NOT_FOUND (404) |
| 4	| Administrador | Muestra la casa junto a los datos de usuario. | /api/adminDashboard/users/id | Casas con sus usuarios y OK (200).	| NOT_FOUND (404) |
| 5	| Administrador | Muestra la casas junto al pedidos. | /api/adminDashboard/orders | Casas con pedidos y OK (200).	| NOT_FOUND (404) |
| 6	| Administrador | Muestra la casa junto al pedido de un usuario concreto. | /api/adminDashboard/orders/id | Casa con su usuario y OK (200).	| NOT_FOUND (404) |

[1]
````
[
   {
       "id": 2,
       "postCode": 21111,
       "address": "c/ole",
       "activated": false,
       "deviceList": [],
       "deviceQuantity": 0
   },
   {
       "id": 3,
       "postCode": 28007,
       "address": "c/hugo",
       "activated": true,
       "deviceList": [
           {
               "id": 1,
               "description": "Actuador de bombilla",
               "cost": 30,
               "type": "LIGHT",
               "status": "ON",
               "img": null,
               "activated": false,
               "activatedStatus": false,
               "serialNumber": null,
               "favorite": false
           },
           {
               "id": 3,
               "description": "RaspberryPi",
               "cost": 30,
               "type": "RASPBERRYPI",
               "status": "OFF",
               "img": null,
               "activated": false,
               "activatedStatus": false,
               "serialNumber": null,
               "favorite": false
           },
           {
               "id": 4,
               "description": "Actuador de persiana",
               "cost": 150,
               "type": "BLIND",
               "status": "UP",
               "img": null,
               "activated": true,
               "activatedStatus": false,
               "serialNumber": null,
               "favorite": false
           }
       ],
       "deviceQuantity": 3
   }
]

````

###### Método POST
| Tipo | Solicitud de descripción |	URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Crea ua nueva casa. | /api/dashboard/shop | Vea abajo | Nuevo casa y CREADO (201) | NOT_FOUND (404) |


## Estadísticas
La API de géneros tiene métodos GET. 
Un usuario registrado, puede enviar solicitude de GET. 
Todas las URL de solicitud se pueden enviar escribiendo http://localhost:8443 seguido de la URL de solicitud contenida en las siguientes tablas.

###### Métodos GET
| Tipo | Solicitud de descripción |	URL de solicitud | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | 
| 1  | Muestra las estadísticas con su casa asociada. | /api/dashboard/analytic/device/{id} | Estadistica de cada casa y OK (200). | NOT_FOUND (404) |

[1]
```
[
   {
       "id": 1,
       "device": {
           "id": 4,
           "description": "Actuador de persiana",
           "cost": 150,
           "type": "BLIND",
           "status": "UP",
           "img": null,
           "activated": true,
           "activatedStatus": false,
           "serialNumber": null,
           "favorite": false
       },
       "date": 1521399545000,
       "previousState": "OFF",
       "newState": "ON"
   },
   {
       "id": 2,
       "device": {
           "id": 4,
           "description": "Actuador de persiana",
           "cost": 150,
           "type": "BLIND",
           "status": "DOWN",
           "img": null,
           "activated": true,
           "activatedStatus": false,
           "serialNumber": null,
           "favorite": false
       },
       "date": 1521403145000,
       "previousState": "ON",
       "newState": "OFF"
   }
]
```

### Facturas
La API de generar facturas solo tiene método GET. 
Solo un usuario registrado puede enviar solicitudes a este endpoint especificando sobre que casa quiere la factura. 
Todas las URL de solicitud se pueden enviar escribiendo http://localhost:8443 seguido de la URL de solicitud contenida en las siguientes tablas.

###### Método POST
| Tipo | Solicitud de descripción |	URL de solicitud | Solicitar cuerpo | Respuesta de éxito | Respuesta de error |
| --- | --- | --- | --- | --- | --- |
| 1 | Crea ua nueva factura. | /api/dashboard/homes/{id}/generateInvoice | Vea abajo | Nueva factura y CREADO (200) | UNAUTHORIZED |

