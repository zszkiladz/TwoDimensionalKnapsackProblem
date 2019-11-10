## Task 3

### Problem 3 – Rzymscy najemnicy 
Pewien Rzymianin żył sobie w szczęściu i bogactwie. Pewnego dnia stało się nieszczęście, gdyż
jego ukochana została uprowadzona przez jego zaciekłych wrogów. Co mu teraz po samym
bogactwie, gdy szczęścia nie ma? A jednak pieniądze mogą mu pomóc – ma on zamiar wynająć
całą drużynę najemnych żołnierzy, którzy pomogą mu odbić ukochaną. Sprawa nie jest jednak taka
prosta, gdyż rzymscy najemnicy się wysoko cenią. Każdy z nich ma swoje wymagania w czasie
misji. Zgodnie z powiedzeniem „chleba i igrzysk” żołnierze oczekują prowiantu i rozrywek w
zamian za świadczone przez nich usługi. Jeśli którykolwiek z tych warunków nie zostanie
spełniony, to najemnik odchodzi w poszukiwaniu lepszego pracodawcy, a nasz Rzymianin dalej
wzdycha do ukochanej. Ma on pewien górny próg na sumę prowiantu i sumaryczną rozrywkę, jaką
może zapewnić dla drużyny najemnej. Ograniczenia wynikają zarówno z budżetu jak i z logistyki.
Mieszcząc się w tych ograniczeniach nasz bohater chce skompletować oddział o możliwie
największej sile rażenia. A może Ty pomożesz mu w tym zadaniu?

#### Wejście:

W pierwszej linii wejścia podane są liczby P i R (1<=P, R<=1000) będące
maksymalnymi ilościami prowiantu i rozrywki, które może zapewnić
Rzymianin. W drugiej linii podana jest liczba n (1<=n<=100) najemników.
W kolejnych n liniach podane są liczby si, pi, ri(0<=si, pi, ri
<=100000) oznaczające odpowiednio: siłę i-go żołnierza, jego wymagania
co do prowiantu oraz rozrywek.

#### Wyjście:

W pierwszej linii wyjścia ma być podana sumaryczna siła najmocniejszego
oddziału leżącego w możliwościach wynajmu Rzymianina. W kolejnej linii
podane są numery wynajętych żołnierzy (numeracja od 1).

##### Przykład:

Wejście *(in.txt)*: 

    10 8 //Rzymianin może zapewnić 10 jednostek prowiantu i 8 rozrywek
    4 //Jest 4 najemników
    3 5 2 //Pierwszy z nich ma siłę 3, wymaga 5 prowiantu i 2 rozrywki
    4 6 3 //itd.
    2 4 6
    3 5 9
    
Wyjście *(out.txt)*:

    5 //najmocniejszy wynajęty oddział może mieć siłę 5
    1 3 //składa on się z żołnierzy nr 1 oraz 3, Rzymianin może sprostać ich wymaganiom
    
###### in1.txt
    11
    1 2 5 6
    
###### in2.txt 
    25
    1 3 4 5 8 9
    
###### in3.txt
    177
    1 3 6 7 8 9 10 12
    
###### in4.txt 
    233
    1 2 3 4 5 6 8 10 14 15 16 17
    
###### in5.txt 
    277
    1 2 4 5 6 14 17 22 23 26 27 29 30