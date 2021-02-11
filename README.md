podręczna przypominajka przykładowych implementacji wzorców projektowych
## Spis treści
* [Wzorce kreacyjne](#wzorce-kreacyjne)
* [Wzorce strukturalne](#wzorce-strukturalne)
* [Wzorce czynnościowe](#wzorce-czynnosciowe)


## Wzorce kreacyjne
* [Metoda wytwórcza](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/kreacyjne/MetodaWytworcza.java)
Chcemy tworzyć obiekt bez ujawniania logiki tworzenia i odwołać się do nowo utworzonego obiektu za pomocą wspólnego interfejsu
* [Fabryka abstrakcyjna](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/kreacyjne/FabrykaAbstrakcyjna.java)
Możemy użyć gdy 
1)klasa ma skomplikowany, przeciążony wielokrotnie konstruktor. Oznaczać to może oczywiście błędnie zaprojektowaną klasę, ale może też wskazywać na to, że utworzenie instancji klasy potrzebuje dodatkowej logiki.
2)utworzenie instancji klasy jest poprzedzone instrukcją warunkową if.
3)w momencie pisania programu nie wiesz, której instancji potrzebujesz (bo np. jest to uzależnione od parametru zwracanego z API). Ponownie, logikę hermetyzujemy wewnątrz fabryki.
* [Budowniczy](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/kreacyjne/Budowniczy.java)
Gdy klasa posiada skomplikowany konstruktor, a zależy nam na tworzeniu różnych opcji obiektu. Obiekt budujemy etapami, a nie tak jak w przypadku fabryk od razu.
* [Prototyp](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/kreacyjne/Prototyp.java)
Prosty przykład, to gra Pac-Man, którą każdy zna od zygoty. W grze występują złe “duszki”, które mają za zadanie dorwać Pac-Mana zanim ten wszama wszystkie “kropki” na planszy. Każdy z duszków ma identyczny kształt, funkcjonalności; “duszki” różnią się jedynie kolorem. Możemy więc zastosować wzorzec Prototyp do powielania(sklonowanie) postaci w grze.Zmniejsza koszt inicjalizacji wielu podobnych obiektów.
* [Singelton](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/kreacyjne/Singelton.java)
Chcemy mieć tylko jedną globalną instancję obiektu do której mają dostęp inne komponenty. Np obiekt połączenia z bazą danych, dziennik systemowy
## Wzorce strukturalne
* [Adapter](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Adapter.java)
Umożliwienie współpracy dwóm klasom o niekompatybilnych interfejsach. Adapter przekształca interfejs jednej z klas na interfejs drugiej klasy. Innym zadaniem omawianego wzorca jest opakowanie istniejącego interfejsu w nowy.
* [Most](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Most.java)
Stosujemy gdy chcemy
1)odseparować implementację od interfejsu,
2)poprawić możliwości rozbudowy klas, zarówno implementacji, jak i interfejsu (m.in. przez dziedziczenie),
3)ukryć implementację przed klientem, co umożliwia zmianę implementacji bez zmian interfejsu.
* [Dekorator](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Dekorator.java)
Dekorator polega na opakowaniu bazowej klasy w klasę dekorującą. Wykorzystuje się do tego kompozycję. Wzorzec ten jest alternatywą dla dziedziczenia, które posiada szereg ograniczeń w tym zakresie. Przede wszystkim dekorator pozwala na dekorowanie w trakcie działania programu, a nie podczas kompilacji. Dodatkowo umożliwia „składanie” dekoratorów, a więc daje elastyczność w kwestii doboru zestawu nowych funkcjonalności.
* [Kompozyt](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Kompozyt.java)
Chcemy mieć powiązene ze sobą obiekty w formie drzewa. np Pracownik jak Manager, ma pod sobą innych pracowników, ale sam również jest pracownikiem i jest pod dyrektorem.
* [Fasada](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Fasada.java)
Przykład: System sterowania domem, który implementuje wiele różnych podsystemów, a chcemy mieć jedno uniwersalne API. Więc na wejściu zastosujemy fasadę.
* [Proxy](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Proxy.java)
Pełnomocnik jest wzorcem projektowym, którego celem jest utworzenie obiektu zastępującego inny obiekt. Stosowany jest on w celu kontrolowanego tworzenia na żądanie kosztownych obiektów oraz kontroli dostępu do nich. Chcemy mieć dostęp do obiektu tylko pod jakimiś warunkami.
* [Pylek](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/strukturalne/Pylek.java)
Chcemy aby obiekty tego samego typu były tworzone tylko raz.
Np. mamy pozycję w sklepie internetowym, i pozycji tego samego typu tworzonych jest mnóstwo,
nie chcemy za każdym razem każdą pozycję tworzyć od nowa.
## Wzorce czynnościowe
* [Łańcuch zobowiązań](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/LancuchOdpowiedzialnosci.java)
Chcemy oddzielić obiekty nadawcy (sender) i odborcy (receiver).
Umożliwia on tworzenie listy zadań (czynności), które będą wykonywane kolejno do momentu, gdzie nie będzie już więcej zadań do zrealizowania. Każde pod zadanie jest reprezentowane przez oddzielną klasę, która dziedziczy po wspólnym interfejsie. Interfejs ten agreguje interfejsy nowych zadań dodanych do listy. Łańcuch zobowiązań może być zamknięty lub otwarty. W przypadku jego zamknięcia zadania będą realizowane do momentu przerwania przez użytkownika.
* [Mediator](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Mediator.java)
Mediator to wzorzec obiektowy. Zapewnia jednolity interfejs dla różnych elementów danego systemu. Innymi słowy jeśli istnieje wiele obiektów klas, które muszą się komunikować ze sobą, to zamiast tego, aby wszyscy znali wszystkich, wszyscy znają mediatora. Ten z kolei zna wszystkich.
* [Memento](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Memento.java)
Pamiątka może zostać wykorzystana np w procesorze tekstu do zaimplementowania operacji "Cofnij" oraz "Ponów". Za każdym razem kiedy użytkownik wykonuje jakąś akcję – wprowadza tekst, zmienia wielkość czcionki czy jej kolor – tworzony jest obiekt pamiątki zapamiętujący bieżący stan dokumentu. Gdy użytkownik zleci wycofanie ostatniej operacji, stan dokumentu zostanie odtworzony za pomocą wcześniej zapisanej pamiątki.
* [Metoda szablonowa](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/MetodaSzablonowa.java)
Służy do określenia szkieletu algorytmu. Pozwala na doprecyzowanie wybranych kroków algorytmu w klasach dziedzicznych, zachowując przy tym określoną kolejność kroków.
* [Obserwator](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Obserwator_Main.java)
Istnieją zdarzenia, które powinny wyzwalać pewne zachowanie. Wystąpienie zdarzenia powoduje to, że obserwator aktualizuje swój stan na podstawie zmiany obserwowanego elementu. Aktywne sprawdzanie czy zdarzenie wystąpiło w większości przypadków nie jest dobrym rozwiązaniem. W projektach informatycznych problem tego typu rozwiązany jest przez wzorzec projektowy obserwator (ang. observer).
* [Polecenie](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Polecenie.java)
Jego celem jest umieszczenie w jednej klasie zarządzającej wszystkich poleceń, które mogą być wywołane np. przy wciśnięciu przycisku klawiatury. W tejże klasie przechowywane są interfejsy obiektów klas, które wykonują określone polecenie.
* [Stan](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Stan.java)
Rozważmy aplikację, której zadaniem jest rysowanie różnych obiektów za pomocą różnych komponentów. Aplikacja taka może posiadać abstrakcyjny interfejs reprezentujący narzędzie do rysowania implementowany przez klasy konkretnych narzędzi. Klasa główna będzie wywoływać odpowiednie narzędzie do rysowania - w zależności od tego w jakim będzie stanie. W sekcji przykłady znajduje się przykładowy kod rozwiązujący powyższy problem.
* [Strategia](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Strategia.java)
Obecnie w przypadku umowy o pracę mamy dwa sposoby rozliczenia z podatku dochodowego. Poprzez skalę i poprzez podatek liniowy. Co z tym idzie mamy drobne różnice w sposobie implementacji algorytmu do obliczenia podatku dochodowego. Klient korzystający z naszej funkcjonalności chce mieć tylko możliwość wyboru sposobu opodatkowania w trakcie działania programu.
* [Visitor](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Visitor.java)
Chcemy umożliwić łatwe dodawanie nowej operacji do struktury obiektowej bez konieczności otwierania klas tej struktury
* [Iterator](https://github.com/SlawomirK/PrzykladyWzorcowProjektowych/blob/master/src/czynnosciowe/Wzorzec_Iterator.java)
Pozwala sekwencyjnie przechodzić od elementu do elementu jakiegoś zbioru bez konieczności eksponowania jego formy.
