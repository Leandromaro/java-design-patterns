# Java Design Patterns

Some of the benefits of using design patterns are:

1. Design Patterns are already defined and provides industry standard approach to solve a recurring problem.
2. Using design patterns promotes reusability that leads to more robust and highly maintainable code.
3. Since design patterns are already defined, it makes our code easy to understand and debug. It leads to faster development and new members of team understand it easily.

## Table of Contents
  - [Creational Design Patterns](#creational)
    - [Singleton](#singleton)
    - [Factory](#factory-pattern)
    - [Abstract Factory Pattern](#abstract-factory-pattern)
    - [Builder](#builder)
    - [Prototype](#prototype)
  - [Structural Design Patterns](#Structural-Design-Patterns)
    - [Adapter](#adapter-pattern)
    - [Composite](#composite)
    - [Flyweight](#flyweight-pattern)
    - [Facade](#facade)
    - [Bridge](#bridge)
    - [Proxy](#proxy)
    - [Decorator](#decorator)
  - [Behavioral patterns](#Behavioral-patterns) 
    - [Template Method](#template-pattern)
    - [Mediator](#mediator-pattern)
    - [Chain of Responsibility](#chain-of-responsibility-pattern)
    - [Observer](#observer)
    - [Strategy](#strategy)
    - [Comand](#comand)
    - [State](#state)
    - [Visitor](#visitor)
    - [Interpreter](#interpreter)
    - [Iterator](#iterator)
    - [Memento](#memento)


# Creational Design Patterns

Creational design patterns provide solution to __instantiate__ a object in the best possible way for specific situations

## Singleton
__Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine__. It seems to be a very simple design pattern but when it comes to implementation, it comes with a lot of implementation concerns. The implementation of Singleton pattern has always been a controversial topic among developers and it's also considered as an anti-pattern.

#### To implement a Singleton pattern, we have different approaches but all of them have the following common concepts.
  - Private constructor to restrict instantiation of the class from other classes.
  - Private static variable of the same class that is the only instance of the class.
  - Public static method that returns the instance of the class, this is the global access point for outer world to get the     instance of the singleton class.

## Factory Pattern
Factory design pattern __is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class__. This pattern take out the responsibility of instantiation of a class from client program to the factory class. We can apply Singleton pattern on Factory class or make the factory method static.

### Factory Design Pattern Advantages

  - Factory design pattern provides approach to code for interface rather than implementation.
  - Factory pattern removes the instantiation of actual implementation classes from client code. Factory pattern makes our    code more robust, less coupled and easy to extend. 
  - Factory pattern provides abstraction between implementation and client classes through inheritance.

### Factory Design Pattern Examples in JDK

java.util.Calendar, ResourceBundle and NumberFormat getInstance() methods uses Factory pattern.
valueOf() method in wrapper classes like Boolean, Integer etc.

## Abstract Factory Pattern
Abstract Factory pattern is similar to Factory pattern and it’s factory of factories. This model allows us to create objects that follow a general pattern.

### When to Use Abstract Factory Pattern:

 - The client is independent of how we create and compose the objects in the system
 - The system consists of multiple families of objects, and these families are designed to be used together
 - We need a run-time value to construct a particular dependency

## Builder
Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object. It allows us to write readable, understandable code to set up complex objects.

*The Builder pattern is a good choice when designing classes whose constructors or static factories would have more than a handful of parameters, especially if many of the parameter are optional or of identical type* [Joshua Bloch](https://github.com/jbloch).

## Prototype
Prototype pattern is used when the Object creation is a costly affair and requires a lot of time and resources and you have a similar object already existing. __So this pattern provides a mechanism to copy the original object to a new object and then modify it according to our needs__. This pattern uses __java cloning__ to copy the object.

### When to Use Prototype Design Pattern

It would be easy to understand prototype design pattern with an example. Suppose we have an Object that loads data from database. Now we need to modify this data in our program multiple times, __so it’s not a good idea to create the Object using new keyword__ and load all the data again from database.__The better approach would be to clone the existing object into a new object and then do the data manipulation__.
Prototype design pattern mandates that the Object which you are copying should provide the copying feature. It should not be done by any other class. However whether to use shallow or deep copy of the Object properties depends on the requirements and its a design decision.

# Structural Design Patterns

Structural patterns provide different ways to create a class structure, for example using inheritance and composition to create a large object from small objects.

## Adapter Pattern

Adapter design pattern is one of the structural design pattern and __it’s used so that two unrelated interfaces can work together__. It translate the interface of one class into another interface. This means that we can make classes work together that couldn't otherwise because of incompatible interfaces. The object that joins these unrelated interface is called an __Adapter__. As a real life example, we can think of a mobile charger as an adapter because mobile battery needs 3 volts to charge but the normal socket produces either 120V (US) or 240V (India). So the mobile charger works as an adapter between mobile charging socket and the wall socket.

### Two Way Adapter Pattern
While implementing Adapter pattern, there are two approaches (class adapter and object adapter) __however both these approaches produce same result.__
 - Class Adapter – This form uses java inheritance and extends the source interface, in our case Socket class.
 - Object Adapter – This form uses Java Composition and adapter contains the source object.

### Where to use
  - When you want to use an existing class, and its interface does not match the one you need.
  - When you want to create a reusable class that cooperates with unrelated or unforeseen classes, that is, classes that don't necessarily have compatible interfaces.
  - When you want to increase transparency of classes. •When you want to make a pluggable kit.
  
### Usage example
The Java API uses the Adapter pattern, WindowAdapter, ComponentAdapter, ContainerAdapter, FocusAdapter, KeyAdapter, MouseAdapter, MouseMotionAdapter.

## Composite
The Composite pattern helps you to create tree structures of objects without the need to force clients to differentiate between branches and leaves regarding usage.
Composite design patten allows you to have a tree structure and ask each node in the tree structure to perform a task. You can take real life example of a organization. It have general managers and under general managers, there can be managers and  under managers there can be developers.

As described by Gof:

> Compose objects into tree structure to represent part-whole hierarchies. __Composite lets client treat individual objects and compositions of objects uniformly__.

### Where to use
Use the Composite pattern when

 - When you want to represent part-whole hierarchies of objects
 - When you want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly.
 
## Flyweight Pattern
This pattern is used to reduce the memory footprint. It can also improve performance in applications where object instantiation is expensive.

Simply put, the flyweight pattern is based on a factory which recycles created objects by storing them after creation. Each time an object is requested, the factory looks up the object in order to check if it’s already been created. If it has, the existing object is returned – otherwise, a new one is created, stored and then returned.

The flyweight object’s state is made up of an invariant component shared with other similar objects (intrinsic) and a variant component which can be manipulated by the client code (extrinsic).

### When to use
  - The number of Objects to be created by application should be huge.
  - The object creation is heavy on memory and it can be time consuming too.
  - The object properties can be divided into intrinsic and extrinsic properties, extrinsic properties of an Object should be defined by the client program.

__It’s very important that the flyweight objects are immutable: any operation on the state must be performed by the factory.__


## Facade
According to GoF Facade design pattern is:

> Provide a unified interface to a set of interfaces in a subsystem. Facade Pattern defines a higher-level interface that makes the subsystem easier to use.

__A facade encapsulates a complex subsystem behind a simple interface__. It hides much of the complexity and makes the subsystem easy to use.

Also, if we need to use the complex subsystem directly, we still can do that; we aren’t forced to use the facade all the time.

Besides a much simpler interface, there’s one more benefit of using this design pattern. __It decouples a client implementation from the complex subsystem__. Thanks to this, we can make changes to the existing subsystem and don’t affect a client.

### Where to use
 - Facade design pattern is more like a helper for client applications, it doesn’t hide subsystem interfaces from the client. Whether to use Facade or not is completely dependent on client code.
 - Facade design pattern can be applied at any point of development, usually when the number of interfaces grow and system gets complex.
 - Subsystem interfaces are not aware of Facade and they shouldn’t have any reference of the Facade interface.
 - Facade design pattern should be applied for similar kind of interfaces, its purpose is to provide a single interface rather than multiple interfaces that does the similar kind of jobs.
 - We can use Factory pattern with Facade to provide better interface to client systems.

## Bridge
Bridge design pattern is used to decouple the interfaces from implementation and hiding the implementation details from the client programs.

According to GoF bridge design pattern is:

> Decouple an abstraction from its implementation so that the two can vary independently

When there are inheritance hierarchies in both interface and implementation then you loose coupling because of interdependence. In other words, Decoupling interface from implementation and hiding implementation detail of abstraction from client is main objectives of bridge design pattern.

The implementation of bridge design pattern follows the notion to prefer Composition over inheritance.

### Where to use
 - Bridge design pattern can be used when both abstraction and implementation can have different hierarchies independently and we want to hide the implementation from the client application.
 - Abstraction and implementation should be bound at compile time.
 - Both abstraction and implementation can have different hierarchies independently. You want to extend both hierarchies by subclassing.
 - Changes in implementation should have no impact on abstraction.
 - If you want to hide implementation of abstraction from client.
 - Best use when you have multiple implementation.
 
> At first sight, the Bridge pattern looks a lot like the Adapter pattern in that a class is used to convert one kind of interface to another. However, the intent of the Adapter pattern is to make one or more classes' interfaces look the same as that of a particular class. The Bridge pattern is designed to separate a class's interface from its implementation so you can vary or replace the implementation without changing the client code.

## Proxy
According to GoF Proxy design pattern is:

>Provide a surrogate or placeholder for another object to control access to it. 

The definition itself is very clear and proxy pattern is used when we want to provide controlled access of a functionality.

### Where to use
Proxy design pattern common uses are to control access or to provide a wrapper implementation for better performance.
Java RMI package uses proxy pattern. That’s all for proxy design pattern in java.

## Decorator
Decorator design pattern is used to modify the functionality of an object at runtime. At the same time other instances of the same class will not be affected by this, so individual object gets the modified behavior. 
We use inheritance or composition to extend the behavior of an object but this is done at compile time and it’s applicable to all the instances of the class. We can’t add any new functionality of remove any existing behavior at runtime – this is when Decorator pattern comes into picture

### Where to use
 - Decorator design pattern is helpful in providing runtime modification abilities and hence more flexible. Its easy to maintain and extend when the number of choices are more.
 - The disadvantage of decorator design pattern is that it uses a lot of similar kind of objects (decorators).
 - Decorator pattern is used a lot in Java IO classes, such as FileReader, BufferedReader etc.
 
 ## Behavioral patterns 
Behavioral patterns provide solution for the better interaction between objects and how to provide lose coupling and flexibility to extend easily


## Template Pattern
Template method defines the steps to execute an algorithm and it can provide default implementation that might be common for all or some of the subclasses.

### Intent

- Define the skeleton of an algorithm in an operation, deferring some steps to subclasses.
- Template Method lets subclasses redefine certain steps of an algorithm without letting them to change the algorithm's structure.

## Mediator Pattern
According to GoF Mediator design pattern is:

> Allows loose coupling by encapsulating the way disparate sets of objects interact and communicate with each other. Allows for the actions of each object set to vary independently of one another.

Mediator design pattern is very helpful in an enterprise application where multiple objects are interacting with each other. If the objects interact with each other directly, the system components are tightly-coupled with each other that makes higher maintainability cost and not hard to extend. Mediator pattern focuses on provide a mediator between objects for communication and help in implementing lose-coupling between objects.

### Mediator in the Real World 
An airport control tower is an excellent example of the mediator pattern. The tower looks after who can take off and land - all communications are done from the airplane to control tower, rather than having plane-to-plane communication. This idea of a central controller is one of the key aspects to the mediator pattern.

### Where to use
The mediator is a good choice of pattern when the communication between objects is complicated, but well defined. When there are too many relationships between the objects in your code, it's time to think of having such a central point of control.

An observer based variation of the mediator pattern is used in Java Message Service (JMS) implementations, which allows applications to subscribe and publish data to other applications. This is a common combination of patterns that makes sense.

## Chain of Responsibility Pattern

Chain of responsibility pattern is used to achieve lose coupling in software design where a request from client is passed to a chain of objects to process them. Then the object in the chain will decide themselves who will be processing the request and whether the request is required to be sent to the next object in the chain or not.

### Example in JDK

We know that we can have multiple catch blocks in a try-catch block code. Here every catch block is kind of a processor to process that particular exception. So when any exception occurs in the try block, it’s sent to the first catch block to process. If the catch block is not able to process it, it forwards the request to next object in chain i.e next catch block. If even the last catch block is not able to process it, the exception is thrown outside of the chain to the calling program.

### Chain of Responsibility Design Pattern Important Points

 - Client doesn’t know which part of the chain will be processing the request and it will send the request to the first object in the chain.
 - Each object in the chain will have it’s own implementation to process the request, either full or partial or to send it to the next object in the chain.
 - Every object in the chain should have reference to the next object in chain to forward the request to, __its achieved by java composition__.
 - Creating the chain carefully is very important otherwise there might be a case that the request will never be forwarded to a particular processor or there are no objects in the chain who are able to handle the request. 
 - Chain of Responsibility design pattern is good to achieve lose coupling but it comes with the trade-off of having a lot of implementation classes and maintenance problems if most of the code is common in all the implementations.

## Observer
According to GoF Observer design pattern is:

>Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically

Observer design pattern is useful when you are interested in the state of an object and want to get notified whenever there is any change. In observer pattern, the object that watch on the state of another object are called __Observer__ and the object that is being watched is called __Subject__.

__Subject__ contains a list of observers to notify of any change in it’s state, so it should provide methods using which observers can register and unregister themselves. Subject also contain a method to notify all the observers of any change and either it can send the update while notifying the observer or it can provide another method to get the update.

__Observer__ should have a method to set the object to watch and another method that will be used by Subject to notify them of any updates.

Java provides inbuilt platform for implementing Observer pattern through __java.util.Observable__ class and __java.util.Observer__ interface. However it’s not widely used because the implementation is really simple and most of the times we don’t want to end up extending a class just for implementing Observer pattern as java doesn’t provide multiple inheritance in classes.

## Strategy

Strategy pattern is used when we have multiple algorithm for a specific task and client decides the actual implementation to be used __at runtime__.

Strategy pattern is also known as Policy Pattern. We defines multiple algorithms and __let client application pass the algorithm to be used as a parameter__.

### Intent

Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it

### Strategy Design Pattern Important Points

 - We could have used composition to create instance variable for strategies but we should avoid that as we want the specific strategy to be applied for a particular task. Same is followed in Collections.sort() and Arrays.sort() method that take comparator as argument.
 - Strategy Pattern is very similar to State Pattern. One of the difference is that Context contains state as instance variable and there can be multiple tasks whose implementation can be dependent on the state whereas in strategy pattern strategy is passed as argument to the method and context object doesn’t have any variable to store it.
 - Strategy pattern is useful when we have multiple algorithms for specific task and we want our application to be flexible to chose any of the algorithm at runtime for specific task.
 
## Comand

According to GoF Comand design pattern is:

>Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations

The Command pattern __is used to create objects that represents actions and events in an application__. A command object encapsulates an action or event and contains all information required to understand exactly what has happened. By passing the command object as a parameter we can, anywhere needed extract information about occurred actions and events.

Today's pattern is the Command, which allows the requester of a particular action to be decoupled from the object that performs the action. Where the [Chain of Responsibility pattern](#chain-of-responsibility-pattern) forwarded requests along a chain, the Command pattern forwards the request to a specific module.

### Command in the Real World 
One example of the command pattern being executed in the real world is the idea of a table order at a restaurant: the waiter takes the order, which is a command from the customer.This order is then queued for the kitchen staff.  The waiter tells the chef that the a new order has come in, and the chef has enough information to cook the meal.

### Command Pattern Important Points

 - Command is the core of command design pattern that defines the contract for implementation.
 - Receiver implementation is separate from command implementation.
 - Command implementation classes chose the method to invoke on receiver object, for every method in receiver there will be a command implementation. It works as a bridge between receiver and action methods.
 - Invoker class just forward the request from client to the command object.
 - Client is responsible to instantiate appropriate command and receiver implementation and then associate them together.
 - Client is also responsible for instantiating invoker object and associating command object with it and execute the action method.
 - Command design pattern is easily extendible, we can add new action methods in receivers and create new Command implementations without changing the client code.
 - The drawback with Command design pattern is that the code gets huge and confusing with high number of action methods and because of so many associations.
 
## State

### Definition
The State pattern __allows an object to alter its behavior when its internal state changes__. By using inheritance and letting subclasses represent different states and functionality we can switch during runtime. This is a clean way for an object to partially change its type at runtime.

### Intent
- Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
- An object-oriented state machine
- wrapper + polymorphic wrappee + collaboration

### Where to use
- When we need to define a "context" class to present a single interface to the outside world. By defining a State abstract base class.
- When we want to represent different "states" of a state machine as derived classes of the State base class.
### Benefits
- Cleaner code when each state is a class instead. •Use a class to represent a state, not a constant.


## Visitor

Visitor's primary purpose is to abstract functionality that can be applied to an aggregate hierarchy of "element" objects. The approach encourages designing lightweight Element classes __- because processing functionality is removed from their list of responsibilities__. New functionality can easily be added to the original inheritance hierarchy by creating a new Visitor subclass.

Visitor implements "double dispatch". OO messages routinely manifest "single dispatch" - the operation that is executed depends on: the name of the request, and the type of the receiver. In "double dispatch", the operation executed depends on: the name of the request, and the type of TWO receivers (the type of the Visitor and the type of the element it visits).

Add a single pure virtual accept method to the base class of the Element hierarchy. accept is defined to receive a single argument - a pointer or reference to the abstract base class of the Visitor hierarchy.
Each concrete derived class of the Element hierarchy implements the accept method by simply calling the visit method on the concrete derived instance of the Visitor hierarchy that it was passed, passing its "this" pointer as the sole argument.

### Visitor Pattern Benefits

The benefit of this pattern is that if the logic of operation changes, then we need to make change only in the visitor implementation rather than doing it in all the item classes.

Another benefit is that adding a new item to the system is easy, it will require change only in visitor interface and implementation and existing item classes will not be affected.

An acknowledged __objection__ to the Visitor pattern is that is represents a regression to functional decomposition - separate the algorithms from the data structures. While this is a legitimate interpretation, perhaps a better perspective/rationale is the goal of promoting non-traditional behavior to full object status.

## Interpreter

According to GoF Interpreter design pattern is:

>Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.

### When Would I Use This Pattern?
The Interpreter pattern should be used when you have a simple grammar that can be represented as an Abstract Syntax Tree. This is the more obvious use of the pattern. A more interesting and useful application of Interpreter is when you need a program to produce different types of output, such as a report generator.

## Iterator
The Iterator pattern is used as the core pattern of Java's Collection Framework. It's used to access the members of collections all the while hiding the underlying implementation.
An aggregate object such as a list should give you a way to access its elements without exposing its internal structure. Moreover, you might want to traverse the list in different ways, depending on what you need to accomplish.

- Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
- The C++ and Java standard library abstraction that makes it possible to decouple collection classes and algorithms.
- Promote to "full object status" the traversal of a collection.
- Polymorphic traversal

## Memento

The memento design pattern is used when we want to save the state of an object so that we can restore later on. Memento pattern is used to implement this in such a way that the saved state data of the object is not accessible outside of the object, this protects the integrity of saved state data.

Memento pattern is implemented with two objects – Originator and Caretaker. The originator is the object whose state needs to be saved and restored and it uses an inner class to save the state of Object. The inner class is called Memento and it’s private so that it can’t be accessed from other objects.

Memento pattern is simple and easy to implement, one of the thing needs to take care is that Memento class should be accessible only to the Originator object. Also in client application, we should use caretaker object for saving and restoring the originator state.

Also if Originator object has properties that are not immutable, we should use deep copy or cloning to avoid data integrity issue like I have used in above example. We can use Serialization to achieve memento pattern implementation that is more generic rather than Memento pattern where every object needs to have it’s own Memento class implementation.

One of the drawback is that if Originator object is very huge then Memento object size will also be huge and use a lot of memory.

## References
This guide has taken some examples from: 
  - [Journaldev](https://www.journaldev.com/1827/java-design-patterns-example-tutorial).
  - [Dzone](https://dzone.com/articles/design-patterns-the-builder-pattern).
  - [Baeldung](https://www.baeldung.com/java-abstract-factory-pattern).
  - [oodesign](https://www.oodesign.com).
