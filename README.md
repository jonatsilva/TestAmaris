Este tutorial es indicado para ejecutar el proyecto java.

A- Ejecutar el proyecto con: :: Spring Boot :: (v2.2.7.RELEASE)

B- Las librerías necesarias están configuradas desde el pom.xml de MAVEN.

C- La versión de JDK es JAVA 8.

D- La base de datos es H2 ejecutado en memoria al iniciar el proyecto. http://localhost:8080/h2-ui/login.jsp user: sa pass: sa

E- Usar Swagger para poder acceder a los métodos del controller construidos. http://localhost:8080/swagger-ui.html#/

F- Los métodos a acceder son:

User Controller

* Método POST createUser
  Este método es el necesario para crear a un usuario en la base de datos que relaciona la tabla USER para poder luego agregar una nueva news.
  Antes de crear el usuario el servicio valida que no exista una coincidencia en la base de datos del correo del usuario antes de ser insertado.
  El correo siempre es validado que su estructura sea correcta y no contenga caracteres especiales.

* Con lo anterior se crea News Controller

* Método GET searchNews
  Este método puede devolver todas la news del servicio REST https://api.spaceflightnewsapi.net/v4/articles/ tal como su origen, obteniendo todos los datos.
  

* Método POST createFavorite
  Este método con el id de usaurio creado y el id del news del servicio rest guarda las noticias en la tabla FAVORITE y hace la distincion de las news de cada usuario creado.
  
* Método GET getAllFavoritesById
  Este método entrega todos los idNews guardados asociados al usuario idUser y llama el servicio REST https://api.spaceflightnewsapi.net/v4/articles/ para traer todas las noticias de los idNews registrados.

* Método DELETE deleteFavorite
  Este método elimina una noticias de la tabla FAVORITE asociados a un usuario idUser y cada uno de los idNews que este usuario tenga.
 
