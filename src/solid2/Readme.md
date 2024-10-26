This is another example of a banking domain objects to demonstarte for code smells that can be resolved
using good OOP and SOLID principles. This example is not written in a "client-server" pattern like the other one.

This code does not need a buildfile, simply directly compile and run:
```
javac -d classes *.java
java -cp classes <various Smell2 drivers>
```

You can put the classes directory wherever you like just be consistent in referenciong it when using -d and -cp flags.

While this code works fine, and on initial inspection it would seem to be reasonably well-structured, it actually violates some
best practices of OOP and multiple [SOLID principles]https://anmolsehgal.medium.com/solid-principles-de1029ef8a8f.

The way this code is structured (a class diagram is below) introduces the violations and demands refactoring. What refactorings would you introduce?

<details>
  <summary>Hints</summary>
</details>


Last updated: October 10, 2024
