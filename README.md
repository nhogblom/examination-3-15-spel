# 15 Puzzle – Java (Swing GUI)

[![Java](https://img.shields.io/badge/Java-17+-red.svg)](#)
[![Maven](https://img.shields.io/badge/Built%20with-Maven-blue.svg)](#)
[![OOP](https://img.shields.io/badge/Paradigm-OOP-green.svg)](#)
[![Status](https://img.shields.io/badge/Status-Student%20Project-success.svg)](#)

A classic **15 Puzzle** (sliding puzzle) game built in Java using Swing. Move the numbered tiles into the empty space until all tiles are in the correct order.  
This project focuses on clean code, event-driven programming, and basic GUI development.

<p align="center">
  <img src="docs/win-demo.gif" alt="Win animation" width="540"/>
</p>

---

## 🎯 Features

- Click-to-move tiles (only valid moves allowed)
- **Start new game** – always generates a solvable puzzle
- **Win detection** with a celebratory message and visual feedback
- Move counter and timer
- Simple code structure that’s easy to expand

<p align="center">
  <img src="/screenshot-start.png" alt="Start screen" width="360"/>
</p>

---

## 🚀 Getting Started

### Option A: IntelliJ IDEA (recommended)

1. Go to `File → New → Project from Version Control…` and clone this repository.
2. Open the project (IntelliJ will auto-detect Maven).
3. Run the **Main** class (e.g., `Main` in `src/main/java/...`).

### Option B: Maven CLI

```bash
# Build the project
mvn clean package

# Run (replace with the generated .jar file name)
java -jar target/15puzzle-*.jar
```

> If you want to run via `exec-maven-plugin`:

```bash
mvn -Dexec.mainClass="your.package.Main" exec:java
```

---

## 🎮 How to Play

1. Press **Start New Game** to enter your username and choose the difficulty of your liking.
2. Click a tile that is **next to** or two tiles away from the empty space to move it.
3. Continue until tiles are in order `1…15` with the empty tile at the end.
4. Enjoy your win moment 🎉

<p align="center">
  <img src="https://media.tenor.com/eDchk3srty4AAAAC/processing-loading.gif" alt="Brain loading" width="280"/>
</p>

---

## 🧱 Suggested Code Structure

```
src/
  main/
    java/
      your.package/
        Main.java              // Starts the app and GUI
        GameBoard.java         // Model: board representation
        Tile.java              // Model: a tile
        GameController.java    // Logic: valid moves, win state, shuffle
        GameView.java          // GUI components and event listeners
    resources/
        icons/                 // Optional graphics/icons
  test/
    java/                      // Unit tests (optional)
```

## 🛠️ Future Improvements / TODO

- ⌨️ Keyboard control (arrow keys)
- 🎨 Themes (light/dark mode)
- 🧩 Custom board sizes (3×3, 5×5, etc.)
- 🖼️ Picture puzzle mode (split an image into tiles)

<p align="center">
  <img src="https://media.tenor.com/Wx9IEmZZXSoAAAAC/thumbs-up-okay.gif" alt="Thumbs up" width="220"/>
</p>

---


## 📦 License

Free for educational use.  

---

## 🙌 Acknowledgements

Created as part of a Java/OOP course – a great beginner project to practice GUIs, events, logic, and Git workflow.

<p align="center">
  <img src="https://media.tenor.com/sJXl2p7UOe0AAAAC/shuffle-cards.gif" alt="Shuffle!" width="340"/>
</p>
