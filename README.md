# GreenStitchAssignment
Parking lot

Automated Parking Lot System

This is a simple automated parking lot system implemented in Java. It allows users to create a parking lot, park cars, free up slots, and perform queries based on registration number and color.

Prerequisites:
- Java Development Kit (JDK) installed on your system
- Command-line interface (Terminal, Command Prompt, etc.)

How to Run:

1. Compile the Java code:

2. Run the compiled program:


3. Follow the prompts to interact with the parking lot system. Here are the supported commands:
- create_parking_lot <capacity>: Create a parking lot with the specified capacity.
- park <registration_number> <color>: Park a car with the given registration number and color.
- leave <slot_number>: Free up the slot with the given slot number.
- registration_numbers_for_cars_with_colour <color>: Get registration numbers of cars with the specified color.
- slot_numbers_for_cars_with_colour <color>: Get slot numbers of slots where cars with the specified color are parked.
- slot_number_for_registration_number <registration_number>: Get the slot number where the car with the specified registration number is parked.
- exit: Exit the program.

Example Usage:

create_parking_lot 6

park KA-01-HH-1234 White

park KA-01-HH-9999 White

park KA-01-BB-0001 Black

park KA-01-HH-7777 Red

park KA-01-HH-2701 Blue

leave 4

registration_numbers_for_cars_with_colour White

slot_numbers_for_cars_with_colour White

slot_number_for_registration_number KA-01-HH-1234

exit


Note: Replace the commands and input values with your desired inputs.

Enjoy using the Automated Parking Lot System!
