# Maven: Build Tool y Gestor de Dependencias

**Fuente:** Eazy Bytes

**Nivel:** Principiante a Intermedio

**Relación:** Herramienta esencial para Spring Boot projects

---

## ¿Por qué necesitamos Maven?

### El Problema: Antes de Maven

En aplicaciones Core Java simples trabajas con pocos archivos `.java`. Pero en aplicaciones enterprise como Spring Boot, dependes de **cientos de clases** proporcionadas por:

- Frameworks (Spring, Hibernate)
- Librerías de terceros (MySQL driver, JSON libraries)
- Herramientas externas

Estos se llaman **dependencias**.

### Ejemplo de necesidades:

```
✓ Spring Web - para construir servicios web
✓ MySQL driver - para acceso a bases de datos
✓ Jackson - para manejo de JSON
✓ ... y muchas más librerías
```

Para una simple web app necesitas **50+ archivos JAR**.

### El Dolor: Gestión Manual de JARs

**Antes de Maven**, los desarrolladores tenían que:

1. **Buscar manualmente** en internet: `spring-web.jar`, `mysql-connector.jar`, `jackson.jar`
2. **Descargar uno por uno** desde diferentes sitios web
3. **Colocar dentro de una carpeta** llamada `lib/`
4. **Agregar manualmente al classpath** del proyecto
5. **Si un JAR dependía de 10 más:** Repetir el proceso para cada uno (transitive dependencies)

### Problemas resultantes:

❌ **Proceso tedioso:** Horas solo descargando JARs

❌ **Dependencias transitivas:** Un JAR puede depender de otros, ¡más descargas!

❌ **Portabilidad:** Cada desarrollador en el equipo repetía lo mismo

❌ **Cambio de máquina:** Mover el proyecto = JARs faltantes = el proyecto se rompe

❌ **Sin consistencia:** Diferentes versiones en diferentes máquinas

---

## Entra Maven: El Héroe

Maven **automatiza todo esto**.

### Concepto Simple

En lugar de buscar y descargar manualmente, simplemente le **dices a Maven qué necesitas** en un único archivo:

```xml
pom.xml
(POM = Project Object Model)
```

### Sintaxis de Dependencia

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <version>3.1.5</version>
</dependency>
```

### Estructura de Dirección (Como una dirección postal)

Cada librería tiene una **dirección única**:

| Componente | Analogía | Ejemplo |
| --- | --- | --- |
| **GroupId** | Ciudad | `org.springframework.boot` |
| **ArtifactId** | Calle | `spring-boot-starter-web` |
| **Version** | Número de casa | `3.1.5` |

### Qué Maven hace automáticamente:

✅ **Busca** la librería en Maven Central Repository

✅ **Descarga** automáticamente

✅ **Descarga TODAS sus dependencias** (transitive dependencies)

✅ **Las coloca en el classpath correcto**

✅ **Sin esfuerzo manual**

---

## Maven Central Repository

### ¿Dónde descarga Maven?

Maven descarga de un lugar central en internet llamado:

**Maven Central Repository**

Piénsalo como el **"Amazon de librerías Java"** donde están todas disponibles.

### Cómo funciona:

```
pom.xml
    ↓
Check: ¿Existe en tu máquina?
    ↓ NO
Maven Central Repository
    ↓
Download JARs
    ↓
Add to Classpath
    ↓
