This example of a banking application is written in a "client-server" pattern, but there is no networking involved.
Instead the "server" can be thought of as a service interface that interacts with model object (Bank accounts)

This code does not need a buildfile, simply directly compile and run:
```
javac -d classes ./banking/gui/Main.java ./banking/gui/MainFrame.java ./banking/primitive/Asset.java ./banking/primitive/InterestBearing.java ./banking/server/AccountServer.java ./banking/server/AccountServerFactory.java  ./banking/server/ServerSolution.java ./banking/server/ServerTest.java
java -cp classes banking.gui.Main my.properties
```

Or use the simple provided ant script:
```
ant clean
ant compile
ant run
```

While this code works fine, and on initial inspection it would seem to be reasonably well-structured, it actually violates some
best practices of OOP and multiple [SOLID principles]https://anmolsehgal.medium.com/solid-principles-de1029ef8a8f.

The way this code is structured (a class diagram is below) introduces the violations and demands refactoring. What refactorings would you introduce?

<details>
  <summary>Hints</summary>

  #### Single Responsibility Principle (SRP)
  The SRP says *a component/object should have a single responsibility.* Uncle Bob puts it as:
  "The Single Responsibility Principle (SRP) states that each software module should have one and only one reason to change."
    The ramification for this in code is that when a change to an algorithm is required, it should happen in one place and not affect the users
    (client code) of that code.

    The provided code has 2 distinct sets of responsibilities, embodied in the display() method on Asset with its Swing-based
    realization in abstract class Account, which then is subclassed by Check and Savings accounts which provide withdraw/deposit behaviors
    that have nothing to do with display.

  #### Open-Closed Principle (OCP)
  The OCP says *a component/class should be open for extension but closed for modification.* 
  This means you code with *intention*, directing maintainers/enhancers where and how the code can be specialized/extended. If this intention is
  not clear, the revisions quickly become spaghetti because the newbie is conjecturing (guessing) how to do such extensions. The use of class
  hierarchies, interafes, and the application of structural and behavioral patterns like Template, Strategy, Decorator, and Visitor may be used
  to express such intention.

  The provided code has a subtle OCP problem in that the subtypes of Account have specific yet related implementations of their withdraw and
  deposit behaviors. 
</details>

![alt text][SOLID1_class_diagram]

[SOLID1_class_diagram]: https://www.public.asu.edu/~kgary/ser515/fall23/SOLID_092823_ser515.drawio.png "SOLID Example 1 given class diagram"

Last updated: October 10, 2024
