/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.org.ljc;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import java.io.Console;

/**
 *
 * @author carljokl
 */
public class RaspberryPiHacking {

    private static final long FLASH_DELAY_MILLIS = 1000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Starting Java light flashing application!");
        System.out.println("Getting hold of GPIO Controller instance...");
        final GpioController controller = GpioFactory.getInstance();
        System.out.println("Provisioning general purpose pin 26 for digital output...");
        final GpioPinDigitalOutput ledPin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_25);
        System.out.println("Setting initial pin state to low...");
        ledPin.low();
        System.out.printf("Rendering morse code!\n");
        final MorseCodeDisplay morseDisplay = new MorseCodeDisplay(ledPin);
        final String message = "Hello world";
        final boolean[][][] morse = MorseCode.toMorseCode(message);
        morseDisplay.renderMorse(morse);
        Console console = System.console();
        System.out.println("Wait for input...");
        console.readLine();
        System.out.println("Shutting off pin...");
        ledPin.low();
        System.out.println("Shutting down GPIO...");
        controller.shutdown();
        System.out.println("Done...exiting!");
    }
    
}
