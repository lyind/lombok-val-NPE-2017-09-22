package net.talpidae.issue;

import lombok.val;

import java.util.stream.Stream;


/**
 * Simple test case for Lombok NPE at build time.
 */
public class LombokIssue extends Thread
{
    private LombokIssue()
    {
        super(() ->
        {
            for (int i = 0; i < 5; ++i)
            {
                val index = i;
                Stream.of(new Character[]{'a', '1', 'b', '2', '3', 'c', 'd', '4', 'e', '5', 'f', 'g'})
                        .filter(Character::isDigit)
                        .forEach(character ->
                        {
                            System.out.println(Integer.toString(index) + ": " + character);
                        });
            }
        });
    }


    public static void main(String[] args)
    {
        new LombokIssue().run();
    }
}