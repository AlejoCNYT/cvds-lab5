# LABORATORIO 5 - SPRING MVC INTRODUCTION
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

Después de terminar el aprendizaje analice: - ¿Por qué MVC obtiene ese nombre? (puede apoyarse de https://www.javatpoint.com/spring-mvc-tutorial) - ¿Cuáles son las ventajas de usar MVC? - ¿Qué diferencia tiene la estructura de directorios de este proyecto comparado con las de proyectos pasados (con solo maven y java EE)? - ¿Qué anotaciones usaste y cuál es la diferencia entre ellas?
## PARTE III. - APLICACIÓN MVC PARA CONSUMO DE SERVICIO RESTful

Usando la arquitectura MVC del punto anterior (el proyecto anterior), realice una aplicación simple qué permita navegar gráficamente sobre esta API https://jsonplaceholder.typicode.com/todos/1, puede guiarse de tutoriales como https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0

Luego de terminada esta parte responda: - ¿Qué es RESTful? - Si utilizo un framework como Boostrap CSS para qué el apartado gráfico se vea más profesional, ¿en qué capa se haría su uso?
## PARTE IV. - APLICACIÓN MVC JUEGO

¡Llego la hora del reto! Teniendo las bases del uso del framework, cree una nueva ruta, por ejemplo /guess, y agrege formulario básico con un campo llamado "número" (guía de como crear formularios HTML https://www.w3schools.com/html/)

Y vamos a implementar la lógica de nuestro juego: 1. Se trata de un juego en línea para adivinar un número, en el que el ganador, si acierta en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio se reduce en $10.000, como en los juegos de apuesta, es natural qué quede en saldos negativos. 2. El número a adivinar debe ser generado en cada intento y comparado con el número qué el usuario está insertando, es un número de 1 a 10. 3. Debe existir un botón de reset, qué permita al jugador iniciar de nuevo. 4. La capa de controlador debe procer el número del usuario mediante método POST.

Analice las siguientes situaciones: - ¿Qué pasa si abro el sitio de juegos en dos navegadores difententes? - Si quisiera qué a cada jugador le aparecieran independientemente sus respectivos saldos. ¿Qué habría que hacer?
