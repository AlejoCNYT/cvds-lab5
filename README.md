# LABORATORIO 5 - SPRING MVC INTRODUCTION

* Daniel Alejandro AV
* Julian Triana

## INTRODUCCIÓN A PROYECTOS WEB

Previamente, se dispone la configuración de Windows para ello.

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20171321.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20171334.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20171531.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20171545.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20171612.png)

PARTE I. - JUGANDO A SER UN CLIENTE HTTP

    Abra una terminal Linux o consola de comandos Windows.
    Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
    Host: www.escuelaing.edu.co
    Puerto: 80 Teniendo en cuenta los parámetros del comando telnet:

$ telnet HOST PORT

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20171704.png)

    Antes de que el servidor cierre la conexión por falta de comunicación:

Revise el RFC del protocolo HTTP, sobre cómo realizar una petición GET. Debe lucir más o menos de esta forma:

GET /with-a-resource.html HTTP/1.0
Host: www.escuelaing.edu.co

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20172301.png)

Con esto, solicite al servidor el recurso sssss/abc.html, usando la versión 1.0 de HTTP. Copie las dos lineas de codigo con el recurso agregado y peguelas en la consola del servidor ya abierta. Asegúrese de presionar ENTER dos veces después de ingresar el comando.

Revise el resultado obtenido.

    ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.

El error obtenido es **301 Moved Permanently**, lo cual indica que el recurso ha sido movido permanentemente a otra ubicación proporcionada en el encaezado **location**.
    
    ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?

* **200 OK** Indica que la solicitud ha tenido éxito.
* **400 Bad Request** Síntaxis incorrecta.
* **403 Forbidden** Negación en cumplimiento de solicitud requerida.
* **404 Not Found** Recurso solicitado no está en servidor.
* **500 Internal Server Error** Error en el servidor, al procesar la solicitud.

    Responder en el README.md según lo indicado en la última sección de este laboratorio (ENTREGA).

    Realice una nueva conexión con telnet, esta vez a:

Host: www.httpbin.org
Puerto: 80
Versión HTTP: 1.1

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20174431.png)

Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20174416.png)

¡Muy bien!, ¡Acaba de usar del protocolo HTTP sin un navegador Web!. Cada vez que se usa un navegador, éste se conecta a un servidor HTTP, envía peticiones del protocolo HTTP, espera el resultado de las mismas, y si se trata de contenido HTML lo interpreta y dibuja.

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20181159.png)

    Seleccione el contenido HTML de la respuesta y copielo al cortapapeles CTRL-SHIFT-C. Ejecute el comando wc (word count) para contar palabras con la opción -c para contar el número de caracteres:

$ wc -c

Pegue el contenido del portapapeles con CTRL-SHIFT-V y presione CTRL-D (fin de archivo de Linux). Si no termina el comando wc presione CTRL-D de nuevo. No presione mas de dos veces CTRL-D indica que se termino la entrada y puede cerrarle la terminal. Debe salir el resultado de la cantidad de caracteres que tiene el contenido HTML que respondió el servidor.

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20181143.png)

Claro está, las peticiones GET son insuficientes en muchos casos. Investigue: ¿Cuál esla diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen? 7. En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos:

1) **GET** Solicita datos de un recurso específico del servidor.
2) **POST** Crear o actualizar un recurso.

Aparte, existen otros tipos de solicitud tales como:

* **PUT** Crear o Actualizar datos hacia una ubicación específica.
* **DELETE** Eliminar recurso en una ubicación específica.
* **PATCH** Modificar temporalmente un recurso.
* **HEAD** Solicitar encabezados de respuesta.
* **OPTIONS** Solicitar opciones disponibles de comunicación de un recurso o servidor.

$ curl "www.httpbin.org"

Utilice ahora el parámetro -v y con el parámetro -i:

¿Cuáles son las diferencias con los diferentes parámetros?

$ curl -v www.httpbin.org

*Detalla información sobre solicitud y repuesta.*

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20182426.png)

$ curl -i www.httpbin.org

*Muestra sólo encabezados de la respuesta.*

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-22%20182445.png)


## PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA USANDO EL PATRÓN MVC

En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de spring MVC.

Para esto usaremos la documentación oficial de Spring con que que aprenderemos las funciones básicas de este framework https://spring.io/guides/gs/serving-web-content/

![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-25%20163426.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-25%20163444.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-25%20163626.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-25%20163846.png)
![](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-25%20164155.png)

Después de terminar el aprendizaje analice: 

