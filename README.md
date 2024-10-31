AVL System ReadMe
by Nicholas Wronski
University of Maryland Computer Science '27

This project was created using the foundational Java object-oriented programming skills I developed during my freshman year at the University of Maryland, spanning from Fall 2023 to Spring 2024.

The idea for the project is based on the Prince George's County Fire/EMS Department's Automatic Vehicle Locator (AVL) system. This system tracks the GPS locations of all fire and EMS apparatus and dispatches the closest unit for each call, depending on location, incident type, required resources, and more. While volunteering at the Hyattsville Volunteer Fire Department, I took a deep interest in this system, and with a year of college-level programming experience, I decided to recreate a simplified version of it on my own.

Structure
The system's structure can be summarized as follows:
apparatus => firehouse => county
apparatus => incident type => incident => county 

Real Life Application:
911 Call Received => Address Given => Incident Created (proper type) => Units Sorted by location => Units assigned to call => Dangerous Situation Fixed!

Each county contains a list of firehouses, each with its own address.
Note: This simulation assumes that all apparatus are at their respective firehouses when a call is dispatched, which may not always reflect real-life situations.

Each firehouse holds a list of apparatus objects, modeled after real-life fire companies in Prince George’s County, MD. Apparatus types are represented as enums, classifying each unit by type (e.g., E for Engine, RE for Rescue Engine, RS for Rescue Squad, TK for Truck).

GPS Routing
The project includes a mapquestAPI class, which interacts with the MapQuest API to obtain estimated travel times (ETAs) and directions between two locations. It uses HTTP GET requests to connect to the MapQuest API, encoding locations into URLs and parsing the responses to extract and return the ETA in seconds.

Incident Class
The incident class creates and assigns units to an emergency incident based on the incident type and location. When an incident is created, it calculates the ETA of nearby firehouses using the mapquestAPI and assigns apparatus (such as engines, trucks, or search and rescue teams) from the closest firehouses according to the incident type—either "box" (structure fire), "piawi" (accident with entrapment), or "serv" (service call). The incident class sorts firehouses by ETA, selects the appropriate apparatus types, and provides a method to print incident details including type, radio channel, location, notes, and assigned apparatus. Apparatus assignment is determined by a pull method defined in the firehouse class, which checks for availability in each firehouse and selects the next closest firehouse if needed.

Reflection
This project has been a rewarding way to blend my real-world experiences with programming, using the skills I acquired in my first year of college. In the future, I hope to enhance this system with real-time GPS tracking. If you have any questions or would like to connect, my contact information is provided below. Thank you for checking out my project!

email: nickwronski32@gmail.com

