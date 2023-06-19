1. Prerrequisitos:
    - Descargar, instalar y configurar variable de entorno para Java 11
    - Descargar, instalar y configurar variable de entorno para apache-maven-3.9.2
    - Descargar e Instalar IDE Intellij IDEA
    - Descargar e instalar GIT
2. Comandos de instalación
    - java -version (Valida versión de java instalado localmente)
    - mvn -version (Valida versión de maven instalado localmente)
    - mvn clean package -U (Limpiara todo las dependencias y recursos descargados anteriormente por el proyecto)
    - mvn clean install -DskipTests (Hará un install sobre el proyecto sin ejecutar los tests y verificará que no exista errores y comenzará a descargar las dependencias y recursos que el proyecto utilizará)
3. Instrucciones para ejecutar los test
    - Ingresar al feature ubicado en la siguiente ruta NTTDataSerenityTest\src\test\resources\features\search\ShoppingCart.feature
    - Abrir una terminal dentro del IDE 
    - Ejecutar el comento mvn clean install y automáticamente comenzara a realizar la ejecución del test automatizado