- ¿Por qué MVC obtiene ese nombre? (puede apoyarse de https://www.javatpoint.com/spring-mvc-tutorial)

El nombre se debe al modelo de capas en que se organiza, según este modelo:

* **Model** Es la lógica implicada.
* **Vista** Presenta la interfaz al usuario y le permite interactuar con el programa.
* **Controlador** Actúa como intermediario entre usuario y modelo, regresando los resultados adecuados dependiendo de la solicitud.

- ¿Cuáles son las ventajas de usar MVC?

Facilita la concepción de código al separar roles MVC, utiliza servlets ligeros para contener y desarrollar la aplicación, facilita desarrollo veloz y paralelo, facilidad para reutilizar objetos existentes, mayor facilidad para uso de setters, mapeo flexible y, uso de validadores y objetos de negocio.

- ¿Qué diferencia tiene la estructura de directorios de este proyecto comparado con las de proyectos pasados (con solo maven y java EE)?

**src/main/java**: aquí se ubican los componentes MVC del programa, en código fuente.

**src/main/resources**: Se encuentran archivos estáticos y de parametrización de la aplicación tales como propiedades, XML y web.

**src/test**: Contiene test unitarios e integración.

**src/main/webapp**: Contiene recursos web de JSP, CSS, JS, etc.

- ¿Qué anotaciones usaste y cuál es la diferencia entre ellas?

**@Controller**: Define las peticiones que manejan HTTP. Marca controladores de Spring MVC.

**@RequestMapping**: Asigna una URL o patrón URL al método controlador que lo requiere.

**@GetMapping, @PostMapping, @PutMapping, @DeleteMapping**: Especifican el método HTTP como versión simplificada GET, POST, PUT y DELETE.

**@RequestParam**: Vincula parámetros HTTP a los de un método _Controler_.

**@ModelAttribute**: Enlaza parámetros de una solicitud HTTP o valores determinados con un objeto _Model_. Facilita agregación de atributos para su renderización.

**@ResponseBody**: Indica serialización del valor devuelto por un método y no, ser interpretado con el nombre de una vista.
  
## PARTE III. - APLICACIÓN MVC PARA CONSUMO DE SERVICIO RESTful

Usando la arquitectura MVC del punto anterior (el proyecto anterior), realice una aplicación simple qué permita navegar gráficamente sobre esta API [https://jsonplaceholder.typicode.com/todos/1](https://jsonplaceholder.typicode.com/todos/1), puede guiarse de tutoriales como [https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0](https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0).

![Captura de pantalla 1](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20071214.png)
![Captura de pantalla 2](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20071329.png)
![Captura de pantalla 3](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20071340.png)
![Captura de pantalla 4](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20071621.png)
![Captura de pantalla 5](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20071647.png)
![Captura de pantalla 6](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20071958.png)
![Captura de pantalla 7](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20072211.png)
![Captura de pantalla 8](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20072219.png)
![Captura de pantalla 9](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20072242.png)
![Captura de pantalla 10](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20072336.png)
![Captura de pantalla 11](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20073846.png)
![Captura de pantalla 12](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20074414.png)
![Captura de pantalla 13](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20074430.png)

Luego de terminada esta parte responda: 

- ¿Qué es RESTful?

* **RESTful (Representational State Transfer)**: Es un determinado estilo eficiente para DevOps. Dichos servicios son denominados RESTful APIs o servicios web RESTful.

Algunas características de una API RESTful incluyen:

*Protocolo HTTP*: Utiliza HTTP como el protocolo de comunicación estándar, aprovechando sus operaciones (GET, POST, PUT, DELETE, etc.) para realizar acciones sobre los recursos.

*Recursos*: Los recursos son las entidades que se manipulan a través de la API. Cada recurso tiene un identificador único (URI) y puede ser representado en diferentes formatos (JSON, XML, etc.).

*Operaciones CRUD*: Las operaciones CRUD (Create, Read, Update, Delete) se mapean a las operaciones HTTP (POST, GET, PUT, DELETE) para crear, leer, actualizar y eliminar recursos.

*Sin estado (Stateless)*: Las solicitudes de cliente contienen toda la información necesaria para ser comprendidas por el servidor. El servidor no mantiene ningún estado de sesión entre solicitudes.

*Interfaz uniforme*: Utiliza un conjunto común de operaciones (GET, POST, PUT, DELETE) para interactuar con los recursos, lo que simplifica el desarrollo y la comprensión de la API.

*HATEOAS (Hypermedia as the Engine of Application State)*: Los clientes interactúan con la API a través de hipervínculos proporcionados en las respuestas, lo que les permite descubrir y navegar por los recursos de forma dinámica.

- Si utilizo un framework como Boostrap CSS para qué el apartado gráfico se vea más profesional, ¿en qué capa se haría su uso?

* El uso de un framework de CSS como Bootstrap es para mejorar la visualización o presentación. Dicha capa corresponde a la parte del código que se encarga de la interfaz de usuario y la presentación de la información.
  
## PARTE IV. - APLICACIÓN MVC JUEGO

¡Llegó la hora del reto! Teniendo las bases del uso del framework, cree una nueva ruta, por ejemplo /guess, y agregue un formulario básico con un campo llamado "número" (guía de cómo crear formularios HTML [aquí](https://www.w3schools.com/html/)).

Y vamos a implementar la lógica de nuestro juego: 

1) Se trata de un juego en línea para adivinar un número, en el que el ganador, si acierta en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio se reduce en $10.000, como en los juegos de apuesta, es natural que quede en saldos negativos.
2) El número a adivinar debe ser generado en cada intento y comparado con el número que el usuario está insertando, es un número de 1 a 10.
3) Debe existir un botón de reset, que permita al jugador iniciar de nuevo.
4) La capa de controlador debe procesar el número del usuario mediante método POST.

![Captura de pantalla del juego](https://github.com/AlejoCNYT/cvds-lab5/blob/main/img/Captura%20de%20pantalla%202024-03-31%20080936.png)

Analice las siguientes situaciones:

¿Qué pasa si abro el sitio de juegos en dos navegadores diferentes?

- Los jugadores pueden jugar independientemente entre sí. Cada jugador tiene su propio servidor.

Si quisiera que a cada jugador le aparecieran independientemente sus respectivos saldos. ¿Qué habría que hacer?

- Se puede implementar usando Spring Session, el cual facilita que cada usuario tenga su propia sesión. Con Spring Session, cada jugador puede tener su propia sesión y saldo asociado. Igualmente, con una base de datos se puede mantener persistentemente, por lo cual los saldos estarían independientes si el servidor se reinicia.
