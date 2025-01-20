# Maze_Game
Labirinto (Maze Solver)
This project implements a maze solver using a stack-based depth-first search (DFS) algorithm in Java. The program reads a maze from a text file, processes it, and attempts to find a path from the start point to the finish point. The algorithm uses DFS to explore possible paths and outputs the sequence of positions that lead to the solution.

Features
Maze Representation: The maze is read from a text file (labirinto.txt) and represented as a 2D grid.
Depth-First Search (DFS): A DFS algorithm is used to find the path from the start point to the finish point.
Backtracking: The stack-based DFS explores all potential paths and backtracks when it hits dead ends.
Text-Based Visualization: The maze is printed to the console, and the stack is visualized during execution to show the steps taken by the algorithm.
File Format
The maze is stored in a text file (labirinto.txt) with the following format:

The first two integers specify the dimensions of the maze: rows and columns.
The following values represent the maze grid, where 0 indicates a walkable path and 1 represents a wall.
The last two pairs of integers represent the coordinates of the starting point and the finish point.

How It Works
Maze Loading: The CaricaLabirinto method loads the maze from a text file and initializes the maze grid, marking each position with a value of 0 (walkable) or 1 (wall). It also sets the start and finish coordinates.

Depth-First Search (DFS): The TrovaStrada method uses DFS to explore the maze:

Starting from the initial position, it checks all possible directions (right, down, up, left) and marks visited positions.
The stack is used to backtrack if the algorithm reaches a dead end.
Path Visualization: The VisualizzaStack method prints the positions in the stack, showing the steps taken by the algorithm to find the solution.