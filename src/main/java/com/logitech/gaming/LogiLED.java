/*
 * .____                 .__.____     ___________________   
 * |    |    ____   ____ |__|    |    \_   _____/\______ \  
 * |    |   /  _ \ / ___\|  |    |     |    __)_  |    |  \ 
 * |    |__(  <_> ) /_/  >  |    |___  |        \ |    `   \
 * |_______ \____/\___  /|__|_______ \/_______  //_______  /
 *         \/    /_____/            \/        \/         \/ 
 *
 * MIT License
 *
 * Copyright (c) 2018 Trent Summerlin, Logitech Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.logitech.gaming;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A modified LogiLED source file that is more organized and works with both
 * 32-bit and 64-bit operating systems.
 * 
 * @author Trent Summerlin
 * @author Logitech Corporation
 */
public class LogiLED {

	// DLL information
	private static final char ARCHITECTURE_SEPARATOR = '_';
	private static final String LOGI_LED_LIBRARY_WINDOWS = "LogiLEDWindows";

	static {
		try {
			// Get system architecture
			String dataModel = System.getProperty("sun.arch.data.model");
			int architecture = 0;
			try {
				architecture = Integer.parseInt(dataModel);
			} catch (NumberFormatException e) {
				if (dataModel.contains("32") || dataModel.contains("x86")) {
					architecture = 32;
				} else if (dataModel.contains("64")) {
					architecture = 64;
				} else {
					throw new IOException("Failed to determine system architecture");
				}
			}

			// Get DLL information
			String dllName = "/" + LOGI_LED_LIBRARY_WINDOWS + ARCHITECTURE_SEPARATOR + Integer.toString(architecture)
					+ ".dll";
			InputStream dllInput = LogiLED.class.getResource(dllName).openStream();
			File dllFile = File.createTempFile(dllName, null);
			FileOutputStream dllOutput = new FileOutputStream(dllFile);

			// Write DLL to a temporary file where it can be loaded
			byte[] dllBuffer = new byte[1024];
			int read = -1;
			while ((read = dllInput.read(dllBuffer)) != -1) {
				dllOutput.write(dllBuffer, 0, read);
			}
			dllOutput.close();
			dllInput.close();

			// Load the DLL file
			System.load(dllFile.getAbsolutePath());
		} catch (Exception e) {
			System.err.println("Failed to load LogiLED libraries: " + e.getMessage());
		}
	}

