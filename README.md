#  NeuroFuel – Smart Energy Distribution in AI Brain Cells

  A Java-based simulation that models intelligent energy management in AI systems using **Dynamic Programming (0/1 Knapsack)**. This project helps artificial brain cells (neurons) decide which tasks to activate when energy is limited — optimizing for **maximum total priority**.

---

## Project Overview

In AI systems, every task (neuron) consumes energy and has a priority based on importance. With limited energy (like in self-driving cars or drones), it’s not possible to activate all neurons. **NeuroFuel** solves this using a **0/1 Knapsack Dynamic Programming algorithm** that selects the best combination of neurons to activate while staying within an energy budget.

---

##  Tech Stack

- Language: **Java**
- Core Concept: **Dynamic Programming (0/1 Knapsack)**
- Data Structures: Arrays, Classes, 2D DP Table
- CLI Input/Output

---

##  Features

- Accepts multiple neuron inputs (energy cost + priority rank)
- Accepts total available energy as input
- Calculates the **optimal combination of neurons**
- Returns:
  - Neurons to activate
  - Total priority achieved
  - Energy used and remaining
- Ideal for **DSA practice**, **CRT training**, and **real-world AI logic modeling**

---

##  Sample Input

Enter number of neurons: 3
Enter total energy available: 7

-Neuron 1:
  Energy Cost: 3 ,
  Priority Rank: 6

-Neuron 2:
  Energy Cost: 4 ,
  Priority Rank: 7

-Neuron 3:
  Energy Cost: 2 ,
  Priority Rank: 3

  ## Sample Output

  Optimal Neurons to Activate (based on Priority): [1, 2]
  
  Total Priority Achieved: 13
  
   Energy Used: 7
  
   Remaining Energy: 0

