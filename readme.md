
### Cards deck creation and shuffling
  
This Java program will create a 52 card deck (by default it's 52 but you can specify more if you want but then you will need to do corresponding changes in certain functions).  
It will also shuffle it to be as random as possible using the function: Math.floor(Math.random()*(max-min+1)+min) where max and min are the maximum and minimum amounts of cards.  
  
Inner class Card will create the object card where it will then be added in a static array.  
   
The interesting part in this deck is the shuffling where we have a instance function **shuffleOnce(int rdm1 , int rdm2)** where it will take two random numbers, the first number is **rdm1** which is the amount of cards to be removed from the top of the deck, **rdm2** is the amount of cards right after the collection of cards of **rdm1** which will move up to the top and where after them the rdm1 cards would be located.  
This type of shuffling is similar to the [Hindu shuffle](https://www.youtube.com/watch?v=ylifviUQHrI) but instead of taking multiple times a collection of cards from the top off the deck, we only will take a collection once.  
To have a fully and well shuffled deck this way, [Mr. Persi Diaconis recommends to do this shuffle 10000 times!](https://www.youtube.com/watch?v=AxJubaijQbI) which might not be possible for humans but for a program like this one we can and to randomize the shuffle even more it will specify the amount of shuffles randomly between 50000 and 30000 times.  
  
**visual()** is an instance function used to visualize/print the deck on the console.  
  
Date of creation: *20/03/2022*  
Project done by **CSwaiby** using Eclipse IDE.  
  