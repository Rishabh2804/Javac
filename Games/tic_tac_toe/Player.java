package tic_tac_toe;

class InvalidName extends Exception{

}

class InvalidSymbol extends Exception{

}

public class Player {

    private String name = null;
    private char symbol = '\0';

    public void setName(String name) throws InvalidName {
        if (name == null) {
            throw new InvalidName();
        } else {
            this.name = name;
        }
    }

    public void setSymbol(char symbol) throws InvalidSymbol{
        if(symbol == '\0' || symbol == '!'){
            throw new InvalidSymbol();
        }

        this.symbol = symbol;
    }

    public String getName(){
        return this.name;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
