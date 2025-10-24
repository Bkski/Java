<#
.SYNOPSIS
    Uruchamia serwer i trzech klient�w Java w oddzielnych oknach PowerShell.

.DESCRIPTION
    Ten skrypt otwiera cztery nowe okna PowerShell:
    1.  Okno "Serwer" z poleceniem: java -cp app.jar org.example.Server
    2.  Okno "Klient 1 (Red)" z poleceniem: java -cp app.jar org.example.RedGamer
    3.  Okno "Klient 2 (Green)" z poleceniem: java -cp app.jar org.example.GreenGamer
    4.  Okno "Klient 3 (Blue)" z poleceniem: java -cp app.jar org.example.BlueGamer

.NOTES
    Wymagania:
    -   Upewnij si�, �e plik 'app.jar' znajduje si� w tym samym katalogu, z kt�rego uruchamiasz ten skrypt.
    -   Upewnij si�, �e 'java' jest poprawnie zainstalowana i dost�pna w zmiennej �rodowiskowej PATH.
    -   Aby uruchomi� skrypty .ps1, mo�e by� konieczne ustawienie polityki wykonywania w PowerShell, np.
        `Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass` (tylko dla bie��cej sesji).
#>

Write-Host "Uruchamianie Serwera..."
# POPRAWKA: U�ywamy 'cmd /c start' co jest bardziej niezawodnym sposobem
# na uruchomienie nowego procesu konsoli z w�asnym tytu�em i poleceniem.
# Sk�adnia: start "Tytu� Okna" polecenie_do_uruchomienia
# U�ywamy &{ ... } aby PowerShell na pewno wykona� blok skryptu.
Start-Process cmd -ArgumentList "/c start `"Serwer`" powershell -NoExit -Command &{ java -cp app.jar org.example.Server }"

# Kr�tka pauza, aby zapewni� uporz�dkowane uruchamianie okien
Start-Sleep -Seconds 1

Write-Host "Uruchamianie Klienta 1 (RedGamer)..."
Start-Process cmd -ArgumentList "/c start `"Klient 1 (Red)`" powershell -NoExit -Command &{ java -cp app.jar org.example.RedGamer }"

Start-Sleep -Seconds 1

Write-Host "Uruchamianie Klienta 2 (GreenGamer)..."
Start-Process cmd -ArgumentList "/c start `"Klient 2 (Green)`" powershell -NoExit -Command &{ java -cp app.jar org.example.GreenGamer }"

Start-Sleep -Seconds 1

Write-Host "Uruchamianie Klienta 3 (BlueGamer)..."
Start-Process cmd -ArgumentList "/c start `"Klient 3 (Blue)`" powershell -NoExit -Command &{ java -cp app.jar org.example.BlueGamer }"

Write-Host "Zako�czono. Wszystkie cztery procesy powinny by� uruchomione w osobnych oknach."