	// LogiLED keyboard keys
	public static final int ESC = 0x01;
	public static final int ONE = 0x02;
	public static final int TWO = 0x03;
	public static final int THREE = 0x04;
	public static final int FOUR = 0x05;
	public static final int FIVE = 0x06;
	public static final int SIX = 0x07;
	public static final int SEVEN = 0x08;
	public static final int EIGHT = 0x09;
	public static final int NINE = 0x0A;
	public static final int ZERO = 0x0B;
	public static final int MINUS = 0x0C;
	public static final int EQUALS = 0x0D;
	public static final int BACKSPACE = 0x0E;
	public static final int TAB = 0x0F;
	public static final int Q = 0x10;
	public static final int W = 0x11;
	public static final int E = 0x12;
	public static final int R = 0x13;
	public static final int T = 0x14;
	public static final int Y = 0x15;
	public static final int U = 0x16;
	public static final int I = 0x17;
	public static final int O = 0x18;
	public static final int P = 0x19;
	public static final int OPEN_BRACKET = 0x1A;
	public static final int CLOSE_BRACKET = 0x1B;
	public static final int ENTER = 0x1C;
	public static final int LEFT_CONTROL = 0x1D;
	public static final int A = 0x1E;
	public static final int S = 0x1F;
	public static final int D = 0x20;
	public static final int F = 0x21;
	public static final int G = 0x22;
	public static final int H = 0x23;
	public static final int J = 0x24;
	public static final int K = 0x25;
	public static final int L = 0x26;
	public static final int SEMICOLON = 0x27;
	public static final int APOSTROPHE = 0x28;
	public static final int TILDE = 0x29;
	public static final int LEFT_SHIFT = 0x2A;
	public static final int BACKSLASH = 0x2B;
	public static final int Z = 0x2C;
	public static final int X = 0x2D;
	public static final int C = 0x2E;
	public static final int V = 0x2F;
	public static final int B = 0x30;
	public static final int N = 0x31;
	public static final int M = 0x32;
	public static final int COMMA = 0x33;
	public static final int PERIOD = 0x34;
	public static final int FORWARD_SLASH = 0x35;
	public static final int RIGHT_SHIFT = 0x36;
	public static final int NUM_ASTERISK = 0x37;
	public static final int LEFT_ALT = 0x38;
	public static final int SPACE = 0x39;
	public static final int CAPS_LOCK = 0x3A;
	public static final int F1 = 0x3b;
	public static final int F2 = 0x3c;
	public static final int F3 = 0x3d;
	public static final int F4 = 0x3e;
	public static final int F5 = 0x3f;
	public static final int F6 = 0x40;
	public static final int F7 = 0x41;
	public static final int F8 = 0x42;
	public static final int F9 = 0x43;
	public static final int F10 = 0x44;
	public static final int NUM_LOCK = 0x45;
	public static final int SCROLL_LOCK = 0x46;
	public static final int NUM_SEVEN = 0x47;
	public static final int NUM_EIGHT = 0x48;
	public static final int NUM_NINE = 0x49;
	public static final int NUM_MINUS = 0x4A;
	public static final int NUM_FOUR = 0x4B;
	public static final int NUM_FIVE = 0x4C;
	public static final int NUM_SIX = 0x4D;
	public static final int NUM_PLUS = 0x4E;
	public static final int NUM_ONE = 0x4F;
	public static final int NUM_TWO = 0x50;
	public static final int NUM_THREE = 0x51;
	public static final int NUM_ZERO = 0x52;
	public static final int NUM_PERIOD = 0x53;
	public static final int F11 = 0x57;
	public static final int F12 = 0x58;
	public static final int NUM_ENTER = 0x11C;
	public static final int RIGHT_CONTROL = 0x11D;
	public static final int NUM_SLASH = 0x135;
	public static final int PRINT_SCREEN = 0x137;
	public static final int RIGHT_ALT = 0x138;
	public static final int PAUSE_BREAK = 0x145;
	public static final int HOME = 0x147;
	public static final int ARROW_UP = 0x148;
	public static final int PAGE_UP = 0x149;
	public static final int ARROW_LEFT = 0x14B;
	public static final int ARROW_RIGHT = 0x14D;
	public static final int END = 0x14F;
	public static final int ARROW_DOWN = 0x150;
	public static final int PAGE_DOWN = 0x151;
	public static final int INSERT = 0x152;
	public static final int KEYBOARD_DELETE = 0x153;
	public static final int LEFT_WINDOWS = 0x15B;
	public static final int RIGHT_WINDOWS = 0x15C;
	public static final int APPLICATION_SELECT = 0x15D;
	public static final int G_1 = 0xFFF1;
	public static final int G_2 = 0xFFF2;
	public static final int G_3 = 0xFFF3;
	public static final int G_4 = 0xFFF4;
	public static final int G_5 = 0xFFF5;
	public static final int G_6 = 0xFFF6;
	public static final int G_7 = 0xFFF7;
	public static final int G_8 = 0xFFF8;
	public static final int G_9 = 0xFFF9;
	public static final int G_LOGO = 0xFFFF1;
	public static final int G_BADGE = 0xFFFF2;

	// LogiLED device types
	public static final int DEVICETYPE_KEYBOARD = 0x0;
	public static final int DEVICETYPE_MOUSE = 0x3;
	public static final int DEVICETYPE_MOUSE_PAD = 0x4;
	public static final int DEVICETYPE_HEADSET = 0x8;
	public static final int LOGI_DEVICETYPE_MONOCHROME_ORD = 0;
	public static final int LOGI_DEVICETYPE_RGB_ORD = 1;
	public static final int LOGI_DEVICETYPE_PERKEY_RGB_ORD = 2;
	public static final int LOGI_DEVICETYPE_MONOCHROME = 1 << LOGI_DEVICETYPE_MONOCHROME_ORD;
	public static final int LOGI_DEVICETYPE_RGB = 1 << LOGI_DEVICETYPE_RGB_ORD;
	public static final int LOGI_DEVICETYPE_PERKEY_RGB = 1 << LOGI_DEVICETYPE_PERKEY_RGB_ORD;
	public static final int LOGI_DEVICETYPE_ALL = LOGI_DEVICETYPE_MONOCHROME | LOGI_DEVICETYPE_RGB
			| LOGI_DEVICETYPE_PERKEY_RGB;

