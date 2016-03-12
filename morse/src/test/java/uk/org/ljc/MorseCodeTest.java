/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.org.ljc;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Ignore;
/**
 * Test that MorseCode is working correctly
 * 
 * @author Carl Jokl
 */
public class MorseCodeTest {
    
    
    @Test
    public void testMorseChar() {
        Assert.assertArrayEquals("The letter s should be converted to expected morse.", new boolean[] {false, false, false}, MorseCode.charToMorseCode('s'));
    }
    
    @Test
    public void testCaseInsensitiveChar() {
        Assert.assertArrayEquals("The letter S should be case insensitive converted to expected morse.", new boolean[] {false, false, false}, MorseCode.charToMorseCode('S'));
    }

    @Test
    public void testUnknownChar() {
        Assert.assertArrayEquals("Unknown character should result in empty array.", new boolean[] {}, MorseCode.charToMorseCode('!'));
    }
    
    @Test
    public void testMorseWord() {
    	Assert.assertArrayEquals("The wordToMorseCode() method returns the correct value for s", new boolean[] {false, false, false}, MorseCode.wordToMorseCode("s")[0]);
    }
    
    @Test
    public void testMorseSOS() {
    	Assert.assertArrayEquals(new boolean[] {false, false, false}, MorseCode.wordToMorseCode("sos")[0]);
    	Assert.assertArrayEquals(new boolean[] {true, true, true}, MorseCode.wordToMorseCode("sos")[1]);
    	Assert.assertArrayEquals(new boolean[] {false, false, false}, MorseCode.wordToMorseCode("sos")[2]);
    	
    	Assert.assertEquals(3, MorseCode.wordToMorseCode("sos").length);
    }
    
    @Test
    public void testMorsePhrase() {
    	boolean[][][] morse = MorseCode.toMorseCode("Hello World");
    	Assert.assertEquals("The number of worlds are as expected", 2, morse.length);
    	boolean[][] firstMorse = morse[0];
    	boolean[][] lastMorse = morse[1];
    	Assert.assertEquals("The number of character in first word as expected", 5, firstMorse.length);
    	Assert.assertArrayEquals(new boolean[]{false, false, false, false}, firstMorse[0]);
    	Assert.assertArrayEquals(new boolean[]{false}, firstMorse[1]);
    	Assert.assertArrayEquals(new boolean[]{false, true, false, false}, firstMorse[2]);
    	Assert.assertArrayEquals(new boolean[]{false, true, false, false}, firstMorse[3]);
    	Assert.assertArrayEquals(new boolean[]{true, true, true}, firstMorse[4]);
    	Assert.assertEquals("The number of characters in the second word is as expected", 5, lastMorse.length);
    	Assert.assertArrayEquals(new boolean[]{false, true, true}, lastMorse[0]);
    	Assert.assertArrayEquals(new boolean[]{true, true, true}, lastMorse[1]);
    	Assert.assertArrayEquals(new boolean[]{false, true, false}, lastMorse[2]);
    	Assert.assertArrayEquals(new boolean[]{false, true, false, false}, lastMorse[3]);
    	Assert.assertArrayEquals(new boolean[]{true, false, false}, lastMorse[4]);
    }
}
