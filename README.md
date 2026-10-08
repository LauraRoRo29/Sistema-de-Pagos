<div align="center">

# Sistema de Procesamiento de Pagos

**Una solución en Java 21 orientada a objetos para la gestión de transacciones electrónicas.**

![Proyecto](https://img.shields.io/badge/Proyecto-POO_Java_21-orange?style=for-the-badge)
![Estado](https://img.shields.io/badge/Estado-Completado-brightgreen?style=for-the-badge)



---
</div>

## Participantes

| Integrante | Rol / Módulos Asignados | Componentes Desarrollados |
| :--- | :--- | :--- |
| **Manuel Rodríguez** | Interfaz y Excepciones Personalizadas | `Refundable`, `InsufficientFundsException`, `InvalidPaymentException` |
| **Laura Rojas** | Clase Abstracta y Tarjetas | `Payment`, `CreditCardPayment` |
| **Efraín Sagols** | Métodos de Pago Digitales y Bancarios | `PayPalPayment`, `BankTransferPayment` |
| **Gonzalo Vargas** | Gestión, Ejecución y Pruebas | `PaymentManager`, `PaymentsApp` |

## Descripción del Proyecto
Este proyecto es una aplicación desarrollada en Java que simula un sistema de procesamiento de pagos para una tienda en línea. El objetivo principal es aplicar los conceptos de la Programación Orientada a Objetos (POO), incluyendo encapsulamiento, abstracción, herencia, polimorfismo, interfaces, colecciones y manejo de excepciones personalizadas para controlar la lógica de negocio.

> La arquitectura del sistema permite extender nuevos métodos de pago sin modificar la lógica existente del gestor de pagos (`PaymentManager`), cumpliendo con los principios de diseño orientado a objetos.

## Estructura del Proyecto
```text
src/
└── com/
    └── payments/
        ├── entities/
        │   ├── Payment.java
        │   ├── CreditCardPayment.java
        │   ├── PayPalPayment.java
        │   ├── BankTransferPayment.java
        │   └── PaymentManager.java
        ├── interfaces/
        │   └── Refundable.java
        ├── exceptions/
        │   ├── InsufficientFundsException.java
        │   └── InvalidPaymentException.java
        └── PaymentsApp.java

```
## Tecnologías Utilizadas

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05033?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-121011?style=for-the-badge&logo=github&logoColor=white)

- Lenguaje: Java (JDK 21)
- IDE: IntelliJ IDEA
- Control de Versiones: Git y GitHub

## Conceptos de POO Aplicados

1. Abstracción: La clase abstracta Payment establece la estructura y los comportamientos comunes que deben cumplir todos los métodos de pago.
2. Herencia: Las clases CreditCardPayment, PayPalPayment y BankTransferPayment heredan de la clase base Payment.
3. Polimorfismo: La clase PaymentManager administra una lista de tipo List<Payment>, lo que permite gestionar cualquier método de pago sin depender de sus clases concretas.
4. Interfaces: La interfaz Refundable define la capacidad de realizar reembolsos únicamente en los métodos de pago que la implementan (Tarjeta de Crédito y PayPal).
5. Manejo de Excepciones: Creación de Checked Exceptions personalizadas (InsufficientFundsException e InvalidPaymentException) para capturar errores de saldo o datos inválidos sin detener la ejecución del programa.
6. Colecciones: Uso de ArrayList para almacenar y manipular el registro histórico de pagos.

## Casos de Prueba Demostrados
En la clase principal PaymentsApp se ejecutan los siguientes escenarios:

- Caso 1: Procesamiento exitoso de un pago con Tarjeta de Crédito.
- Caso 2: Manejo de la excepción InsufficientFundsException al intentar procesar un pago con saldo insuficiente en PayPal.
- Caso 3: Procesamiento exitoso de un pago mediante Transferencia Bancaria.
- Caso 4: Demostración de polimorfismo al listar todos los pagos registrados a través de PaymentManager.
- Caso 5: Búsqueda de transacciones por su ID (existentes y no existentes).
- Caso 6: Ejecución de un reembolso utilizando una referencia de la interfaz Refundable.

## Requisitos de Ejecución
- Java Development Kit (JDK 21) instalado.
- IDE compatible con Java (IntelliJ IDEA recomendado) o terminal con comandos javac y java.

## Instrucciones de Ejecución

### Desde IntelliJ IDEA
1. Clonar el repositorio o descargar el código fuente.
2. Abrir la carpeta del proyecto en IntelliJ IDEA.
3. Asegurarse de que la carpeta src esté configurada como Sources Root y el SDK del proyecto apunte a JDK 21.
4. Navegar hasta src/com/payments/PaymentsApp.java.
5. Ejecutar la clase haciendo clic secundario y seleccionando Run 'PaymentsApp.main()'.

### Desde la Terminal
1. Clonar el repositorio:
   git clone <URL_DEL_REPOSITORIO>
2. Acceder al directorio del proyecto:
   cd <NOMBRE_DEL_PROYECTO>
3. Compilar los archivos fuente:
   javac -d bin src/com/payments/exceptions/*.java src/com/payments/interfaces/*.java src/com/payments/entities/*.java src/com/payments/PaymentsApp.java
4. Ejecutar la aplicación:
   java -cp bin com.payments.PaymentsApp

## Flujo de Trabajo en Git
El proyecto se desarrolló utilizando una estrategia de ramificación individual por integrante integrada hacia una rama principal de desarrollo:

- main: Contiene únicamente versiones probadas y totalmente funcionales del código.
- develop: Rama intermedia donde se integraron los Pull Requests del equipo.
- manuel: Rama individual utilizada por Manuel Rodríguez para desarrollar la interfaz Refundable y las excepciones personalizadas.
- laura: Rama individual utilizada por Laura Rojas para desarrollar las clases Payment y CreditCardPayment.
- efrain: Rama individual utilizada por Efraín Sagols para desarrollar las clases PayPalPayment y BankTransferPayment.
- gonzalo: Rama individual utilizada por Gonzalo Vargas para desarrollar PaymentManager, PaymentsApp y las pruebas de integración.


