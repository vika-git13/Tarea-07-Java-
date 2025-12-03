# 🏦 BankApp – Java Banking Project
---

## 🇬🇧 Description  
Educational Java project developed during the first year.  
It practices OOP, inheritance, interfaces, regular expression validation,  
and basic operations on different types of bank accounts.

## 🇪🇸 Descripción  
Proyecto educativo en Java desarrollado en el primer año.  
Practica POO, herencia, interfaces, validación con expresiones regulares  
y operaciones básicas sobre distintos tipos de cuentas bancarias.

---

## 📌 Features / Funcionalidades

- Create new bank accounts/Crear nuevas cuentas bancarias  
- Account types: Savings, Personal Checking, Business Checking/Ahorro, Corriente Personal, Corriente Empresa
- Deposit money/Ingresar dinero 
- Withdraw money/Retirar dinero 
- Check balance/Consultar saldo  
- List all accounts/Listar todas las cuentas
- Validate DNI and IBAN using regex/Validar DNI e IBAN con expresiones regulares

---

## 🧱 Project Structure / Estructura del Proyecto

```plaintext
BancoApp/
│
├── bancoapp/
│   ├── Banco.java
│   ├── Principal.java
│
├── cuentas/
│   ├── CuentaBancaria.java
│   ├── CuentaAhorro.java
│   ├── CuentaCorriente.java
│   ├── CuentaCorrientePersonal.java
│   ├── CuentaCorrienteEmpresa.java
│   ├── Imprimible.java
│
└── utils/
    └── Validar.java
```

---

## 🧩 Class Summary / Resumen de Clases

### 🇬🇧 Classes
- **Principal.java** – main menu & user interaction  
- **Banco.java** – manages accounts: add, search, delete, list  
- **CuentaBancaria.java** – base class for all accounts  
- **CuentaAhorro.java** – saving account with interest  
- **CuentaCorrientePersonal.java** – personal checking with authorized companies  
- **CuentaCorrienteEmpresa.java** – business checking with overdraft rules  
- **Imprimible.java** – interface for printing  
- **Validar.java** – regex-based DNI & IBAN validation  

### 🇪🇸 Clases
- **Principal.java** – menú principal & interacción con usuario  
- **Banco.java** – gestiona cuentas: añadir, buscar, eliminar, listar  
- **CuentaBancaria.java** – clase base para todas las cuentas  
- **CuentaAhorro.java** – cuenta de ahorro con interés  
- **CuentaCorrientePersonal.java** – cuenta personal con empresas autorizadas  
- **CuentaCorrienteEmpresa.java** – cuenta de empresa con descubierto  
- **Imprimible.java** – interfaz de impresión  
- **Validar.java** – validación de DNI e IBAN con regex  

---

## 👩‍💻 Author / Autora  
**Viktoriia Bohoslavska**  
GitHub: https://github.com/vika-git13
