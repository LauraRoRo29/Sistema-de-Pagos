# Sistema de Procesamiento de Pagos

## Participantes
- Manuel Rodríguez - Interfaz Refundable y excepciones personalizadas (InsufficientFundsException, InvalidPaymentException)
- Laura Rojas - Clase abstracta Payment y CreditCardPayment
- Efraín Sagols - PayPalPayment y BankTransferPayment
- Gonzalo Vargas - PaymentManager, PaymentsApp y pruebas de integración

## Descripción del Proyecto
Este proyecto es una aplicación desarrollada en Java que simula un sistema de procesamiento de pagos para una tienda en línea. El objetivo principal es aplicar los conceptos de la Programación Orientada a Objetos (POO), incluyendo encapsulamiento, abstracción, herencia, polimorfismo, interfaces, colecciones y manejo de excepciones personalizadas para controlar la lógica de negocio.

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


