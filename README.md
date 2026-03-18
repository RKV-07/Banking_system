
  #  Bank Account Management System

A beginner-friendly Java application that demonstrates core Object-Oriented Programming principles through a practical banking system implementation.

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![OOP](https://img.shields.io/badge/OOP-Encapsulation%20%7C%20Inheritance-orange.svg)
![License](https://img.shields.io/badge/license-%20%20GNU%20GPLv3%20-green?style=plastic)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen.svg)

##  Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [OOP Concepts Demonstrated](#-oop-concepts-demonstrated)
- [Project Structure](#-project-structure)
- [Installation & Setup](#-installation--setup)
- [Usage](#-usage)
- [Code Examples](#-code-examples)
- [GitHub Workflow](#-github-workflow)
- [Learning Outcomes](#-learning-outcomes)
- [Future Enhancements](#-future-enhancements)
- [Contributing](#-contributing)
- [License](#-license)

##  Overview

The Bank Account Management System is a console-based Java application that simulates real-world banking operations. This project serves as an excellent learning tool for understanding Object-Oriented Programming principles in a practical context.

**Key Highlights:**
-  Implements different bank account types
-  Demonstrates real banking operations
-  Perfect for Java beginners transitioning from Python
-  Clean, well-documented code with OOP best practices

##  Features

| Feature | Description | OOP Concept |
|---------|-------------|-------------|
| **Account Creation** | Create Savings & Current accounts | Inheritance |
| **Transactions** | Deposit, withdraw, check balance | Encapsulation |
| **Interest Calculation** | Automatic interest for savings accounts | Polymorphism |
| **Overdraft Protection** | Limit management for current accounts | Method Overriding |
| **Transaction History** | Complete audit trail | Data Hiding |
| **Account Management** | View all accounts and details | Abstraction |

##  OOP Concepts Demonstrated

###  Encapsulation
```java
public abstract class Account {
    private String accountNumber;  // Data hiding
    private double balance;        // Protected access

    // Controlled access via methods
    public double getBalance() { return balance; }
    protected void setBalance(double balance) { this.balance = balance; }
}
```

### Inheritance
```java
// Base class
public abstract class Account {
    // Common properties and methods
}

// Derived classes
public class SavingsAccount extends Account {    // IS-A relationship
    // Inherits common features + adds specific ones
}

public class CurrentAccount extends Account {    // IS-A relationship
    // Inherits common features + adds specific ones
}
```

###  Polymorphism
```java
// Method Overriding - Same method, different behavior
@Override
public void withdraw(double amount) {
    // SavingsAccount: Minimum balance check
    // CurrentAccount: Overdraft limit check
}
```

##  Project Structure

```
bank-management-system/
├──  src/
│   ├──  models/           # Core business entities
│   │   ├── Account.java          Abstract base class
│   │   ├── SavingsAccount.java   Savings account implementation
│   │   └── CurrentAccount.java   Current account implementation
│   ├──  services/         # Business logic
│   │   └── BankService.java      Main banking operations
│   └── Main.java                 Application entry point
├── README.md                    This file
└── .gitignore                 Git ignore rules
```

##  Installation & Setup

### Prerequisites
- Java JDK 8 or higher
- Git (for version control)

### Step-by-Step Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/bank-management-system.git
   cd bank-management-system
   ```

2. **Compile the Project**
   ```bash
   # Compile all Java files
   javac -d bin src/models/*.java src/services/*.java src/Main.java
   ```

3. **Run the Application**
   ```bash
   java -cp bin Main
   ```

##  Usage

### Starting the Application
```bash
 Welcome to Bank Management System!
=== Main Menu ===
1. Create Savings Account
2. Create Current Account
3. Deposit Money
4. Withdraw Money
5. Check Balance
6. View Transaction History
7. Apply Interest (Savings)
8. View All Accounts
9. Exit
Choose an option:
```

### Sample Workflow

1. **Create a Savings Account**
   ```
   Enter account number: SA001
   Enter account holder name: Alice Johnson
   Enter initial balance: 1000.0
   Enter interest rate: 2.5
   Savings account created successfully!
   ```

2. **Deposit Money**
   ```
   Enter account number: SA001
   Enter deposit amount: 500.0
   Successfully deposited $500.0
   ```

3. **Check Balance**
   ```
   === Account Information ===
   Account Number: SA001
   Account Holder: Alice Johnson
   Balance: $1500.0
   Account Type: SavingsAccount
   Interest Rate: 2.5%
   Minimum Balance: $100.0
   ```

##  Code Examples

### Core OOP Implementation

**Abstract Base Class (Encapsulation)**
```java
public abstract class Account {
    private String accountNumber;  // Encapsulated data
    private double balance;

    // Public interface for controlled access
    public final String getAccountNumber() { return accountNumber; }
    public final double getBalance() { return balance; }

    // Template method pattern
    public abstract void withdraw(double amount);
}
```

**Inheritance in Action**
```java
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holder,
                         double balance, double rate) {
        // Constructor chaining
        super(accountNumber, holder, balance);
        this.interestRate = rate;
    }

    @Override
    public void withdraw(double amount) {
        // Polymorphic behavior
        if (getBalance() - amount >= 100.0) {  // Minimum balance check
            setBalance(getBalance() - amount);
        }
    }
}
```

##  GitHub Workflow

### Initial Setup
```bash
# Initialize Git repository
git init

# Add all project files
git add .

# Make initial commit
git commit -m "feat: initial commit - Bank Management System with OOP principles

- Implement Account base class with encapsulation
- Create SavingsAccount and CurrentAccount with inheritance
- Add BankService for account management
- Demonstrate polymorphism through method overriding"

# Connect to GitHub and push
git remote add origin https://github.com/yourusername/bank-management-system.git
git branch -M main
git push -u origin main
```

### Feature Development Workflow
```bash
# Create feature branch
git checkout -b feature/transaction-fees

# Make changes and commit
git add .
git commit -m "feat: add transaction fee system

- Implement fee calculation in Account class
- Add fee exemption for premium accounts
- Update transaction history to show fees"

# Push feature branch
git push origin feature/transaction-fees
```

##  Learning Outcomes

###  Technical Skills Gained
- **Java Fundamentals**: Classes, objects, methods, constructors
- **OOP Principles**: Encapsulation, Inheritance, Polymorphism, Abstraction
- **Package Management**: Organized code structure
- **Error Handling**: Basic input validation
- **Console I/O**: User interaction handling

###  Software Engineering Practices
- **Code Organization**: Proper package structure
- **Documentation**: Clear comments and README
- **Version Control**: Git workflow and commit messages
- **Project Structure**: Separation of concerns

###  Real-World Application
- **Banking Concepts**: Account types, transactions, interest
- **Data Protection**: Encapsulation for security
- **Business Rules**: Minimum balance, overdraft limits
- **Audit Trail**: Transaction history tracking

##  Future Enhancements

| Enhancement | Description | Skills Practiced |
|-------------|-------------|------------------|
| **Database Integration** | Persist accounts using JDBC | Database connectivity |
| **GUI Implementation** | Swing or JavaFX interface | GUI programming |
| **Web Services** | REST API for banking operations | Spring Boot, Web services |
| **Authentication** | User login and security | Security principles |
| **Reporting** | Generate account statements | File I/O, PDF generation |
| **Multi-currency** | Support different currencies | Internationalization |

##  Contributing

Contributions are welcome! Here's how you can help:

1. **Fork the repository**
2. **Create a feature branch** (`git checkout -b feature/amazing-feature`)
3. **Commit your changes** (`git commit -m 'Add some amazing feature'`)
4. **Push to the branch** (`git push origin feature/amazing-feature`)
5. **Open a Pull Request**

### Suggested Improvements
- Add unit tests with JUnit
- Implement exception handling
- Add more account types
- Create a web interface

##  License

This project is licensed under the  GNU GENERAL PUBLIC LICENSE - see the [LICENSE](LICENSE) file for details.

##  Acknowledgments

- Inspired by real-world banking systems
- Perfect for beginners transitioning from Python to Java
- Thanks to the Java community for excellent documentation
- Built while learning OOP principles practically

---

<div align="center">

### ⭐ **If you find this project helpful, don't forget to give it a star!**

*"The best way to learn programming is by building projects that solve real problems."*

</div>

---



```
