# Onceava práctica - Balanceador de carga

![PUCMMM-logo](https://i.imgur.com/9eEIci9.png)

Onceava práctica realizada para la asignatura **Programación Web Avanzada (ISC-517)** perteneciente a la carrera **Ingeniería de Sistemas y Computación** de la **Pontificia Universidad Católica Madre y Maestra (PUCMM)** en el ciclo **Agosto-Diciembre 2018**.

## Realizado por

**JEAN LOUIS TEJEDA GARCÍA** -  MAT. 2013-1459

**OSCAR DIONISIO NÚÑEZ SIRI** -  MAT. 2014-0056

**CESAR JOSÉ PEÑA MARTE** - MAT. 2013-0488

## Objetivo general

Seguir la práctica #10 en Spring Boot, implementando en esta un balanceador de carga que distribuya las sesiones entre diferentes instancias, esto se tiene que hostear en un servidor en la nube. Las tareas requeridas pueden ser vistas en [Tareas requeridas](#tareas-requeridas).

## Vídeo de demostración del proyecto

Todavía no realizado.

## Tecnologías requeridas

- **Se puede elegir entre estas opciones:**
  - Hazelcast
  - Memcached
  - Redis
  - Apache Ignite
- Digital Ocean (o cualquier otro servidor en la nube).
- Let's Encrypt
- HAProxy

## Otras tecnologías utilizadas

- HTML5
- CSS
- BootStrap 4
- Java
- SpringBoot
- Spring Security
- i18n
- ORM
- JavaScript
- Font Awesome 5
- H2
- ChartJS

## Modelo de datos
Este proyecto no requiere de un modelo de datos, ya que ya se realizó en la [Práctica #10 (click aquí)](https://github.com/Jeanlo/practica10-springboot-electronica-oscar-jean-cesar). En sí este modelo de datos utilizado es para una tienda de alquileres que consta de:
- Usuarios / Roles
- Clientes
- Equipos / Familia de Equipos 
- Alquileres

## Tareas requeridas

- Ejecutar como mínimo un clúster de tres instancias de la aplicación corriendo en diferentes puertos.
  - Para acceder a las instancias se necesita un balanceador de carga.
- Usar el método de Round Robin para distribuir la carga entre las tres instancias.
- Usar máquina virtual en la nube.
  - Esta máquina necesita tener un certificado SSL vía Let's Encrypt.
