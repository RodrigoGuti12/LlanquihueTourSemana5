# Sistema Llanquihue Tour - PRY2202 Semana 5

## Autor del proyecto

Nombre completo: Rodrigo Fabián Gutiérrez Espinoza  
Sección: PRY2202 DESARROLLO ORIENTADO A OBJETOS I_004A  
Carrera: Analista Programador Computacional     
Sede: Online

---

## Descripción general del sistema

Este proyecto corresponde a la Actividad Sumativa 2 de la asignatura Desarrollo Orientado a Objetos I. Se trata de un sistema orientado a objetos desarrollado en Java, cuyo objetivo es modelar y gestionar los colaboradores de la agencia de turismo Llanquihue Tour, ubicada en la Region de Los Lagos.

El sistema permite leer datos de colaboradores desde un archivo CSV externo, cargarlos en una colección ArrayList y realizar operaciones de búsqueda, filtrado y visualización por consola. El proyecto aplica los principios de encapsulamiento, composición y herencia, organizado en paquetes funcionales con responsabilidades claramente separadas.

---

## Estructura general del proyecto

```
LlanquihueTour/
└── src/
    ├── app/
    │   └── Main.java             - Punto de entrada del programa
    ├── model/
    │   ├── Direccion.java        - Clase de composicion
    │   ├── Colaborador.java      - Clase base general (superclase)
    │   ├── GuiaTuristico.java    - Clase hija (hereda de Colaborador)
    │   └── OperadorLocal.java    - Clase hija (hereda de Colaborador)
    ├── service/
    │   └── GestorColaboradores.java - Clase gestora de la coleccion
    ├── util/
    │   └── LectorArchivo.java    - Clase utilitaria de lectura de archivos
    └── resources/
        └── colaboradores.csv     - Archivo de datos externos
```

---

## Clases implementadas

### model/Direccion.java
Clase de composicion que representa la ubicacion fisica de un colaborador.
Atributos: calle, numero, comuna, region.

### model/Colaborador.java
Clase base general que centraliza los datos comunes de cualquier colaborador de la agencia.
Atributos: rut, nombre, telefono, tipo, activo, direccion.
Relacion: clase padre de GuiaTuristico y OperadorLocal.

### model/GuiaTuristico.java
Clase hija que representa a un guia turistico de la agencia.
Hereda de: Colaborador.
Atributos propios: especialidad, aniosExperiencia.

### model/OperadorLocal.java
Clase hija que representa a un operador local de servicios.
Hereda de: Colaborador.
Atributos propios: servicio, rubro.

### service/GestorColaboradores.java
Clase gestora que administra el ArrayList de colaboradores.
Permite cargar, mostrar, buscar y filtrar colaboradores.

### util/LectorArchivo.java
Clase utilitaria que lee archivos CSV y retorna los datos separados por punto y coma.

---

## Instrucciones para clonar y ejecutar el proyecto

Clona el repositorio desde GitHub:

```
git clone https://github.com/usuario/repositorio.git
```

Abre el proyecto en IntelliJ IDEA.

Marca la carpeta src como Sources Root: clic derecho sobre src, Mark Directory As, Sources Root.

Verifica que el archivo colaboradores.csv este correctamente ubicado en la carpeta resources dentro de src.

Configura el Working Directory: ve a Run, Edit Configurations, agrega una nueva Application, en el campo Main class escribe app.Main y verifica que el Working Directory apunte a la carpeta raiz del proyecto LlanquihueTour.

Ejecuta el archivo Main.java desde el paquete app.

En el menu de consola, selecciona primero la opcion 1 para cargar los colaboradores desde el archivo.

---

## Menu del sistema

```
1. Cargar colaboradores desde archivo
2. Mostrar todos los colaboradores
3. Mostrar colaboradores activos
4. Buscar colaborador por nombre
5. Filtrar colaboradores por comuna
6. Filtrar colaboradores por tipo
7. Salir
```

---

Repositorio GitHub: https://github.com/RodrigoGuti12/LlanquihueTourSemana5  
Fecha de entrega: 22/06/2026

Duoc UC | Escuela de Informatica y Telecomunicaciones | PRY2202 Desarrollo Orientado a Objetos I
