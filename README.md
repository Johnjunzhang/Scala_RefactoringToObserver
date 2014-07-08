ObserverPattern
===================================
### Example
Observer pattern case from book "Head First Design Pattern"

### Content
####Step 1
#####Motivation:
Bad Smell: Divergent Change

#####Intent
Encapsulate a request as a object

#####Mechanics
1. Replace Nested Conditional with Guard Clauses: move if (humidity > 65) block out
2. Extract Method: extract the seedingMachine.Start() and the if condition together to a method seedingMachineUpdate
3. Generate Code: create a seedingMachineObserver class
4. Move Method: Move the method seedingMachineUpdate to SeedingMachineObserver class
5. Use  1-3 to extract ReapingMachineObserver and  WateringMachineObserver

#####Result
git checkout step1

####Step 2
#####Motivation
Bad Smell: Alternative Classes with Different Interfaces

#####Intent
Make requests with same interface

#####Mechanics
1. Change Method Signature: modify seedingMachineUpdate, reapingMachineUpdate to the same parameter with waterMachineUpdate
2. Rename Method:  rename seedingMachineUpdate, waterMachineUpdate, reapingMachineUpdate to Update
3. Extract Interface: Extract interface IObserver from seedingMachineObserver
4. Let other Observer class to inherit IObserver

#####Result
git checkout step2

####Step 3
#####Motivation
Bad Smell: Duplicate Code

#####Intent   
Map all actions to list

#####Mechanics
1. Inline Method: inline wateringMachineUpdate, reapingMachineUpdate, seedingMachineUpdate
2. New MutableList[IObserver](), Introduce field: observers
3. observers += wateringMachineUpdate
4. observers += reapingMachineUpdate
5. observers += seedingMachineUpdate
6. Use observers.foreach(_.update(temp, humidity, windPower)) to remove duplicate update

#####Result
git checkout step3

####Step 4
#####Motivation
Bad Smell: Functions Should Do One Thing

#####Intent
Decouple initilize observers from executing update

#####Mechanics
1. Move all initilize observers code to class level

#####Result
git checkout step4

####Step 5
#####Motivation
Bad Smell: Primitive Obsession

#####Intent
Use user defined method to replace list +=

#####Mechanics
1. Extract Method: Extract observers += seedingMachineObserver to subscribe method
2. Introduce Parameter: Introduce seedingMachineObserver to parameter and use IObserver as its type
3. Use subscribe for add wateringMachineObserver and reapingMachineObserver

#####Result
git checkout step5

####Step 6
#####Motivation
Bad Smell: Temporary Field

#####Intent
Remove temporary field

#####Mechanics
1. Inline Field: seedingMachineObserver, wateringMachineObserver and reapingMachineObserver

#####Result
git checkout step6

####Step 7
#####Motivation
Bad Smell: Divergent Change

#####Intent
Parameterize clients with different request

#####Mechanics
1. Move Method: Move all subscribe methods to client
2. Inline Method: inline getWeatherData in WeatherDataFact class
3. Remove useless subscribe for each test

#####Result
git checkout step7

###Further Exercises
1. Read the "Refactoring" book about the bad smells and mechanics have been used. This is the website version of the book for quick reference: http://sourcemaking.com/refactoring
2. Read the "Head First Design Pattern" to understand more about Observer Pattern.