Build, Test, Package, Run
```

---

## Local Repository

### Almacenamiento Local

Una vez descargadas, las librerías se guardan en tu máquina en una carpeta Maven llamada **local repository**.

### Ruta ejemplo (Mac/Linux):

```
~/.m2/repository
```

### Ruta ejemplo (Windows):

```
C:\Users\YourUsername\.m2\repository
```

### El Beneficio: Reutilización

Si otro proyecto necesita el **mismo JAR**:

✅ Maven **simplemente lo reutiliza localmente**

✅ **No descarga de nuevo**

✅ **Ahorras tiempo** y ancho de banda de red

### Ventajas:

| Beneficio | Impacto |
| --- | --- |
| **Velocidad** | Proyectos posteriores se construyen más rápido |
| **Ancho de banda** | No descargas lo mismo 100 veces |
| **Consistencia** | Todos los proyectos usan la misma versión |

---

## Ventajas de Trabajo en Equipo

### El Escenario

Compartes tu código con un colega:

**Antes de Maven:**

```
- Espera... necesitas estos 50 JARs
- ¿Dónde los descargo?
- ¿Qué versiones?
- ¿De dónde?
```

**Con Maven:**

```
- Solo comparte el pom.xml
- El colega ejecuta: mvn install
- ¡Todo descargado automáticamente!
```

### Resultado:

✅ **Proyecto portátil** - funciona en cualquier máquina

✅ **Fácil de compartir** - solo necesitas el código fuente

✅ **Menos error-prone** - no hay versiones inconsistentes

✅ **Escalable** - funciona para 10 proyectos o 10,000

---

## Maven: Más allá de Dependencias

Maven no es **solo** un gestor de dependencias. También es una herramienta de **automatización de builds**.

### Qué puede hacer Maven:

✅ **Compilar** código Java

✅ **Ejecutar tests** unitarios

✅ **Empaquetar** aplicaciones (JAR/WAR)

✅ **Crear reportes** de análisis

✅ **Desplegar** artefactos

✅ **Generar documentación**

Todo usando **simples comandos**:

```bash
mvn clean install
mvn package
mvn test
```

---

## Estructura Estándar de Proyectos Maven

Maven **ama la organización**. Cada proyecto Maven sigue la misma estructura:

```
maven-app/
├── pom.xml                 → Tu "lista de compras"
├── src/
│   ├── main/
│   │   ├── java/          → Tu código Java aquí
│   │   └── resources/     → Config, properties, etc
│   └── test/
│       ├── java/          → Tu código de pruebas
│       └── resources/     → Configuraciones de test
└── target/                → Código compilado (Maven lo crea)
```

### Beneficios de estructura estándar:

✅ **Predictibilidad** - cualquier desarrollador entiende el proyecto instantáneamente

✅ **Herramientas smart** - IDEs e herramientas saben exactamente dónde buscar

✅ **Sin confusión** - no hay dudas sobre dónde poner archivos

✅ **Compatibilidad** - funciona con cualquier herramienta Maven

---

## Comandos Maven Comunes

Maven ejecuta tareas predefinidas llamadas **goals**.

### 1. **mvn clean** - Limpia construcciones anteriores

```bash
mvn clean
```

**Qué hace:**

- Elimina la carpeta `target/`
- Borra artefactos compilados anteriormente

**Por qué:**

- Evitar conflictos con builds antiguos
- Garantizar un "fresh start"
- Evitar archivos obsoletos

---

### 2. **mvn validate** - Valida configuración del proyecto

```bash
mvn validate
```

**Qué verifica:**

- ¿Es `pom.xml` un XML válido?
- ¿Están presentes todos los campos requeridos? (groupId, artifactId, version)
- ¿Es correcta la estructura del proyecto?
- ¿Están disponibles todos los plugins necesarios?

---

### 3. **mvn compile** - Compila código fuente

```bash
mvn compile
```

**Qué hace:**

- Lee archivos de `src/main/java`
- Genera archivos `.class` en `target/`
- Verifica sintaxis Java

---

### 4. **mvn test** - Ejecuta pruebas unitarias

```bash
mvn test
```

**Qué hace:**

- Busca en `src/test/java`
- Ejecuta todos los tests
- Reporta resultados

**Importancia:**

> Solo después de tests exitosos podemos decir que la app es estable
> 

---

### 5. **mvn package** - Empaqueta en JAR o WAR

```bash
mvn package
```

**Qué genera:**

- `target/myapp-0.0.1-SNAPSHOT.jar` (o WAR)
- Archivo ejecutable o deployable
- Puede correr o desplegar

---

### 6. **mvn verify** - Verifica construcción completa

```bash
mvn verify
```

**Qué hace:**

- Compila el proyecto
- Ejecuta tests
- Verifica que todo funcione
- **NO despliega** (solo verifica)

**Diferencia con package:**

- `package` solo empaqueta
- `verify` valida TODO sin desplegar

---

### 7. **mvn install** - El comando más importante

```bash
mvn install
```

**Qué hace (en orden):**

1. Compila → tests → empaqueta → verifica
2. Instala el JAR final en tu **local repository** (~/.m2)
3. Permite que otros proyectos en tu máquina lo reutilicen

**Por qué es importante:**

- Proyecto compartible entre tus propios proyectos
- Ciclo completo de validación
- Estándar de la industria

---

### 8. **mvn deploy** - Sube a repositorio remoto

```bash
mvn deploy
```

**Qué hace:**

- Sube tu JAR/WAR a un repositorio remoto
- (Nexus, Artifactory, GitHub Packages, etc)
- Otros en la organización pueden reutilizarlo

---

### 9. **mvn site** - Genera documentación HTML

```bash
mvn site
```

**Qué genera:**

- Sitio web HTML con documentación del proyecto
- Información del POM
- Reportes, dependencias, test coverage
- Abre en navegador

---

## Flujo Completo de Maven

### La Pipeline (orden importa):

```
validate → compile → test → package → verify → install → deploy
    ↓           ↓         ↓       ↓          ↓         ↓
  Check     Compile   Run    Create   Verify  Save    Upload
 config    .class    tests   JAR    locally locally  remote
