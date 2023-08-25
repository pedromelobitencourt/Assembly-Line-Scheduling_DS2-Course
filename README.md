# Assembly-Line-Scheduling_DS2-Course

Welcome to the "Assembly Line Scheduling" project! This project is part of the "Algorithms and Data Structures 2" course and involves implementing an algorithm to solve the well-known Assembly Line Scheduling problem. The goal of this project is to deepen your understanding of dynamic programming and its applications in optimization problems.

## Introduction

The Assembly Line Scheduling problem involves optimizing the production process in a factory with multiple assembly lines. The goal is to minimize the total time taken to produce a given number of units while considering different processing times and transfer times between assembly lines.

## Problem Statement

Given two parallel assembly lines, each with a set of stations, processing times, and transfer times between corresponding stations on the other line, the problem is to find the fastest way to produce a specified number of units while minimizing the overall production time.

## Algorithm Overview

The dynamic programming approach is commonly used to solve the Assembly Line Scheduling problem. The algorithm involves building two tables to keep track of the optimal production times and the corresponding paths through the assembly lines. The final solution can be obtained by tracing back the paths from the tables.

## Implementation Details

- Create data structures to represent assembly lines, stations, processing times, and transfer times.
- Implement the dynamic programming algorithm to compute optimal production times and paths.
- Develop a traceback mechanism to determine the optimal sequence of stations for each assembly line.

## Performance

The dynamic programming algorithm offers efficient performance characteristics:

- Time complexity: O(n), where n is the number of stations per assembly line.
- Space complexity: O(n), due to the need for tables to store optimal times and paths.

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use and modify the content for educational purposes while providing appropriate attribution.

Happy coding and exploring the efficient solutions to Assembly Line Scheduling!
