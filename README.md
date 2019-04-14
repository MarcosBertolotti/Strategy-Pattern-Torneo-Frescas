# Strategy_Pattern_Torneo_Frescas

## Que es Maven? 

_**Maven** es un framework de administración de proyectos, automatiza el proceso de construcción de un proyecto Java. Provee un conjunto de estándares de construcción, un modelo de repositorio de artefactos y un motor de software que administra y describe los proyectos_

## POM que significa y para que nos sirve.

_**POM** (Project Object Model). Este es un archivo en formato XML que contiene todo lo necesario para que a la hora de generar el fichero ejecutable de nuestra aplicación este contenga todo lo que necesita para su ejecución en su interior._

## Diferencia entre Archetype y ArtifacId

_**Archetype** es un patrón o modelo sobre el que se pueden desarrollar todas aquellas tareas que son de un mismo tipo. Son plantillas, parametrizadas o configuradas para utilizar determinadas tecnologías que los desarrolladores utilizan como base para escribir y organizar el código de la aplicación._

_**ArtifactID** es un nombre para identificar los proyectos Maven, Maven creará un directorio con este nombre y el jar que genere para el proyecto tendrá también este nombre_

## Explique los siguientes goals de Maven: [clean package, install, compile].

_**Goal** representa un plugin de maven que puede ser añadido a una fase para poder especificar o extender el comportamiento de dicha fase y una fase específica que será ejecutada en la construcción de nuestro proyecto._

* _**clean**: borra cualquier archivo generado previamente, como los .class resultado de la compilación. Lo que hace es borrar la carpeta "target" de nuetro proyecto, que es a donde va a parar todo el contenido generado._

* _**compile**: Compiló al directorio target._

* _**package**: genera un paquete con el código (.jar por ejemplo)._

* _**install**: Empaqueta el proyecto y lo publica en nuestro repositorio local. Hace un copy al repo local $HOME/.m2/repository/com/blah/artifactBlah/1.0.0/artifactBlah-1.0.0,jar 
Este comando se utiliza para publicar una nueva versión del jar y así poder utilizarla desde otro proyecto, pero dentro de nuestra máquina._

## Explique los Siguientes Scopes; [compi,provide,runtime,test,system].

_**Scope** sirve para indicar el alcance de nuestra dependencia y su transitividad._

* _**compile**: es la que tenemos por defecto sino especificamos scope. Indica que la dependencia es necesaria para compilar. La dependencia además se propaga en los proyectos dependientes._

* _**provided**: Es como la anterior, pero esperas que el contenedor ya tenga esa libreria._

* _**runtime**: La dependencia es necesaria en tiempo de ejecución pero no es necesaria para compilar._

* _**test**: La dependencia es solo para testing que es una de las fases de compilación con maven. Ejemplo: JUnit._

* _**system**: Es como provided pero tienes que incluir la dependencia explicitamente. Maven no buscará este artefacto en tu repositorio local. Habrá que especificar la ruta de la dependencia mediante la etiqueta <systemPath>._

---
_**Github**:_ [MarcosBertolotti](https://github.com/MarcosBertolotti)
