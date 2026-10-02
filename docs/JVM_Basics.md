#### `docs/JVM_Basics.md`

```markdown
# Architecture Basics: JDK, JRE, JVM & Bytecode

### JDK vs JRE vs JVM
- **JDK (Java Development Kit)**: A complete software development environment containing compilers, tools, and the JRE used to develop and execute Java applications.
- **JRE (Java Runtime Environment)**: Provides the class libraries and runtime environment needed to run Java programs, containing the JVM inside it.
- **JVM (Java Virtual Machine)**: An abstract computing machine that executes compiled Java bytecode directly on the host operating system.

### Java Bytecode & "Write Once, Run Anywhere"
Java source code (`.java`) is compiled by `javac` into intermediate machine-independent code called **Bytecode** (`.class` files). Bytecode does not execute directly on host processors. Instead, the OS-specific JVM interprets or Just-In-Time (JIT) compiles this bytecode into native machine instructions at runtime. 

Because distinct native JVM distributions exist for Linux, macOS, and Windows, the same compiled bytecode file can run unmodified on any device containing a compatible JVM runtime.