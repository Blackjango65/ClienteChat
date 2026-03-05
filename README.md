# ClienteChat

ClienteChat es un cliente de chat escrito en Java (proyecto generado con NetBeans).

**Requisitos**
- Java JDK 8 o superior
- (Opcional) Apache Ant para compilar desde línea de comandos
- (Opcional) NetBeans para abrir y ejecutar el proyecto directamente

**Compilación**
- Desde NetBeans: abrir el proyecto y presionar Run (Ejecutar).
- Desde línea de comandos: ejecutar `ant` en la raíz del proyecto. El script de build generará los artefactos según la configuración del proyecto.

**Ejecución**
- Si el proceso de build genera un JAR (por ejemplo en `dist/`), puede ejecutarse con:

```
java -jar dist/ClienteChat.jar
```

Nota: el nombre exacto del JAR depende del `build.xml` del proyecto.

**Configuración**
- Al iniciar la aplicación, use la ventana de configuración para indicar la dirección del servidor y el puerto.

**Estructura**
- Código fuente: `src/clientechat`
- Ficheros de construcción: `build.xml`, `nbproject/`

Si quieres, puedo añadir una licencia y una descripción más detallada del proyecto.
