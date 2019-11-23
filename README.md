# Rustico tarea final de Ncapas

## Como ejecutar :rocket:
Primero se debe utilizar *backup-ncapas.backup* para realizar un backup en el gestor de base datos de postgresql de versiones 10 para arriba. Depues de realizar el backup de la base datos se debe modificar el documento *application.properties* que se encuentra en *rustico/src/main/resources/*

![Carpeta](https://i.imgur.com/JM3ycBd.png)

Seguido de eso se debe abrir el documento y modificar los campos respectivos para la conexion:

- spring.datasource.url=jdbc:postgresql://(IP):(puerto)/(nombre_de_base)
- spring.datasource.username=(usuario)
- spring.datasource.password=(contraseña)

![Informacion](https://i.imgur.com/6aSae4X.png)


Una vez realizado sera posible logear en la aplicacion con el usuario :key: _admin@admin_ y la clave secreta _12345678_ 

¡Eso es todo! :tada:
