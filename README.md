# 15-spelet – Java (Swing/GUI)

[![Java](https://img.shields.io/badge/Java-17+-red.svg)](#)
[![Maven](https://img.shields.io/badge/Built%20with-Maven-blue.svg)](#)
[![OOP](https://img.shields.io/badge/Paradigm-OOP-green.svg)](#)
[![Status](https://img.shields.io/badge/Status-Student%20projekt-success.svg)](#)

Ett klassiskt **15-spel** (sliding puzzle) där du flyttar numrerade brickor in i den tomma rutan tills allt ligger i ordning. Projektet är byggt i Java med ett enkelt GUI och fokus på ren kod, händelsehantering och Git-flöden.

<p align="center">
  <img src="docs/win-demo.gif" alt="Vinstanimering" width="540"/>
</p>

---

## 🎯 Funktioner

- Klick-och-flytt av brickor (endast giltiga drag)
- **New Game / Shuffle** med slumpad, lösbar konfiguration
- **Vinstdetektering** + liten “confetti”-känsla med färg/meddelande
- Räknare för drag (moves) och tid (valfritt)
- Enkel, läsbar kodstruktur som är lätt att bygga vidare på

<p align="center">
  <img src="docs/screenshot-start.png" alt="Startvy" width="360"/>
</p>

---

## 🚀 Kom igång

### Alternativ A: IntelliJ IDEA (rekommenderas)
1. `File → New → Project from Version Control…` och klona repo.
2. Öppna projektet (Maven känns igen automatiskt).
3. Kör **Main**-klassen (t.ex. `Main` eller motsvarande i `src/main/java/...`).

### Alternativ B: Maven CLI
```bash
# Bygg
mvn clean package

# Kör (byt filnamn till det JAR som byggs i target/)
java -jar target/15spel-*.jar
```

> Om du vill köra via `exec-maven-plugin`:
```bash
mvn -Dexec.mainClass="fullständigt.paket.Main" exec:java
```

---

## 🎮 Så spelar du

1. Tryck **New Game** för att blanda.
2. Klicka på en bricka som ligger **intill** den tomma rutan för att flytta in den.
3. Fortsätt tills ordningen är `1 … 15` med tom ruta sist.  
4. Njut av vinstmeddelandet 🎉

<p align="center">
  <img src="https://media.tenor.com/eDchk3srty4AAAAC/processing-loading.gif" alt="Brain loading" width="280"/>
</p>

---

## 🧱 Kodstruktur (förslag)

```
src/
  main/
    java/
      <ditt.paket.namn>/
        Main.java              // Startar appen och GUI:t
        GameBoard.java         // Modell: representation av rutnätet
        Tile.java              // Modell: en bricka
        GameController.java    // Logik: giltiga drag, vinst, shuffle
        GameView.java          // GUI-komponenter, event-lyssnare
    resources/
        icons/                 // Ev. ikoner/grafik
  test/
    java/                      // Enhetstester (valfritt)
```

> Namn kan skilja mot din implementation – behåll dina klassnamn, detta är endast vägledning.

---

## 🧪 Testning (valfritt)

- Enhetstester för:
  - `isSolvable()` – blandning ska vara lösbar
  - `isWin()` – korrekt vinstdetektion
  - `canMove()` – endast giltiga drag

```bash
mvn test
```

---

## 🛠️ Vidare utveckling / TODO

- ⏱️ Timer + bästa tider (high score)
- ⌨️ Piltangenter för att flytta den tomma rutan
- 🎨 Tema/Läge: mörkt & ljust
- 🧩 Olika brädstorlekar (t.ex. 3×3, 5×5)
- 🖼️ Bildpussel-läge (ersätt siffror med en bild uppdelad i tiles)

<p align="center">
  <img src="https://media.tenor.com/Wx9IEmZZXSoAAAAC/thumbs-up-okay.gif" alt="Thumbs up" width="220"/>
</p>

---

## 💡 Tips

- Håll **modell (logik)** och **vy (GUI)** separerade – lättare att testa och utöka.
- Skriv små, rena metoder för flyttkontroll och vinstkontroll.
- Lägg screenshots/GIFs i `docs/` och länka i README (så funkar de även offline i repo).

---

## 📦 Licens

Använd fritt i utbildningssyfte. Lägg gärna till en licensfil (`LICENSE`) om du vill öppna upp koden för vidare användning.

---

## 🙌 Tack!

Byggt som en del av OOP/JAVA-kurs – och som ett perfekt litet projekt för att öva GUI, händelser, datastrukturer och Git-workflows.

<p align="center">
  <img src="https://media.tenor.com/sJXl2p7UOe0AAAAC/shuffle-cards.gif" alt="Shuffle!" width="340"/>
</p>
