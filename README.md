Lab 4.1

Przechodzimy do ścieżki w projekcie: "4.1\build\libs" i odpalamy poniższe komendy, każda w innym terminalu zaczynając od serwera.

Terminal 1 (Serwer): java -cp app.jar org.example.Server

Terminal 2 (Klient 1): java -cp app.jar org.example.RedGamer

Terminal 3 (Klient 2): java -cp app.jar org.example.GreenGamer

Terminal 4 (Klient 3): java -cp app.jar org.example.BlueGamer


Lab 6.1

1. Zainstaluj wtyczkę (Plugin) Lombok
2. 
Dla IntelliJ IDEA:

Idź do File -> Settings (lub IntelliJ IDEA -> Preferences... na macOS).

Wybierz Plugins z menu po lewej.

Przejdź do zakładki Marketplace.

Wyszukaj "Lombok".

Zainstaluj wtyczkę i zrestartuj IDE.

2. Włącz przetwarzanie adnotacji (Annotation Processing)

To kluczowy krok, szczególnie w IntelliJ, nawet po zainstalowaniu wtyczki.

Idź do File -> Settings (lub IntelliJ IDEA -> Preferences... na macOS).

Nawiguj do Build, Execution, Deployment -> Compiler -> Annotation Processors.

Zaznacz pole "Enable annotation processing".

Kliknij Apply i OK.

Po zainstalowaniu wtyczki i włączeniu przetwarzania adnotacji, Twój projekt prawdopodobnie musi zostać odświeżony:

Odśwież projekt Gradle: W oknie Gradle kliknij przycisk Reload All Gradle Projects
