# Schachbrett-Spiel - README

Dieses README-Dokument beschreibt den Java-Code für ein einfaches Schachbrett-Spiel, das in der Konsole ausgeführt wird. Das Spiel ermöglicht es zwei Spielern, abwechselnd ihre Züge zu machen und Schachfiguren auf dem Schachbrett zu bewegen.

# Spielregeln

- Das Schachbrett besteht aus 8x8 Feldern mit 8 vertikalen Spalten (a-h) und 8 horizontalen Reihen (1-8).
- Zu Beginn des Spiels werden die Schachfiguren entsprechend ihrer Startpositionen auf dem Schachbrett platziert.
- Weiß beginnt das Spiel, und die Spieler machen abwechselnd ihre Züge.
- Die Schachfiguren können je nach Typ unterschiedliche Zugmöglichkeiten haben: Bauer, Turm, Springer, Läufer, Dame (Queen) und König.
- Das Ziel des Spiels ist es, den König des Gegners schachmatt zu setzen, was bedeutet, dass der König im nächsten Zug geschlagen werden kann und keine legalen Züge mehr übrig hat.

# Code-Aufbau

Der Code basiert auf einer einfachen Konsolenanwendung. Die wichtigsten Klassen im Code sind:

- **Main**: Die Hauptklasse des Spiels, die die Initialisierung der Spielfiguren, das Schachbrett und die Eingabe der Spielerzüge steuert.
- **Spielfigur**: Eine Klasse, die eine Schachfigur repräsentiert und ihre Eigenschaften wie Farbe, Typ, ID und Symbol verwaltet.
- **Ausgabe**: Eine Hilfsklasse zum Anzeigen des Schachbretts und der Schachfiguren auf der Konsole.
- **moveFigures**: Eine Methode, die die Spiellogik steuert und prüft, ob die Züge der Spieler gültig sind und das Schachbrett entsprechend aktualisiert.

# Spielzüge speichern

Das Spiel speichert die getätigten Züge in einer Datei namens "schachspielzuege.txt". Jeder Zug wird in einer neuen Zeile gespeichert. Wenn das Spiel beendet wird oder ein Spieler den Befehl "c" eingibt, wird der Inhalt der Datei gelöscht.

# Hinweis

Dies ist ein einfaches Konsolenspiel, das auf der Logik von Schach basiert. Es gibt keine Implementierung für spezielle Schachregeln wie Rochade, en passant, Schach oder Schachmatt. Das Spiel ist nur als Demonstration der Grundlagen von Schach und der Programmierung in Java gedacht. Es kann als Grundlage für ein umfangreicheres Schachspiel weiterentwickelt werden.
