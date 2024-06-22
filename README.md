# Just-Do-It

Just-Do-It is a task management application designed to help you organize and manage your tasks efficiently. This application leverages fundamental data structures to provide a robust and scalable task management system.

## Table of Contents

- [Features](#features)
  - [Efficient Task Management](#efficient-task-management)
  - [User Interface](#user-interface)
  - [Robustness and Flexibility](#robustness-and-flexibility)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Data Structures Used](#data-structures-used)
  - [LinkedList for Task Management](#linkedlist-for-task-management)
  - [Queue for Completed Tasks](#queue-for-completed-tasks)
  - [Stack for Urgent Tasks](#stack-for-urgent-tasks)
  - [Node as a Building Block](#node-as-a-building-block)
- [Contributing](#contributing)
- [License](#license)

## Features

- **Add Task**: Users can add new tasks to the task list. Tasks can be normal or urgent, with urgent tasks being added to the stack for immediate attention.
- **View Tasks**: Users can view all current tasks, including normal tasks in the linked list and urgent tasks in the stack.
- **Complete Task**: Users can mark tasks as completed, which moves them from the linked list or stack to the queue of completed tasks.
- **Delete Task**: Users can delete tasks from the task list, removing them from the linked list or stack.
- **View Completed Tasks**: Users can view the list of completed tasks in the order they were completed, maintained in the queue.
- **Search Task**: Users can search for tasks within the task list to quickly locate and manage them.
- **Task Prioritization**: The system allows for prioritization of tasks, ensuring urgent tasks are handled promptly while normal tasks are managed systematically.

### Efficient Task Management

- **Memory Management**: By using linked lists, the application optimizes memory usage, as tasks are dynamically allocated and deallocated.
- **Scalability**: The data structures employed ensure that the application can scale efficiently, handling a growing number of tasks without performance degradation.

### User Interface

- **Interactive CLI**: The application provides an interactive Command Line Interface (CLI) for users to manage their tasks, view task lists, and perform other task management operations with ease.

### Robustness and Flexibility

- **Data Integrity**: The use of well-defined data structures ensures the integrity and consistency of task data.
- **Modular Design**: The application’s modular design allows for easy updates and enhancements, providing flexibility for future feature additions.

## Prerequisites

- Java 8 or higher
- Gradle 6.0 or higher

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/just-do-it.git
   cd just-do-it
   ```

2. Ensure you have Gradle installed. If not, you can use the Gradle wrapper included in the project.

3. Build the project using Gradle:

   ```bash
   ./gradlew build
   ```

## Usage

### Linux run

```bash
gradle build

./gradlew run --console=plain
```

### Windows run

```bash
gradle build

./gradlew.bat run --console=plain
```

## Data Structures Used

### LinkedList for Task Management

- **Task Storage**: The application uses a linked list to store and manage all tasks. Each task is represented as a node in the linked list, ensuring efficient addition, deletion, and traversal of tasks.
- **Dynamic Task Management**: Linked lists allow for dynamic memory allocation, meaning the application can handle an arbitrary number of tasks without a predefined limit.

### Queue for Completed Tasks

- **Task Completion Tracking**: When a task is marked as completed, it is moved to a queue. This utilizes the First In, First Out (FIFO) principle, ensuring that tasks are completed and reviewed in the order they were finished.
- **Task History**: The queue provides a historical log of completed tasks, allowing users to track their progress over time.

### Stack for Urgent Tasks

- **Priority Task Handling**: Urgent tasks are added to a stack, leveraging the Last In, First Out (LIFO) principle. This ensures that the most recently added urgent task is addressed first.
- **Efficient Urgent Task Management**: By using a stack, the application allows users to quickly add and access urgent tasks, ensuring they are handled promptly.

### Node as a Building Block

- **Data Structure Foundation**: The node is the fundamental building block for the linked list, queue, and stack used in the application. Each node typically contains data (such as task details) and a reference to the next node (or previous, in some cases).
- **Versatile and Efficient**: Nodes provide a versatile and efficient way to structure and manage tasks within the various data structures employed by the application.

## Contributing

We welcome contributions to improve Just-Do-It. Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (git checkout -b feature-branch).
3. Commit your changes (git commit -m 'Add some feature').
4. Push to the branch (git push origin feature-branch).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Additional Information

- **Author**: Yousinator

If you have any questions or need further assistance, feel free to reach out.

Enjoy managing your tasks with Just-Do-It!
