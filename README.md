# Zombie Apocalypse v4.5

## Solution description

Uses Publisher/Observer pattern to notify state changes and trigger events for Creatures and Zombies.

- Zombie queue maintains a queue of initial and converted Zombies. It listens for the Zombie walk to be over and starts walk for another Zombie
- Creatures listens for every move of Zombie and publishes a messages when it is dead. It is removed from list of creatures and added as a Zombie to the queue
- Zombie does what Zombies do best. Walk and eat brains with every move.
- Grid has the game setup and configuration of Zombies and Creature at any instance of apocalypse execution.

## How to run
```$xslt
Run java class src/main/java/io/ailo/ZombieRunner.java
```

##Tests

Junit tests for -

- Grid
- Zombie
- Creature
- ZombieQueue
- ZombieRunner

ZombieRunner is an integration test that puts all the components together. It can be used to change the inputs and test the output

##Instruction
 - Please read the problem description thoroughly then create a program to solve the
problem.
 - For the solution, we prefer you to use Javascript (typescript), Java or Python.
- There is no requirement for visualising this in any way beyond the console output
specified below.
- Your application must run, and generate the correct result.
- A README on how to run, diagnose or some key design thoughts is appreciated.
- To submit your code: either compress your files into a single Zip or GZip archive and
send via email, or store your code in private repositories and give us the access right.
Please DO NOT publish the code in public repositories.
- As a general rule, we allow 3 days from the date that you receive these instructions
to submit your code, but you may request more time if needed.
This exercise could take you anywhere around 2 to 8 hours to complete depends on your
approach, experience and how much time you have to spare.
Through this exercise, we assess a number of things including the design of your solution
and your programming skills. We will review the code and may offer you an interview in
which we will discuss the design and code decisions you made.
While these are small problems, we expect you to submit what you believe is production
quality code. That is code that you would be happy to test, run, maintain, and evolve.

## Problem Description
After the nuclear war, a strange and deadly virus has infected the planet. Living creatures
are becoming zombies that spread their zombiness by an unfriendly bite. The world consists
of an n x n grid on which zombies and creatures live.
Both of these occupy a single square on the grid and can be addressed using zero-indexed
x-y coordinates. Top left corner is (x: 0, y: 0) with x represent horizontal coordinate, y
represent vertical coordinate. Any number of zombies and creatures may occupy the same
grid square.
At the beginning of the program, a single zombie awakes and begins to move around the
grid. It is given an initial x-y coordinate and a list of movements, up, down, left and right. E.g.
(U,D,L,R).

The ordered sequence of movements needs to be represented somehow as input, for
example: DLUURR (down, left, up, up, right, right). Zombies can move through the edge of
the grid, appearing on the directly opposite side. For a 10x10 grid, a zombie moving left for
(0,4) will move to (9,4); a zombie moving down from (3,9) will move to (3,0).
The poor creatures in the area are the zombie’s victims. They also have an initial x-y
coordinate. The creatures are aware of zombie presence but are so frightened that they
never move.
If a zombie moves so that it end up on the same location as a creature, the creature is
transformed into another zombie and zombies score one point. The zombie continues
moving and infecting creatures until has performed all its moves.
Once it has completed its movement, the first newly created zombie moves using the same
sequence as the original zombie. Once it has completed its move, the second newly created
zombie moves, and so in order of infection with each zombie performing the same sequence
of moves. Once no new zombies have been created and all the zombies have completed
moving the program ends.
Your task is to write a program that takes input that describes the following
parameters:
- dimensions of the area (N)
- the initial position of the zombie
- a list of positions of poor creatures
- and a list of moves zombies will make
to produce an output that shows:
- the number of points scored by the zombies
- the final position of the zombies
The input and output are not limited to a particular format. I.e. it can be json, txt,
visual input etc.