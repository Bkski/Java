<#
.SYNOPSIS
    Uruchamia serwer i trzech klientów Java w oddzielnych oknach PowerShell.

.DESCRIPTION
    Ten skrypt otwiera cztery nowe okna PowerShell:
    1.  Okno "Serwer" z poleceniem: java -cp app.jar org.example.Server
    2.  Okno "Klient 1 (Red)" z poleceniem: java -cp app.jar org.example.RedGamer
    3.  Okno "Klient 2 (Green)" z poleceniem: java -cp app.jar org.example.GreenGamer
    4.  Okno "Klient 3 (Blue)" z poleceniem: java -cp app.jar org.example.BlueGamer

.NOTES
    Wymagania:
    -   Upewnij siê, ¿e plik 'app.jar' znajduje siê w tym samym katalogu, z którego uruchamiasz ten skrypt.
    -   Upewnij siê, ¿e 'java' jest poprawnie zainstalowana i dostêpna w zmiennej œrodowiskowej PATH.
    -   Aby uruchomiæ skrypty .ps1, mo¿e byæ konieczne ustawienie polityki wykonywania w PowerShell, np.
        `Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass` (tylko dla bie¿¹cej sesji).
#>

Write-Host "Uruchamianie Serwera..."
# POPRAWKA: U¿ywamy 'cmd /c start' co jest bardziej niezawodnym sposobem
# na uruchomienie nowego procesu konsoli z w³asnym tytu³em i poleceniem.
# Sk³adnia: start "Tytu³ Okna" polecenie_do_uruchomienia
# U¿ywamy &{ ... } aby PowerShell na pewno wykona³ blok skryptu.
Start-Process cmd -ArgumentList "/c start `"Serwer`" powershell -NoExit -Command &{ java -cp app.jar org.example.Server }"

# Krótka pauza, aby zapewniæ uporz¹dkowane uruchamianie okien
Start-Sleep -Seconds 1

Write-Host "Uruchamianie Klienta 1 (RedGamer)..."
Start-Process cmd -ArgumentList "/c start `"Klient 1 (Red)`" powershell -NoExit -Command &{ java -cp app.jar org.example.RedGamer }"

Start-Sleep -Seconds 1

Write-Host "Uruchamianie Klienta 2 (GreenGamer)..."
Start-Process cmd -ArgumentList "/c start `"Klient 2 (Green)`" powershell -NoExit -Command &{ java -cp app.jar org.example.GreenGamer }"

Start-Sleep -Seconds 1

Write-Host "Uruchamianie Klienta 3 (BlueGamer)..."
Start-Process cmd -ArgumentList "/c start `"Klient 3 (Blue)`" powershell -NoExit -Command &{ java -cp app.jar org.example.BlueGamer }"

Write-Host "Zakoñczono. Wszystkie cztery procesy powinny byæ uruchomione w osobnych oknach."