	// LogiLED bitmap information and duration information
	public static final int LOGI_LED_BITMAP_WIDTH = 21;
	public static final int LOGI_LED_BITMAP_HEIGHT = 6;
	public static final int LOGI_LED_BITMAP_BYTES_PER_KEY = 4;
	public static final int LOGI_LED_BITMAP_SIZE = LOGI_LED_BITMAP_WIDTH * LOGI_LED_BITMAP_HEIGHT
			* LOGI_LED_BITMAP_BYTES_PER_KEY;
	public static final int LOGI_LED_DURATION_INFINITE = 0;

	/**
	 * Initializes LogiLED.
	 * 
	 * @return <code>true</code> if LogiLED was successfully initialized,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedInit();

	/**
	 * Gets a configuration option number.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultValue
	 *            the default value.
	 * @return the configuration option number.
	 */
	public static native double LogiLedGetConfigOptionNumber(String configPath, double defaultValue);

	/**
	 * Gets a configuration option boolean.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultValue
	 *            the default value.
	 * @return the configuration option boolean.
	 */
	public static native boolean LogiLedGetConfigOptionBool(String configPath, boolean defaultValue);

	/**
	 * Gets a configuration option color red.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultRed
	 *            the default red.
	 * @return the configuration option color red.
	 */
	public static native int LogiLedGetConfigOptionColorRed(String configPath, int defaultRed);

	/**
	 * Gets a configuration option color green.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultGreen
	 *            the default green.
	 * @return the configuration option color green.
	 */
	public static native int LogiLedGetConfigOptionColorGreen(String configPath, int defaultGreen);

	/**
	 * Gets a configuration option color blue.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultBlue
	 *            the default blue.
	 * @return the configuration option color blue.
	 */
	public static native int LogiLedGetConfigOptionColorBlue(String configPath, int defaultBlue);

	/**
	 * Gets a configuration option key input.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultValue
	 *            the default value.
	 * @return the configuration option key input.
	 */
	public static native String LogiLedGetConfigOptionKeyInput(String configPath, String defaultValue);

