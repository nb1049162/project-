hello world!!!!
this is a repository for a mini compiler project 

The files required to run the project are in the repositiry you need all files 




the project was to make a minicompiler that will take simple expressions such as 2+2 or (1+(8*2)-3)..
it should take that expression and give the tokens, result and print out a tree to go with it 

we had to split this project into diffent sections the lexer, the parser, and the syntax tree builder :(

THE LEXER 
is responsible for reading the input and converting it to a stream of tokens, 
the way we have it set up it uses out token class witch holds the types and other general stuff,

HOW IT WORKS
it goes through the token types in Token.clas and builds a regex with the groups (NUMBER,PLUS,MINUS...). 
then it takes that regex and mathes it 
when the matcher finds somthing it checks the group basedon that group it creates a Token (NUMBER,PLUS,MINUS...). 
and finally it adds it to an arrray and returns it; fun fact thats what we used to print out the tokens for the dispaly;

THE PARSER 
the parser is the thing responsible for handeling the orders of operations like how + and - go after * and / as well as handels parentaseese 

HOW IT WORKS 

