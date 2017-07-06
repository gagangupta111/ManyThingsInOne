package com.HackerEarth;

import java.util.Stack;

public class ExpandChemistryFormula {

    public static void main(String[] args) {

        String string = "(CH3(CO)2CA)6";
        char[] chars = string.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        CharacterStack characterStack = new CharacterStack(stack);

        for (char c: chars){

            if (isDigit(c)){

                int noOfTimes = Character.getNumericValue(c);
                Character peeked = characterStack.peek();
                if (isLetter(peeked)){

                    Character pop = characterStack.pop();
                    for (int i = 0; i < noOfTimes; i++){
                        characterStack.push(peeked);
                    }

                }else if (peeked == ')'){

                    StringBuilder stringBuilder = new StringBuilder();
                    characterStack.pop();
                    while (characterStack.peek() != '('){
                        stringBuilder.append(characterStack.pop());
                    }
                    characterStack.pop();
                    stringBuilder.reverse();
                    for (int i = 0; i < noOfTimes; i++){
                        characterStack.push(stringBuilder);
                    }

                }
            continue;
            }

            characterStack.push(c);

        }

        System.out.println(characterStack.toString());

    }

    private static boolean isDigit(Character c) {
        return (c >= '0' && c <= '9');
    }

    private static boolean isLetter(Character c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

}

class CharacterStack{

    public CharacterStack(Stack<Character> stack) {
        this.stack = stack;
    }

    private Stack<Character> stack = new Stack<Character>();

    public Character peek(){

        return stack.peek();

    }

    public void push(Character character){

        stack.push(character);

    }

    public void push(StringBuilder stringBuilder){

        for (int i = 0; i < stringBuilder.length(); i++){
            stack.push(stringBuilder.charAt(i));
        }

    }

    public Character pop(){
        return stack.pop();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stack.size(); i++){
            stringBuilder.append(stack.get(i));
        }
        return stringBuilder.toString();
    }
}