```

### Tip de Atajo Importante:

No necesitas ejecutar comandos por separado.

**Ejemplo:** Ejecutar `mvn install` automáticamente hace:

```
1. Clean (opcional)
2. Validate
3. Compile
4. Test
5. Package
6. Verify
7. Install
```

**¡Todo en secuencia!** Una línea, múltiples pasos.

---

## Analogía del Mundo Real: Hornear un Pastel

Imagina hornear un pastel. Los pasos deben seguir un orden específico:

| Maven | Pastel |
| --- | --- |
| **validate** | Verificar ingredientes |
| **compile** | Mezclar ingredientes |
| **test** | Probar la masa |
| **package** | Hornear el pastel |
| **install** | Poner en el refrigerador local |
| **deploy** | Entregar a la panadería |

### La Regla de Oro:

⚠️ **No puedes hornear antes de mezclar**

⚠️ **No puedes probar antes de mezclar**

⚠️ **Deben seguir un orden específico**

Maven funciona **exactamente igual**.

---

## pom.xml: Tu Archivo de Configuración

El corazón de todo proyecto Maven es el **pom.xml**.

### Estructura básica:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
    <modelVersion>4.0.0</modelVersion>

    <!-- Identidad del proyecto -->
    <groupId>com.ejemplo</groupId>
    <artifactId>mi-app</artifactId>
    <version>1.0.0</version>

    <!-- Nombre y descripción -->
    <name>Mi Aplicación</name>
    <description>Una descripción de mi app</description>

    <!-- Dependencias -->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>3.1.5</version>
        </dependency>
    </dependencies>

    <!-- Plugins -->
    <build>
        <plugins>
            <!-- Plugins aquí -->
        </plugins>
    </build>
</project>
```

### Secciones clave:

| Sección | Propósito |
| --- | --- |
| **modelVersion** | Versión del formato POM |
| **groupId** | Identificador único de organización |
| **artifactId** | Nombre del proyecto |
| **version** | Versión del proyecto |
| **dependencies** | Lista de librerías necesarias |
| **build** | Configuración de compilación |

---

## Comparación: Maven vs Sin Maven

### Sin Maven (manual):

```
1. Descargar 50+ JARs → Horas
2. Organizarlos en carpetas → Error-prone
3. Agregar al classpath → Confuso
4. Cambiar máquina → Se rompe
5. Compartir con equipo → Pesadilla
```

### Con Maven:

```
1. Editar pom.xml → 5 minutos
2. mvn install → Automático
3. Proyecto listo → Funciona en todas partes
4. Compartir → Solo código fuente + pom.xml
```

---

## Conceptos Clave

### Transitive Dependencies

Cuando A depende de B, y B depende de C:

```
Tu app → Spring Web (A)
    ↓
Spring Web → JSON Library (B)
    ↓
JSON Library → Logging (C)
```

**Sin Maven:** Descargabas A, B y C manualmente

**Con Maven:** Solo especificas A, Maven descarga B y C automáticamente

---

## Resumen

| Aspecto | Beneficio |
| --- | --- |
| **Gestión de dependencias** | Automática, centralizada |
| **Transitive deps** | Descarga todas las dependencias necesarias |
| **Portabilidad** | Proyecto funciona en cualquier máquina |
| **Teamwork** | Compartir código sin problemas |
| **Build automation** | Compile, test, package en un comando |
| **Consistencia** | Misma estructura en todos los proyectos |
| **Escala** | Funciona desde pequeños a grandes proyectos |

---

## Próximos Pasos

Con Maven dominado, estás listo para:

1. **Spring Core** - IoC, DI, Beans
2. **Spring Boot** - Auto-configuration
3. **REST APIs** - Controllers, mappings
4. **Bases de datos** - JPA, Hibernate
5. **Despliegue** - Docker, producción

Maven será tu compañero en todo el camino.

---

*Apuntes generados basado en el curso "Master Spring, Spring Boot, REST, JPA, Spring Security" de Eazy Bytes*