	/**
	 * Gets a configuration option label.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param label
	 *            the label.
	 * @return <code>true</code> if the configuration option label was
	 *         successfully set, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetConfigOptionLabel(String configPath, String label);

	/**
	 * Sets the target device.
	 * 
	 * @param targetDevice
	 *            the target device type.
	 * @return <code>true</code> if the device type was successfully set,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetTargetDevice(int targetDevice);

	/**
	 * Saves the current lighting.
	 * 
	 * @return <code>true</code> if the current lighting was successfully saved,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSaveCurrentLighting();

	/**
	 * Sets the lighting of the keyboard.
	 * 
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if the lighting was successfully set,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLighting(int redPercentage, int greenPercentage, int bluePercentage);

	/**
	 * Restores the lighting.
	 * 
	 * @return <code>true</code> if the lighting was successfully restored,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedRestoreLighting();

	/**
	 * Flashes the lighting.
	 * 
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @param milliSecondsDuration
	 *            how long the flashing will last in milliseconds.
	 * @param milliSecondsInterval
	 *            the flashing interval in milliseconds.
	 * @return <code>true</code> if the flashing was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedFlashLighting(int redPercentage, int greenPercentage, int bluePercentage,
			int milliSecondsDuration, int milliSecondsInterval);

	/**
	 * Pulses the lighting.
	 * 
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @param milliSecondsDuration
	 *            how long the pulsing will last in milliseconds.
	 * @param milliSecondsInterval
	 *            the pulsing interval in milliseconds.
	 * @return <code>true</code> if the pulsing was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedPulseLighting(int redPercentage, int greenPercentage, int bluePercentage,
			int milliSecondsDuration, int milliSecondsInterval);

	/**
	 * Stops all effects.
	 * 
	 * @return <code>true</code> if the effects were successfully stopped,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedStopEffects();

	/**
	 * Sets the lighting from a bitmap.
	 * 
	 * @param bitmap
	 *            the bitmap.
	 * @return <code>true</code> if setting the lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLightingFromBitmap(byte bitmap[]);

	/**
	 * Excludes the specified keys from the bitmap when setting the lighting
	 * with a bitmap.
	 * 
	 * @param keyList
	 *            the keys to exclude.
	 * @return <code>true</code> if excluding the keys was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedExcludeKeysFromBitmap(int keyList[]);

	/**
	 * Sets the lighting for the specified key using its scan code.
	 * 
	 * @param keyCode
	 *            the scan code.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLightingForKeyWithScanCode(int keyCode, int redPercentage,
			int greenPercentage, int bluePercentage);

	/**
	 * Sets the lighting for the specified key using its HID code.
	 * 
	 * @param keyCode
	 *            the HID code.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLightingForKeyWithHidCode(int keyCode, int redPercentage,
			int greenPercentage, int bluePercentage);

	/**
	 * Sets the lighting for the specified key using its quartz code.
	 * 
	 * @param keyCode
	 *            the quartz code.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLightingForKeyWithQuartzCode(int keyCode, int redPercentage,
			int greenPercentage, int bluePercentage);

	/**
	 * Sets the lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLightingForKeyWithKeyName(int keyName, int redPercentage,
			int greenPercentage, int bluePercentage);

	/**
	 * Saves the lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @return <code>true</code> if saving the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSaveLightingForKey(int keyName);

	/**
	 * Restores the lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @return <code>true</code> if restoring the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedRestoreLightingForKey(int keyName);

	/**
	 * Flashes lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @param msDuration
	 *            the duration of the flashing in milliseconds.
	 * @param msInterval
	 *            the interval of flashing in milliseconds.
	 * @return <code>true</code> if flashing the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedFlashSingleKey(int keyName, int redPercentage, int greenPercentage,
			int bluePercentage, int msDuration, int msInterval);

	/**
	 * Pulses lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @param startRedPercentage
	 *            the starting red percentage.
	 * @param startGreenPercentage
	 *            the starting green percentage.
	 * @param startBluePercentage
	 *            the starting blue percentage.
	 * @param finishRedPercentage
	 *            the finishing red percentage.
	 * @param finishGreenPercentage
	 *            the finishing green percentage.
	 * @param finishBluePercentage
	 *            the finishing blue percentage.
	 * @param msDuration
	 *            the duration of the pulsing in milliseconds.
	 * @param isInfinite
	 *            <code>true</code> if the pulsing is infinite,
	 *            <code>false</code> otherwise.
	 * @return <code>true</code> if pulsing the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedPulseSingleKey(int keyName, int startRedPercentage, int startGreenPercentage,
			int startBluePercentage, int finishRedPercentage, int finishGreenPercentage, int finishBluePercentage,
			int msDuration, boolean isInfinite);

	/**
	 * Stops all effects for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @return <code>true</code> if the effects for the key were successfully
	 *         stopped, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedStopEffectsOnKey(int keyName);

	/**
	 * Sets the lighting for the specified target zone.
	 * 
	 * @param deviceType
	 *            the device type.
	 * @param zone
	 *            the target zone.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the lighting for the target zone was
	 *         successful, <code>false</code> otherwise.
	 */
	public static native boolean LogiLedSetLightingForTargetZone(int deviceType, int zone, int redPercentage,
			int greenPercentage, int bluePercentage);

	/**
	 * Shuts down LogiLED.
	 */
	public static native void LogiLedShutdown();

	/**
	 * Initializes LogiLED.
	 * 
	 * @return <code>true</code> if LogiLED was successfully initialized,
	 *         <code>false</code> otherwise.
	 */
	public static boolean init() {
		return LogiLedInit();
	}

	/**
	 * Gets a configuration option number.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultValue
	 *            the default value.
	 * @return the configuration option number.
	 */
	public static double getConfigOptionNumber(String configPath, double defaultValue) {
		return LogiLedGetConfigOptionNumber(configPath, defaultValue);
	}

	/**
	 * Gets a configuration option boolean.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultValue
	 *            the default value.
	 * @return the configuration option boolean.
	 */
	public static boolean getConfigOptionBool(String configPath, boolean defaultValue) {
		return LogiLedGetConfigOptionBool(configPath, defaultValue);
	}

	/**
	 * Gets a configuration option color red.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultRed
	 *            the default red.
	 * @return the configuration option color red.
	 */
	public static int getConfigOptionColorRed(String configPath, int defaultRed) {
		return LogiLedGetConfigOptionColorRed(configPath, defaultRed);
	}

	/**
	 * Gets a configuration option color green.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultGreen
	 *            the default green.
	 * @return the configuration option color green.
	 */
	public static int getConfigOptionColorGreen(String configPath, int defaultGreen) {
		return LogiLedGetConfigOptionColorGreen(configPath, defaultGreen);
	}

