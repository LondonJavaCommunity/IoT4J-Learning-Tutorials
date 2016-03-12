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
    public void testa() {
        Assert.assertEquals(1, 1);
    }
    
    @Test
    public void testMorseChar() {
        Assert.assertArrayEquals("The letter s shoulc be converted to expected morse.", new boolean[] {false, false, false}, MorseCode.charToMorseCode('s'));
    }
    
    @Test
    public void testCaseInsensitiveChar() {
        Assert.assertArrayEquals("The letter S shoulc be case insensitive converted to expected morse.", new boolean[] {false, false, false}, MorseCode.charToMorseCode('S'));
    }

    @Test
    public void testUnknownChar() {
        Assert.assertArrayEquals("Unknown character should result in empty array.", new boolean[] {}, MorseCode.charToMorseCode('!'));
    }
}
