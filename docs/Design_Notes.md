# Design Notes & Architectural Decisions

### 1. Choice of Collection Framework
`ArrayList` was selected over primitive arrays because standard arrays require fixed memory allocation upon instantiation. Student and Course data within management platforms fluctuates dynamically. `ArrayList` dynamically handles resizing and simplifies operations via internal array structures.

### 2. Utilization of Static Members
Static variables and synchronized methods were utilized inside `util.IdGenerator`. This guarantees centralized, stateful ID counters across the runtime memory lifecycle without needing to pass identifier instances across service boundaries.

### 3. Application of Inheritance Principles
The structural parent class `Person` captures generic personal attributes (`id`, `firstName`, `lastName`, `email`). Extending `Person` into sub-classes (`Student`, `Trainer`) prevents redundant field definitions and enables polymorphic method invocation (`getDisplayName()`), demonstrating specialized class implementations sharing common ancestor interfaces.