	/**
	 * Gets a configuration option color blue.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultBlue
	 *            the default blue.
	 * @return the configuration option color blue.
	 */
	public static int getConfigOptionColorBlue(String configPath, int defaultBlue) {
		return LogiLedGetConfigOptionColorBlue(configPath, defaultBlue);
	}

	/**
	 * Gets a configuration option key input.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param defaultValue
	 *            the default value.
	 * @return the configuration option key input.
	 */
	public static String getConfigOptionKeyInput(String configPath, String defaultValue) {
		return LogiLedGetConfigOptionKeyInput(configPath, defaultValue);
	}

	/**
	 * Gets a configuration option label.
	 * 
	 * @param configPath
	 *            the configuration path.
	 * @param label
	 *            the label.
	 * @return <code>true</code> if the configuration option label was
	 *         successfully set, <code>false</code> otherwise.
	 */
	public static boolean setConfigOptionLabel(String configPath, String label) {
		return LogiLedSetConfigOptionLabel(configPath, label);
	}

	/**
	 * Sets the target device.
	 * 
	 * @param targetDevice
	 *            the target device type.
	 * @return <code>true</code> if the device type was successfully set,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setTargetDevice(int targetDevice) {
		return LogiLedSetTargetDevice(targetDevice);
	}

	/**
	 * Saves the current lighting.
	 * 
	 * @return <code>true</code> if the current lighting was successfully saved,
	 *         <code>false</code> otherwise.
	 */
	public static boolean saveCurrentLighting() {
		return LogiLedSaveCurrentLighting();
	}

	/**
	 * Sets the lighting of the keyboard.
	 * 
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if the lighting was successfully set,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setLighting(int redPercentage, int greenPercentage, int bluePercentage) {
		return LogiLedSetLighting(redPercentage, greenPercentage, bluePercentage);
	}

	/**
	 * Restores the lighting.
	 * 
	 * @return <code>true</code> if the lighting was successfully restored,
	 *         <code>false</code> otherwise.
	 */
	public static boolean restoreLighting() {
		return LogiLedRestoreLighting();
	}

	/**
	 * Flashes the lighting.
	 * 
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @param milliSecondsDuration
	 *            how long the flashing will last in milliseconds.
	 * @param milliSecondsInterval
	 *            the flashing interval in milliseconds.
	 * @return <code>true</code> if the flashing was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean flashLighting(int redPercentage, int greenPercentage, int bluePercentage,
			int milliSecondsDuration, int milliSecondsInterval) {
		return LogiLedFlashLighting(redPercentage, greenPercentage, bluePercentage, milliSecondsDuration,
				milliSecondsInterval);
	}

	/**
	 * Pulses the lighting.
	 * 
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @param milliSecondsDuration
	 *            how long the pulsing will last in milliseconds.
	 * @param milliSecondsInterval
	 *            the pulsing interval in milliseconds.
	 * @return <code>true</code> if the pulsing was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean pulseLighting(int redPercentage, int greenPercentage, int bluePercentage,
			int milliSecondsDuration, int milliSecondsInterval) {
		return LogiLedPulseLighting(redPercentage, greenPercentage, bluePercentage, milliSecondsDuration,
				milliSecondsInterval);
	}

	/**
	 * Stops all effects.
	 * 
	 * @return <code>true</code> if the effects were successfully stopped,
	 *         <code>false</code> otherwise.
	 */
	public static boolean stopEffects() {
		return LogiLedStopEffects();
	}

