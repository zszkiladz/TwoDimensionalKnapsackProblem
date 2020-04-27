## Knapsack problem with 2 constraints

Files:
- First line - 2 constraints for backpack
- Second line - number of things
- Next lines - value of thing and 2 constraints, e.g. weight and volume

##### Examples:

*(in.txt)*: 

    10 8 //Rzymianin może zapewnić 10 jednostek prowiantu i 8 rozrywek
    4 //Jest 4 najemników
    3 5 2 //Pierwszy z nich ma siłę 3, wymaga 5 prowiantu i 2 rozrywki
    4 6 3 //itd.
    2 4 6
    3 5 9
    
    Result:
    5 //najmocniejszy wynajęty oddział może mieć siłę 5
    1 3 //składa on się z żołnierzy nr 1 oraz 3, Rzymianin może sprostać ich wymaganiom
    
    Results
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
    
###### inMed.txt 
    642
    4 5 7 9 16 17 19 21 23 24 25 26 27 29 30 32 43 45 46 47 50 52 
    53 54 55 57 58 60 61 63 64 67 69

    
###### inBig.txt 
    1176
    2 3 5 7 10 11 12 13 18 20 21 23 24 25 27 29 30 31 32 34 36 37 
    38 41 42 43 45 46 47 48 52 54 55 56 57 58 59 61 64 65 66 67 
    68 69 70 72 73 75 76 77 78 80 82 84 85 86 87 88 90 92 93 95 96 
    97 98 100