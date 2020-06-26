# Tablero Online

En este proyecto se realizó un tablero web, en el cual varios usuarios pueden escribir y ver lo que hacen los demas usuarios que estén conectados a la aplicación

## Getting Started

Para hacer uso del proyecto solo debe clonar el repositorio o descargarlo directamente, para ejectarlo lo hacemos por medio de la consola usando el siguiente comando.

```bash
mvn exec:java -Dexec.mainClass=co.edu.escuelaing.arsw.tablero.WebSiteController
```

O puede usar el tablero directamente desde la siguiente dirección:

https://stark-ridge-45751.herokuapp.com/

### Prerequisites

Para usar el proyecto se necesitan tener las siguientes versiones de java o superior:

```
java version "1.8"
javac version "1.8"
Apache Maven 3.6.3
```

### Installing

Para usar el proyecto decargamos directamente el proyecto o lo clonamos de la siguiente manera:

En la consola nos vamos al directorio donde vamos a clonar el repositorio y ponemos el siguiente comando:

```bash
git clone https://github.com/anfegoca/ARSW-lab6.git

```
![clone](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/1.png)

En el direcctorio nos quedará la carpeta del proyecto y dentro veremos las siguiente carpetas

![direc](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/2.png)

Para modificar abrimos el proyecto con cualquier editor, en este caso usamos NetBeans

![edit](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/3.png)

Y ya podemos modificar cualquier clase del proyecto

![class](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/4.png)

## Running the tests

Para ver el funcionamiento, ejecutamos el programa, veremos lo siguiente

![class](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/5.png)

Abrimos la siguiente pagina y ya podremos usar la aplicación

http://localhost:8080/

![class](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/6.png)

Tambien podemos usar la aplicación usando la siguiente dirección

https://powerful-anchorage-32349.herokuapp.com/


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring](https://spring.io/projects/spring-boot) - Framework


## Versioning

El versionamiento se realizó a través de [github](https://github.com/anfegoca/ARSW-lab6.git)

## Authors

* **Andrés González** - [anfegoca](https://github.com/anfegoca)


## License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details

## Design

![class](https://github.com/anfegoca/ARSW-lab6/blob/master/resources/7.png)

La aplicación funciona con 2 paquetes, el de presentación captura los eventos del telado a traves de un JS llamado **sketch**, este JS le pasa los puntos en los cuales el usuario presionó el mouse a un JSX llamado **Tablero**, a través de un metodo **add** el cual hace un llamado a la clase **WebSiteController** a su método **add**, pasandole los puntos, el método add, guarda el punto en una clase singleton la cual se llama **Cola**. el **Tablero** cada 5ms verifica si la **Cola** está vacía haciendo una consulta al **WebSiteController**, si no está vacía, usa el metodo **getPoints**, el cual manda una solicitud a **WebSiteController**, para que esté le pida a la **Cola** el punto, el punto es retornado como un **JSON**, luego el **Tablero** usa a **Sketch** con su metodo **dibujo**, para pintar el resultado en pantalla. Para borrar el contenido del tablero hay un boton el cual usa el método **limpiar** de **Sketch**.

## JavaDoc

La documentación del proyecto la puede encontrar [aquí](https://github.com/anfegoca/ARSW-lab6/tree/master/site/apidocs)