	/**
	 * Sets the lighting from a bitmap.
	 * 
	 * @param bitmap
	 *            the bitmap.
	 * @return <code>true</code> if setting the lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setLightingFromBitmap(byte bitmap[]) {
		return LogiLedSetLightingFromBitmap(bitmap);
	}

	/**
	 * Excludes the specified keys from the bitmap when setting the lighting
	 * with a bitmap.
	 * 
	 * @param keyList
	 *            the keys to exclude.
	 * @return <code>true</code> if excluding the keys was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean excludeKeysFromBitmap(int keyList[]) {
		return LogiLedExcludeKeysFromBitmap(keyList);
	}

	/**
	 * Sets the lighting for the specified key using its scan code.
	 * 
	 * @param keyCode
	 *            the scan code.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setLightingForKeyWithScanCode(int keyCode, int redPercentage, int greenPercentage,
			int bluePercentage) {
		return LogiLedSetLightingForKeyWithScanCode(keyCode, redPercentage, greenPercentage, bluePercentage);
	}

	/**
	 * Sets the lighting for the specified key using its HID code.
	 * 
	 * @param keyCode
	 *            the HID code.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setLightingForKeyWithHidCode(int keyCode, int redPercentage, int greenPercentage,
			int bluePercentage) {
		return LogiLedSetLightingForKeyWithHidCode(keyCode, redPercentage, greenPercentage, bluePercentage);
	}

	/**
	 * Sets the lighting for the specified key using its quartz code.
	 * 
	 * @param keyCode
	 *            the quartz code.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setLightingForKeyWithQuartzCode(int keyCode, int redPercentage, int greenPercentage,
			int bluePercentage) {
		return LogiLedSetLightingForKeyWithQuartzCode(keyCode, redPercentage, greenPercentage, bluePercentage);
	}

	/**
	 * Sets the lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the key lighting was successful,
	 *         <code>false</code> otherwise.
	 */
	public static boolean setLightingForKeyWithKeyName(int keyName, int redPercentage, int greenPercentage,
			int bluePercentage) {
		return LogiLedSetLightingForKeyWithKeyName(keyName, redPercentage, greenPercentage, bluePercentage);
	}

	/**
	 * Saves the lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @return <code>true</code> if saving the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static boolean saveLightingForKey(int keyName) {
		return LogiLedSaveLightingForKey(keyName);
	}

	/**
	 * Restores the lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @return <code>true</code> if restoring the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static boolean restoreLightingForKey(int keyName) {
		return LogiLedRestoreLightingForKey(keyName);
	}

	/**
	 * Flashes lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @param msDuration
	 *            the duration of the flashing in milliseconds.
	 * @param msInterval
	 *            the interval of flashing in milliseconds.
	 * @return <code>true</code> if flashing the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static boolean flashSingleKey(int keyName, int redPercentage, int greenPercentage, int bluePercentage,
			int msDuration, int msInterval) {
		return LogiLedFlashSingleKey(keyName, redPercentage, greenPercentage, bluePercentage, msDuration, msInterval);
	}

	/**
	 * Pulses lighting for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @param startRedPercentage
	 *            the starting red percentage.
	 * @param startGreenPercentage
	 *            the starting green percentage.
	 * @param startBluePercentage
	 *            the starting blue percentage.
	 * @param finishRedPercentage
	 *            the finishing red percentage.
	 * @param finishGreenPercentage
	 *            the finishing green percentage.
	 * @param finishBluePercentage
	 *            the finishing blue percentage.
	 * @param msDuration
	 *            the duration of the pulsing in milliseconds.
	 * @param isInfinite
	 *            <code>true</code> if the pulsing is infinite,
	 *            <code>false</code> otherwise.
	 * @return <code>true</code> if pulsing the lighting for the key was
	 *         successful, <code>false</code> otherwise.
	 */
	public static boolean pulseSingleKey(int keyName, int startRedPercentage, int startGreenPercentage,
			int startBluePercentage, int finishRedPercentage, int finishGreenPercentage, int finishBluePercentage,
			int msDuration, boolean isInfinite) {
		return LogiLedPulseSingleKey(keyName, startRedPercentage, startGreenPercentage, startBluePercentage,
				finishRedPercentage, finishGreenPercentage, finishBluePercentage, msDuration, isInfinite);
	}

	/**
	 * Stops all effects for the specified key.
	 * 
	 * @param keyName
	 *            the key name.
	 * @return <code>true</code> if the effects for the key were successfully
	 *         stopped, <code>false</code> otherwise.
	 */
	public static boolean stopEffectsOnKey(int keyName) {
		return LogiLedStopEffectsOnKey(keyName);
	}

	/**
	 * Sets the lighting for the specified target zone.
	 * 
	 * @param deviceType
	 *            the device type.
	 * @param zone
	 *            the target zone.
	 * @param redPercentage
	 *            the red percentage.
	 * @param greenPercentage
	 *            the green percentage.
	 * @param bluePercentage
	 *            the blue percentage.
	 * @return <code>true</code> if setting the lighting for the target zone was
	 *         successful, <code>false</code> otherwise.
	 */
	public static boolean setLightingForTargetZone(int deviceType, int zone, int redPercentage, int greenPercentage,
			int bluePercentage) {
		return LogiLedSetLightingForTargetZone(deviceType, zone, redPercentage, greenPercentage, bluePercentage);
	}

	/**
	 * Shuts down LogiLED.
	 */
	public static void shutdown() {
		LogiLedShutdown();
	}

}
