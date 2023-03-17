**Explicación de los archivos incluidos en esta entrega:**

El directorio `.target` contiene los archivos compilados y construidos por Maven, por lo que no debería incluirse en el control de versiones de Git. Cada desarrollador o integrador de proyecto puede construir el proyecto localmente usando Maven, y cada uno tendrá su propio conjunto de archivos de compilación.

El directorio `.idea` es específico de IntelliJ IDEA y contiene archivos de configuración y opciones de proyecto. Incluir este directorio en el control de versiones puede hacer que se mantenga una configuración desactualizada o incorrecta para otros desarrolladores que trabajan en el proyecto. Además, cada desarrollador puede preferir utilizar un IDE diferente, por lo que no tendría sentido incluir archivos específicos de IDEA que son irrelevantes para otros entornos de desarrollo.

Sin embargo, hemos incluido los informes de Jacoco en nuestro repositorio, ya que se mencionan en los requisitos de la práctica. Estos informes son útiles para medir la cobertura de pruebas de nuestro proyecto y para realizar análisis estáticos del código fuente.

También hemos incluido los enunciados del ejercicio para dar mayor contexto al proyecto y para que los miembros del equipo tengan fácil acceso a ellos. Además, hemos agregado un archivo `.txt` con el enlace a nuestro repositorio de Git, ya que esto es un requisito para la entrega de la práctica en el campus virtual.
